package vn.edu.usth.opendota.models;

public class Heroes {
    private long hero_id;
    private long last_played;
    private long games;
    private long win;
    private long with_games;
    private long with_win;
    private long against_games;
    private long against_win;

    public long getHeroID() { return hero_id; }
    public void setHeroID(long value) { this.hero_id = hero_id; }

    public long getLastPlayed() { return last_played; }
    public void setLastPlayed(long value) { this.last_played = last_played; }

    public long getGames() { return games; }
    public void setGames(long value) { this.games = value; }

    public long getWin() { return win; }
    public void setWin(long value) { this.win = value; }

    public long getWithGames() { return with_games; }
    public void setWithGames(long value) { this.with_games = value; }

    public long getWithWin() { return with_win; }
    public void setWithWin(long value) { this.with_win = value; }

    public long getAgainstGames() { return against_games; }
    public void setAgainstGames(long value) { this.against_games = against_games; }

    public long getAgainstWin() { return against_win; }
    public void setAgainstWin(long value) { this.against_win = against_win; }
}
