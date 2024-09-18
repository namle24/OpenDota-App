package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.opendota.R;


public class OverviewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    public static OverviewFragment newInstance() {
        OverviewFragment frag_layout1 = new OverviewFragment();
        return frag_layout1;
    }


}