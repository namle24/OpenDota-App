package vn.edu.usth.opendota.ui.my_profile.heroes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import vn.edu.usth.opendota.R;


public class PlayerHeroesFragment extends Fragment {
    private LinearLayout anti_mage;
    private LinearLayout invoker;
    private LinearLayout slark;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_heroes, container, false);



        return v;
    }


}