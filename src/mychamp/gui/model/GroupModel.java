/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.model;

import java.util.ArrayList;
import mychamp.be.Group;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.bll.FileManager;
import mychamp.bll.GroupManager;
import mychamp.bll.RankingManager;

public class GroupModel {

    private ArrayList<Group> randomGroups;

    private ArrayList<Match> quarterMatches;

    private final ArrayList<Group> finalGroups;

    private ArrayList<ArrayList<Match>> finalMatches;

    private static GroupModel instance;

    private final GroupManager groupManager = GroupManager.getInstance();

    private final TeamModel teamModel = TeamModel.getInstance();

    private final RankingManager rankingManager = RankingManager.getInstance();

    private final FileManager fileManager = FileManager.getInstance();

    private boolean groupPlayOver;

    public static GroupModel getInstance() {
        if (instance == null) {
            instance = new GroupModel();
        }
        return instance;
    }

    private GroupModel() {
        randomGroups = getPlayOffGroupsFromFile();
        finalMatches = getFinalMatchesFromFile();
        quarterMatches = new ArrayList<>();
        finalGroups = new ArrayList<>();
        finalGroups.add(new Group("Quarter Finals", teamModel.getQuarterFinalTeams()));
        finalGroups.add(new Group("Semi finals", teamModel.getSemiFinalTeams()));
        finalGroups.add(new Group("Finale", teamModel.getFinalTeams()));
        groupPlayOver = false;
    }

    /**
     *
     * @return the random groups
     */
    public ArrayList<Group> getGroups() {
        return randomGroups;
    }

    /**
     * Sets the parse groups. Used to store the loaded group data.
     *
     * @param groups
     */
    public void setGroups(ArrayList<Group> groups) {
        randomGroups = groups;
    }

    /**
     * Sends a request to the GroupManager for new random teams
     */
    public void createRandomGroups() {
        groupManager.setTeamIDS(teamModel.getTeamsAsArrayList());
        randomGroups = groupManager.getNewRandomGroups();
    }

    /**
     *
     * @return state of group plays
     */
    public boolean isGroupPlayOver() {
        groupPlayOver = groupManager.checkIfGroupPlayIsOver(randomGroups);
        if (groupPlayOver) {
            quarterMatches = groupManager.getQuarterFinalMatches();
        }
        return groupPlayOver;
    }

    /**
     *
     * @param group
     * @return group rankings
     */
    public ArrayList<Team> getRankings(int group) {
        return rankingManager.sortTeamRankingOrder(group);
    }

    /**
     *
     * @return Matches for the quarter final
     */
    public ArrayList<Match> getQuarterMatches() {
        return quarterMatches;
    }

    /**
     *
     * @return the final groups
     */
    public ArrayList<Group> getFinalGroups() {
        return finalGroups;
    }

    /**
     * Saves the groups in the playfOff in "playOffGroups.data".
     */
    public void savePlayOffGroups() {
        fileManager.saveGroups(randomGroups, "playOffGroups");
        System.out.println("PlayOffGroups saved!");
    }

    /**
     * Save the final groups
     */
    public void saveFinalMatches() {
        fileManager.saveMatches(finalMatches);
        //TODO ALH: Also save other stages
        System.out.println("Final matches saved!");
    }

    /**
     * Return an ArrayList with all the teams. If "teams.data" does not exits,
     * it returns null.
     *
     * @return
     */
    public ArrayList<ArrayList<Match>> getFinalMatchesFromFile() {
        ArrayList<ArrayList<Match>> loadedMatches = null;
        if (fileManager.isFinalMatchesThere()) {
            loadedMatches = fileManager.getFinalMatchesFromFile();
        } else {
            System.out.println("Could not find \"finalMatches.data\"...");
        }
        return loadedMatches;
    }

    /**
     * Returns an ArrayList with the groups in the playOff. If
     * "playOffGroups.data" does not exits, it returns null.
     *
     * @return
     */
    public ArrayList<Group> getPlayOffGroupsFromFile() {
        ArrayList<Group> loadedGroups = null;
        if (fileManager.isGroupsThere("playOffGroups")) {
            loadedGroups = fileManager.getGroupsFromFile("playOffGroups");
        } else {
            System.out.println("Could not find \"playOffGroups.data\"...");
        }
        return loadedGroups;
    }

    /**
     * Remove team from all group matches
     *
     * @param teamToRemove
     */
    public void removeTeamFromGroupMatches(Team teamToRemove) {
        groupManager.removeTeamFromMatches(teamToRemove);
    }

    /**
     * Check if playoffs data is available
     */
    public boolean isGroupsDataThere() {
        return fileManager.isGroupsThere("playOffGroups");
    }

    /**
     * Checks if data for finals exists
     */
    public boolean isFinalDataThere() {
        return fileManager.isFinalMatchesThere();
    }

    /**
     *
     * @return
     */
    public ArrayList<ArrayList<Match>> getFinalMatches() {
        return finalMatches;
    }

    public void setFinalMatches(ArrayList<ArrayList<Match>> finalMatches) {
        this.finalMatches = finalMatches;
    }

}
