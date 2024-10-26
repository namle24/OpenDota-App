package vn.edu.usth.opendota.models;

public class Overview {
    private Profile profile;
    private int rank_tier;
    private int leaderboard_rank;
    private Winlose winlose;

    public Profile getProfile() { return profile; }
    public void setProfile(Profile value) { this.profile = value; }

    public int getRankTier() { return rank_tier; }
    public void setRankTier(int value) { this.rank_tier = value; }

    public int getLeaderboardRank() { return leaderboard_rank; }
    public void setLeaderboardRank(int value) { this.leaderboard_rank = value; }

    public Winlose getWinlose() { return winlose; }

    public void setWinlose(Winlose winlose) { this.winlose = winlose; }

}