package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.opendota.R;


public class fragment_overview extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    public static fragment_overview newInstance() {
        fragment_overview frag_layout1 = new fragment_overview();
        return frag_layout1;
    }
}