package vn.edu.usth.opendota.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NormalPlayerObj implements Serializable {

    @SerializedName("tracked_until")
    private String trackedUntil;

    @SerializedName("solo_competitive_rank")
    private String soloCompetitiveRank;

    @SerializedName("competitive_rank")
    private String competitiveRank;

    @SerializedName("rank_tier")
    private int rankTier;

    @SerializedName("leaderboard_rank")
    private int leaderboardRank;

    @SerializedName("mmr_estimate")
    private MmrEstimate mmrEstimate;

    @SerializedName("profile")
    private Profile profile;

    @SerializedName("isFavorited")
    private boolean isFavorited;

    // Getter and Setter methods

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public String getTrackedUntil() {
        return trackedUntil;
    }

    public void setTrackedUntil(String trackedUntil) {
        this.trackedUntil = trackedUntil;
    }

    public String getSoloCompetitiveRank() {
        return soloCompetitiveRank;
    }

    public void setSoloCompetitiveRank(String soloCompetitiveRank) {
        this.soloCompetitiveRank = soloCompetitiveRank;
    }

    public String getCompetitiveRank() {
        return competitiveRank;
    }

    public void setCompetitiveRank(String competitiveRank) {
        this.competitiveRank = competitiveRank;
    }

    public int getRankTier() {
        return rankTier;
    }

    public void setRankTier(int rankTier) {
        this.rankTier = rankTier;
    }

    public int getLeaderboardRank() {
        return leaderboardRank;
    }

    public void setLeaderboardRank(int leaderboardRank) {
        this.leaderboardRank = leaderboardRank;
    }

    public MmrEstimate getMmrEstimate() {
        return mmrEstimate;
    }

    public void setMmrEstimate(MmrEstimate mmrEstimate) {
        this.mmrEstimate = mmrEstimate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "NormalPlayerObj{" +
                "profile=" + profile +
                ", rankTier=" + rankTier +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NormalPlayerObj that = (NormalPlayerObj) obj;
        return profile.getAccountId() == that.profile.getAccountId();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(profile.getAccountId());
    }

    // Nested MmrEstimate class
    public class MmrEstimate {
        @SerializedName("estimate")
        private int estimate;

        public int getEstimate() {
            return estimate;
        }

        public void setEstimate(int estimate) {
            this.estimate = estimate;
        }

        @Override
        public String toString() {
            return "MmrEstimate{" +
                    "estimate=" + estimate +
                    '}';
        }
    }

    // Nested Profile class
    public class Profile {
        @SerializedName("account_id")
        private int accountId;

        @SerializedName("personaname")
        private String personaname;

        @SerializedName("avatarfull")
        private String avatarfull;

        @SerializedName("profileurl")
        private String profileurl;

        @SerializedName("last_login")
        private String lastLogin;

        @SerializedName("steamid")
        private String steamid;

        // Getter and Setter methods

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public String getPersonaname() {
            return personaname;
        }

        public void setPersonaname(String personaname) {
            this.personaname = personaname;
        }

        public String getAvatarfull() {
            return avatarfull;
        }

        public void setAvatarfull(String avatarfull) {
            this.avatarfull = avatarfull;
        }

        public String getProfileurl() {
            return profileurl;
        }

        public void setProfileurl(String profileurl) {
            this.profileurl = profileurl;
        }

        public String getLastLogin() {
            return lastLogin;
        }

        public void setLastLogin(String lastLogin) {
            this.lastLogin = lastLogin;
        }

        public String getSteamid() {
            return steamid;
        }

        public void setSteamid(String steamid) {
            this.steamid = steamid;
        }

        @Override
        public String toString() {
            return "Profile{" +
                    "personaname='" + personaname + '\'' +
                    ", accountId=" + accountId +
                    '}';
        }
    }
}
