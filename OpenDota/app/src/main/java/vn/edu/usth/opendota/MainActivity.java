package vn.edu.usth.opendota;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import vn.edu.usth.opendota.favourite.FavouritesActivity;
import vn.edu.usth.opendota.search.SearchActivity;
import vn.edu.usth.opendota.settings.SettingActivity;


public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayoutSearch;
    private SharedPreferences sharedPreferences;
    private int storedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayoutSearch = findViewById(R.id.relative_layout_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        storedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        relativeLayoutSearch.setBackgroundColor(storedColor);

//        // Player heroes fragment initial
//        PlayerHeroesFragment firstFragment = new PlayerHeroesFragment();
//        getSupportFragmentManager().beginTransaction().add(
//                R.id.container, firstFragment
//        ).commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                if (id == R.id.nav_home) {
//                    Toast toast = Toast.makeText(MainActivity.this, " Homw has been clicked", Toast.LENGTH_SHORT);
//                    toast.show();
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_favourite) {
                    Intent intent = new Intent(MainActivity.this, FavouritesActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_search) {
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.nav_setting) {
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });
    }

    // keep background color
    @Override
    protected void onResume() {
        super.onResume();
        int updatedColor = sharedPreferences.getInt("selected_color", getResources().getColor(R.color.background));
        if (storedColor != updatedColor) {
            storedColor = updatedColor;
            relativeLayoutSearch.setBackgroundColor(storedColor);
        }
    }
}