/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.io.Serializable;

public class IDCreator implements Serializable{

    private int teamID;

    private int matchID;

    private static IDCreator instance;

    public static IDCreator getInstance() {
        if (instance == null) {
            instance = new IDCreator();
        }
        return instance;
    }

    /**
     * Initiate the IDs at zero
     */
    private IDCreator() {
        teamID = 0;
        matchID = 0;
    }

    public int getTeamID() {
        increaseTeamID();
        return teamID;
    }

    private void increaseTeamID() {
        teamID++;
    }

    public int getMatchID() {
        increaseMatchID();
        return matchID;
    }

    private void increaseMatchID() {
        matchID++;
    }

}
