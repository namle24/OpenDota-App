package vn.edu.usth.opendota.search;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
import vn.edu.usth.opendota.MainActivity;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.favourite.FavouritesActivity;
import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.PlayerWinLoss;
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.profile.ProfileActivity;
import vn.edu.usth.opendota.retrofit.APIClient;
import vn.edu.usth.opendota.settings.SettingActivity;
import vn.edu.usth.opendota.utils.PrefUtil;


public class SearchActivity extends AppCompatActivity {
    private final String TAG = SearchActivity.class.getSimpleName();
    private RelativeLayout relativeLayoutSearch;
    private SharedPreferences sharedPreferences;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private SearchAdapter searchAdapter;
    private List<ProPlayerObj> listPlayer;
    private ArrayList<ProPlayerObj> arrayList;
    private List<ProPlayerObj> allPlayers;
    private List<ProPlayerObj> listFavorited;
    // Lưu màu nền
    private int storedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        relativeLayoutSearch = findViewById(R.id.relative_layout_search);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        storedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        relativeLayoutSearch.setBackgroundColor(storedColor);

        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        searchView=findViewById(R.id.searchView);
        searchView.setIconified(false);
        searchView.clearFocus();

        Toolbar toolbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.search_drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // Điều hướng
        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            drawerLayout.closeDrawer(GravityCompat.START);

            if (id == R.id.nav_home) {
                startActivity(new Intent(SearchActivity.this, MainActivity.class));
            } else if (id == R.id.nav_favourite) {
                startActivity(new Intent(SearchActivity.this, FavouritesActivity.class));
            } else if (id == R.id.nav_search) {
                startActivity(new Intent(SearchActivity.this, SearchActivity.class));
            } else if (id == R.id.nav_setting) {
                startActivity(new Intent(SearchActivity.this, SettingActivity.class));
            }

            return true;
        });

        // Khởi tạo danh sách người chơi
        listPlayer = new ArrayList<>();
        arrayList = new ArrayList<>();
        searchAdapter = new SearchAdapter(SearchActivity.this, arrayList, new SearchAdapter.IOnSearchAdapterListener() {
            @Override
            public void onClickItem(ProPlayerObj user) {
                onClickGoTODetail(user);
            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {
                if (user.isFavorited()) {
                    PrefUtil.removeFavorite(SearchActivity.this, user);
                    user.setFavorited(false);
                } else {
                    PrefUtil.addToFavorites(SearchActivity.this, user);
                    user.setFavorited(true);
                }
                searchAdapter.notifyDataSetChanged();
            }
        })

        {
            @Override
            public void onClickItem(ProPlayerObj user) {

            }

            @Override
            public void onClickFavorite(ProPlayerObj user) {

            }
        };
        recyclerView.setAdapter(searchAdapter);

        listFavorited = PrefUtil.getListFavorite(this);

        callGetProPlayer();

        // search bar
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayList.clear();
                for(ProPlayerObj item: listPlayer){
                    if(item.getName().contains(newText)) {
                        arrayList.add(item);
                    }
                }
                searchAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    private List<ProPlayerObj> loadAllPlayers() {
        return new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int updatedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        if (storedColor != updatedColor) {
            storedColor = updatedColor;
            relativeLayoutSearch.setBackgroundColor(storedColor);
        }
    }

    private void callGetProPlayer() {
        APIClient.getProPlayer().enqueue(new Callback<List<ProPlayerObj>>() {
            @Override
            public void onResponse(Call<List<ProPlayerObj>> call, Response<List<ProPlayerObj>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    listPlayer.clear();
                    arrayList.clear();
                    for(ProPlayerObj item: response.body().subList(0, Math.min(response.body().size(), 30))){
                        for (ProPlayerObj itemFavorite : listFavorited) {
                            if (item.getAccountId() == itemFavorite.getAccountId()) {
                                item.setFavorited(true);
                                break;
                            }
                        }
                        listPlayer.add(item);
                        arrayList.add(item);
                    }
                    searchAdapter.notifyDataSetChanged();
                }
                //TODO: remove bot giu lai 20 items
            }

            @Override
            public void onFailure(Call<List<ProPlayerObj>> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void onClickGoTODetail(ProPlayerObj user) {
        APIClient.getRecentMatch(user.getAccountId()).enqueue(new Callback<List<RecentMatchesObj>>() {
            @Override
            public void onResponse(Call<List<RecentMatchesObj>> call, Response<List<RecentMatchesObj>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    callGetPlayerData(user,
                            response.body().subList(0, Math.min(response.body().size(), 30)));
                }
            }
            @Override
            public void onFailure(Call<List<RecentMatchesObj>> call, Throwable t) {
                Log.e("recent matches list", "onFailure: ", t);
            }
        });


    }

    private void callGetPlayerData(ProPlayerObj user, List<RecentMatchesObj> recentMatchesList) {
        APIClient.getPlayerData(user.getAccountId()).enqueue(new Callback<PlayerObj>() {
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

        APIClient.getPlayerWinLoss(accountId).enqueue(new Callback<PlayerWinLoss>() {
            @Override
            public void onResponse(Call<PlayerWinLoss> call, Response<PlayerWinLoss> response) {
                if (response.isSuccessful() && response.body() != null) {
                    playerObj.setWinLoss(response.body());
                    Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
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