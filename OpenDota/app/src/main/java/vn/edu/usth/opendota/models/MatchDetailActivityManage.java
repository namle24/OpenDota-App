package vn.edu.usth.opendota.models;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.matches.Matches;

public class MatchDetailActivityManage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Matches match = (Matches) intent.getSerializableExtra("MATCH_DETAILS");

        if (match != null) {
            setContentView(getLayoutForMatchId(match.getId()));
        } else {
            setContentView(R.layout.fragment_error);
        }
    }

    private int getLayoutForMatchId(int matchId) {
        switch (matchId) {
            case 1:
                return R.layout.fragment_match_details;
            case 2:
                return R.layout.hero_item;
            default:
                return R.layout.fragment_match_details;
        }
    }
}