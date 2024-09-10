package vn.edu.usth.opendota;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class layout_header extends MainActivity{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View home = inflater.inflate(R.layout.layout_home, container, false);
        return home;
    }
}
