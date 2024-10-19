package vn.edu.usth.opendota.models;

public class Heroes {
    private int hero_id;
    private int last_played;
    private int games;
    private int win;
    private int with_games;
    private int with_win;
    private int against_games;
    private int against_win;

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
