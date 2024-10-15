package vn.edu.usth.opendota.profile;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;


public class ProfileActivity extends AppCompatActivity {
    private TabLayout myTabLayout;
    private ViewPager myViewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile);

        myTabLayout = findViewById(R.id.pp_tabLayout);
        myViewPager = findViewById(R.id.viewPager);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        PlayerObj user = (PlayerObj) bundle.get("player_data");
        ArrayList<RecentMatchesObj> rcMatchesList = (ArrayList<RecentMatchesObj>) bundle.get("player_recent_matches");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,user,rcMatchesList);
        myViewPager.setOffscreenPageLimit(3);
        myViewPager.setAdapter(viewPagerAdapter);
        myTabLayout.setupWithViewPager(myViewPager);

        toolbar = findViewById(R.id.playerProfile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}