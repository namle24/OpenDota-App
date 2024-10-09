package vn.edu.usth.opendota.ui.search;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;

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
import vn.edu.usth.opendota.adapters.ProfileAdapters;
import vn.edu.usth.opendota.models.Profile;
import vn.edu.usth.opendota.retrofit.ApiClient;

public class SearchFragment extends Fragment {
    private final ProfileAdapters profileAdapters = new ProfileAdapters();
    private ApiClient client;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private List<Profile> profileList = new ArrayList<>();  // Lưu danh sách người chơi

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        client = ApiClient.getInstance();
        recyclerView = view.findViewById(R.id.Matches_recyclerview);
        searchView = view.findViewById(R.id.search_view); // Lấy SearchView từ layout
        setViews();
        listeners();
        setupSearch();  // Thiết lập lắng nghe tìm kiếm
    }

    private void setViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(profileAdapters);
    }

    private void listeners() {
        client.getAPIService().getProfile().enqueue(new Callback<List<Profile>>() {
            @Override
            public void onResponse(@NonNull Call<List<Profile>> call, @NonNull Response<List<Profile>> response) {
                Log.d(TAG, "onResponse: " + response.body());
                if (response.isSuccessful()) {
                    profileList = response.body();
                    if (profileList != null) {
                        if (profileList.size() > 30) {
                            profileList = profileList.subList(0, 30);
                        }
                    }
                    profileAdapters.submit(profileList); // Hiển thị danh sách ban đầu
                } else {
                    Log.e(TAG, "Error code: " + response.code() + " Error Message: " + response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Profile>> call, @NonNull Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
            }
        });
    }

    private void setupSearch() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;  // Không xử lý gì khi nhấn "submit"
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterProfiles(newText);  // Lọc danh sách khi người dùng nhập liệu
                return true;
            }
        });
    }

    // Hàm lọc danh sách người chơi
    private void filterProfiles(String query) {
        List<Profile> filteredList = new ArrayList<>();
        for (Profile profile : profileList) {
            if (profile.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(profile);
            }
        }
        profileAdapters.submit(filteredList);  // Cập nhật lại danh sách hiển thị
    }
}
