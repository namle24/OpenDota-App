package vn.edu.usth.opendota.models;

public class Overview {
    private Profile profile;
    private int rank_tier;
    private long leaderboardRank;
    private Winlose winlose;

    public Profile getProfile() { return profile; }
    public void setProfile(Profile value) { this.profile = value; }

    public int getRankTier() { return rank_tier; }
    public void setRankTier(int value) { this.rank_tier = value; }

    public long getLeaderboardRank() { return leaderboardRank; }
    public void setLeaderboardRank(long value) { this.leaderboardRank = value; }

    public Winlose getWinlose() { return winlose; }

    public void setWinlose(Winlose winlose) { this.winlose = winlose; }

}
