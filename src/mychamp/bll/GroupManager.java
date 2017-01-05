/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import java.util.Collections;
import mychamp.be.Group;
import mychamp.be.Match;
import mychamp.be.Team;

public class GroupManager {

    public static GroupManager instance;

    private ArrayList<Team> teamIDS;

    private ArrayList<Group> playOffGroups;

    private Group A;
    private ArrayList<Team> groupATeams;

    private Group B;
    private ArrayList<Team> groupBTeams;

    private Group C;
    private ArrayList<Team> groupCTeams;

    private Group D;
    private ArrayList<Team> groupDTeams;

    private final ArrayList<Match> quarterMatches = new ArrayList<>();

    /**
     * Fills an arraylist with teamIDS
     *
     * @param teams
     */
    public GroupManager() {
        playOffGroups = new ArrayList<>();
        groupATeams = new ArrayList<>();
        groupBTeams = new ArrayList<>();
        groupCTeams = new ArrayList<>();
        groupDTeams = new ArrayList<>();
    }

    /**
     * SetTeamIDs
     *
     * @param teams
     */
    public void setTeamIDS(ArrayList<Team> teams) {
        teamIDS = teams;
    }

    /**
     * Gets the instance of the GroupManager.
     *
     * @param teams Pass null as paramter unless in the GroupModel.
     * @return
     */
    public static GroupManager getInstance() {
        if (instance == null) {
            instance = new GroupManager();
        }
        return instance;
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

    /**
     * Returns an ArrayList whit the teams of the specified group.
     *
     * @param groupToGetFrom String as the capital letter of the group to get
     * from. Example "A".
     * @return
     */
    public ArrayList<Team> getTeamsOfGroup(int groupToGetFrom) {
        switch (groupToGetFrom) {
            case 0: {
                return groupATeams;
            }
            case 1: {
                return groupBTeams;
            }
            case 2: {
                return groupCTeams;
            }
            case 3: {
                return groupDTeams;
            }
            default: {
                System.out.println("Something went wrong!");
                return null;
            }
        }
    }

    /**
     * Check if all matches in round 6 are played
     *
     * @param groups
     */
    public boolean checkIfGroupPlayIsOver(ArrayList<Group> groups) {
        ArrayList<Match> roundSixMatches = new ArrayList<>();
        boolean allMatchesPlayed = true;
        for (int i = 0; i < groups.size(); i++) {
            roundSixMatches.add(groups.get(i).getGroupMatches().get(10));
            roundSixMatches.add(groups.get(i).getGroupMatches().get(11));
        }
        for (Match roundSixMatch : roundSixMatches) {
            if (roundSixMatch.isPlayed()) {
                allMatchesPlayed = false;
            }
        }
        return allMatchesPlayed;
    }

    /**
     * Set the quarter final matches
     */
    public ArrayList<Match> getQuarterFinalMatches() {
        ArrayList<Team> rankedA = RankingManager.getInstance().sortTeamRankingOrder(0);
        ArrayList<Team> rankedB = RankingManager.getInstance().sortTeamRankingOrder(1);
        ArrayList<Team> rankedC = RankingManager.getInstance().sortTeamRankingOrder(2);
        ArrayList<Team> rankedD = RankingManager.getInstance().sortTeamRankingOrder(3);

        //Team A1 vs B2
        quarterMatches.add(new Match(rankedA.get(0).getHomeField(), rankedA.get(0), rankedB.get(1)));
        quarterMatches.add(new Match(rankedB.get(0).getHomeField(), rankedB.get(0), rankedA.get(1)));
        quarterMatches.add(new Match(rankedC.get(0).getHomeField(), rankedC.get(0), rankedD.get(1)));
        quarterMatches.add(new Match(rankedD.get(0).getHomeField(), rankedD.get(0), rankedC.get(1)));
        return quarterMatches;
    }
}
