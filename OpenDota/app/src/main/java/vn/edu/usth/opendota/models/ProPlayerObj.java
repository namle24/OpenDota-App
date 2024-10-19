package vn.edu.usth.opendota.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProPlayerObj implements Serializable {

	@SerializedName("profileurl")
	private String profileurl;

	@SerializedName("is_locked")
	private boolean isLocked;

	@SerializedName("last_login")
	private Object lastLogin;

	@SerializedName("fantasy_role")
	private int fantasyRole;

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

	@SerializedName("team_id")
	private int teamId;

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

	@SerializedName("is_pro")
	private boolean isPro;

	@SerializedName("name")
	private String name;

	@SerializedName("loccountrycode")
	private String loccountrycode;

	@SerializedName("isFavorited")
	private boolean isFavorited;

	private int hero_id;
	private int last_played;
	private int games;
	private int win;
	private int with_games;
	private int with_win;
	private int against_games;
	private int against_win;

	public boolean isFavorited() {
		return isFavorited;
	}

	public void setFavorited(boolean favorited) {
		isFavorited = favorited;
	}

	// Các Getter và Setter khác

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public String getProfileurl() {
		return profileurl;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isIsLocked() {
		return isLocked;
	}

	public void setLastLogin(Object lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Object getLastLogin() {
		return lastLogin;
	}

	public void setFantasyRole(int fantasyRole) {
		this.fantasyRole = fantasyRole;
	}

	public int getFantasyRole() {
		return fantasyRole;
	}

	public void setAvatarfull(String avatarfull) {
		this.avatarfull = avatarfull;
	}

	public String getAvatarfull() {
		return avatarfull;
	}

	public void setFhUnavailable(boolean fhUnavailable) {
		this.fhUnavailable = fhUnavailable;
	}

	public boolean isFhUnavailable() {
		return fhUnavailable;
	}

	public void setTeamTag(String teamTag) {
		this.teamTag = teamTag;
	}

	public String getTeamTag() {
		return teamTag;
	}

	public void setAvatarmedium(String avatarmedium) {
		this.avatarmedium = avatarmedium;
	}

	public String getAvatarmedium() {
		return avatarmedium;
	}

	public void setLockedUntil(Object lockedUntil) {
		this.lockedUntil = lockedUntil;
	}

	public Object getLockedUntil() {
		return lockedUntil;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setPersonaname(String personaname) {
		this.personaname = personaname;
	}

	public String getPersonaname() {
		return personaname;
	}

	public void setPlus(boolean plus) {
		this.plus = plus;
	}

	public boolean isPlus() {
		return plus;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamName() {
		return teamName;
	}

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

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}

	public String getSteamid() {
		return steamid;
	}

	public void setLastMatchTime(String lastMatchTime) {
		this.lastMatchTime = lastMatchTime;
	}

	public String getLastMatchTime() {
		return lastMatchTime;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setIsPro(boolean isPro) {
		this.isPro = isPro;
	}

	public boolean isIsPro() {
		return isPro;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLoccountrycode(String loccountrycode) {
		this.loccountrycode = loccountrycode;
	}

	public String getLoccountrycode() {
		return loccountrycode;
	}

	public int getHeroID() { return hero_id; }
	public void setHeroID(int value) { this.hero_id = hero_id; }

	public int getLastPlayed() { return last_played; }
	public void setLastPlayed(int value) { this.last_played = last_played; }

	public int getGames() { return games; }
	public void setGames(int value) { this.games = value; }

	public int getWin() { return win; }
	public void setWin(int value) { this.win = value; }

	public int getWithGames() { return with_games; }
	public void setWithGames(int value) { this.with_games = value; }

	public int getWithWin() { return with_win; }
	public void setWithWin(int value) { this.with_win = value; }

	public int getAgainstGames() { return against_games; }
	public void setAgainstGames(int value) { this.against_games = against_games; }

	public int getAgainstWin() { return against_win; }
	public void setAgainstWin(int value) { this.against_win = against_win; }

	@Override
	public String toString() {
		return "ProPlayerObj{" +
				"name='" + name + '\'' +
				", isFavorited=" + isFavorited + // Hiển thị trạng thái favorited
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		ProPlayerObj that = (ProPlayerObj) obj;
		return accountId == that.accountId; // Assuming accountId uniquely identifies a player
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(accountId); // Use accountId for hash code
	}

}
