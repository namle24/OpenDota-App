package vn.edu.usth.opendota.ui.my_profile;

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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.MatchesAdapter;
import vn.edu.usth.opendota.models.Matches;
import vn.edu.usth.opendota.retrofit.ApiClient;
import vn.edu.usth.opendota.retrofit.ApiService;

public class OverviewFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchesAdapter matchesAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        recyclerView = view.findViewById(R.id.Matches_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        matchesAdapter = new MatchesAdapter();
        recyclerView.setAdapter(matchesAdapter);

        String playerId = "1296625";
        fetchMatchesData(playerId);

        return view;
    }

    private void fetchMatchesData(String playerId) {
        ApiService apiService = ApiClient.getInstance().getAPIService();
        Call<List<Matches>> call = apiService.getMatches(playerId);

        call.enqueue(new Callback<List<Matches>>() {
            @Override
            public void onResponse(@NonNull Call<List<Matches>> call, @NonNull Response<List<Matches>> response) {
                if (response.isSuccessful()) {
                    List<Matches> matches = response.body();
                    if (matches != null) {
                        for (Matches match : matches) {
                            Log.d("OverviewFragment", "Hero ID: " + match.getHeroID() + ", Kills: " + match.getKills());
                        }
                        matchesAdapter.submit(matches);
                    }
                } else {
                    Log.e("OverviewFragment", "Error code: " + response.code() + " Error Message: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Matches>> call, @NonNull Throwable t) {
                Log.e("OverviewFragment", "Failure: " + t.getMessage());
            }
        });
    }

    public static OverviewFragment newInstance() {
        return new OverviewFragment();
    }
}
