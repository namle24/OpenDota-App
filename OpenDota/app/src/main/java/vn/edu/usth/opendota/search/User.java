package vn.edu.usth.opendota.search;

public class User {
    private int image;
    private String name;
    private String id;
    private int imagerank;

    public User(int image, String name, String id) {
        this.image = image;
        this.name = name;
        this.id = id;
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


}