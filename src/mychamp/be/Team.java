/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.be;

import mychamp.bll.IDCreator;

public class Team {

    private int ID;

    private String TEAM_NAME;

    private String SCHOOL;

    private String HOME_FIELD;

    private int points;

    private int goalsScored;

    private int goalsTaken;

    private int wins;

    private int losses;

    private int matchesPlayed;

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
        this.TEAM_NAME = teamName;
        this.HOME_FIELD = HOME_FIELD;
        this.SCHOOL = SCHOOL;
        points = 0;
        this.wins = 0;
        this.losses = 0;
        this.matchesPlayed = 0;
    }

    /**
     * Adds points to the team from a played match
     *
     * @param points
     */
    public void setPoints(int points) {
        this.points += points;
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
        this.goalsTaken = goalsTaken;
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
        return TEAM_NAME;
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
    public void setWins(int wins) {
        this.wins += wins;
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
    public void setLosses(int losses) {
        this.losses += losses;
    }

    /**
     *
     * @return matches played
     */
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    /**
     * Add to total matches played
     *
     * @param matchesPlayed
     */
    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public void setTeamName(String TEAM_NAME)
    {
        this.TEAM_NAME = TEAM_NAME;
    }

    public void setSchool(String SCHOOL)
    {
        this.SCHOOL = SCHOOL;
    }

    public void setHomeField(String HOME_FIELD)
    {
        this.HOME_FIELD = HOME_FIELD;
    }

}
