/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mychamp.be.Team;

public class TeamModel {

    private final ObservableList<Team> teams;

    private static TeamModel instance;

    public TeamModel() {
        teams = FXCollections.observableArrayList();
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
}
