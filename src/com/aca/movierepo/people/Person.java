package com.aca.movierepo.people;


import java.io.Serializable;

public abstract class Person implements Serializable {

    private static int count = 0;
    private final int id = count++;
    private String fullName;
    private String bio;

    public Person(String fullName, String bio) {
        this.fullName = fullName;
        this.bio = bio;
    }

    public int getId() { return id;  }

    public String getFullName() {
        return fullName;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public String toString() {
        return String.format("Full name: %s.\nBiography: %s.", getFullName(), getBio());
    }
}
