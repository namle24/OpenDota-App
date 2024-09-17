package vn.edu.usth.opendota.matches;

import java.io.Serializable;

public class Matches implements Serializable {
    private int id; // Thêm trường ID
    private String modes;
    private int kills;
    private int deaths;
    private int assists;
    private final String startDate;
    private final String durationStr;
    private int avatarResId;
    private final boolean isWin;

    public Matches(int id, String modes, int kills, int deaths, int assists, String startDate, String durationStr, int avatarResId, boolean isWin) {
        this.id = id;
        this.modes = modes;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.startDate = startDate;
        this.durationStr = durationStr;
        this.avatarResId = avatarResId;
        this.isWin = isWin;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public boolean isWin() {
        return isWin;
    }

    public int getKills() {
        return kills;
    }
    public void setKills(int value) {
        this.kills = value;
    }

    public int getDeaths() {
        return deaths;
    }
    public void setDeaths(int value) {
        this.deaths = value;
    }

    public int getAssists() {
        return assists;
    }
    public void setAssists(int value) {
        this.assists = value;
    }

    public String getStartTime() {
        return startDate;
    }

    public String getDuration() {
        return durationStr;
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

    public void setModes(String modes) {
        this.modes = modes;
    }
}
