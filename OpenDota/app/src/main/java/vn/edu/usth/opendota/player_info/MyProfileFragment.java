package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapter.player_adapter;

public class MyProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        // Retrieve user data from the bundle
        Bundle args = getArguments();
        if (args != null) {
            String userName = args.getString("userName");
            String userId = args.getString("userId");

            // You can now use the userName and userId in the fragment, e.g., set the title
            getActivity().setTitle(userName);
        }

        ViewPager viewPager = view.findViewById(R.id.viewpager);
        player_adapter adapter = new player_adapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}