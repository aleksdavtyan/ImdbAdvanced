package com.aca.movierepo;

import com.aca.movierepo.movie.Action;
import com.aca.movierepo.movie.Comedy;
import com.aca.movierepo.movie.Crime;
import com.aca.movierepo.movie.Movie;
import com.aca.movierepo.people.Actor;
import com.aca.movierepo.people.Director;
import com.aca.movierepo.people.Person;
import com.aca.movierepo.people.Writer;
import com.aca.movierepo.repository.RepositoryTools;
import com.aca.movierepo.user.Admin;
import com.aca.movierepo.user.StandardUser;
import com.aca.movierepo.user.User;
import java.time.LocalDate;


public class ImdbAdvanced {

    private static final Admin admin = new Admin("admin", "admin12345678");
    //private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public static void startImdb() {

        User user1 = new StandardUser("john", "john1111");
        User user2 = new StandardUser("alex", "alex2222");


        if (admin.userSignUp(admin)) {
            System.out.println("admin was successfully Signed up!!!");
        }

        if (user1.userSignUp(user1)) {
            System.out.println("john was successfully Signed up.");
        }
        if (user1.userSignIn(user1)) {
            System.out.println("john has successfully Signed In.");
        }

        if (user2.userSignUp(user2)) {
            System.out.println(user2.getUsername() + " has successfully signed up.");
        }
        if (user2.userSignIn(user2)) {
            System.out.println(user2.getUsername() + " has successfully signed In.");
        }
        System.out.printf("Details of admin:\n%s", RepositoryTools.getInstance().get("admin", RepositoryTools.getUserRepoPath()));
        System.out.printf("\nDetails of alex:\n%s", RepositoryTools.getInstance().get("alex", RepositoryTools.getUserRepoPath()));


        //System.out.println(RepositoryTools.getInstance().searchByKey("alex", RepositoryTools.getUserRepoPath()));

        Person[] people1 = {new Director("John Smith", "John Smith was born in 1965"), new Writer("George Clooney", "George is an American actor, filmmaker"), new Actor("Brad Pitt", "Brad Pitt was corn in 1963..")};
        Person[] people2 = {new Director("Sylvester Stallone", "Sylvester was born in 1975"), new Writer("Katie Holmes", "Katie is an American actress, filmmaker"), new Actor("Pitt", "Brad Pitt was corn in 1933.")};

        LocalDate localDate1 = LocalDate.parse("2019-02-27");
        LocalDate localDate2 = LocalDate.parse("1994-07-28");
        LocalDate localDate3 = LocalDate.parse("1972-03-25");
        Movie theAlgorithm = new Action("The Algorithm", "The Algorithm is an extraterrestrial...", localDate1, people1);
        Movie theMask = new Comedy("The Mask", "When bank clerk discovers a magical mask", localDate2, people2);
        Movie theGodfather = new Crime("The Godfather", "Widely regarded as one of the greatest films of all time.", localDate3, people2);

        RepositoryTools.getInstance().put("The Algorithm", theAlgorithm, RepositoryTools.getMovieRepoPath());
        RepositoryTools.getInstance().put("The Mask", theMask, RepositoryTools.getMovieRepoPath());
        RepositoryTools.getInstance().put("The Godfather", theGodfather, RepositoryTools.getMovieRepoPath());
    }

}
