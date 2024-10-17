package vn.edu.usth.opendota.ui.favourite;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.SearchAdapter;
import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.PlayerWinLoss;
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.retrofit.IAPINetwork;
import vn.edu.usth.opendota.ui.my_profile.MyProfileFragment;
import vn.edu.usth.opendota.utils.PrefUtil;


public class Favourites_Activity extends AppCompatActivity {
    private RelativeLayout relativeLayoutSearch;
    private SharedPreferences sharedPreferences;
    private int storedColor;
    private RecyclerView recyclerView;
    private SearchAdapter favAdapter;
    private List<ProPlayerObj> listFavorited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_favourite);

        recyclerView = findViewById(R.id.favorites_recyclerview);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        storedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        recyclerView.setBackgroundColor(storedColor);
        List<ProPlayerObj> allPlayers = getAllPlayers();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listFavorited = PrefUtil.getListFavorite(this);

        if (listFavorited.isEmpty()) {
            Log.d("Favorites", "No favorites found.");
        }

        favAdapter = new SearchAdapter(Favourites_Activity.this, new ArrayList<>(listFavorited), new SearchAdapter.IOnSearchAdapterListener() {
            @Override
            public void onClickItem(ProPlayerObj user) {
                onClickGoTODetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {
                // Bỏ yêu thích hoặc thêm yêu thích
                if (user.isFavorited()) {
                    removeFavorite(user);
                } else {
                    addFavorite(user);
                }
            }
        }) {
            @Override
            public void onClickItem(ProPlayerObj user) {

            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {

            }
        };

        recyclerView.setAdapter(favAdapter);
        favAdapter.notifyDataSetChanged();
    }

    private List<ProPlayerObj> getAllPlayers() {
        return new ArrayList<>();
    }

    private void removeFavorite(ProPlayerObj user) {
        PrefUtil.removeFavorite(Favourites_Activity.this, user); // Xóa người chơi khỏi danh sách yêu thích
        user.setFavorited(false); // Cập nhật trạng thái
        updateUIWithFavorites(); // Cập nhật giao diện người dùng
    }

    private void addFavorite(ProPlayerObj user) {
        PrefUtil.addToFavorites(Favourites_Activity.this, user); // Thêm người chơi vào danh sách yêu thích
        user.setFavorited(true); // Cập nhật trạng thái
        updateUIWithFavorites(); // Cập nhật giao diện người dùng
    }

    private void updateUIWithFavorites() {
        favAdapter.notifyDataSetChanged(); // Cập nhật adapter
    }

    @Override
    protected void onResume() {
        super.onResume();
        int updatedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        if (storedColor != updatedColor) {
            storedColor = updatedColor;
            recyclerView.setBackgroundColor(storedColor);
        }
    }

    private void onClickGoTODetail(ProPlayerObj user) {
        IAPINetwork.getRecentMatch(user.getAccountId()).enqueue(new Callback<List<RecentMatchesObj>>() {
            @Override
            public void onResponse(Call<List<RecentMatchesObj>> call, Response<List<RecentMatchesObj>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    callGetPlayerData(user, response.body().subList(0, Math.min(response.body().size(), 30)));
                }
            }

            @Override
            public void onFailure(Call<List<RecentMatchesObj>> call, Throwable t) {
                Log.e("recent matches list", "onFailure: ", t);
            }
        });
    }

    private void callGetPlayerData(ProPlayerObj user, List<RecentMatchesObj> recentMatchesList) {
        IAPINetwork.getPlayerData(user.getAccountId()).enqueue(new Callback<PlayerObj>() {
            @Override
            public void onResponse(Call<PlayerObj> call, Response<PlayerObj> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PlayerObj playerObj = response.body();
                    playerObj.setProfile(user);
                    callGetPlayerWl(playerObj, user.getAccountId(), recentMatchesList);
                }
            }

            @Override
            public void onFailure(Call<PlayerObj> call, Throwable t) {
                Log.e("player_data", "onFailure: ", t);
            }
        });
    }

    private void callGetPlayerWl(PlayerObj playerObj, int accountId, List<RecentMatchesObj> recentMatchesList) {
        IAPINetwork.getPlayerWinLoss(accountId).enqueue(new Callback<PlayerWinLoss>() {
            @Override
            public void onResponse(Call<PlayerWinLoss> call, Response<PlayerWinLoss> response) {
                if (response.isSuccessful() && response.body() != null) {
                    playerObj.setWinLoss(response.body());
                    Intent intent = new Intent(Favourites_Activity.this, MyProfileFragment.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("player_data", playerObj);
                    bundle.putSerializable("player_recent_matches", new ArrayList<>(recentMatchesList));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<PlayerWinLoss> call, Throwable t) {
                Log.e("recent matches list", "onFailure: ", t);
            }
        });
    }
}