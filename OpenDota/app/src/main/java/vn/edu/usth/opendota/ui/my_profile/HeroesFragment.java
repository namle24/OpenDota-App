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
import vn.edu.usth.opendota.adapters.HeroesAdapters;
import vn.edu.usth.opendota.models.Heroes;
import vn.edu.usth.opendota.retrofit.ApiClient;

public class HeroesFragment extends Fragment {
    private HeroesAdapters heroesAdapters;
    private ApiClient client;
    private RecyclerView recyclerView;
    private String accountId;
    private LottieAnimationView animationView;


    public static HeroesFragment newInstance(String accountId) {
        HeroesFragment fragment = new HeroesFragment();
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
        return inflater.inflate(R.layout.fragment_heroes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = ApiClient.getInstance();
        recyclerView = view.findViewById(R.id.Heroes_recyclerview);
        animationView = view.findViewById(R.id.animationView);
        animationView.setVisibility(View.VISIBLE);


        heroesAdapters = new HeroesAdapters(getContext(), new ArrayList<>());

        setViews();
        listeners();
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(heroesAdapters);
    }

    private void listeners() {
        if (accountId != null) {
            client.getAPIService().getHeroes(accountId).enqueue(new Callback<List<Heroes>>() {
                @Override
                public void onResponse(@NonNull Call<List<Heroes>> call, @NonNull Response<List<Heroes>> response) {
                    Log.d(TAG, "onResponse: " + response.body());
                    if (response.isSuccessful()) {
                        List<Heroes> heroes = response.body();
                        assert heroes != null;
                        heroesAdapters.submit(heroes);
                        animationView.setVisibility(View.GONE);

                    } else {
                        Log.e(TAG, "Error code: " + response.code() + " Error Message: " + response.message());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<Heroes>> call, @NonNull Throwable t) {
                    Log.e(TAG, "Failure: " + t.getMessage());
                    animationView.setVisibility(View.GONE);

                }
            });
        } else {
            Log.e(TAG, "Account ID is null");
        }
    }
}
