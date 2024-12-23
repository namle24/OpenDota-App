package vn.edu.usth.opendota;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import vn.edu.usth.opendota.ui.favourite.FavoriteFragment;
import vn.edu.usth.opendota.ui.home.HomeFragment;
import vn.edu.usth.opendota.ui.search.SearchFragment;
import vn.edu.usth.opendota.ui.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        applyThemeFromPreferences();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.topappbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedTitle = sharedPreferences.getString("toolbar_title", "Home");
        toolbar.setTitle(savedTitle);

        toolbar.setNavigationOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
            navigationView.setCheckedItem(R.id.nav_home);
            toolbar.setTitle("Home");
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            item.setChecked(true);
            drawerLayout.closeDrawer(GravityCompat.START);

            if (id == R.id.nav_home) {
                replaceFragment(new HomeFragment());
                toolbar.setTitle("Home");
            } else if (id == R.id.nav_favourite) {
                replaceFragment(new FavoriteFragment());
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
        });
    }

    public MaterialToolbar getToolbar() {
        return toolbar;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }

    private void applyThemeFromPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPreferences.getString("theme_key", "Light");

        switch (theme) {
            case "Dark":
                setTheme(R.style.AppTheme_Dark);
                break;
            case "Classic Light":
                setTheme(R.style.AppTheme_ClassicLight);
                break;
            case "Classic Dark":
                setTheme(R.style.AppTheme_ClassicDark);
                break;
            case "Pearl Dark":
                setTheme(R.style.AppTheme_PearlDark);
                break;
            default:
                setTheme(R.style.AppTheme_Light);
                break;
        }
    }
}
