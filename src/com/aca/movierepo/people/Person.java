package com.aca.movierepo.people;


public abstract class Person {

    private static int count = 0;
    private final int id = count++;
    private final String fullName;
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
        return String.format("Full name: %f.\nBiography: %f.", getFullName(), getBio());
    }
}
