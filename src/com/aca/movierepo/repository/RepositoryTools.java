package com.aca.movierepo.repository;

import com.aca.movierepo.ui.CommandLineUserInterface;
import com.aca.movierepo.user.User;

import java.io.*;
import java.util.Scanner;

public class RepositoryTools extends Repository {

    CommandLineUserInterface commandLineUserInterface = new CommandLineUserInterface();
    private static final String USER_REPO_PATH = "src\\com\\aca\\movierepo\\repository\\UserRepo.txt";
    private static final String MOVIE_REPO_PATH = "src\\com\\aca\\movierepo\\repository\\MovieRepo.txt";
    private static final String SEPARATOR = "-";
    private static final String NEW_LINE = "\r\n";

    private static RepositoryTools repositoryToolsInstance = new RepositoryTools();

    public static RepositoryTools getInstance() {
        return repositoryToolsInstance;
    }

    public static String getUserRepoPath() {
        return USER_REPO_PATH;
    }

    public static String getMovieRepoPath() {
        return MOVIE_REPO_PATH;
    }

    private RepositoryTools() {
    }

    @Override
    public void put(String key, Serializable value, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // append true is writing from next position
            String strValue = ObjectSerializer.objectToString(value);
            writer.append(key + SEPARATOR + strValue + NEW_LINE);
            System.out.println("Successfully wrote to the file.");
            writer.flush(); //method flushes the stream.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object get(String key, String fileName) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(SEPARATOR);
                if (key.equals(parts[0])) {
                    Object obj = ObjectSerializer.ObjectFromString(parts[1]);
                    return obj;
                }
            }
            myReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean containsKey(String key) {
        try {
            File file = new File(USER_REPO_PATH);
            Scanner reader = new Scanner(file);
            if (file.length() != 0) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    String[] parts = data.split(SEPARATOR);
                    if (key.equals(parts[0])) {
                        return true;
                    }
                }
            } else {
                System.out.println("The repository is empty.");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean signUp(User user) {
        if (!containsKey(user.getUsername())) {
            put(user.getUsername(), user, USER_REPO_PATH);
            return true;
        } else {
            commandLineUserInterface.output("The username is already taken. Please use another username.");
            return false;
        }
    }

    public boolean signIn(User user) {
        if (containsKey(user.getUsername())) {
            User userObj = (User) RepositoryTools.getInstance().get(user.getUsername(), USER_REPO_PATH);
            if (user.getUsername().equals(userObj.getUsername()) && user.getPassword().equals(userObj.getPassword()))
                return true;
        }
        return false;
    }

    public String searchByKey(String key, String fileName) {
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(SEPARATOR);
                if (key.equals(parts[0]))
                    return parts[1];
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

}
