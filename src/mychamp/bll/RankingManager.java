/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import java.util.Random;
import mychamp.be.Team;

public class RankingManager {

    public static RankingManager instance;

    private final GroupManager groupManager = GroupManager.getInstance();

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
                } else if (teamToBeChecked.getPoints() < teams.get(i).getPoints()) { //Checks if the points aren't equal.
                    teams.add(i + 1, teamToBeChecked);
                } else if (teamToBeChecked.getPoints() == teams.get(i).getPoints()) { //Checks if the points are equal.
                    if (teamToBeChecked.getGoalDifference() < teams.get(i).getGoalDifference()) { //Checks if the goalDifference aren't equal.
                        teams.add(i + 1, teamToBeChecked);
                    } else if (teamToBeChecked.getGoalDifference() == teams.get(i).getGoalDifference()) { //Checks if the goalDifference is the same.
                        if (teamToBeChecked.getGoalsScored() < teams.get(i).getGoalsScored()) { //Checks if the goalScored isn't equal.
                            teams.add(i + 1, teamToBeChecked);
                        } else if (teamToBeChecked.getGoalsScored() == teams.get(i).getGoalsScored()) { //Checks if the goalsScored is equal.
                            if (teamToBeChecked.getWinLossRatio() < teams.get(i).getWinLossRatio()) { //Checks if the win/lose isn't equal.
                                teams.add(i + 1, teamToBeChecked);
                            } else if (teamToBeChecked.getWinLossRatio() == teams.get(i).getWinLossRatio()) { //Checks if the win/lose is equal.
                                Random rand = new Random();
                                if (rand.nextInt(2) == 0) {
                                    teams.add(i + 1, teamToBeChecked);
                                } else {
                                    teams.add(i, teamToBeChecked);
                                }
                            } else {
                                teams.add(i, teamToBeChecked);
                            }
                        } else {
                            teams.add(i, teamToBeChecked);
                        }
                    } else {
                        teams.add(i, teamToBeChecked);
                    }
                } else {
                    teams.add(i, teamToBeChecked);
                }
            }
        }

        //Testing purpose only. Shows the ranking in console TODO: Remove.
        for (Team team : teams) {
            System.out.println(
                    +team.getPoints() + " : "
                    + team.getGoalDifference() + " : "
                    + team.getGoalsScored() + " : "
                    + team.getWinLossRatio() + " : "
                    + team.getGoalsTaken() + " : "
                    + team.getTeamName());
        }
        System.out.println("------------------------------");

        return teams;
    }
}
