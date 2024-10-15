package vn.edu.usth.opendota.profile;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.profile.heroes.PlayerHeroesFragment;
import vn.edu.usth.opendota.profile.matches.MatchesFragment;
import vn.edu.usth.opendota.profile.overview.OverviewFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private String titles[]=new String[]{"Overview","Matches","Heroes"};
    PlayerObj user;
    ArrayList<RecentMatchesObj> recentMatchList;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, PlayerObj user,ArrayList<RecentMatchesObj> recentMatchList) {
        super(fm,behavior);
        this.user=user;
        this.recentMatchList= recentMatchList;
    }

    @NonNull
    @Override
    public Fragment getItem(int page) {
        switch (page){
            case 1: return new MatchesFragment(recentMatchList);
            case 2: return new PlayerHeroesFragment();
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


