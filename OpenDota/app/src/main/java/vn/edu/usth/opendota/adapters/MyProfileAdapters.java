package vn.edu.usth.opendota.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import vn.edu.usth.opendota.models.Matches;
import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.ui.my_profile.HeroesFragment;
import vn.edu.usth.opendota.ui.my_profile.MatchesFragment;
import vn.edu.usth.opendota.ui.my_profile.OverviewFragment;

public class MyProfileAdapters extends FragmentPagerAdapter {
    private static final String TAG = "ADAPTERS";
    private final ProPlayerProfile profile;
    ArrayList<Matches> recentMatchList;

    private final String[] titles = new String[]{"Overview", "Matches", "Heroes"};

    public MyProfileAdapters(FragmentManager fm, int behaviorResumeOnlyCurrentFragment, ProPlayerProfile profile, ArrayList<Matches> rcMatchesList) {
        super(fm);
        this.profile = profile;
        this.recentMatchList = rcMatchesList;  // Corrected recentMatchList initialization
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int page) {
        if (profile == null) {
            // Handle the error, maybe return a default fragment or log the issue
            return new OverviewFragment(); // or another fragment to indicate an error
        }

        switch (page) {
            case 0:
                return OverviewFragment.newInstance(String.valueOf(profile.getAccountId()));
            case 1:
                return MatchesFragment.newInstance(String.valueOf(profile.getAccountId()));
            case 2:
                return HeroesFragment.newInstance(String.valueOf(profile.getAccountId()));
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
