package com.aca.movierepo.movie;

import com.aca.movierepo.people.Director;
import com.aca.movierepo.people.Person;
import com.aca.movierepo.people.Writer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Movie implements Serializable {

    private String title;
    private String description;
    private LocalDate premiereDate;
//    private Map<String, Double> userRatingMap;
//    private List<Director> directors;
//    private List<Writer> writers;
//    private List<Action> actions;
    private Genre genre;


    public ArrayList<Integer> rating = new ArrayList<Integer>();
    private Person[] people;


    public Movie(String title, String description, LocalDate premiereDate, Genre genre, Person[] people) {
        this.title = title;
        this.description = description;
        this.premiereDate = premiereDate;
        this.genre = genre;
        this.people = people;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public Genre getGenre() {
        return genre;
    }

//    public double currentRating() {
//        double calculatedRating;
//        double sum = 0;
//        for (int i = 0; i < this.rating.size(); i++) {
//            sum += this.rating.get(i);
//        }
//        calculatedRating = sum / (this.rating.size());
//        return calculatedRating;
//    }


    @Override
    public String toString() {
        return String.format("Movie title: %s\nGenre: %s.\nPremiere date: %s.\nDescription: %s\n", getTitle(), getGenre().toString(), getPremiereDate(), getDescription());
    }
}
