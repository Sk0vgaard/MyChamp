/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import mychamp.be.Group;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.dal.DAOManager;

public class FileManager {

    private static FileManager instance;

    private final DAOManager daoManager = DAOManager.getInstance();

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * Calls the data acces layer to save the teams.
     *
     * @param teams
     */
    public void saveTeams(ArrayList<Team> teams) {
        daoManager.saveTeams(teams);
    }

    /**
     * Calls the data acces layer to save the teams.
     *
     * @param teams
     */
    public void saveTop8Teams(ArrayList<Team> teams) {
        daoManager.saveTop8(teams);
    }

    /**
     * Calls the data acces layer and loads the saved teams.
     *
     * @return
     */
    public ArrayList<Team> getTeamsFromFile() {
        return daoManager.getTeamsFromFile();
    }

    /**
     * Checks if the file "teams.data" is there.
     *
     * @return
     */
    public boolean isTeamsThere() {
        return daoManager.isTeamsThere();
    }

    /**
     * Save the parsed ArrayList to "groups.data".
     *
     * @param groups
     * @param fileName
     */
    public void saveGroups(ArrayList<Group> groups, String fileName) {
        daoManager.saveGroups(groups, fileName);
    }

    /**
     * Save the parsed matches to finalMatches.data
     *
     * @param matches
     */
    public void saveMatches(ArrayList<ArrayList<Match>> matches) {
        daoManager.saveMatches(matches);
    }

    /**
     * Calls the data acces layer and loads "groups.data".
     *
     * @param fileName
     * @return
     */
    public ArrayList<Group> getGroupsFromFile(String fileName) {
        return daoManager.getGroupsFromFile(fileName);
    }

    /**
     * Calls the data acces layer and loads "finalMatches.data".
     *
     * @return
     */
    public ArrayList<ArrayList<Match>> getFinalMatchesFromFile() {
        return daoManager.getMatchesFromFile();
    }

    /**
     * Checks if "groups.data" exist. Return true if yes.
     *
     * @param fileName
     * @return
     */
    public boolean isGroupsThere(String fileName) {
        return daoManager.isGroupsThere(fileName);
    }

    /**
     * Checks if finalMatches exists
     */
    public boolean isFinalMatchesThere() {
        return daoManager.isFinalMatchesThere();
    }

    /**
     * Loads the top 8 teams
     *
     * @return
     */
    public ArrayList<Team> getTop8TeamsFromFile() {
        return daoManager.getTop8TeamsFromFile();
    }

    /**
     * Checks if finalMatches exists
     */
    public boolean isTop8There() {
        return daoManager.isTop8There();
    }
}
