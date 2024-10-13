package vn.edu.usth.opendota.ui.search;

import static android.content.ContentValues.TAG;

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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.ProfileAdapters;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.retrofit.ApiClient;

public class SearchFragment extends Fragment {
    private ProfileAdapters profileAdapters;
    private ApiClient client;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private List<ProPlayerProfile> proPlayerProfileList = new ArrayList<>();

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

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
        profileAdapters = new ProfileAdapters(requireContext());
        setViews();
        listeners();
        setupSearch();
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(profileAdapters);
    }

    private void listeners() {
        client.getAPIService().getProfile().enqueue(new Callback<List<ProPlayerProfile>>() {
            @Override
            public void onResponse(@NonNull Call<List<ProPlayerProfile>> call, @NonNull Response<List<ProPlayerProfile>> response) {
                Log.d(TAG, "onResponse: " + response.body());
                if (response.isSuccessful()) {
                    proPlayerProfileList = response.body();
                    if (proPlayerProfileList != null) {
                        if (proPlayerProfileList.size() > 30) {
                            proPlayerProfileList = proPlayerProfileList.subList(0, 30);
                        }
                    }
                    profileAdapters.submit(proPlayerProfileList);
                } else {
                    Log.e(TAG, "Error code: " + response.code() + " Error Message: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ProPlayerProfile>> call, @NonNull Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
            }
        });
    }

    private void setupSearch() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterProfiles(newText);
                return true;
            }
        });
    }

    private void filterProfiles(String query) {
        List<ProPlayerProfile> filteredList = new ArrayList<>();
        for (ProPlayerProfile proPlayerProfile : proPlayerProfileList) {
            if (proPlayerProfile.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(proPlayerProfile);
            }
        }
        profileAdapters.submit(filteredList);
    }
}
