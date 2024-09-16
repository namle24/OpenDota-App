package vn.edu.usth.opendota.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import vn.edu.usth.opendota.R;

public class Matches {
    private String modes;
    private int kills;
    private int deaths;
    private int assists;
    private final String startDate;
    private String durationStr;
    private int avatarResId;
    private boolean isWin;

    public Matches(String modes, int kills, int deaths, int assists, String startDate, String durationStr, int avatarResId, boolean isWin) {
        this.modes = modes;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.startDate = startDate;
        this.durationStr = durationStr;
        this.avatarResId = avatarResId;
        this.isWin = isWin;
    }


    public boolean isWin() {
        return isWin;
    }

    public long getKills() {
        return kills;
    }
    public void setKills(int value) {
        this.kills = value;
    }

    public long getDeaths() {
        return deaths;
    }
    public void setDeaths(int value) {
        this.deaths = value;
    }

    public long getAssists() {
        return assists;
    }
    public void setAssists(int value) {
        this.assists = value;
    }

    public long getStartTime() {
        return parseDateToTimestamp(startDate);
    }

    public long getDuration() {
        return parseDurationToSeconds(durationStr);
    }

    public int getAvatarResId() {
        return avatarResId;
    }
    public void setAvatarResId(int resId) {
        this.avatarResId = resId;
    }

    public String getModes() {
        return modes;
    }

    public void setModes(int modes) {
        this.modes = String.valueOf(modes);
    }


    private static long parseDateToTimestamp(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date date = sdf.parse(dateStr);
            if (date != null) {
                return date.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static long parseDurationToSeconds(String durationStr) {
        String[] parts = durationStr.split(":");
        if (parts.length == 2) {
            try {
                long minutes = Long.parseLong(parts[0]);
                long seconds = Long.parseLong(parts[1]);
                return minutes * 60 + seconds;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static List<Matches> generates() {
        List<Matches> results = new ArrayList<>();

        results.add(new Matches("Ranks",10, 2, 15, "12/09/2024", "50:00", R.drawable.slardar_full, true));
        results.add(new Matches("All Draft Normal",5, 8, 20, "12/09/2024", "50:00", R.drawable.queenofpain_full, false));
        results.add(new Matches("All Draft Normal", 12, 4, 8, "12/09/2024", "50:00", R.drawable.slardar_full, true));
        results.add(new Matches("All Draft Normal",7, 10, 25, "12/09/2024", "50:00", R.drawable.slardar_full, false));
        results.add(new Matches("All Draft Normal",14, 3, 17, "12/09/2024", "50:00", R.drawable.slardar_full, true));

        return results;
    }
}
