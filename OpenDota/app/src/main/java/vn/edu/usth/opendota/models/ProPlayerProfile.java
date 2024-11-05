package vn.edu.usth.opendota.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ProPlayerProfile implements Parcelable {
    private String account_id;
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

    protected ProPlayerProfile(Parcel in) {
        account_id = String.valueOf(in.readLong());
        name = in.readString();
        countryCode = in.readString();
        fantasyRole = in.readLong();
        teamID = in.readLong();
        teamName = in.readString();
        teamTag = in.readString();
        isLocked = in.readByte() != 0;
        isPro = in.readByte() != 0;
    }

    public static final Creator<ProPlayerProfile> CREATOR = new Creator<ProPlayerProfile>() {
        @Override
        public ProPlayerProfile createFromParcel(Parcel in) {
            return new ProPlayerProfile(in);
        }

        @Override
        public ProPlayerProfile[] newArray(int size) {
            return new ProPlayerProfile[size];
        }
    };


    public String getAccountID() { return account_id; }
    public void setAccountID(long value) { this.account_id = String.valueOf(value); }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(Long.parseLong(account_id));
        dest.writeString(name);
        dest.writeString(countryCode);
        dest.writeLong(fantasyRole);
        dest.writeLong(teamID);
        dest.writeString(teamName);
        dest.writeString(teamTag);
        dest.writeByte((byte) (isLocked ? 1 : 0));
        dest.writeByte((byte) (isPro ? 1 : 0));
        }
}
