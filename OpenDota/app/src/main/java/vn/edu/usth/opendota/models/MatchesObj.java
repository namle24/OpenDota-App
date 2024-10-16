package vn.edu.usth.opendota.models;

public class MatchesObj {
    private int match_id;
    private int player_slot;
    private boolean radiant_win;
    private int duration;
    private int game_mode;
    private int lobby_type;
    private int hero_id;
    private int start_time;
    private String version;
    private int kills;
    private int deaths;
    private int assists;
    private String skill;
    private int average_rank;
    private int leaver_status;
    private int party_size;

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
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

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
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
}
