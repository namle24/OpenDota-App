package vn.edu.usth.opendota.models;

import java.io.Serializable;

public class PlayerObj implements Serializable {
    private int solo_competitive_rank;
    private int competitive_rank;
    private int rank_tier;
    private int leaderboard_rank;
    private ProPlayerProfile profile;
    private Winlose winLoss;
    private Heroes heroes;

    public Winlose getWinLoss() {
        return winLoss;
    }

    public void setWinLoss(Winlose winLoss) {
        this.winLoss = winLoss;
    }

    public int getSolo_competitive_rank() {
        return solo_competitive_rank;
    }

    public void setSolo_competitive_rank(int solo_competitive_rank) {
        this.solo_competitive_rank = solo_competitive_rank;
    }

    public int getCompetitive_rank() {
        return competitive_rank;
    }

    public void setCompetitive_rank(int competitive_rank) {
        this.competitive_rank = competitive_rank;
    }

    public int getRank_tier() {
        return rank_tier;
    }

    public void setRank_tier(int rank_tier) {
        this.rank_tier = rank_tier;
    }

    public int getLeaderboard_rank() {
        return leaderboard_rank;
    }

    public void setLeaderboard_rank(int leaderboard_rank) {
        this.leaderboard_rank = leaderboard_rank;
    }

    public ProPlayerProfile getProfile() {
        return profile;
    }

    public void setProfile(ProPlayerProfile profile) {
        this.profile = profile;
    }

    public Heroes getHeroes() {
        return heroes;
    }

    public void setHeroes(Heroes heroes) {
        this.heroes = heroes;
    }

}