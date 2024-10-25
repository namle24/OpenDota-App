package vn.edu.usth.opendota.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Matches implements Parcelable {
    private long matchID;
    private long player_slot;
    private boolean radiant_win;
    private long hero_id;
    private long start_time;
    private long duration;
    private long game_mode;
    private long lobby_type;
    private Long version;
    private long kills;
    private long deaths;
    private long assists;
    private long averageRank;
    private long xpPerMin;
    private long goldPerMin;
    private long heroDamage;
    private long towerDamage;
    private long heroHealing;
    private long lastHits;
    private Long lane;
    private Long laneRole;
    private Boolean isRoaming;
    private long cluster;
    private long leaverStatus;
    private Long partySize;
    private long heroVariant;

    public long getMatchID() { return matchID; }
    public void setMatchID(long value) { this.matchID = value; }

    public long getPlayerSlot() { return player_slot; }
    public void setPlayerSlot(long value) { this.player_slot = value; }

    public boolean getRadiantWin() { return radiant_win; }
    public void setRadiantWin(boolean value) { this.radiant_win = value ; }

    public long getHeroID() { return hero_id; }
    public void setHeroID(long value) { this.hero_id = value; }

    public long getStartTime() { return start_time; }
    public void setStartTime(long value) { this.start_time = value; }

    public long getDuration() { return duration; }
    public void setDuration(long value) { this.duration = value; }

    public long getGameMode() { return game_mode; }
    public void setGameMode(long value) { this.game_mode = value; }

    public long getLobbyType() { return lobby_type; }
    public void setLobbyType(long value) { this.lobby_type = value; }

    public Long getVersion() { return version; }
    public void setVersion(Long value) { this.version = value; }

    public long getKills() { return kills; }
    public void setKills(long value) { this.kills = value; }

    public long getDeaths() { return deaths; }
    public void setDeaths(long value) { this.deaths = value; }

    public long getAssists() { return assists; }
    public void setAssists(long value) { this.assists = value; }

    public long getAverageRank() { return averageRank; }
    public void setAverageRank(long value) { this.averageRank = value; }

    public long getXPPerMin() { return xpPerMin; }
    public void setXPPerMin(long value) { this.xpPerMin = value; }

    public long getGoldPerMin() { return goldPerMin; }
    public void setGoldPerMin(long value) { this.goldPerMin = value; }

    public long getHeroDamage() { return heroDamage; }
    public void setHeroDamage(long value) { this.heroDamage = value; }

    public long getTowerDamage() { return towerDamage; }
    public void setTowerDamage(long value) { this.towerDamage = value; }

    public long getHeroHealing() { return heroHealing; }
    public void setHeroHealing(long value) { this.heroHealing = value; }

    public long getLastHits() { return lastHits; }
    public void setLastHits(long value) { this.lastHits = value; }

    public Long getLane() { return lane; }
    public void setLane(Long value) { this.lane = value; }

    public Long getLaneRole() { return laneRole; }
    public void setLaneRole(Long value) { this.laneRole = value; }

    public Boolean getIsRoaming() { return isRoaming; }
    public void setIsRoaming(Boolean value) { this.isRoaming = value; }

    public long getCluster() { return cluster; }
    public void setCluster(long value) { this.cluster = value; }

    public long getLeaverStatus() { return leaverStatus; }
    public void setLeaverStatus(long value) { this.leaverStatus = value; }

    public Long getPartySize() { return partySize; }
    public void setPartySize(Long value) { this.partySize = value; }

    public long getHeroVariant() { return heroVariant; }
    public void setHeroVariant(long value) { this.heroVariant = value; }

    protected Matches(Parcel in) {
        matchID = in.readLong();
        player_slot = in.readLong();
        radiant_win = in.readByte() != 0;
        hero_id = in.readLong();
        start_time = in.readLong();
        duration = in.readLong();
        game_mode = in.readLong();
        lobby_type = in.readLong();
        if (in.readByte() == 0) {
            version = null;
        } else {
            version = in.readLong();
        }
        kills = in.readLong();
        deaths = in.readLong();
        assists = in.readLong();
        averageRank = in.readLong();
        xpPerMin = in.readLong();
        goldPerMin = in.readLong();
        heroDamage = in.readLong();
        towerDamage = in.readLong();
        heroHealing = in.readLong();
        lastHits = in.readLong();
        if (in.readByte() == 0) {
            lane = null;
        } else {
            lane = in.readLong();
        }
        if (in.readByte() == 0) {
            laneRole = null;
        } else {
            laneRole = in.readLong();
        }
        byte tmpIsRoaming = in.readByte();
        isRoaming = tmpIsRoaming == 0 ? null : tmpIsRoaming == 1;
        cluster = in.readLong();
        leaverStatus = in.readLong();
        if (in.readByte() == 0) {
            partySize = null;
        } else {
            partySize = in.readLong();
        }
        heroVariant = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(matchID);
        dest.writeLong(player_slot);
        dest.writeByte((byte) (radiant_win ? 1 : 0));
        dest.writeLong(hero_id);
        dest.writeLong(start_time);
        dest.writeLong(duration);
        dest.writeLong(game_mode);
        dest.writeLong(lobby_type);
        if (version == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(version);
        }
        dest.writeLong(kills);
        dest.writeLong(deaths);
        dest.writeLong(assists);
        dest.writeLong(averageRank);
        dest.writeLong(xpPerMin);
        dest.writeLong(goldPerMin);
        dest.writeLong(heroDamage);
        dest.writeLong(towerDamage);
        dest.writeLong(heroHealing);
        dest.writeLong(lastHits);
        if (lane == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(lane);
        }
        if (laneRole == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(laneRole);
        }
        dest.writeByte((byte) (isRoaming == null ? 0 : isRoaming ? 1 : 2));
        dest.writeLong(cluster);
        dest.writeLong(leaverStatus);
        if (partySize == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(partySize);
        }
        dest.writeLong(heroVariant);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Matches> CREATOR = new Creator<Matches>() {
        @Override
        public Matches createFromParcel(Parcel in) {
            return new Matches(in);
        }

        @Override
        public Matches[] newArray(int size) {
            return new Matches[size];
        }
    };
}
