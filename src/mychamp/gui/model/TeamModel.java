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

public class TeamModel {

    private final ObservableList<Team> teams;

    private ArrayList<Team> quarterFinalTeams;

    private ArrayList<Team> semiFinalTeams;

    private ArrayList<Team> finalTeams;

    private static TeamModel instance;

    public TeamModel() {
        teams = FXCollections.observableArrayList();
        teams.addAll(MockData.getMockTeams());
        quarterFinalTeams = new ArrayList<>();
        semiFinalTeams = new ArrayList<>();
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

    public ArrayList<Team> getTeamsAsArrayList() {
        ArrayList<Team> teamsAsArrayList = new ArrayList<>();
        teamsAsArrayList.addAll(teams);
        return teamsAsArrayList;
    }

    public void deleteTeam(ObservableList<Team> teamsToDelete) {
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
     * Set quarter final teams
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

}
