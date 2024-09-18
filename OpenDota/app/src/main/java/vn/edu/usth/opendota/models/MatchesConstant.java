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
        Matches match5 = new Matches(5, "Turbo", 6, 5, 9, "2024-09-24", "25:30", R.drawable.obsidian_destroyer_full, true);
        Matches match6 = new Matches(6, "All Draft Normal", 9, 4, 4, "2024-09-25", "60:15", R.drawable.slardar_full, true);
        Matches match7 = new Matches(7, "Ranks", 11, 2, 7, "2024-09-26", "35:45", R.drawable.mirana_full, false);
        Matches match8 = new Matches(8, "Turbo", 14, 1, 10, "2024-09-27", "20:10", R.drawable.sniper_full, true);
        Matches match9 = new Matches(9, "All Draft Normal", 7, 6, 8, "2024-09-28", "55:00", R.drawable.juggernaut_full, false);
        Matches match10 = new Matches(10, "Ranks", 13, 0, 5, "2024-09-29", "48:20", R.drawable.nevermore_full, true);
        Matches match11 = new Matches(11, "Turbo", 10, 3, 6, "2024-09-30", "22:50", R.drawable.phantom_assassin_full, false);
        Matches match12 = new Matches(12, "All Draft Normal", 9, 2, 9, "2024-10-01", "37:40", R.drawable.puck_full, true);
        Matches match13 = new Matches(13, "Ranks", 8, 4, 4, "2024-10-02", "52:10", R.drawable.pudge_full, false);
        Matches match14 = new Matches(14, "All Draft Normal", 11, 3, 12, "2024-10-03", "43:00", R.drawable.phoenix_full, true);
        Matches match15 = new Matches(15, "Turbo", 7, 5, 10, "2024-10-04", "33:33", R.drawable.sniper_full, true);

        results.add(match1);
        results.add(match2);
        results.add(match3);
        results.add(match5);
        results.add(match6);
        results.add(match7);
        results.add(match8);
        results.add(match9);
        results.add(match10);
        results.add(match11);
        results.add(match12);
        results.add(match13);
        results.add(match14);
        results.add(match15);


        return results;
    }
}
