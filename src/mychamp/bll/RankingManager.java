/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import mychamp.be.Team;

/**
 *
 * @author Rasmus
 */
public class RankingManager {

    public static RankingManager instance;

    private GroupManager groupManager;

    public RankingManager() {
        groupManager = GroupManager.getInstance(null);
    }

    /**
     * Singleton of the RankingManager. Returns the instance of it.
     *
     * @return
     */
    public static RankingManager getInstance() {
        if (instance == null) {
            instance = new RankingManager();
        }
        return instance;
    }

    /**
     * Gets an ArrayList<Team> for the parsed group, then sorts the list so the
     * team with the highest amounts of points is at index 0. Second highest at
     * index 1 and so on.
     *
     * @param group
     * @return
     */
    public ArrayList<Team> sortTeamRankingOrder(int group) {
        //Gets the list to be sorted from the groupManager.
        ArrayList<Team> teams = groupManager.getTeamsOfGroup(group);

        //Keeps the method looping until all numbers have been placed.
        for (int j = 0; j < teams.size(); j++) {
            //Places the lowest number to the right. Then the second lowest just left of that. And so on...
            for (int i = 0; i < teams.size(); i++) {
                Team teamToBeChecked = teams.remove(i);
                if (i == teams.size()) { //Checks if it's the last in the list.
                    teams.add(teamToBeChecked);
                    i = teams.size();
                } else if (teamToBeChecked.getPoints() < teams.get(i).getPoints()) { //Checks the points difference.
                    teams.add(i + 1, teamToBeChecked);
                } else if (teamToBeChecked.getGoalDifference() < teams.get(i).getGoalDifference()) { //Checks the goal difference.
                    teams.add(i + 1, teamToBeChecked);
                } else if(teamToBeChecked.getGoalsScored() < teams.get(i).getGoalsScored()){ //Checks the goalScored difference.
                    teams.add(i + 1, teamToBeChecked);
                }else if(teamToBeChecked.getWinLossRatio() < teams.get(i).getWinLossRatio()){ //Checks the mutual results.
                    teams.add(i + 1, teamToBeChecked);
                }else {
                    teams.add(i, teamToBeChecked);
                }
            }
        }

        //Testing purpose only. Shows the ranking in console TODO: Remove.
        for (Team team : teams) {
            System.out.println(team.getPoints() + "");
        }

        return teams;
    }
}
