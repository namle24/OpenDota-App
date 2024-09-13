package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.opendota.R;


public class fragment_heroes extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_heroes, container, false);
    }

    public static fragment_heroes newInstance() {
        fragment_heroes frag_layout3 = new fragment_heroes();
        return frag_layout3;
    }
}