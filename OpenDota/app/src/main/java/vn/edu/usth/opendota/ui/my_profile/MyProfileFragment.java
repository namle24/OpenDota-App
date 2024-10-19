package vn.edu.usth.opendota.ui.my_profile;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.adapters.MyProfileAdapters;
import vn.edu.usth.opendota.models.Heroes;
import vn.edu.usth.opendota.models.PlayerObj;
import vn.edu.usth.opendota.models.PlayerWinLoss;
import vn.edu.usth.opendota.models.ProPlayerObj;
import vn.edu.usth.opendota.models.RecentMatchesObj;
import vn.edu.usth.opendota.retrofit.IAPINetwork;

public class MyProfileFragment extends Fragment {

    private TabLayout myTabLayout;
    private ViewPager myViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        myTabLayout = view.findViewById(R.id.profile_tab);
        myViewPager = view.findViewById(R.id.profile_viewpager);

        Bundle bundle = getArguments();
        if (bundle == null) {
            Toast.makeText(getContext(), "No data received", Toast.LENGTH_SHORT).show();
            return view;
        }

        PlayerObj user = (PlayerObj) bundle.get("player_data");
        ArrayList<RecentMatchesObj> rcMatchesList = (ArrayList<RecentMatchesObj>) bundle.get("player_recent_matches");


        MyProfileAdapters viewPagerAdapter = new MyProfileAdapters(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, user, rcMatchesList);
        myViewPager.setOffscreenPageLimit(3);
        myViewPager.setAdapter(viewPagerAdapter);
        myTabLayout.setupWithViewPager(myViewPager);

        return view;
    }
}
