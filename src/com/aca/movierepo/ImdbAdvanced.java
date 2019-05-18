package com.aca.movierepo;

import com.aca.movierepo.repository.RepositoryTools;
import com.aca.movierepo.user.Admin;
import com.aca.movierepo.user.StandardUser;

public class ImdbAdvanced {

    private static final Admin admin = new Admin("admin", "admin");

    public static void startImdb() {

        StandardUser user1 = new StandardUser("john", "john1111");
        StandardUser user2 = new StandardUser("alex", "alex2222");

        RepositoryTools.getInstance().put(admin.getUsername(), admin, RepositoryTools.getUserRepoPath());

        if(admin.userSignUp(admin)) { System.out.println("Admin was successfully Signed up!!!"); }

        if (user2.userSignUp(user2)) {
            System.out.println("alex was successfully Signed up.");
        }

        //if(user2.userSignIn(user2)) { System.out.println("Successfully Signed In."); }

        System.out.printf("Details of john:\n%s", RepositoryTools.getInstance().get("john", RepositoryTools.getUserRepoPath()));


        //System.out.println(RepositoryTools.getInstance().searchByKey("user2", RepositoryTools.getUserRepoPath()));

    }

}
