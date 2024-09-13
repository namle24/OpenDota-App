package vn.edu.usth.opendota;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class fragment_match extends MainActivity{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View match = inflater.inflate(R.layout.layout_match_details, container, false);
        return match;
    }
}
