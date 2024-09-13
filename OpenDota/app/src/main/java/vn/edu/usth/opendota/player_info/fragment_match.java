package vn.edu.usth.opendota.player_info;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import vn.edu.usth.opendota.R;

public class fragment_match extends Fragment implements View.OnClickListener {
    private static final String TAG = "Cardview";
    private CardView card1, card2, card3, card4, card5, card6, card7, card8, card9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        card1 = view.findViewById(R.id.match_1);
        card2 = view.findViewById(R.id.match_2);
        card3 = view.findViewById(R.id.match_3);
        card4 = view.findViewById(R.id.match_4);
        card5 = view.findViewById(R.id.match_5);
        card6 = view.findViewById(R.id.match_6);
        card7 = view.findViewById(R.id.match_7);
        card8 = view.findViewById(R.id.match_8);
        card9 = view.findViewById(R.id.match_9);


        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.match_1) {
            Log.d(TAG, "======================( CardView 1 clicked )=========================");
            Intent intent = new Intent(getActivity(), layout_match_details.class);
        } else if (v.getId() == R.id.match_2) {
            Log.d(TAG, "======================( CardView 2 clicked )=========================");
        } else if (v.getId() == R.id.match_3) {
            Log.d(TAG, "======================( CardView 3 clicked )=========================");
        } else if (v.getId() == R.id.match_4) {
            Log.d(TAG, "======================( CardView 4 clicked )=========================");
        } else if (v.getId() == R.id.match_5) {
            Log.d(TAG, "======================( CardView 5 clicked )=========================");
        } else if (v.getId() == R.id.match_6) {
            Log.d(TAG, "======================( CardView 6 clicked )=========================");
        } else if (v.getId() == R.id.match_7) {
            Log.d(TAG, "======================( CardView 7 clicked )=========================");
        } else if (v.getId() == R.id.match_8) {
            Log.d(TAG, "======================( CardView 8 clicked )=========================");
        } else if (v.getId() == R.id.match_9) {
            Log.d(TAG, "======================( CardView 9 clicked )=========================");
        } else {
            Log.d(TAG, "Unknown CardView clicked");
        }

        Toast.makeText(getActivity(), "CardView clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), layout_match_details.class);
        startActivity(intent);
    }


    public static fragment_match newInstance() {
        return new fragment_match();
    }
}
