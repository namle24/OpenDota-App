package vn.edu.usth.opendota.ui.favourite;

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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.ProfileAdapters;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.ui.my_profile.MyProfileActivity;

public class FavoriteFragment extends Fragment {

    private static final String TAG = "FAVOURITE";
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

        // Khởi tạo RecyclerView và Adapter
        recyclerView = view.findViewById(R.id.favorites_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProfileAdapters(getContext(), this::navigateToProfileDetail);
        recyclerView.setAdapter(adapter);

        // Lấy danh sách yêu thích và cập nhật Adapter
        loadFavorites();
    }

    private void loadFavorites() {
        List<ProPlayerProfile> favouriteProPlayerProfiles = getFavourites();
        if (favouriteProPlayerProfiles.isEmpty()) {
            Log.d(TAG, "No favorite profiles found.");
        } else {
            Log.d(TAG, "Loaded " + favouriteProPlayerProfiles.size() + " favorite profiles.");
        }
        adapter.submit(favouriteProPlayerProfiles); // Gọi submit với danh sách yêu thích
    }

    @Override
    public void onResume() {
        super.onResume();
        // Cập nhật danh sách yêu thích khi trở lại fragment
        loadFavorites();
    }


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

    private void navigateToProfileDetail(ProPlayerProfile proPlayerProfile) {
        Intent intent = new Intent(getContext(), MyProfileActivity.class);
        intent.putExtra("profile_data", proPlayerProfile);
        startActivity(intent);
    }
}
