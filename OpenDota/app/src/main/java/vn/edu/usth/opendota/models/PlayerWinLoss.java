package vn.edu.usth.opendota.models;

import java.io.Serializable;

public class PlayerWinLoss implements Serializable {
    private int win;
    private int lose;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }
}
