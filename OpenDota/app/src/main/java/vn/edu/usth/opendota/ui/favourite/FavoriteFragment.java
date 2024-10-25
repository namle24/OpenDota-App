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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.ProfileAdapters;
import vn.edu.usth.opendota.adapters.SearchAdapter;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.ui.my_profile.MyProfileActivity;
import vn.edu.usth.opendota.utils.PrefUtil;

public class FavoriteFragment extends Fragment {

    private static final String TAG = "FAVOURITE";
    private RecyclerView recyclerView;
    private SearchAdapter adapter;
    private List<ProPlayerProfile> listFavorited;
    private SharedPreferences sharedPreferences;
    private ProfileAdapters favAdapter;

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
        List<ProPlayerProfile> allPlayers = getAllPlayers();

        listFavorited = PrefUtil.getListFavorite(requireContext());
        if (listFavorited.isEmpty()) {
            Log.d("Favorites", "No favorites found.");
        }

        adapter = new SearchAdapter(requireContext(), new ArrayList<>(listFavorited), new SearchAdapter.IOnSearchAdapterListener() {

            @Override
            public void onClickItem(ProPlayerProfile user) {
                navigateToProfileDetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerProfile proPlayerProfile) {
                if (proPlayerProfile.isFavorited()) {
                    removeFavorite(proPlayerProfile);
                } else {
                    addFavorite(proPlayerProfile);
                }
            }
        }) {
            @Override
            public void onClickItem(ProPlayerProfile user) {

            }

            @Override
            public void onClickFavorite(ProPlayerProfile user) {

            }
        };
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private List<ProPlayerProfile> getAllPlayers() {
        return new ArrayList<>();
    }

    private void removeFavorite(ProPlayerProfile user) {
        PrefUtil.removeFavorite(requireContext(), user); // Xóa người chơi khỏi danh sách yêu thích
        user.setFavorited(false); // Cập nhật trạng thái
        updateUIWithFavorites(); // Cập nhật giao diện người dùng
    }

    private void addFavorite(ProPlayerProfile user) {
        PrefUtil.addToFavorites(requireContext(), user); // Thêm người chơi vào danh sách yêu thích
        user.setFavorited(true); // Cập nhật trạng thái
        updateUIWithFavorites(); // Cập nhật giao diện người dùng
    }

    private void updateUIWithFavorites() {
        favAdapter.notifyDataSetChanged(); // Cập nhật adapter
    }

    private void navigateToProfileDetail(ProPlayerProfile proPlayerProfile) {
        Intent intent = new Intent(getContext(), MyProfileActivity.class);
        intent.putExtra("profile_data", proPlayerProfile);
        startActivity(intent);
    }
}