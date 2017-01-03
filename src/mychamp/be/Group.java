/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.be;

import java.util.ArrayList;

public class Group {

    private final String GROUP_NAME;

    private ArrayList<Team> groupTeams;

    /**
     * Construct a group for the matchups
     *
     * @param groupName
     * @param groupTeams
     */
    public Group(String groupName, ArrayList<Team> groupTeams) {
        this.GROUP_NAME = groupName;
        this.groupTeams = groupTeams;
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

}
