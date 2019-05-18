package com.aca.movierepo.movie;

import com.aca.movierepo.people.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class Comedy extends Movie {
    public ArrayList<Integer> rating = new ArrayList<Integer>();

    public Comedy(String title, String description, LocalDate premiereDate, Person[] people) {
        super(title, description, premiereDate, Genre.COMEDY, people);
    }

    @Override
    public String toString() {return "|Comedy|\n" + super.toString(); }

//    @Override
//    public double currentRating() {
//        return super.currentRating();
//    }
}
