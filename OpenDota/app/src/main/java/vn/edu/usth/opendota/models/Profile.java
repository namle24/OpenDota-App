package vn.edu.usth.opendota.models;

import java.time.OffsetDateTime;

public class Profile {
    private long accountID;
    private String personaname;
    private String name;
    private boolean plus;
    private long cheese;
    private String steamid;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private String profileurl;
    private OffsetDateTime lastLogin;
    private String loccountrycode;
    private Object status;
    private boolean fhUnavailable;
    private boolean isContributor;
    private boolean isSubscriber;

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public boolean isPlus() {
        return plus;
    }

    public void setPlus(boolean plus) {
        this.plus = plus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isFhUnavailable() {
        return fhUnavailable;
    }

    public void setFhUnavailable(boolean fhUnavailable) {
        this.fhUnavailable = fhUnavailable;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }

    public boolean isSubscriber() {
        return isSubscriber;
    }

    public void setSubscriber(boolean subscriber) {
        isSubscriber = subscriber;
    }

    public long getCheese() {
        return cheese;
    }

    public void setCheese(long cheese) {
        this.cheese = cheese;
    }

    public boolean isContributor() {
        return isContributor;
    }

    public void setContributor(boolean contributor) {
        isContributor = contributor;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public OffsetDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(OffsetDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
