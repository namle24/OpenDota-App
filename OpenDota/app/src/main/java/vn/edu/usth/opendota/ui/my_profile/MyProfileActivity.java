package vn.edu.usth.opendota.ui.my_profile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.MyProfileAdapters;
import vn.edu.usth.opendota.models.Matches;
import vn.edu.usth.opendota.models.ProPlayerProfile;

public class MyProfileActivity extends AppCompatActivity {
    private static final String TAG = "MyProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        applyThemeFromPreferences();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Toolbar toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Profile");

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        ProPlayerProfile proPlayerProfile = (ProPlayerProfile) bundle.get("profile_data");
        ArrayList<Matches> recentMatchesList = (ArrayList<Matches>) bundle.get("player_recent_matches");



        ViewPager viewPager = findViewById(R.id.profile_viewpager);
        MyProfileAdapters adapter = new MyProfileAdapters(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, proPlayerProfile, recentMatchesList);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.profile_tab);
        tabLayout.setupWithViewPager(viewPager);
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
            case "ClassicDark":
                setTheme(R.style.AppTheme_ClassicDark);
                break;
            case "PearlDark":
                setTheme(R.style.AppTheme_PearlDark);
                break;
            default:
                setTheme(R.style.AppTheme_Light);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
