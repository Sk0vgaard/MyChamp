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
        playOffGroups.add(A);
        playOffGroups.add(B);
        playOffGroups.add(C);
        playOffGroups.add(D);
    }

    /**
     *
     * @return playoff groups
     */
    public ArrayList<Group> getGroups() {
        return playOffGroups;
    }

    /**
     * Create a randomized list of teamIDS
     */
    private void createRandomGroups() {
        Collections.shuffle(teamIDS);

        //Fill teams
        for (int i = 0; i < 4; i++) {
            groupATeams.add(teamIDS.get(i));
            teamIDS.remove(i);
        }
        for (int i = 0; i < 4; i++) {
            groupBTeams.add(teamIDS.get(i));
            teamIDS.remove(i);
        }
        for (int i = 0; i < 4; i++) {
            groupCTeams.add(teamIDS.get(i));
            teamIDS.remove(i);
        }
        groupDTeams.addAll(teamIDS);

        A = new Group("A", groupATeams);
        B = new Group("B", groupBTeams);
        C = new Group("C", groupCTeams);
        D = new Group("D", groupDTeams);
    }

}
