package vn.edu.usth.opendota.ui.my_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import vn.edu.usth.opendota.R;

public class HeroesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_heroes, container, false);
    }

    public static HeroesFragment newInstance() {
        HeroesFragment my_profilefrag3 = new HeroesFragment();
        return my_profilefrag3;
    }
}