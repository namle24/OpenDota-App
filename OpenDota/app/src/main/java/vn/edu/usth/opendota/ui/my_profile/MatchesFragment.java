package vn.edu.usth.opendota.ui.my_profile;

import static android.content.ContentValues.TAG;

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

import com.airbnb.lottie.LottieAnimationView;

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
    private final MatchesAdapter matchesAdapter = new MatchesAdapter(getContext(), new ArrayList<>());
    private ApiClient client;
    private RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_matches, container, false);
    }

    public static MatchesFragment newInstance() {
        MatchesFragment my_profilefrag2 = new MatchesFragment();
        return my_profilefrag2;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = ApiClient.getInstance();
        recyclerView = view.findViewById(R.id.Matches_recyclerview);


        setViews();
        listeners();
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(matchesAdapter);
    }

    private void listeners() {
        client.getAPIService().getMatches("1296625").enqueue(new Callback<List<Matches>>() {
            @Override
            public void onResponse(@NonNull Call<List<Matches>> call, @NonNull Response<List<Matches>> response) {
                Log.d(TAG, "onResponse: " + response.body());
                if (response.isSuccessful()) {
                    List<Matches> matches = response.body();
                    assert matches != null;
                    matchesAdapter.submit(matches);

                } else {
                    Log.e(TAG, "Error code: " + response.code() + "Error Message:" + response.message());
                }
            }



            @Override
            public void onFailure(@NonNull Call<List<Matches>> call, @NonNull Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());

            }
        });
    }
}