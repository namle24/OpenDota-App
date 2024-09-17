package vn.edu.usth.opendota.models;

import android.content.Context;
import android.content.Intent;

import vn.edu.usth.opendota.matches.Matches;

public class MyClickListener implements OnClickListener {
    private final Context context;

    public MyClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(int position, Matches match) {
        int matchId = match.getId();
        Intent intent = null;
        intent.putExtra("MATCH_ID", matchId);
        context.startActivity(intent);
    }
}
