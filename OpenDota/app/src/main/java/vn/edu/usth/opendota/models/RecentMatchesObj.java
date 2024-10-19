package vn.edu.usth.opendota.models;

import java.io.Serializable;

public class RecentMatchesObj implements Serializable {
    private long match_id;
    private int player_slot;
    private boolean radiant_win;
    private int duration;
    private int game_mode;
    private int lobby_type;
    private int hero_id;
    private long start_time;
    private String version;
    private int kills;
    private int deaths;
    private int assists;
    private String skill;
    private int average_rank;
    private int xp_per_min;
    private int gold_per_min;
    private int hero_damage;
    private int tower_damage;
    private int hero_healing;
    private int last_hits;
    private String lane;
    private String lane_role;
    private String is_roaming;
    private int cluster;
    private int leaver_status;
    private int party_size;
    private int last_played;
    private int games;
    private int win;
    private int with_games;
    private int with_win;
    private int against_games;
    private int against_win;

    public long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(long match_id) {
        this.match_id = match_id;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public void setPlayer_slot(int player_slot) {
        this.player_slot = player_slot;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public void setGame_mode(int game_mode) {
        this.game_mode = game_mode;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(int lobby_type) {
        this.lobby_type = lobby_type;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getAverage_rank() {
        return average_rank;
    }

    public void setAverage_rank(int average_rank) {
        this.average_rank = average_rank;
    }

    public int getXp_per_min() {
        return xp_per_min;
    }

    public void setXp_per_min(int xp_per_min) {
        this.xp_per_min = xp_per_min;
    }

    public int getGold_per_min() {
        return gold_per_min;
    }

    public void setGold_per_min(int gold_per_min) {
        this.gold_per_min = gold_per_min;
    }

    public int getHero_damage() {
        return hero_damage;
    }

    public void setHero_damage(int hero_damage) {
        this.hero_damage = hero_damage;
    }

    public int getTower_damage() {
        return tower_damage;
    }

    public void setTower_damage(int tower_damage) {
        this.tower_damage = tower_damage;
    }

    public int getHero_healing() {
        return hero_healing;
    }

    public void setHero_healing(int hero_healing) {
        this.hero_healing = hero_healing;
    }

    public int getLast_hits() {
        return last_hits;
    }

    public void setLast_hits(int last_hits) {
        this.last_hits = last_hits;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getLane_role() {
        return lane_role;
    }

    public void setLane_role(String lane_role) {
        this.lane_role = lane_role;
    }

    public String getIs_roaming() {
        return is_roaming;
    }

    public void setIs_roaming(String is_roaming) {
        this.is_roaming = is_roaming;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public int getLeaver_status() {
        return leaver_status;
    }

    public void setLeaver_status(int leaver_status) {
        this.leaver_status = leaver_status;
    }

    public int getParty_size() {
        return party_size;
    }

    public void setParty_size(int party_size) {
        this.party_size = party_size;
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
}
