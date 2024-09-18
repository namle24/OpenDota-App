package vn.edu.usth.opendota.player_info;

public class Player {
    private String name;
    private String stats;

    public Player(String name, String stats) {
        this.name = name;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public String getStats() {
        return stats;
    }
}

