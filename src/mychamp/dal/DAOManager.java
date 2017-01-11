/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import mychamp.be.Group;
import mychamp.be.Team;

/**
 *
 * @author Rasmus
 */
public class DAOManager {

    private static DAOManager instance;

    private ArrayList<Team> savedTeams;
    private ArrayList<Group> savedGroups;

    public static DAOManager getInstance() {
        if (instance == null) {
            instance = new DAOManager();
        }
        return instance;
    }

    /**
     * Save the ArrayLists that is parsed.
     *
     * @param teams
     */
    public void saveTeams(ArrayList<Team> teams) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teams.data"))) {
            oos.writeObject(teams);
            System.out.println("Teams saved");
        } catch (IOException ex) {
            System.out.println("Teams save Error " + ex);
        }
    }

    /**
     * Load "teams.data" and return it in an ArrayList.
     *
     * @return
     */
    public ArrayList<Team> getTeamsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teams.data"))) {
            savedTeams = (ArrayList<Team>) ois.readObject();
            System.out.println("Loaded teams!");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Teams read Error: " + ex);
        }
        return savedTeams;
    }

    /**
     * Checks if "teams.data" exits.
     *
     * @return
     */
    public boolean isTeamsThere() {
        File teams = new File("teams.data");
        File groups = new File("playOffGroups.data");
        //TODO ALH: Remove this again!
//        if (teams.exists()) {
//            teams.delete();
//            groups.delete();
//            System.out.println("Deleted files for testing purposes, remember to remove this!!!");
//        }
        return new File("teams.data").exists();
    }

    /**
     * Save the ArrayList to the specified file.
     *
     * @param groups
     * @param fileName
     */
    public void saveGroups(ArrayList<Group> groups, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".data"))) {
            oos.writeObject(groups);
            System.out.println("Groups saved");
        } catch (IOException ex) {
            System.out.println("Group save Error : " + ex);
        }
    }

    /**
     * Load and returns matches from the specified file.
     *
     * @param fileName
     * @return
     */
    public ArrayList<Group> getGroupsFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".data"))) {
            savedGroups = (ArrayList<Group>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Groups read Error: " + ex);
        }
        return savedGroups;
    }

    /**
     * Checks if the specified file exits and returns true if it does.
     *
     * @param fileName
     * @return
     */
    public boolean isGroupsThere(String fileName) {
        return new File(fileName + ".data").exists();
    }
}
