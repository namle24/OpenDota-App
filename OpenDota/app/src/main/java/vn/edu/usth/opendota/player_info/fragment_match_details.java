package vn.edu.usth.opendota.player_info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import vn.edu.usth.opendota.R;

public class fragment_match_details extends Fragment {

    private LinearLayout player_info1, player_info2, player_info3, player_info4, player_info5,
            player_info6, player_info7, player_info8, player_info9, player_info10;

    private LinearLayout layout_hide_show1, layout_hide_show2, layout_hide_show3, layout_hide_show4, layout_hide_show5,
            layout_hide_show6, layout_hide_show7, layout_hide_show8, layout_hide_show9, layout_hide_show10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View match = inflater.inflate(R.layout.fragment_match_details, container, false);
        initializeViews(match);

        setupClickListeners();

        return match;
    }

    private void initializeViews(View match) {
        player_info1 = match.findViewById(R.id.player_info1);
        player_info2 = match.findViewById(R.id.player_info2);
        player_info3 = match.findViewById(R.id.player_info3);
        player_info4 = match.findViewById(R.id.player_info4);
        player_info5 = match.findViewById(R.id.player_info5);
        player_info6 = match.findViewById(R.id.player_info6);
        player_info7 = match.findViewById(R.id.player_info7);
        player_info8 = match.findViewById(R.id.player_info8);
        player_info9 = match.findViewById(R.id.player_info9);
        player_info10 = match.findViewById(R.id.player_info10);

        layout_hide_show1 = match.findViewById(R.id.layout_hide_show1);
        layout_hide_show2 = match.findViewById(R.id.layout_hide_show2);
        layout_hide_show3 = match.findViewById(R.id.layout_hide_show3);
        layout_hide_show4 = match.findViewById(R.id.layout_hide_show4);
        layout_hide_show5 = match.findViewById(R.id.layout_hide_show5);
        layout_hide_show6 = match.findViewById(R.id.layout_hide_show6);
        layout_hide_show7 = match.findViewById(R.id.layout_hide_show7);
        layout_hide_show8 = match.findViewById(R.id.layout_hide_show8);
        layout_hide_show9 = match.findViewById(R.id.layout_hide_show9);
        layout_hide_show10 = match.findViewById(R.id.layout_hide_show10);
    }

    private void setupClickListeners() {
        player_info1.setOnClickListener(view -> toggleVisibility(layout_hide_show1));
        player_info2.setOnClickListener(view -> toggleVisibility(layout_hide_show2));
        player_info3.setOnClickListener(view -> toggleVisibility(layout_hide_show3));
        player_info4.setOnClickListener(view -> toggleVisibility(layout_hide_show4));
        player_info5.setOnClickListener(view -> toggleVisibility(layout_hide_show5));
        player_info6.setOnClickListener(view -> toggleVisibility(layout_hide_show6));
        player_info7.setOnClickListener(view -> toggleVisibility(layout_hide_show7));
        player_info8.setOnClickListener(view -> toggleVisibility(layout_hide_show8));
        player_info9.setOnClickListener(view -> toggleVisibility(layout_hide_show9));
        player_info10.setOnClickListener(view -> toggleVisibility(layout_hide_show10));
    }

    // Method to toggle visibility of a layout
    private void toggleVisibility(LinearLayout layout) {
        if (layout.getVisibility() == View.VISIBLE) {
            layout.setVisibility(View.GONE);
        } else {
            layout.setVisibility(View.VISIBLE);
        }
    }
}
