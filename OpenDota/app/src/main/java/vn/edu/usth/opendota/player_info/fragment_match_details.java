package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.player_info.MyProfileFragment;

public class fragment_match_details extends MyProfileFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View match = inflater.inflate(R.layout.fragment_match_details, container, false);
        return match;
    }
}