/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import java.util.Collections;
import mychamp.be.Group;
import mychamp.be.Team;

public class GroupManager {

    private final ArrayList<Team> teamIDS;

    private ArrayList<Group> playOffGroups;

    private Group A;
    private ArrayList<Team> groupATeams;

    private Group B;
    private ArrayList<Team> groupBTeams;

    private Group C;
    private ArrayList<Team> groupCTeams;

    private Group D;
    private ArrayList<Team> groupDTeams;

    /**
     * Fills an arraylist with teamIDS
     *
     * @param teams
     */
    public GroupManager(ArrayList<Team> teams) {
        teamIDS = teams;
        playOffGroups = new ArrayList<>();
        groupATeams = new ArrayList<>();
        groupBTeams = new ArrayList<>();
        groupCTeams = new ArrayList<>();
        groupDTeams = new ArrayList<>();
    }

    /**
     *
     * @return playoff groups
     */
    public ArrayList<Group> getNewRandomGroups() {
        createRandomGroups();
        return playOffGroups;
    }

    /**
     * Create a randomized list of teamIDS
     */
    private void createRandomGroups() {
        Collections.shuffle(teamIDS);

        //Fill teams
        while (teamIDS.size() > 0) {
            if (teamIDS.size() > 0) {
                //Fill team A
                groupATeams.add(teamIDS.get(0));
                teamIDS.remove(0);
            }
            if (teamIDS.size() > 0) {
                //Fill team B
                groupBTeams.add(teamIDS.get(0));
                teamIDS.remove(0);
            }
            if (teamIDS.size() > 0) {
                //Fill team C
                groupCTeams.add(teamIDS.get(0));
                teamIDS.remove(0);
            }
            if (teamIDS.size() > 0) {
                //Fill team D
                groupDTeams.add(teamIDS.get(0));
                teamIDS.remove(0);
            }
        }

        A = new Group("A", groupATeams);
        B = new Group("B", groupBTeams);
        C = new Group("C", groupCTeams);
        D = new Group("D", groupDTeams);
        playOffGroups.add(A);
        playOffGroups.add(B);
        playOffGroups.add(C);
        playOffGroups.add(D);
    }

}
