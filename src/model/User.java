package model;

import java.util.Random;

public class User {
    Random random = new Random();
    private String id;
    private String username;
    private String password;

    public User(String id, String username, String password) {
        for(int i = 0; i < 3; i++){
            id += String.valueOf(random.nextInt(10));
        }
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
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
}
