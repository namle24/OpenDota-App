package vn.edu.usth.opendota.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import vn.edu.usth.opendota.player_info.fragment_heroes;
import vn.edu.usth.opendota.player_info.fragment_match;
import vn.edu.usth.opendota.player_info.fragment_overview;

public class player_adapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String[] titles = new String[] { "Overview", "Matches", "Heroes" };

    public player_adapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int page) {
        switch (page) {
            case 0:
                return fragment_overview.newInstance();
            case 1:
                return fragment_match.newInstance();
            case 2:
                return fragment_heroes.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
