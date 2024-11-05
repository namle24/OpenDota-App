package vn.edu.usth.opendota.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import vn.edu.usth.opendota.models.ProPlayerProfile;
import vn.edu.usth.opendota.ui.my_profile.HeroesFragment;
import vn.edu.usth.opendota.ui.my_profile.MatchesFragment;
import vn.edu.usth.opendota.ui.my_profile.OverviewFragment;

public class MyProfileAdapters extends FragmentPagerAdapter {
    private static final String TAG = "ADAPTERS";
    private final ProPlayerProfile profile;

    private final String[] titles = new String[]{"Overview", "Matches", "Heroes"};

    public MyProfileAdapters(FragmentManager fm, ProPlayerProfile profile) {
        super(fm);
        this.profile = profile;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int page) {
        switch (page) {
            case 0:
                return OverviewFragment.newInstance(profile.getAccountID());
            case 1:
                return MatchesFragment.newInstance(profile.getAccountID());
            case 2:
                return HeroesFragment.newInstance(profile.getAccountID());
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}