package Sem3.PrakPBO.UAS;

import java.util.ArrayList;

public class User {
    private String userId, username, password, bio;
    private ArrayList<Post> listPosts = new ArrayList<>();

    public User(String userId, String username, String password, String bio, ArrayList<Post> listPosts) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.bio = bio;
        this.listPosts = listPosts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Post> getListPosts() {
        return listPosts;
    }

    public void setListPosts(ArrayList<Post> listPosts) {
        this.listPosts = listPosts;
    }

}
