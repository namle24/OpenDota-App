package vn.edu.usth.opendota.ui.favourite;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.ProfileAdapters;
import vn.edu.usth.opendota.models.ProPlayerProfile;

public class FavoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProfileAdapters adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.favorites_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Truyền context khi khởi tạo adapter
        adapter = new ProfileAdapters(getContext());
        recyclerView.setAdapter(adapter);

        // Load danh sách yêu thích
        List<ProPlayerProfile> favouriteProPlayerProfiles = getFavourites();
        adapter.submit(favouriteProPlayerProfiles);
    }


    // Lấy danh sách profile yêu thích từ SharedPreferences
    private List<ProPlayerProfile> getFavourites() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("favorite_profiles", getContext().MODE_PRIVATE);
        String json = sharedPreferences.getString("favorites_list", null);
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<ProPlayerProfile>>() {}.getType();
            return gson.fromJson(json, type);
        }
        return new ArrayList<>();
    }
}
