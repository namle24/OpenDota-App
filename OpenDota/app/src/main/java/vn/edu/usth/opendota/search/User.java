package vn.edu.usth.opendota.search;

public class User {
    private int image;
    private String name;
    private String id;
    private int rank;

    public User(int image, String name, String id, int rank_icon_8) {
        this.image = image;
        this.name = name;
        this.id = id;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
