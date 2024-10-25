package vn.edu.usth.opendota.ui.search;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.ProfileAdapters;
import vn.edu.usth.opendota.adapters.SearchAdapter;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.retrofit.ApiClient;
import vn.edu.usth.opendota.ui.my_profile.MyProfileActivity;
import vn.edu.usth.opendota.utils.PrefUtil;

public class SearchFragment extends Fragment {
    private final String TAG = SearchAdapter.class.getSimpleName();
    private ProfileAdapters profileAdapters;
    private SearchAdapter searchAdapter;
    private List<ProPlayerProfile> listPlayer;
    private ArrayList<ProPlayerProfile> arrayList;
    private List<ProPlayerProfile> listFavorited;
    private ApiClient client;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private List<ProPlayerProfile> proPlayerProfileList = new ArrayList<>();
    private LottieAnimationView animationView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = ApiClient.getInstance();
        recyclerView = view.findViewById(R.id.Matches_recyclerview);
        searchView = view.findViewById(R.id.search_view);
        searchView.setIconified(false);
        searchView.clearFocus();
        animationView = view.findViewById(R.id.animationView);
        animationView.setVisibility(View.VISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        listPlayer = new ArrayList<>();
        arrayList = new ArrayList<>();
        searchAdapter = new SearchAdapter(requireContext(),  arrayList, new SearchAdapter.IOnSearchAdapterListener() {
            @Override
            public void onClickItem(ProPlayerProfile user) {
                navigateToProfileDetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerProfile proPlayerProfile) {
                if (proPlayerProfile.isFavorited()) {
                    PrefUtil.removeFavorite(requireContext(), proPlayerProfile);
                    proPlayerProfile.setFavorited(false);
                } else {
                    PrefUtil.addToFavorites(requireContext(), proPlayerProfile);
                    proPlayerProfile.setFavorited(true);
                }
                searchAdapter.notifyDataSetChanged();
            }

        }) {
            @Override
            public void onClickItem(ProPlayerProfile user) {

            }

            @Override
            public void onClickFavorite(ProPlayerProfile user) {

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
                for (ProPlayerProfile item : listPlayer) {
                    if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                        arrayList.add(item);
                    }
                }
                searchAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }


    private void callGetProPlayer() {
        client.getAPIService().getProfile().enqueue(new Callback<List<ProPlayerProfile>>() {
            @Override
            public void onResponse(Call<List<ProPlayerProfile>> call, Response<List<ProPlayerProfile>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    listPlayer.clear();
                    arrayList.clear();
                    for (ProPlayerProfile item : response.body().subList(0, Math.min(response.body().size(), 30))) {
                        for (ProPlayerProfile itemFavorite : listFavorited) {
                            if (item.getAccountId() == itemFavorite.getAccountId()) {
                                item.setFavorited(true);
                                break;
                            }
                        }
                        listPlayer.add(item);
                        arrayList.add(item);
                    }
                    searchAdapter.notifyDataSetChanged();
                    animationView.setVisibility(View.GONE);// This is now correct
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProPlayerProfile>> call, @NonNull Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
                animationView.setVisibility(View.GONE);
            }
        });
    }


    private void navigateToProfileDetail(ProPlayerProfile proPlayerProfile) {
        Intent intent = new Intent(getContext(), MyProfileActivity.class);
        intent.putExtra("profile_data",  proPlayerProfile);
        startActivity(intent);
    }
}