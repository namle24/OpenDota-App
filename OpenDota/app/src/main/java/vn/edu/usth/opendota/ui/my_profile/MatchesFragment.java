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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.MatchesAdapter;
import vn.edu.usth.opendota.models.Matches;
import vn.edu.usth.opendota.retrofit.ApiClient;

public class MatchesFragment extends Fragment {
    private static final String TAG = "Matches Fragment";
    private MatchesAdapter matchesAdapter;
    private ApiClient client;
    private RecyclerView recyclerView;
    private String accountId;

    public static MatchesFragment newInstance(String accountId) {
        MatchesFragment fragment = new MatchesFragment();
        Bundle args = new Bundle();
        args.putString("account_id", accountId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            accountId = getArguments().getString("account_id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_matches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = ApiClient.getInstance();
        recyclerView = view.findViewById(R.id.Matches_recyclerview);
        matchesAdapter = new MatchesAdapter(getContext(), new ArrayList<>());

        setViews();
        listeners();
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(matchesAdapter);
    }

    private void listeners() {
        if (accountId != null) {
            client.getAPIService().getMatches(accountId).enqueue(new Callback<List<Matches>>() {
                @Override
                public void onResponse(@NonNull Call<List<Matches>> call, @NonNull Response<List<Matches>> response) {
                    Log.d(TAG, "onResponse: " + response.body());
                    if (response.isSuccessful()) {
                        List<Matches> matches = response.body();
                        assert matches != null;
                        matchesAdapter.submit(matches);
                    } else {
                        Log.e(TAG, "Error code: " + response.code() + " Error Message: " + response.message());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<Matches>> call, @NonNull Throwable t) {
                    Log.e(TAG, "Failure: " + t.getMessage());
                }
            });
        } else {
            Log.e(TAG, "Account ID is null");
        }
    }
}
