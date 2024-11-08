package vn.edu.usth.opendota.ui.my_profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class MatchesActivity extends AppCompatActivity implements MatchesAdapter.OnItemClickListener {
    private static final String TAG = "Matches Activity";
    private MatchesAdapter matchesAdapter;
    private ApiClient client;
    private RecyclerView recyclerView;
    private String accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        applyThemeFromPreferences();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        accountId = getIntent().getStringExtra("account_id");

        client = ApiClient.getInstance();
        recyclerView = findViewById(R.id.Matches_recyclerview);

        matchesAdapter = new MatchesAdapter(this, new ArrayList<>(), this);

        setViews();
        listeners();
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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

    @Override
    public void onItemClick(String matchId) {
        Intent intent = new Intent(this, MatchesDetailsFragment.class);
        intent.putExtra("match_id", matchId);
        startActivity(intent);
    }

    private void applyThemeFromPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPreferences.getString("theme_key", "Light");

        switch (theme) {
            case "Dark":
                setTheme(R.style.AppTheme_Dark);
                break;
            case "Classic Light":
                setTheme(R.style.AppTheme_ClassicLight);
                break;
            case "Classic Dark":
                setTheme(R.style.AppTheme_ClassicDark);
                break;
            case "Pearl Dark":
                setTheme(R.style.AppTheme_PearlDark);
                break;
            default:
                setTheme(R.style.AppTheme_Light);
                break;
        }
    }

}
