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

public class TeamModel {

    private final ObservableList<Team> teams;

    private static TeamModel instance;

    private final FileManager fileManager = FileManager.getInstance();

    public TeamModel() {
        teams = FXCollections.observableArrayList();
        teams.addAll(MockData.getMockTeams());
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
     * Save the teams to the files.
     */
    public void saveTeamsToFile() {
        fileManager.saveTeams(getTeamsAsArrayList());
        System.out.println("Teams saved");
    }
    
    /**
     * Return an ArrayList with all the teams.
     * If "teams.data" does not exits, it returns null.
     * @return 
     */
    public ArrayList<Team> getTeamsFromFile(){
        ArrayList<Team> loadedTeams = null;
        if(fileManager.isTeamsThere()){
            loadedTeams = fileManager.getTeamsFromFile();
        }else{
            System.out.println("Could not find \"teams.data\"...");
        }
        return loadedTeams;
    }
}
