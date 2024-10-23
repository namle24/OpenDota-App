package vn.edu.usth.opendota.models;

public class Overview {
    private Profile profile;
    private long rankTier;
    private long leaderboardRank;
    private Winlose winlose;

    public Profile getProfile() { return profile; }

    public void setProfile(Profile value) { this.profile = value; }
    public long getRankTier() { return rankTier; }

    public void setRankTier(long value) { this.rankTier = value; }
    public long getLeaderboardRank() { return leaderboardRank; }

    public void setLeaderboardRank(long value) { this.leaderboardRank = value; }

    public Winlose getWinlose() { return winlose; }

    public void setWinlose(Winlose winlose) { this.winlose = winlose; }

}
