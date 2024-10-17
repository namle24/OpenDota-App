package vn.edu.usth.opendota.ui.favourite;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
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
import vn.edu.usth.opendota.ui.my_profile.MyProfileFragment;
import vn.edu.usth.opendota.utils.PrefUtil;


public class FavoriteFragment extends Fragment {
    private RecyclerView recyclerView;
    private SearchAdapter favAdapter;
    private List<ProPlayerObj> listFavorited;
    private SharedPreferences sharedPreferences;
    private int storedColor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        recyclerView = view.findViewById(R.id.favorites_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        listFavorited = PrefUtil.getListFavorite(requireContext());
        if (listFavorited.isEmpty()) {
            Log.d("Favorites", "No favorites found.");
        }

        favAdapter = new SearchAdapter(requireContext(), new ArrayList<>(listFavorited), new SearchAdapter.IOnSearchAdapterListener() {
            @Override
            public void onClickItem(ProPlayerObj user) {
                onClickGoToDetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {
                if (user.isFavorited()) {
                    removeFavorite(user);
                } else {
                    addFavorite(user);
                }
            }
        }) {
            @Override
            public void onClickItem(ProPlayerObj user) {

            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {

            }
        };

        recyclerView.setAdapter(favAdapter);
        favAdapter.notifyDataSetChanged();

        return view;
    }


    private void removeFavorite(ProPlayerObj user) {
        PrefUtil.removeFavorite(requireContext(), user);
        user.setFavorited(false);
        updateUIWithFavorites();
    }

    private void addFavorite(ProPlayerObj user) {
        PrefUtil.addToFavorites(requireContext(), user);
        user.setFavorited(true);
        updateUIWithFavorites();
    }

    private void updateUIWithFavorites() {
        favAdapter.notifyDataSetChanged();
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
