package vn.edu.usth.opendota.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.ui.my_profile.heroes.HeroesFragment;
import vn.edu.usth.opendota.ui.my_profile.matches.MatchesFragment;
import vn.edu.usth.opendota.ui.my_profile.overview.OverviewFragment;

public class MyProfileAdapters extends FragmentPagerAdapter {
    private String titles[]=new String[]{"Overview","Matches","Heroes"};
    PlayerObj user;
    ArrayList<RecentMatchesObj> recentMatchList;
    public MyProfileAdapters(@NonNull FragmentManager fm, int behavior, PlayerObj user, ArrayList<RecentMatchesObj> recentMatchList) {
        super(fm,behavior);
        this.user=user;
        this.recentMatchList= recentMatchList;
    }

    @NonNull
    @Override
    public Fragment getItem(int page) {
        switch (page){
            case 1: return new MatchesFragment(recentMatchList);
            case 2: return new HeroesFragment();
            default: return new OverviewFragment(user,recentMatchList);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int page) {

        return titles[page];
    }
}