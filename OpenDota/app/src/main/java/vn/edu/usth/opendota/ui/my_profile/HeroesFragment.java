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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.HeroesAdapters;
import vn.edu.usth.opendota.models.Heroes;
import vn.edu.usth.opendota.retrofit.ApiClient;

public class HeroesFragment extends Fragment {
    private HeroesAdapters heroesAdapter = new HeroesAdapters();
    private ApiClient client;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_heroes, container, false);
    }

    public static HeroesFragment newInstance() {
        return new HeroesFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = ApiClient.getInstance();
        recyclerView = view.findViewById(R.id.Heroes_recyclerview);
        setViews();
        listeners();
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(heroesAdapter);
    }

    private void listeners() {
        client.getAPIService().getHeroes("1296625").enqueue(new Callback<List<Heroes>>() {
            @Override
            public void onResponse(@NonNull Call<List<Heroes>> call, @NonNull Response<List<Heroes>> response) {
                Log.d(TAG, "onResponse: " + response.body());
                if (response.isSuccessful()) {
                    List<Heroes> heroes = response.body();
                    if (heroes != null) {

                        heroesAdapter.submit(heroes);
                    }
                } else {
                    Log.e(TAG, "Error code: " + response.code() + " Error Message: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Heroes>> call, @NonNull Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
            }
        });
    }
}
