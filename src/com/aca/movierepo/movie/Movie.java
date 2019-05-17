package com.aca.movierepo.movie;

import com.aca.movierepo.people.Person;
import sun.util.resources.LocaleData;

import java.util.ArrayList;

public abstract class Movie {

        private String title;
        private String description;
        private LocaleData premiereDate;
        private Genre genre;

        public ArrayList<Integer> rating = new ArrayList<Integer>();
        private Person[] people;


        public Movie(String title, String description, LocaleData premiereDate, Genre genre, Person[] people) {
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

        public LocaleData getPremiereDate() {
            return premiereDate;
        }

        public Genre getGenre() {
            return genre;
        }

        public double currentRating() {
            double calculatedRating;
            double sum = 0;
            for (int i = 0; i < this.rating.size(); i++) {
                sum += this.rating.get(i);
            }
            calculatedRating = sum / (this.rating.size());
            return calculatedRating;
        }


        @Override
        public String toString() {
            return String.format("Movie title: %s.\nRating: %f.\nGenre: %s.\nPremiere date: %s.\nDescription: %s\n", getTitle(), currentRating(), getGenre().toString(), getPremiereDate(), getDescription());
        }
}
