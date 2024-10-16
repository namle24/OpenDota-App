package vn.edu.usth.opendota.models;

import android.widget.ProgressBar;

import java.io.Serializable;

public class ModelClass implements Serializable {

    String userName,userNum; //userNum=user id
    String userWin, userLose;
    String userWinrate;
    ProgressBar progressBar;
    int img;

    //user Name
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    //user ID
    public String getUserNum() {
        return "ID: " + userNum;
    }
    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    // user Image
    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }

    // user win
    public String getUserWin() {
        return userWin ;
    }
    public void setUserWin(String userWin) {
        this.userWin = userWin;
    }

    //user lose
    public String getUserLose() {
        return userLose ;
    }
    public void setUserLose( String userLose) {
        this.userLose = userLose;
    }

    // user win rate
    public String getUserWinrate(String userWin, String userLose) {
        Integer wins =Integer.valueOf(userWin);
        Integer looses = Integer.valueOf(userLose);
        this.userWinrate = Integer.toString((wins/(wins+looses))*100);
        return userWinrate ;
    }

    //user progress bar depends on user win rate
    public ProgressBar progressBar() {
        return progressBar;
    }
    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

}
