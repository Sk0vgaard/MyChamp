/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.be;

import java.io.Serializable;
import mychamp.bll.IDCreator;

public class Team implements Serializable {

    private final int ID;

    private String teamName;

    private String SCHOOL;

    private String HOME_FIELD;

    private int points;

    private int goalsScored;

    private int goalsTaken;

    private int wins;

    private int losses;

    private IDCreator getNewID = IDCreator.getInstance();

    /**
     * Create the team
     *
     * @param teamName
     * @param HOME_FIELD
     * @param SCHOOL
     */
    public Team(String teamName, String HOME_FIELD, String SCHOOL) {
        this.ID = getNewID.getTeamID();
        this.teamName = teamName;
        this.HOME_FIELD = HOME_FIELD;
        this.SCHOOL = SCHOOL;
        points = 0;
        this.wins = 0;
        this.losses = 0;
    }

    /**
     * Adds points to the team from a played match
     *
     * @param points
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Retract points if corrections are made
     *
     * @param points
     */
    public void retractPoints(int points) {
        this.points -= points;
    }

    /**
     *
     * @return goals scored
     */
    public int getGoalsScored() {
        return goalsScored;
    }

    /**
     * Adds goals to the total of the team
     *
     * @param goalsScored
     */
    public void setGoalsScored(int goalsScored) {
        this.goalsScored += goalsScored;
    }

    /**
     * Retracts goals scores for corrections
     *
     * @param goalsScored
     */
    public void retractGoalsScored(int goalsScored) {
        this.goalsScored -= goalsScored;
    }

    /**
     *
     * @return goals taken against the team
     */
    public int getGoalsTaken() {
        return goalsTaken;
    }

    /**
     * Add goals taken against the team
     *
     * @param goalsTaken
     */
    public void setGoalsTaken(int goalsTaken) {
        this.goalsTaken += goalsTaken;
    }

    /**
     * Retracts goals taken for corrections
     *
     * @param goalsTaken
     */
    public void retractGoalsTaken(int goalsTaken) {
        this.goalsTaken -= goalsTaken;
    }

    /**
     *
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     *
     * @return the name of the team
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     *
     * @return the home field
     */
    public String getHomeField() {
        return HOME_FIELD;
    }

    /**
     *
     * @return the school of the team
     */
    public String getSchool() {
        return SCHOOL;
    }

    /**
     *
     * @return total points
     */
    public int getPoints() {
        return points;
    }

    /**
     *
     * @return wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Add wins to the team
     *
     * @param wins
     */
    public void addWin() {
        this.wins++;
    }

    /**
     *
     * @return losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Adds losses to the team
     *
     * @param losses
     */
    public void addLoss() {
        this.losses++;
    }

    public void setTeamName(String TEAM_NAME) {
        this.teamName = TEAM_NAME;
    }

    public void setSchool(String SCHOOL) {
        this.SCHOOL = SCHOOL;
    }

    public void setHomeField(String HOME_FIELD) {
        this.HOME_FIELD = HOME_FIELD;
    }

    /**
     * Return the goaldifference.
     *
     * @return
     */
    public int getGoalDifference() {
        return goalsScored - goalsTaken;
    }

    /**
     * Returns the win/loses ratio of the team.
     *
     * @return
     */
    public int getWinLossRatio() {
        return wins - losses;
    }
}
