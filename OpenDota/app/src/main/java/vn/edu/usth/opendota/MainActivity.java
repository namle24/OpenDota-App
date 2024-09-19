package vn.edu.usth.opendota;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import vn.edu.usth.opendota.favourite.FavouriteFragment;
import vn.edu.usth.opendota.home.HomeFragment;
import vn.edu.usth.opendota.player_info.MyProfileFragment;
import vn.edu.usth.opendota.search.SearchFragment;
import vn.edu.usth.opendota.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.topappbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
            toolbar.setTitle("Home");
            navigationView.setCheckedItem(R.id.nav_home);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);

                if (id == R.id.nav_home) {
                    replaceFragment(new HomeFragment());
                    toolbar.setTitle("Home");
                } else if (id == R.id.nav_myprofile) {
                    replaceFragment(new MyProfileFragment());
                    toolbar.setTitle("My Profile");
                } else if (id == R.id.nav_favourite) {
                    replaceFragment(new FavouriteFragment());
                    toolbar.setTitle("Favourite");
                } else if (id == R.id.nav_search) {
                    replaceFragment(new SearchFragment());
                    toolbar.setTitle("Search");
                } else if (id == R.id.nav_settings) {
                    replaceFragment(new SettingsFragment());
                    toolbar.setTitle("Settings");
                } else {
                    return true;
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}
