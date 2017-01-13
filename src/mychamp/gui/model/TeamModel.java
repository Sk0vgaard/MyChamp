/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mychamp.be.MockData;
import mychamp.be.Team;
import mychamp.bll.FileManager;
import mychamp.bll.GroupManager;

public class TeamModel {

    private final ObservableList<Team> teams;

    private ArrayList<Team> quarterFinalTeams;

    private ArrayList<Team> semiFinalTeams;

    private ArrayList<Team> finalTeams;

    private static TeamModel instance;

    private final FileManager fileManager;

    private final GroupManager groupManager;

    public TeamModel() {
        teams = FXCollections.observableArrayList();
        quarterFinalTeams = new ArrayList<>();
        semiFinalTeams = new ArrayList<>();
        fileManager = FileManager.getInstance();
        groupManager = GroupManager.getInstance();
        //Comment this in for mock data
//        teams.addAll(MockData.getMockTeams());
    }

    /**
     * TeamModel singleton to make sure we always only have one instance
     *
     * @return
     */
    public static TeamModel getInstance() {
        if (instance == null) {
            instance = new TeamModel();
        }
        return instance;

    }

    /**
     * Will clear all the teams.
     */
    public void clearTeams() {
        teams.clear();
    }

    /**
     * Adds the team to the list of teams
     *
     * @param team
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /**
     *
     * @return list of teams
     */
    public ObservableList<Team> getTeams() {
        return teams;
    }

    /**
     *
     * @return teams as an array list
     */
    public ArrayList<Team> getTeamsAsArrayList() {
        ArrayList<Team> teamsAsArrayList = new ArrayList<>();
        teamsAsArrayList.addAll(teams);
        return teamsAsArrayList;
    }

    /**
     * Removes the team from the tournament
     *
     * @param teamsToDelete
     */
    public void deleteTeam(ArrayList<Team> teamsToDelete) {
        teams.removeAll(teamsToDelete);
    }

    /**
     * Clears the ObservableList and then adds the ArrayList that is parsed.
     *
     * @param teams
     */
    public void addNewListOfTeams(ArrayList<Team> teams) {
        this.teams.clear();
        this.teams.addAll(teams);
    }

    /**
     * <<<<<<< HEAD Set quarter final teams
     *
     * @param quarterTeams
     */
    public void addToQuarterFinalTeams(ArrayList<Team> quarterTeams) {
        quarterFinalTeams = quarterTeams;
    }

    /**
     *
     * @return the teams in the quarter finals
     */
    public ArrayList<Team> getQuarterFinalTeams() {
        return quarterFinalTeams;
    }

    /**
     * Set semi final teams
     *
     * @param semiTeams
     */
    public void setSemiFinalTeams(ArrayList<Team> semiTeams) {
        semiFinalTeams = semiTeams;
    }

    /**
     * Set final teams
     *
     * @param finalTeams
     */
    public void setFinalTeams(ArrayList<Team> finalTeams) {
        this.finalTeams = finalTeams;
    }

    /**
     *
     * @return semiFinalTeam
     */
    public ArrayList<Team> getSemiFinalTeams() {
        return semiFinalTeams;
    }

    /**
     *
     * @return finalTeams
     */
    public ArrayList<Team> getFinalTeams() {
        return finalTeams;
    }

    /**
     * Save the teams to the file
     */
    public void saveTeamsToFile() {
        fileManager.saveTeams(getTeamsAsArrayList());
    }

    /**
     * Return an ArrayList with all the teams. If "teams.data" does not exits,
     * it returns null.
     *
     * @return
     */
    public ArrayList<Team> getTeamsFromFile() {
        ArrayList<Team> loadedTeams = null;
        if (fileManager.isTeamsThere()) {
            loadedTeams = fileManager.getTeamsFromFile();
        } else {
            System.out.println("Could not find \"teams.data\"...");
        }
        return loadedTeams;
    }

    /**
     * Get the unqualified teams sorted after rankings.
     *
     * @return
     */
    public ArrayList<Team> getSortedUnqualifiedTeams() {
        return groupManager.getSortedUnqualifiedTeams();
    }

    /**
     * Get the teams that are done playing and ended in top 8.
     *
     * @return
     */
    public ArrayList<Team> getSortedTopTeams() {
        return groupManager.getSortedTopTeams();
    }

    /**
     * Add a team to top8Teams in GroupManager.
     *
     * @param teamToAdd
     */
    public void addTeamToTop8Teams(Team teamToAdd) {
        if (teamToAdd != null) {
            groupManager.addATop8Team(teamToAdd);
        }
    }
}
