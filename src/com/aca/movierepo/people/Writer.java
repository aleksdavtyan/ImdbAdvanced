package com.aca.movierepo.people;

public class Writer extends Person {

    public Writer(String fullName, String bio) {
        super(fullName, bio);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public String getBio() {
        return super.getBio();
    }

    @Override
    public String toString() {
        return "Writer " + super.toString();
    }
}
