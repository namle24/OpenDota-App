package vn.edu.usth.opendota.ui.favourite;

import android.content.Intent;
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

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.SearchAdapter;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.ui.my_profile.MyProfileActivity;
import vn.edu.usth.opendota.utils.PrefUtil;

public class FavoriteFragment extends Fragment {
    private List<ProPlayerProfile> listFavorited;
    private RecyclerView recyclerView;
    private SearchAdapter favAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        recyclerView = view.findViewById(R.id.favorites_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Lấy danh sách người dùng yêu thích từ PrefUtil
        listFavorited = PrefUtil.getListFavorite(requireContext());

        favAdapter = new SearchAdapter(requireContext(), new ArrayList<>(listFavorited), new SearchAdapter.IOnSearchAdapterListener() {
            @Override
            public void onClickItem(ProPlayerProfile user) {
                navigateToProfileDetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerProfile user) {
                if (user.isFavorited()) {
                    removeFavorite(user);
                } else {
                    addFavorite(user);
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

        recyclerView.setAdapter(favAdapter);
        favAdapter.notifyDataSetChanged();

        return view;
    }


    private void addFavorite(ProPlayerProfile user) {
        if (!listFavorited.contains(user)) {
            PrefUtil.addToFavorites(requireContext(), user);
            user.setFavorited(true);
            listFavorited.add(user);  // Thêm người dùng vào danh sách yêu thích
            favAdapter.notifyItemInserted(listFavorited.size() - 1);  // Cập nhật giao diện
        }
    }

    private void removeFavorite(ProPlayerProfile user) {
        if (listFavorited.contains(user)) {
            PrefUtil.removeFavorite(requireContext(), user);
            user.setFavorited(false);
            int index = listFavorited.indexOf(user);
            listFavorited.remove(user);  // Xóa người dùng khỏi danh sách yêu thích
            favAdapter.notifyItemRemoved(index);  // Cập nhật giao diện
        }
    }


    private void updateUIWithFavorites() {
        favAdapter.notifyDataSetChanged(); // Cập nhật giao diện
    }

    private void navigateToProfileDetail(ProPlayerProfile proPlayerProfile) {
        Intent intent = new Intent(getContext(), MyProfileActivity.class);
        intent.putExtra("profile_data", proPlayerProfile);
        startActivity(intent);
    }
}
