package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.opendota.R;


public class HeroesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_heroes, container, false);
    }

    public static HeroesFragment newInstance() {
        HeroesFragment frag_layout3 = new HeroesFragment();
        return frag_layout3;
    }
}