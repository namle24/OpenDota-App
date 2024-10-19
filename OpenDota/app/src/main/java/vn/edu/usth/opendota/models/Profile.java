package vn.edu.usth.opendota.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Profile implements Serializable {
    @SerializedName("profileurl")
    private String profileurl;

    @SerializedName("last_login")
    private Object lastLogin;

    @SerializedName("avatarfull")
    private String avatarfull;

    @SerializedName("fh_unavailable")
    private boolean fhUnavailable;

    @SerializedName("team_tag")
    private String teamTag;

    @SerializedName("avatarmedium")
    private String avatarmedium;

    @SerializedName("locked_until")
    private Object lockedUntil;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("personaname")
    private String personaname;

    @SerializedName("plus")
    private boolean plus;

    @SerializedName("team_name")
    private String teamName;

    @SerializedName("full_history_time")
    private String fullHistoryTime;

    @SerializedName("cheese")
    private int cheese;

    @SerializedName("steamid")
    private String steamid;

    @SerializedName("last_match_time")
    private String lastMatchTime;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("name")
    private String name;

    @SerializedName("loccountrycode")
    private String loccountrycode;

    @SerializedName("is_contributor")
    private boolean is_contributor;

    @SerializedName("is_contributor")
    private boolean is_subscriber;

    @SerializedName("isFavorited")
    private boolean isFavorited;

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }


    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public int getAccountId() {
        return accountId;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }
    public String getSteamid() {
        return steamid;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }
    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }
    public String getAvatarfull() {
        return avatarfull;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }
    public String getProfileurl() {
        return profileurl;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }
    public String getPersonaname() {
        return personaname;
    }

    public Object getLastLogin() { return lastLogin; }
    public void setLastLogin(Object value) { this.lastLogin = value; }

    public void setFullHistoryTime(String fullHistoryTime) {
        this.fullHistoryTime = fullHistoryTime;
    }
    public String getFullHistoryTime() {
        return fullHistoryTime;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }
    public int getCheese() {
        return cheese;
    }

    public void setFhUnavailable(boolean fhUnavailable) {
        this.fhUnavailable = fhUnavailable;
    }
    public boolean isFhUnavailable() {
        return fhUnavailable;
    }

    public boolean getIsContributor() { return is_contributor; }
    public void setIsContributor(boolean value) { this.is_contributor = value; }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }
    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLastMatchTime(String lastMatchTime) {
        this.lastMatchTime = lastMatchTime;
    }
    public String getLastMatchTime() {
        return lastMatchTime;
    }

    public void setPlus(boolean plus) {
        this.plus = plus;
    }
    public boolean isPlus() {
        return plus;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String value) { this.countryCode = value; }


    public String getTeamName() { return teamName; }
    public void setTeamName(String value) { this.teamName = value; }

    public String getTeamTag() { return teamTag; }
    public void setTeamTag(String value) { this.teamTag = value; }

    public boolean getIsSubscriber() { return is_subscriber; }
    public void setIsSubscriber(boolean value) { this.is_subscriber = value; }


    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", isFavorited=" + isFavorited + // Hiển thị trạng thái favorited
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Profile that = (Profile) obj;
        return accountId == that.accountId; // Assuming accountId uniquely identifies a player
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(accountId); // Use accountId for hash code
    }
}
