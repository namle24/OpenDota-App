package vn.edu.usth.opendota.models;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.opendota.R;
import vn.edu.usth.opendota.matches.Matches;

public class MatchesConstant {

    public static List<Matches> generates() {
        List<Matches> results = new ArrayList<>();

        Matches match1 = new Matches(1, "Ranks", 10, 2, 5, "2024-09-20", "40:20", R.drawable.slardar_full, true);
        Matches match2 = new Matches(2, "All Draft Normal", 15, 3, 8, "2024-09-21", "50:00", R.drawable.queenofpain_full, false);
        Matches match3 = new Matches(3, "All Draft Normal", 8, 4, 7, "2024-09-22", "30:00", R.drawable.phantom_assassin_full, true);

        results.add(match1);
        results.add(match2);
        results.add(match3);

        return results;
    }
}
