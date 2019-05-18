package com.aca.movierepo.user;

import com.aca.movierepo.repository.RepositoryTools;

import java.io.Serializable;

public abstract class User implements Serializable {

    private static int count = 0;
    transient private final int id = count++;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean userSignUp(User user) {
        return RepositoryTools.getInstance().signUp(user);
    }

    public boolean userSignIn(User user) {
        return RepositoryTools.getInstance().signIn(user);
    }

    @Override
    public String toString() {
        return String.format("userID: %s\nusername: %s\npassword: %s", getId(), getUsername(), getPassword());
    }
}
