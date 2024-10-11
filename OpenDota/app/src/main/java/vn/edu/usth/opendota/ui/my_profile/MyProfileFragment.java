package vn.edu.usth.opendota.ui.my_profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.MyProfileAdapters;

public class MyProfileFragment extends Fragment {

    public static MyProfileFragment newInstance() {
        return new MyProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        ViewPager pager = view.findViewById(R.id.profile_viewpager);
        PagerAdapter adapter = new MyProfileAdapters(getChildFragmentManager());
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.profile_tab);
        tabLayout.setupWithViewPager(pager);

        return view;
    }
}