/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.be;

import java.util.ArrayList;

public class Group {

    private final String groupName;

    private ArrayList<Team> groupTeams;

    private ArrayList<Match> groupMatches;

    /**
     * Construct a group for the matchups
     *
     * @param groupName
     * @param groupTeams
     */
    public Group(String groupName, ArrayList<Team> groupTeams) {
        this.groupName = groupName;
        this.groupTeams = groupTeams;
        groupMatches = new ArrayList<>();
    }

    /**
     *
     * @return teams in the group
     */
    public ArrayList<Team> getGroupTeams() {
        return groupTeams;
    }

    /**
     * Add teams for the group
     *
     * @param groupTeams
     */
    public void setGroupTeams(ArrayList<Team> groupTeams) {
        this.groupTeams = groupTeams;
    }

    /**
     *
     * @return group matches
     */
    public ArrayList<Match> getGroupMatches() {
        return groupMatches;
    }

    /**
     * Adds new matches to the group
     *
     * @param newMatches
     */
    public void addGroupMatches(ArrayList<Match> newMatches) {
        groupMatches.addAll(newMatches);
    }

}
