/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import mychamp.be.Team;
import mychamp.gui.controller.PlayOffController;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

public class TournamentManager {

    /**
     * Removes the parsed teams from the tournament
     *
     * @param teamsToDelete
     */
    public static void deleteTeamFromTournament(ArrayList<Team> teamsToDelete) {
        //Remove team from teams
        TeamModel.getInstance().deleteTeam(teamsToDelete);
        for (Team team : teamsToDelete) {
            //Remove team name labels
            PlayOffController.getInstance().removeTeamLabelsFromTournament(team);
            //Remove team from matches
            GroupModel.getInstance().removeTeamFromGroupMatches(team);
        }
        //Update benched games
        PlayOffController.getInstance().checkBenchMatch();
    }
}
