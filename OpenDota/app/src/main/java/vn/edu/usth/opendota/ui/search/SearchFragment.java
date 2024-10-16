package vn.edu.usth.opendota.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.SearchAdapter;
import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.PlayerWinLoss;
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.retrofit.IAPINetwork;
import vn.edu.usth.opendota.utils.PrefUtil;
import vn.edu.usth.opendota.ui.my_profile.MyProfileFragment;

public class SearchFragment extends Fragment {
    private final String TAG = SearchFragment.class.getSimpleName();
    private SearchView searchView;
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter; // Corrected type
    private List<ProPlayerObj> listPlayer;
    private ArrayList<ProPlayerObj> arrayList;
    private List<ProPlayerObj> listFavorited;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        searchView = view.findViewById(R.id.searchView);
        searchView.setIconified(false);
        searchView.clearFocus();

        listPlayer = new ArrayList<>();
        arrayList = new ArrayList<>();
        searchAdapter = new SearchAdapter(requireContext(), arrayList, new SearchAdapter.IOnSearchAdapterListener() {
            @Override
            public void onClickItem(ProPlayerObj user) {
                onClickGoToDetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {
                if (user.isFavorited()) {
                    PrefUtil.removeFavorite(requireContext(), user);
                    user.setFavorited(false);
                } else {
                    PrefUtil.addToFavorites(requireContext(), user);
                    user.setFavorited(true);
                }
                searchAdapter.notifyDataSetChanged(); // This is now correct
            }
        }) {
            @Override
            public void onClickItem(ProPlayerObj user) {

            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {

            }
        };

        recyclerView.setAdapter(searchAdapter);
        listFavorited = PrefUtil.getListFavorite(requireContext());

        callGetProPlayer();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayList.clear();
                for (ProPlayerObj item : listPlayer) {
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                        arrayList.add(item);
                    }
                }
                searchAdapter.notifyDataSetChanged(); // This is now correct
                return false;
            }
        });

        return view;
    }

    private void callGetProPlayer() {
        IAPINetwork.getProPlayer().enqueue(new Callback<List<ProPlayerObj>>() {
            @Override
            public void onResponse(Call<List<ProPlayerObj>> call, Response<List<ProPlayerObj>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    listPlayer.clear();
                    arrayList.clear();
                    for (ProPlayerObj item : response.body().subList(0, Math.min(response.body().size(), 30))) {
                        for (ProPlayerObj itemFavorite : listFavorited) {
                            if (item.getAccountId() == itemFavorite.getAccountId()) {
                                item.setFavorited(true);
                                break;
                            }
                        }
                        listPlayer.add(item);
                        arrayList.add(item);
                    }
                    searchAdapter.notifyDataSetChanged(); // This is now correct
                }
            }

            @Override
            public void onFailure(Call<List<ProPlayerObj>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void onClickGoToDetail(ProPlayerObj user) {
        IAPINetwork.getRecentMatch(user.getAccountId()).enqueue(new Callback<List<RecentMatchesObj>>() {
            @Override
            public void onResponse(Call<List<RecentMatchesObj>> call, Response<List<RecentMatchesObj>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    callGetPlayerData(user, response.body().subList(0, Math.min(response.body().size(), 30)));
                }
            }

            @Override
            public void onFailure(Call<List<RecentMatchesObj>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void callGetPlayerData(ProPlayerObj user, List<RecentMatchesObj> recentMatchesList) {
        IAPINetwork.getPlayerData(user.getAccountId()).enqueue(new Callback<PlayerObj>() {
            @Override
            public void onResponse(Call<PlayerObj> call, Response<PlayerObj> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PlayerObj playerObj = response.body();
                    playerObj.setProfile(user);
                    callGetPlayerWl(playerObj, user.getAccountId(), recentMatchesList);
                }
            }

            @Override
            public void onFailure(Call<PlayerObj> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void callGetPlayerWl(PlayerObj playerObj, int accountId, List<RecentMatchesObj> recentMatchesList) {
        IAPINetwork.getPlayerWinLoss(accountId).enqueue(new Callback<PlayerWinLoss>() {
            @Override
            public void onResponse(Call<PlayerWinLoss> call, Response<PlayerWinLoss> response) {
                if (response.isSuccessful() && response.body() != null) {
                    playerObj.setWinLoss(response.body());

                    // Here we replace the fragment instead of starting an activity
                    MyProfileFragment myProfileFragment = new MyProfileFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("player_data", playerObj);
                    bundle.putSerializable("player_recent_matches", new ArrayList<>(recentMatchesList));
                    myProfileFragment.setArguments(bundle);

                    // Use FragmentTransaction to replace the current fragment
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.framelayout, myProfileFragment) // Use your actual container ID
                            .addToBackStack(null) // Optional: Add to back stack
                            .commit();
                }
            }

            @Override
            public void onFailure(Call<PlayerWinLoss> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
