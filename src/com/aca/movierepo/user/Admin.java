package com.aca.movierepo.user;

public class Admin extends User{

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean userSignUp(User user) {
        return super.userSignUp(user);
    }

    @Override
    public boolean userSignIn(User user) {  return super.userSignIn(user);  }

    @Override
    public int getId() {  return super.getId();  }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String toString() { return super.toString(); }
}
