package vn.edu.usth.opendota.models;

public class ProPlayerProfile {
    private long account_id;
    private Object steamid;
    private Object avatar;
    private Object avatarmedium;
    private Object avatarfull;
    private Object profileurl;
    private Object personaname;
    private Object lastLogin;
    private Object fullHistoryTime;
    private Object cheese;
    private Object fhUnavailable;
    private Object loccountrycode;
    private Object lastMatchTime;
    private Object plus;
    private String name;
    private String countryCode;
    private long fantasyRole;
    private long teamID;
    private String teamName;
    private String teamTag;
    private boolean isLocked;
    private boolean isPro;
    private Object lockedUntil;
    private boolean isFavourite;

    public boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }



    public long getAccountID() { return account_id; }
    public void setAccountID(long value) { this.account_id = value; }

    public Object getSteamid() { return steamid; }
    public void setSteamid(Object value) { this.steamid = value; }

    public Object getAvatar() { return avatar; }
    public void setAvatar(Object value) { this.avatar = value; }

    public Object getAvatarmedium() { return avatarmedium; }
    public void setAvatarmedium(Object value) { this.avatarmedium = value; }

    public Object getAvatarfull() { return avatarfull; }
    public void setAvatarfull(Object value) { this.avatarfull = value; }

    public Object getProfileurl() { return profileurl; }
    public void setProfileurl(Object value) { this.profileurl = value; }

    public Object getPersonaname() { return personaname; }
    public void setPersonaname(Object value) { this.personaname = value; }

    public Object getLastLogin() { return lastLogin; }
    public void setLastLogin(Object value) { this.lastLogin = value; }

    public Object getFullHistoryTime() { return fullHistoryTime; }
    public void setFullHistoryTime(Object value) { this.fullHistoryTime = value; }

    public Object getCheese() { return cheese; }
    public void setCheese(Object value) { this.cheese = value; }

    public Object getFhUnavailable() { return fhUnavailable; }
    public void setFhUnavailable(Object value) { this.fhUnavailable = value; }

    public Object getLoccountrycode() { return loccountrycode; }
    public void setLoccountrycode(Object value) { this.loccountrycode = value; }

    public Object getLastMatchTime() { return lastMatchTime; }
    public void setLastMatchTime(Object value) { this.lastMatchTime = value; }

    public Object getPlus() { return plus; }
    public void setPlus(Object value) { this.plus = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String value) { this.countryCode = value; }

    public long getFantasyRole() { return fantasyRole; }
    public void setFantasyRole(long value) { this.fantasyRole = value; }

    public long getTeamID() { return teamID; }
    public void setTeamID(long value) { this.teamID = value; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String value) { this.teamName = value; }

    public String getTeamTag() { return teamTag; }
    public void setTeamTag(String value) { this.teamTag = value; }

    public boolean getIsLocked() { return isLocked; }
    public void setIsLocked(boolean value) { this.isLocked = value; }

    public boolean getIsPro() { return isPro; }
    public void setIsPro(boolean value) { this.isPro = value; }

    public Object getLockedUntil() { return lockedUntil; }
    public void setLockedUntil(Object value) { this.lockedUntil = value; }
}
