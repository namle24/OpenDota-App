package vn.edu.usth.opendota.models;

import android.os.Parcel;
import android.os.Parcelable;

public class ProPlayerProfile implements Parcelable {
    private String account_id;
    private Object steamid;
    private Object avatar;
    private String avatarmedium;
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
    private boolean isFavorited;

    // Constructor
    public ProPlayerProfile() {
        // Default constructor
    }

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
        isFavorited = in.readByte() != 0;
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

    // Getters and Setters
    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public String getAccountID() {
        return account_id;
    }

    public void setAccountID(long value) {
        this.account_id = String.valueOf(value);
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    // Other getters and setters...

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
        dest.writeByte((byte) (isFavorited ? 1 : 0));
    }
}
