package vn.edu.usth.opendota.models;

public class Matches {
    private long matchID;
    private long playerSlot;
    private boolean radiantWin;
    private long hero_id;
    private long start_time;
    private long duration;
    private long gameMode;
    private long lobbyType;
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

    public long getPlayerSlot() { return playerSlot; }
    public void setPlayerSlot(long value) { this.playerSlot = value; }

    public boolean getRadiantWin() { return radiantWin; }
    public void setRadiantWin(boolean value) { this.radiantWin = value; }

    public long getHeroID() { return hero_id; }
    public void setHeroID(long value) { this.hero_id = hero_id; }

    public long getStartTime() { return start_time; }
    public void setStartTime(long value) { this.start_time = start_time; }

    public long getDuration() { return duration; }
    public void setDuration(long value) { this.duration = value; }

    public long getGameMode() { return gameMode; }
    public void setGameMode(long value) { this.gameMode = value; }

    public long getLobbyType() { return lobbyType; }
    public void setLobbyType(long value) { this.lobbyType = value; }

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

    @Override
    public String toString() {
        return "Matches{" +
                "matchID=" + matchID +
                ", playerSlot=" + playerSlot +
                ", radiantWin=" + radiantWin +
                ", heroID=" + hero_id +
                ", startTime=" + start_time +
                ", duration=" + duration +
                ", gameMode=" + gameMode +
                ", lobbyType=" + lobbyType +
                ", version=" + version +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", assists=" + assists +
                ", averageRank=" + averageRank +
                ", xpPerMin=" + xpPerMin +
                ", goldPerMin=" + goldPerMin +
                ", heroDamage=" + heroDamage +
                ", towerDamage=" + towerDamage +
                ", heroHealing=" + heroHealing +
                ", lastHits=" + lastHits +
                ", lane=" + lane +
                ", laneRole=" + laneRole +
                ", isRoaming=" + isRoaming +
                ", cluster=" + cluster +
                ", leaverStatus=" + leaverStatus +
                ", partySize=" + partySize +
                ", heroVariant=" + heroVariant +
                '}';
    }

}
