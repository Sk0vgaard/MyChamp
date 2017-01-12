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
import mychamp.be.Match;
import mychamp.be.Team;

/**
 *
 * @author Rasmus
 */
public class DAOManager {

    private static DAOManager instance;

    private ArrayList<Team> savedTeams;
    private ArrayList<Team> savedTop8;
    private ArrayList<Group> savedGroups;
    private ArrayList<ArrayList<Match>> savedMatches;

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
     * Save the ArrayLists that is parsed.
     *
     * @param teams
     */
    public void saveTop8(ArrayList<Team> teams) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("top8Teams.data"))) {
            oos.writeObject(teams);
            System.out.println("Top 8 saved");
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
     * Save Matches
     *
     * @param matches
     */
    public void saveMatches(ArrayList<ArrayList<Match>> matches) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("finalMatches.data"))) {
            oos.writeObject(matches);
            System.out.println("Groups saved");
        } catch (IOException ex) {
            System.out.println("Group save Error : " + ex);
        }
    }

    /**
     * Load and returns matches from the specified file.
     *
     * @return
     */
    public ArrayList<ArrayList<Match>> getMatchesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("finalMatches.data"))) {
            savedMatches = (ArrayList<ArrayList<Match>>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Groups read Error: " + ex);
        }
        return savedMatches;
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

    /**
     * Check if finalMatches exists
     */
    public boolean isFinalMatchesThere() {
        return new File("finalMatches.data").exists();
    }

    /**
     * Loads the top8Teams.data
     *
     * @return
     */
    public ArrayList<Team> getTop8TeamsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("top8Teams.data"))) {
            savedTop8 = (ArrayList<Team>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Groups read Error: " + ex);
        }
        return savedTop8;
    }
}
