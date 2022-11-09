package com.application.genius.model;

public class User{
    private String username;
    private String fullName;
    private String email;
    private int score;

    public User(String id, String name, String email) {
        this.username = id;
        this.fullName = name;
        this.email = email;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}
}
