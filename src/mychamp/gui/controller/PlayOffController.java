/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mychamp.MyChamp;
import mychamp.be.Game;
import mychamp.be.Group;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.bll.GroupManager;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

public class PlayOffController implements Initializable {

    @FXML
    private Label lblRound1GroupATeam1;
    @FXML
    private Label lblRound1GroupATeam2;
    @FXML
    private Label lblRound1GroupAGoals1;
    @FXML
    private Label lblRound1GroupAGoals2;
    @FXML
    private Label lblRound1GroupAWinner1;
    @FXML
    private Label lblRound1GroupATeam3;
    @FXML
    private Label lblRound1GroupATeam4;
    @FXML
    private Label lblRound1GroupAGoals3;
    @FXML
    private Label lblRound1GroupAGoals4;
    @FXML
    private Label lblRound1GroupAWinner2;
    @FXML
    private Label lblRound1GroupBTeam1;
    @FXML
    private Label lblRound1GroupBTeam2;
    @FXML
    private Label lblRound1GroupBGoals1;
    @FXML
    private Label lblRound1GroupBGoals2;
    @FXML
    private Label lblRound1GroupBWinner1;
    @FXML
    private Label lblRound1GroupBTeam3;
    @FXML
    private Label lblRound1GroupBTeam4;
    @FXML
    private Label lblRound1GroupBGoals3;
    @FXML
    private Label lblRound1GroupBGoals4;
    @FXML
    private Label lblRound1GroupBWinner2;
    @FXML
    private Label lblRound1GroupCTeam1;
    @FXML
    private Label lblRound1GroupCTeam2;
    @FXML
    private Label lblRound1GroupCGoals1;
    @FXML
    private Label lblRound1GroupCGoals2;
    @FXML
    private Label lblRound1GroupCWinner1;
    @FXML
    private Label lblRound1GroupCTeam3;
    @FXML
    private Label lblRound1GroupCTeam4;
    @FXML
    private Label lblRound1GroupCGoals3;
    @FXML
    private Label lblRound1GroupCGoals4;
    @FXML
    private Label lblRound1GroupCWinner2;
    @FXML
    private Label lblRound1GroupDTeam1;
    @FXML
    private Label lblRound1GroupDTeam2;
    @FXML
    private Label lblRound1GroupDGoals1;
    @FXML
    private Label lblRound1GroupDGoals2;
    @FXML
    private Label lblRound1GroupDWinner1;
    @FXML
    private Label lblRound1GroupDTeam3;
    @FXML
    private Label lblRound1GroupDTeam4;
    @FXML
    private Label lblRound1GroupDGoals3;
    @FXML
    private Label lblRound1GroupDGoals4;
    @FXML
    private Label lblRound1GroupDWinner2;
    @FXML
    private Label lblRound2GroupATeam1;
    @FXML
    private Label lblRound2GroupAGoals1;
    @FXML
    private Label lblRound2GroupAWinner1;
    @FXML
    private Label lblRound2GroupATeam2;
    @FXML
    private Label lblRound2GroupAGoals2;
    @FXML
    private Label lblRound2GroupATeam3;
    @FXML
    private Label lblRound2GroupAGoals3;
    @FXML
    private Label lblRound2GroupAWinner2;
    @FXML
    private Label lblRound2GroupATeam4;
    @FXML
    private Label lblRound2GroupAGoals4;
    @FXML
    private Label lblRound2GroupBTeam1;
    @FXML
    private Label lblRound2GroupBGoals1;
    @FXML
    private Label lblRound2GroupBWinner1;
    @FXML
    private Label lblRound2GroupBTeam2;
    @FXML
    private Label lblRound2GroupBGoals2;
    @FXML
    private Label lblRound2GroupBTeam3;
    @FXML
    private Label lblRound2GroupBGoals3;
    @FXML
    private Label lblRound2GroupBWinner2;
    @FXML
    private Label lblRound2GroupBTeam4;
    @FXML
    private Label lblRound2GroupBGoals4;
    @FXML
    private Label lblRound2GroupCTeam1;
    @FXML
    private Label lblRound2GroupCTeam2;
    @FXML
    private Label lblRound2GroupCWinner1;
    @FXML
    private Label lblRound2GroupCTeam3;
    @FXML
    private Label lblRound2GroupCWinner2;
    @FXML
    private Label lblRound2GroupCTeam4;
    @FXML
    private Label lblRound2GroupDTeam1;
    @FXML
    private Label lblRound2GroupDGoals1;
    @FXML
    private Label lblRound2GroupDWinner1;
    @FXML
    private Label lblRound2GroupDTeam2;
    @FXML
    private Label lblRound2GroupDTeam3;
    @FXML
    private Label lblRound2GroupDGoals3;
    @FXML
    private Label lblRound2GroupDTeam4;
    @FXML
    private Label lblRound2GroupDGoals4;
    @FXML
    private Label lblRound2GroupCGoals1;
    @FXML
    private Label lblRound2GroupCGoals2;
    @FXML
    private Label lblRound2GroupCGoals3;
    @FXML
    private Label lblRound2GroupCGoals4;
    @FXML
    private Label lblRound2GroupDGoals2;
    @FXML
    private Label lblRound3GroupATeam1;
    @FXML
    private Label lblRound3GroupAGoals1;
    @FXML
    private Label lblRound3GroupAWinner1;
    @FXML
    private Label lblRound3GroupATeam2;
    @FXML
    private Label lblRound3GroupAGoals2;
    @FXML
    private Label lblRound3GroupATeam3;
    @FXML
    private Label lblRound3GroupAGoals3;
    @FXML
    private Label lblRound3GroupAWinner2;
    @FXML
    private Label lblRound3GroupATeam4;
    @FXML
    private Label lblRound3GroupAGoals4;
    @FXML
    private Label lblRound3GroupBTeam1;
    @FXML
    private Label lblRound3GroupBGoals1;
    @FXML
    private Label lblRound3GroupBWinner1;
    @FXML
    private Label lblRound3GroupBGoals2;
    @FXML
    private Label lblRound3GroupBGoals3;
    @FXML
    private Label lblRound3GroupBWinner2;
    @FXML
    private Label lblRound3GroupBGoals4;
    @FXML
    private Label lblRound3GroupCTeam1;
    @FXML
    private Label lblRound3GroupCGoals1;
    @FXML
    private Label lblRound3GroupCWinner1;
    @FXML
    private Label lblRound3GroupCTeam2;
    @FXML
    private Label lblRound3GroupCGoals2;
    @FXML
    private Label lblRound3GroupCTeam3;
    @FXML
    private Label lblRound3GroupCGoals3;
    @FXML
    private Label lblRound3GroupCWinner2;
    @FXML
    private Label lblRound3GroupCTeam4;
    @FXML
    private Label lblRound3GroupCGoals4;
    @FXML
    private Label lblRound3GroupDTeam1;
    @FXML
    private Label lblRound3GroupDGoals1;
    @FXML
    private Label lblRound3GroupDWinner1;
    @FXML
    private Label lblRound3GroupDTeam2;
    @FXML
    private Label lblRound3GroupDGoals2;
    @FXML
    private Label lblRound3GroupDTeam3;
    @FXML
    private Label lblRound3GroupDGoals3;
    @FXML
    private Label lblRound3GroupDWinner2;
    @FXML
    private Label lblRound3GroupDTeam4;
    @FXML
    private Label lblRound3GroupDGoals4;
    @FXML
    private Label lblRound3GroupBTeam2;
    @FXML
    private Label lblRound3GroupBTeam3;
    @FXML
    private Label lblRound3GroupBTeam4;
    @FXML
    private Label lblRound4GroupATeam1;
    @FXML
    private Label lblRound4GroupAGoals1;
    @FXML
    private Label lblRound4GroupAWinner1;
    @FXML
    private Label lblRound4GroupATeam2;
    @FXML
    private Label lblRound4GroupAGoals2;
    @FXML
    private Label lblRound4GroupATeam3;
    @FXML
    private Label lblRound4GroupAGoals3;
    @FXML
    private Label lblRound4GroupAWinner2;
    @FXML
    private Label lblRound4GroupATeam4;
    @FXML
    private Label lblRound4GroupAGoals4;
    @FXML
    private Label lblRound4GroupBTeam1;
    @FXML
    private Label lblRound4GroupBGoals1;
    @FXML
    private Label lblRound4GroupBWinner1;
    @FXML
    private Label lblRound4GroupBTeam2;
    @FXML
    private Label lblRound4GroupBGoals2;
    @FXML
    private Label lblRound4GroupBTeam3;
    @FXML
    private Label lblRound4GroupBGoals3;
    @FXML
    private Label lblRound4GroupBWinner2;
    @FXML
    private Label lblRound4GroupBTeam4;
    @FXML
    private Label lblRound4GroupBGoals4;
    @FXML
    private Label lblRound4GroupCTeam1;
    @FXML
    private Label lblRound4GroupCGoals1;
    @FXML
    private Label lblRound4GroupCWinner1;
    @FXML
    private Label lblRound4GroupCTeam2;
    @FXML
    private Label lblRound4GroupCGoals2;
    @FXML
    private Label lblRound4GroupCTeam3;
    @FXML
    private Label lblRound4GroupCGoals3;
    @FXML
    private Label lblRound4GroupCWinner2;
    @FXML
    private Label lblRound4GroupCTeam4;
    @FXML
    private Label lblRound4GroupCGoals4;
    @FXML
    private Label lblRound4GroupDTeam1;
    @FXML
    private Label lblRound4GroupDGoals1;
    @FXML
    private Label lblRound4GroupDWinner1;
    @FXML
    private Label lblRound4GroupDTeam2;
    @FXML
    private Label lblRound4GroupDGoals2;
    @FXML
    private Label lblRound4GroupDGoals3;
    @FXML
    private Label lblRound4GroupDWinner2;
    @FXML
    private Label lblRound4GroupDGoals4;
    @FXML
    private Label lblRound4GroupDTeam3;
    @FXML
    private Label lblRound4GroupDTeam4;
    @FXML
    private Label lblRound5GroupATeam1;
    @FXML
    private Label lblRound5GroupAGoals1;
    @FXML
    private Label lblRound5GroupAWinner1;
    @FXML
    private Label lblRound5GroupAGoals2;
    @FXML
    private Label lblRound5GroupATeam3;
    @FXML
    private Label lblRound5GroupAGoals3;
    @FXML
    private Label lblRound5GroupAWinner2;
    @FXML
    private Label lblRound5GroupATeam4;
    @FXML
    private Label lblRound5GroupAGoals4;
    @FXML
    private Label lblRound5GroupBTeam1;
    @FXML
    private Label lblRound5GroupBGoals1;
    @FXML
    private Label lblRound5GroupBWinner1;
    @FXML
    private Label lblRound5GroupBTeam2;
    @FXML
    private Label lblRound5GroupBGoals2;
    @FXML
    private Label lblRound5GroupBTeam3;
    @FXML
    private Label lblRound5GroupBGoals3;
    @FXML
    private Label lblRound5GroupBWinner2;
    @FXML
    private Label lblRound5GroupBTeam4;
    @FXML
    private Label lblRound5GroupBGoals4;
    @FXML
    private Label lblRound5GroupCTeam1;
    @FXML
    private Label lblRound5GroupCGoals1;
    @FXML
    private Label lblRound5GroupCWinner1;
    @FXML
    private Label lblRound5GroupCTeam2;
    @FXML
    private Label lblRound5GroupCGoals2;
    @FXML
    private Label lblRound5GroupCTeam3;
    @FXML
    private Label lblRound5GroupCGoals3;
    @FXML
    private Label lblRound5GroupCWinner2;
    @FXML
    private Label lblRound5GroupCTeam4;
    @FXML
    private Label lblRound5GroupCGoals4;
    @FXML
    private Label lblRound5GroupDTeam1;
    @FXML
    private Label lblRound5GroupDGoals1;
    @FXML
    private Label lblRound5GroupDWinner1;
    @FXML
    private Label lblRound5GroupDTeam2;
    @FXML
    private Label lblRound5GroupDGoals2;
    @FXML
    private Label lblRound5GroupDTeam3;
    @FXML
    private Label lblRound5GroupDGoals3;
    @FXML
    private Label lblRound5GroupDWinner2;
    @FXML
    private Label lblRound5GroupDTeam4;
    @FXML
    private Label lblRound5GroupDGoals4;
    @FXML
    private Label lblRound5GroupATeam2;
    @FXML
    private Label lblRound6GroupAGoals1;
    @FXML
    private Label lblRound6GroupAWinner1;
    @FXML
    private Label lblRound6GroupAGoals2;
    @FXML
    private Label lblRound6GroupAGoals3;
    @FXML
    private Label lblRound6GroupAWinner2;
    @FXML
    private Label lblRound6GroupAGoals4;
    @FXML
    private Label lblRound6GroupBTeam1;
    @FXML
    private Label lblRound6GroupBGoals1;
    @FXML
    private Label lblRound6GroupBWinner1;
    @FXML
    private Label lblRound6GroupBTeam2;
    @FXML
    private Label lblRound6GroupBGoals2;
    @FXML
    private Label lblRound6GroupBTeam3;
    @FXML
    private Label lblRound6GroupBGoals3;
    @FXML
    private Label lblRound6GroupBWinner2;
    @FXML
    private Label lblRound6GroupBTeam4;
    @FXML
    private Label lblRound6GroupBGoals4;
    @FXML
    private Label lblRound6GroupCTeam1;
    @FXML
    private Label lblRound6GroupCGoals1;
    @FXML
    private Label lblRound6GroupCTeam2;
    @FXML
    private Label lblRound6GroupCGoals2;
    @FXML
    private Label lblRound6GroupCTeam3;
    @FXML
    private Label lblRound6GroupCGoals3;
    @FXML
    private Label lblRound6GroupCTeam4;
    @FXML
    private Label lblRound6GroupCGoals4;
    @FXML
    private Label lblRound6GroupDTeam1;
    @FXML
    private Label lblRound6GroupDGoals1;
    @FXML
    private Label lblRound6GroupDWinner1;
    @FXML
    private Label lblRound6GroupDTeam2;
    @FXML
    private Label lblRound6GroupDGoals2;
    @FXML
    private Label lblRound6GroupDTeam3;
    @FXML
    private Label lblRound6GroupDGoals3;
    @FXML
    private Label lblRound6GroupDWinner2;
    @FXML
    private Label lblRound6GroupDTeam4;
    @FXML
    private Label lblRound6GroupDGoals4;
    @FXML
    private Label lblRound6GroupATeam1;
    @FXML
    private Label lblRound6GroupATeam2;
    @FXML
    private Label lblRound6GroupATeam3;
    @FXML
    private Label lblRound6GroupATeam4;
    @FXML
    private GridPane PlayOffGridPane;
    @FXML
    private Label lblGroupATeam1;
    @FXML
    private Label lblGroupATeam2;
    @FXML
    private Label lblGroupATeam3;
    @FXML
    private Label lblGroupATeam4;
    @FXML
    private Label lblGroupBTeam1;
    @FXML
    private Label lblGroupBTeam2;
    @FXML
    private Label lblGroupBTeam3;
    @FXML
    private Label lblGroupBTeam4;
    @FXML
    private Label lblGroupCTeam1;
    @FXML
    private Label lblGroupCTeam2;
    @FXML
    private Label lblGroupCTeam3;
    @FXML
    private Label lblGroupCTeam4;
    @FXML
    private Label lblGroupDTeam1;
    @FXML
    private Label lblGroupDTeam2;
    @FXML
    private Label lblGroupDTeam3;
    @FXML
    private Label lblGroupDTeam4;
    @FXML
    private Label lblRound6GroupCWinner1;
    @FXML
    private Label lblRound6GroupCWinner2;
    @FXML
    private Label lblRound2GroupDWinner2;

    private ArrayList<Group> randomGroups;

    private Stage primStage;

    private FinalsController fController;

    private final GroupModel groupModel = GroupModel.getInstance();

    private Label winnerLabel;

    //Create arrays of team name labels
    private final ArrayList<Label> round1teamNameLabels;
    private final ArrayList<Label> round2teamNameLabels;
    private final ArrayList<Label> round3teamNameLabels;
    private final ArrayList<Label> round4teamNameLabels;
    private final ArrayList<Label> round5teamNameLabels;
    private final ArrayList<Label> round6teamNameLabels;

    //Create arrays of team goal labels
    private final ArrayList<Label> round1teamGoalLabels;
    private final ArrayList<Label> round2teamGoalLabels;
    private final ArrayList<Label> round3teamGoalLabels;
    private final ArrayList<Label> round4teamGoalLabels;
    private final ArrayList<Label> round5teamGoalLabels;
    private final ArrayList<Label> round6teamGoalLabels;

    //Add winner labels to an array
    private final ArrayList<Label> winnerLabels;

    //Create arrays for group ranking
    private final ArrayList<Label> rankingsGroupA;
    private final ArrayList<Label> rankingsGroupB;
    private final ArrayList<Label> rankingsGroupC;
    private final ArrayList<Label> rankingsGroupD;

    private final ArrayList<ArrayList<Label>> rankingLabels;

    private Team teamOne = null;
    private Team teamTwo = null;

    private static PlayOffController instance;

    private final TeamModel teamModel = TeamModel.getInstance();

    private boolean unqualifiedRankingsSet = false;

    public static PlayOffController getInstance() {
        return instance;
    }

    public PlayOffController() {
        //Team names
        round1teamNameLabels = new ArrayList();
        round2teamNameLabels = new ArrayList();
        round3teamNameLabels = new ArrayList();
        round4teamNameLabels = new ArrayList();
        round5teamNameLabels = new ArrayList();
        round6teamNameLabels = new ArrayList();
        //Goals
        round1teamGoalLabels = new ArrayList();
        round2teamGoalLabels = new ArrayList();
        round3teamGoalLabels = new ArrayList();
        round4teamGoalLabels = new ArrayList();
        round5teamGoalLabels = new ArrayList();
        round6teamGoalLabels = new ArrayList();

        winnerLabels = new ArrayList();

        //Rankings
        rankingsGroupA = new ArrayList();
        rankingsGroupB = new ArrayList();
        rankingsGroupC = new ArrayList();
        rankingsGroupD = new ArrayList();

        rankingLabels = new ArrayList();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        rankingLabels.add(rankingsGroupA);
        rankingLabels.add(rankingsGroupB);
        rankingLabels.add(rankingsGroupC);
        rankingLabels.add(rankingsGroupD);
    }

    /**
     * Switches to the FinalsView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleFinalsButton(ActionEvent event) throws IOException {
        if (groupModel.isGroupPlayOver()) {
            goToView(MyChamp.FINALS_VIEW);
            fController = FinalsController.getInstance();
            fController.setQuarterFinals(groupModel.getQuarterMatches());
            fController.saveFinals();
            checkUnqualifiedRankings();
        } else {
            System.out.println("We're not done yet!");
        }
    }

    /**
     * Checks for last 8 placements
     */
    public void checkUnqualifiedRankings() {
        if (!unqualifiedRankingsSet) {
            fController = FinalsController.getInstance();
            fController.setLast8RankNames();
            unqualifiedRankingsSet = true;
        }
    }

    /**
     * Goes back to the launcher menu
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleMenuButton(ActionEvent event) throws IOException {
        goToView(MyChamp.MENU_VIEW);
    }

    /**
     * Goes to the TeamSchedule view
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleTeamButton(ActionEvent event) throws IOException {
        goToView(MyChamp.TEAM_SCHEDULE_VIEW);
        TeamScheduleController.getInstance().loadTeamInfo();
    }

    /**
     * Goes to the view that is parsed.
     *
     * @param view
     * @throws IOException
     */
    private void goToView(String view) throws IOException {
        MyChamp.switchScene(view);
    }

    /**
     * Set the random groups
     *
     * @param randomGroups
     */
    public void setRandomGroups(ArrayList<Group> randomGroups) {
        this.randomGroups = randomGroups;
    }

    /**
     * Update PlayOffView information
     */
    public void setPlayOffInformation() {
        resetTournament();
        addLabelsToArrayList();
        setTeamNames();
        setMatches();
        updateGoals();
        checkBenchMatch();
    }

    /**
     * This is to be updated and redesigned!
     */
    public void updateGoals() {
        for (int i = 0; i < 4; i++) {
            round1teamGoalLabels.get(0).setText("" + randomGroups.get(i).getGroupMatches().get(0).getHomeTeamScore());
            round1teamGoalLabels.get(1).setText("" + randomGroups.get(i).getGroupMatches().get(0).getAwayTeamScore());
            round1teamGoalLabels.get(2).setText("" + randomGroups.get(i).getGroupMatches().get(1).getHomeTeamScore());
            round1teamGoalLabels.get(3).setText("" + randomGroups.get(i).getGroupMatches().get(1).getAwayTeamScore());
            round1teamGoalLabels.remove(0);
            round1teamGoalLabels.remove(0);
            round1teamGoalLabels.remove(0);
            round1teamGoalLabels.remove(0);
            round2teamGoalLabels.get(0).setText("" + randomGroups.get(i).getGroupMatches().get(2).getHomeTeamScore());
            round2teamGoalLabels.get(1).setText("" + randomGroups.get(i).getGroupMatches().get(2).getAwayTeamScore());
            round2teamGoalLabels.get(2).setText("" + randomGroups.get(i).getGroupMatches().get(3).getHomeTeamScore());
            round2teamGoalLabels.get(3).setText("" + randomGroups.get(i).getGroupMatches().get(3).getAwayTeamScore());
            round2teamGoalLabels.remove(0);
            round2teamGoalLabels.remove(0);
            round2teamGoalLabels.remove(0);
            round2teamGoalLabels.remove(0);
            round3teamGoalLabels.get(0).setText("" + randomGroups.get(i).getGroupMatches().get(4).getHomeTeamScore());
            round3teamGoalLabels.get(1).setText("" + randomGroups.get(i).getGroupMatches().get(4).getAwayTeamScore());
            round3teamGoalLabels.get(2).setText("" + randomGroups.get(i).getGroupMatches().get(5).getHomeTeamScore());
            round3teamGoalLabels.get(3).setText("" + randomGroups.get(i).getGroupMatches().get(5).getAwayTeamScore());
            round3teamGoalLabels.remove(0);
            round3teamGoalLabels.remove(0);
            round3teamGoalLabels.remove(0);
            round3teamGoalLabels.remove(0);
            round4teamGoalLabels.get(0).setText("" + randomGroups.get(i).getGroupMatches().get(6).getHomeTeamScore());
            round4teamGoalLabels.get(1).setText("" + randomGroups.get(i).getGroupMatches().get(6).getAwayTeamScore());
            round4teamGoalLabels.get(2).setText("" + randomGroups.get(i).getGroupMatches().get(7).getHomeTeamScore());
            round4teamGoalLabels.get(3).setText("" + randomGroups.get(i).getGroupMatches().get(7).getAwayTeamScore());
            round4teamGoalLabels.remove(0);
            round4teamGoalLabels.remove(0);
            round4teamGoalLabels.remove(0);
            round4teamGoalLabels.remove(0);
            round5teamGoalLabels.get(0).setText("" + randomGroups.get(i).getGroupMatches().get(8).getHomeTeamScore());
            round5teamGoalLabels.get(1).setText("" + randomGroups.get(i).getGroupMatches().get(8).getAwayTeamScore());
            round5teamGoalLabels.get(2).setText("" + randomGroups.get(i).getGroupMatches().get(9).getHomeTeamScore());
            round5teamGoalLabels.get(3).setText("" + randomGroups.get(i).getGroupMatches().get(9).getAwayTeamScore());
            round5teamGoalLabels.remove(0);
            round5teamGoalLabels.remove(0);
            round5teamGoalLabels.remove(0);
            round5teamGoalLabels.remove(0);
            round6teamGoalLabels.get(0).setText("" + randomGroups.get(i).getGroupMatches().get(10).getHomeTeamScore());
            round6teamGoalLabels.get(1).setText("" + randomGroups.get(i).getGroupMatches().get(10).getAwayTeamScore());
            round6teamGoalLabels.get(2).setText("" + randomGroups.get(i).getGroupMatches().get(11).getHomeTeamScore());
            round6teamGoalLabels.get(3).setText("" + randomGroups.get(i).getGroupMatches().get(11).getAwayTeamScore());
            round6teamGoalLabels.remove(0);
            round6teamGoalLabels.remove(0);
            round6teamGoalLabels.remove(0);
            round6teamGoalLabels.remove(0);
        }
        addGoalLabels();
    }

    /**
     * This is to be updated and redesigned!
     */
    public void updateWinners() {
        //For each match in goup A
        Match currentMatch = null;
        //Go trough each group match in group A
        for (int i = 0; i < randomGroups.get(0).getGroupMatches().size(); i++) {
            //Set current match to this match
            currentMatch = randomGroups.get(0).getGroupMatches().get(i);
            //If the match was played update the winner label
            if (currentMatch.getWinnerTeam() != null) {
                winnerLabels.get(0).setText(Game.WINNER_TEAM_TEXT + currentMatch.getWinnerTeam().getTeamName());
            } else {
                if (currentMatch.getHomeTeamScore() == currentMatch.getAwayTeamScore() && currentMatch.getHomeTeamScore() != 0) {
                    winnerLabels.get(0).setText(Game.WINNER_DRAW_TEXT);
                }
            }
            winnerLabels.remove(0);
        }
        //Go trough each group match in group B
        for (int i = 0; i < randomGroups.get(1).getGroupMatches().size(); i++) {
            //Set current match to this match
            currentMatch = randomGroups.get(1).getGroupMatches().get(i);
            //If the match was played update the winner label
            if (currentMatch.getWinnerTeam() != null) {
                winnerLabels.get(0).setText(Game.WINNER_TEAM_TEXT + currentMatch.getWinnerTeam().getTeamName());
            } else {
                if (currentMatch.getHomeTeamScore() == currentMatch.getAwayTeamScore() && currentMatch.getHomeTeamScore() != 0) {
                    winnerLabels.get(0).setText(Game.WINNER_DRAW_TEXT);
                }
            }
            winnerLabels.remove(0);
        }
        //Go trough each group match in group C
        for (int i = 0; i < randomGroups.get(2).getGroupMatches().size(); i++) {
            //Set current match to this match
            currentMatch = randomGroups.get(2).getGroupMatches().get(i);
            //If the match was played update the winner label
            if (currentMatch.getWinnerTeam() != null) {
                winnerLabels.get(0).setText(Game.WINNER_TEAM_TEXT + currentMatch.getWinnerTeam().getTeamName());
            } else {
                if (currentMatch.getHomeTeamScore() == currentMatch.getAwayTeamScore() && currentMatch.getHomeTeamScore() != 0) {
                    winnerLabels.get(0).setText(Game.WINNER_DRAW_TEXT);
                }
            }
            winnerLabels.remove(0);
        }
        //Go trough each group match in group D
        for (int i = 0; i < randomGroups.get(3).getGroupMatches().size(); i++) {
            //Set current match to this match
            currentMatch = randomGroups.get(3).getGroupMatches().get(i);
            //If the match was played update the winner label
            if (winnerLabels.size() > 0) {
                if (currentMatch.getWinnerTeam() != null) {
                    winnerLabels.get(0).setText(Game.WINNER_TEAM_TEXT + currentMatch.getWinnerTeam().getTeamName());
                } else {
                    if (currentMatch.getHomeTeamScore() == currentMatch.getAwayTeamScore() && currentMatch.getHomeTeamScore() != 0) {
                        winnerLabels.get(0).setText(Game.WINNER_DRAW_TEXT);
                    }
                }
                winnerLabels.remove(0);
            }
        }
        winnerLabels.clear();
        addWinnerLabelsToArrays();
    }

    /**
     *
     * @return random groups
     */
    public ArrayList<Group> getRandomGroups() {
        return randomGroups;
    }

    /**
     * Load all saved data for PlayOffs
     */
    public void loadSavedPlayOffs() {
        loadSavedGroups();
        addRankingLabels();
        addTeamNameLabels();
        addWinnerLabelsToArrays();
        addGoalLabels();
        setTeamNames();
        updateGoals();
        updateWinners();
        updateAllGroupRankings();
        GroupManager.getInstance().setRankedGroups();
    }

    /**
     * Loads saved groups
     */
    public void loadSavedGroups() {
        randomGroups = groupModel.getGroups();
    }

    /**
     * Load saved rankings
     */
    public void updateAllGroupRankings() {
        updateGroupRankings(0, null);
        updateGroupRankings(1, null);
        updateGroupRankings(2, null);
        updateGroupRankings(3, null);
    }

    /**
     * Set team names for tournament
     */
    public void setTeamNames() {
        setTeamNamesRoundOne();
        setTeamNamesRoundTwo();
        setTeamNamesRoundThree();
        setTeamNamesRoundFour();
        setTeamNamesRoundFive();
        setTeamNamesRoundSix();
    }

    /**
     * Set matches for tournament
     */
    private void setMatches() {
        setMatchesRoundOne();
        setMatchesRoundTwo();
        setMatchesRoundThree();
        setMatchesRoundFour();
        setMatchesRoundFive();
        setMatchesRoundSix();
    }

    /**
     * Set team names for round 1
     */
    public void setTeamNamesRoundOne() {
        for (int i = 0; i < 4; i++) {
            //Go through each group
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            //Set label for first team in current group
            round1teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round1teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = new Team("", "", "");
            //Set label for third team in current group
            round1teamNameLabels.get(2).setText(teamOne.getTeamName());
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Set label for fourth team in current group
            round1teamNameLabels.get(3).setText(teamTwo.getTeamName());

            //Remove labels from the list
            round1teamNameLabels.remove(0);
            round1teamNameLabels.remove(0);
            round1teamNameLabels.remove(0);
            round1teamNameLabels.remove(0);

        }
    }

    /**
     * Set information for round 1
     */
    private void setMatchesRoundOne() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            //Create the first match of the group
            Match groupMatch1 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = new Team("", "", "");
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Create the second match of the group
            Match groupmatch2 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatches
            groupMatches.clear();
        }
    }

    /**
     * Set team names for round 2
     */
    public void setTeamNamesRoundTwo() {
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            //Set label for first team in current group
            round2teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round2teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Clear the match teams to ge ready for the second match in the group
            teamOne = new Team("", "", "");
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamOne = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Set label for fourth team in current group
            round2teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Set label for third team in current group
            round2teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Remove labels from the list
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
        }
    }

    /**
     * Set information for round 2
     */
    private void setMatchesRoundTwo() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            //Create the first match of the group
            Match groupMatch1 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = new Team("", "", "");
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamOne = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Create the second match of the group
            Match groupmatch2 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();

        }
    }

    /**
     * Set team names for round 3
     */
    public void setTeamNamesRoundThree() {
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Set label for first team in current group
            round3teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round3teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Clear the match teams to ge ready for the second match in the group
            teamOne = new Team("", "", "");
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamOne = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Set label for fourth team in current group
            round3teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Set label for third team in current group
            round3teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Remove labels from the list
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
        }
    }

    /**
     * Set information for round 3
     */
    private void setMatchesRoundThree() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Create the first match of the group
            Match groupMatch1 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = new Team("", "", "");
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamOne = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Create the second match of the group
            Match groupmatch2 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set team names for round 4
     */
    public void setTeamNamesRoundFour() {
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = new Team("", "", "");
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Set label for first team in current group
            round4teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round4teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            //Set label for third team in current group
            round4teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round4teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Remove labels from the list
            round4teamNameLabels.remove(0);
            round4teamNameLabels.remove(0);
            round4teamNameLabels.remove(0);
            round4teamNameLabels.remove(0);
        }
    }

    /**
     * Set information for round 4
     */
    private void setMatchesRoundFour() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = new Team("", "", "");
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Create the first match of the group
            Match groupMatch1 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            //Create the second match of the group
            Match groupmatch2 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set team names for round 5
     */
    public void setTeamNamesRoundFive() {
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Set label for first team in current group
            round5teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round5teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = new Team("", "", "");
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Set label for third team in current group
            round5teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round5teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Remove labels from the list
            round5teamNameLabels.remove(0);
            round5teamNameLabels.remove(0);
            round5teamNameLabels.remove(0);
            round5teamNameLabels.remove(0);
        }
    }

    /**
     * Set information for round 5
     */
    private void setMatchesRoundFive() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Create the first match of the group
            Match groupMatch1 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = new Team("", "", "");
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            }
            //Create the second match of the group
            Match groupmatch2 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set team names for round 6
     */
    public void setTeamNamesRoundSix() {
        for (int i = 0; i < 4; i++) {
            teamOne = new Team("", "", "");
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamOne = randomGroups.get(i).getGroupTeams().get(3);
            }
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Set label for first team in current group
            round6teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round6teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            //Set label for third team in current group
            round6teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round6teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Remove labels from the list
            round6teamNameLabels.remove(0);
            round6teamNameLabels.remove(0);
            round6teamNameLabels.remove(0);
            round6teamNameLabels.remove(0);
        }
    }

    /**
     * Set information for round 6
     */
    private void setMatchesRoundSix() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            teamOne = new Team("", "", "");
            if (randomGroups.get(i).getGroupTeams().size() > 3) {
                teamOne = randomGroups.get(i).getGroupTeams().get(3);
            }
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Create the first match of the group
            Match groupMatch1 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            //Create the second match of the group
            Match groupmatch2 = new Match(teamOne.getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Check if a match should be sat over/benched
     */
    public void checkBenchMatch() {
        //Check if a match only has 1 team
        for (Group group : groupModel.getGroups()) {
            for (Match groupMatch : group.getGroupMatches()) {
                if (groupMatch.getHomeTeam().getTeamName().equals("")
                        || groupMatch.getAwayTeam().getTeamName().equals("")) {
                    groupMatch.benchMatch();
                }
            }
        }
    }

    /**
     * Fill up ArrayLists with labels
     */
    private void addLabelsToArrayList() {
        addTeamNameLabels();

        addGoalLabels();

        addRankingLabels();

        addWinnerLabelsToArrays();
    }

    /**
     * Opens the MatchDetails window and loads the details for the match
     *
     * @param group
     * @param match
     * @throws IOException
     */
    private void MatchClicked(int group, int match, Label winnerLabel) throws IOException {
        this.winnerLabel = winnerLabel;
        try {
            //Grab hold of the curret stage.
            primStage = (Stage) lblRound1GroupATeam1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mychamp/gui/view/MatchDetailsView.fxml"));
            Parent root = loader.load();
            Stage editStage = new Stage();
            editStage.setScene(new Scene(root));

            //Create new modal window from the FXMLLoader.
            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(primStage);

            //Finds the match that has been clicked on
            GroupModel gModel = GroupModel.getInstance();
            Match matchToSend = gModel.getGroups().get(group).getGroupMatches().get(match);

            //Loads the modals controller to send match.
            MatchDetailsController mdController = loader.getController();
            mdController.setCurrentMatch(matchToSend);

            //Shows the modal and waits for it to close before continuing reading the code.
            editStage.showAndWait();

            //Updates the group rankings.
            updateGroupRankings(group, null);

            //Save teams to file
            teamModel.saveTeamsToFile();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * Update the rankings for the selected group.
     *
     * @param group
     */
    private void updateGroupRankings(int group, Team removedTeam) {
        ArrayList<Team> rankedTeams = groupModel.getRankings(group);
        //If there is a team to remove in the group, it shall be gone!
        if (rankedTeams.contains(removedTeam)) {
            rankedTeams.remove(removedTeam);
        }

        switch (group) {
            case 0: {
                for (Label label : rankingsGroupA) {
                    label.setText("");
                }
                for (int i = 0; i < rankedTeams.size(); i++) {
                    rankingsGroupA.get(i).setText(rankedTeams.get(i).getTeamName());
                }
                break;
            }
            case 1: {
                for (Label label : rankingsGroupB) {
                    label.setText("");
                }
                for (int i = 0; i < rankedTeams.size(); i++) {
                    rankingsGroupB.get(i).setText(rankedTeams.get(i).getTeamName());
                }
                break;
            }
            case 2: {
                for (Label label : rankingsGroupC) {
                    label.setText("");
                }
                for (int i = 0; i < rankedTeams.size(); i++) {
                    rankingsGroupC.get(i).setText(rankedTeams.get(i).getTeamName());
                }
                break;
            }
            case 3: {
                for (Label label : rankingsGroupD) {
                    label.setText("");
                }
                for (int i = 0; i < rankedTeams.size(); i++) {
                    rankingsGroupD.get(i).setText(rankedTeams.get(i).getTeamName());
                }
                break;
            }
            default: {
                System.out.println("Something went wrong!");
                break;
            }
        }
    }

    /**
     * Opens the selected match
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleMatchClick(ActionEvent event) throws IOException {
        //Typecast the event to the button clicked
        Button clickedButton = (Button) event.getSource();
        //Get the Id from the clicked button
        String buttonId = clickedButton.getId();
        try {
            //Send the clicked button to MatchClicked method to open information with info about the clicked match
            switch (buttonId) {
                case "00":
                    MatchClicked(0, 0, lblRound1GroupAWinner1);
                    break;
                case "01":
                    MatchClicked(0, 1, lblRound1GroupAWinner2);
                    break;
                case "02":
                    MatchClicked(1, 0, lblRound1GroupBWinner1);
                    break;
                case "03":
                    MatchClicked(1, 1, lblRound1GroupBWinner2);
                    break;
                case "04":
                    MatchClicked(2, 0, lblRound1GroupCWinner1);
                    break;
                case "05":
                    MatchClicked(2, 1, lblRound1GroupCWinner2);
                    break;
                case "06":
                    MatchClicked(3, 0, lblRound1GroupDWinner1);
                    break;
                case "07":
                    MatchClicked(3, 1, lblRound1GroupDWinner2);
                    break;
                case "10":
                    MatchClicked(0, 2, lblRound2GroupAWinner1);
                    break;
                case "11":
                    MatchClicked(0, 3, lblRound2GroupAWinner2);
                    break;
                case "12":
                    MatchClicked(1, 2, lblRound2GroupBWinner1);
                    break;
                case "13":
                    MatchClicked(1, 3, lblRound2GroupBWinner2);
                    break;
                case "14":
                    MatchClicked(2, 2, lblRound2GroupCWinner1);
                    break;
                case "15":
                    MatchClicked(2, 3, lblRound2GroupCWinner2);
                    break;
                case "16":
                    MatchClicked(3, 2, lblRound2GroupDWinner1);
                    break;
                case "17":
                    MatchClicked(3, 3, lblRound2GroupDWinner2);
                    break;
                case "20":
                    MatchClicked(0, 4, lblRound3GroupAWinner1);
                    break;
                case "21":
                    MatchClicked(0, 5, lblRound3GroupAWinner2);
                    break;
                case "22":
                    MatchClicked(1, 4, lblRound3GroupBWinner1);
                    break;
                case "23":
                    MatchClicked(1, 5, lblRound3GroupBWinner2);
                    break;
                case "24":
                    MatchClicked(2, 4, lblRound3GroupCWinner1);
                    break;
                case "25":
                    MatchClicked(2, 5, lblRound3GroupCWinner2);
                    break;
                case "26":
                    MatchClicked(3, 4, lblRound3GroupDWinner1);
                    break;
                case "27":
                    MatchClicked(3, 5, lblRound3GroupDWinner2);
                    break;
                case "30":
                    MatchClicked(0, 6, lblRound4GroupAWinner1);
                    break;
                case "31":
                    MatchClicked(0, 7, lblRound4GroupAWinner2);
                    break;
                case "32":
                    MatchClicked(1, 6, lblRound4GroupBWinner1);
                    break;
                case "33":
                    MatchClicked(1, 7, lblRound4GroupBWinner2);
                    break;
                case "34":
                    MatchClicked(2, 6, lblRound4GroupCWinner1);
                    break;
                case "35":
                    MatchClicked(2, 7, lblRound4GroupCWinner2);
                    break;
                case "36":
                    MatchClicked(3, 6, lblRound4GroupDWinner1);
                    break;
                case "37":
                    MatchClicked(3, 7, lblRound4GroupDWinner2);
                    break;
                case "40":
                    MatchClicked(0, 8, lblRound5GroupAWinner1);
                    break;
                case "41":
                    MatchClicked(0, 9, lblRound5GroupAWinner2);
                    break;
                case "42":
                    MatchClicked(1, 8, lblRound5GroupBWinner1);
                    break;
                case "43":
                    MatchClicked(1, 9, lblRound5GroupBWinner2);
                    break;
                case "44":
                    MatchClicked(2, 8, lblRound5GroupCWinner1);
                    break;
                case "45":
                    MatchClicked(2, 9, lblRound5GroupCWinner2);
                    break;
                case "46":
                    MatchClicked(3, 8, lblRound5GroupDWinner1);
                    break;
                case "47":
                    MatchClicked(3, 9, lblRound5GroupDWinner2);
                    break;
                case "50":
                    MatchClicked(0, 10, lblRound6GroupAWinner1);
                    break;
                case "51":
                    MatchClicked(0, 11, lblRound6GroupAWinner2);
                    break;
                case "52":
                    MatchClicked(1, 10, lblRound6GroupBWinner1);
                    break;
                case "53":
                    MatchClicked(1, 11, lblRound6GroupBWinner2);
                    break;
                case "54":
                    MatchClicked(2, 10, lblRound6GroupCWinner1);
                    break;
                case "55":
                    MatchClicked(2, 11, lblRound6GroupCWinner2);
                    break;
                case "56":
                    MatchClicked(3, 10, lblRound6GroupDWinner1);
                    break;
                case "57":
                    MatchClicked(3, 11, lblRound6GroupDWinner2);
                    break;
                default:
                    System.out.println("WTF?");
                    break;
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    /**
     * Open the selected group view
     *
     * @param event
     */
    @FXML
    private void handleGroupClick(MouseEvent event) throws IOException {
        Label selectedGroup = (Label) event.getSource();
        String groupName = selectedGroup.getText();

        switch (groupName) {
            case "A":
                groupClick(0);
                break;
            case "B":
                groupClick(1);
                break;
            case "C":
                groupClick(2);
                break;
            case "D":
                groupClick(3);
                break;
            default:
                System.out.println("WTF!?");
                break;
        }
    }

    /**
     * Open the GroupScheduleView with relevant information of the selected
     * group
     */
    private void groupClick(int group) throws IOException {
        //Grab hold of the curret stage.
        goToView(MyChamp.GROUP_SCHEDULE_VIEW);

        //Finds the match that has been clicked on
        GroupModel gModel = GroupModel.getInstance();
        Group groupToSend = gModel.getGroups().get(group);

        //Loads the modals controller to send match.
        GroupScheduleController.getInstance().setGroup(groupToSend);
    }

    private void handleBackToMenu(ActionEvent event) throws IOException {
        goToView(MyChamp.MENU_VIEW);
    }

    /**
     * resets the tournament
     */
    public void resetTournament() {
        //Clear Team name labels
        round1teamNameLabels.clear();
        round2teamNameLabels.clear();
        round3teamNameLabels.clear();
        round4teamNameLabels.clear();
        round5teamNameLabels.clear();
        round6teamNameLabels.clear();

        //Clear team goal labels
        round1teamGoalLabels.clear();
        round2teamGoalLabels.clear();
        round3teamGoalLabels.clear();
        round4teamGoalLabels.clear();
        round5teamGoalLabels.clear();
        round6teamGoalLabels.clear();

        //Reset Ranking teams
        for (Label group : rankingsGroupA) {
            group.setText("");
        }
        for (Label group : rankingsGroupB) {
            group.setText("");
        }
        for (Label group : rankingsGroupC) {
            group.setText("");
        }
        for (Label group : rankingsGroupD) {
            group.setText("");
        }

        //Clear rankings
        rankingsGroupA.clear();
        rankingsGroupB.clear();
        rankingsGroupC.clear();
        rankingsGroupD.clear();

        //Reset winners
        for (Label winnerLabel : winnerLabels) {
            winnerLabel.setText("Ikke spillet");
        }
    }

    /**
     *
     * @return ranking labels
     */
    public ArrayList<ArrayList<Label>> getRankingLabels() {
        return rankingLabels;
    }

    /**
     * Removes the team from matches and marks the game as benched
     *
     * @param teamToRemove
     */
    public void removeTeamLabelsFromTournament(Team teamToRemove) {
        addTeamNameLabels();
        for (int i = 0; i < round1teamNameLabels.size(); i++) {
            if (round1teamNameLabels.get(i).getText().equals(teamToRemove.getTeamName())) {
                round1teamNameLabels.get(i).setText("");
            }
        }
        for (int i = 0; i < round2teamNameLabels.size(); i++) {
            if (round2teamNameLabels.get(i).getText().equals(teamToRemove.getTeamName())) {
                round2teamNameLabels.get(i).setText("");
            }
        }
        for (int i = 0; i < round3teamNameLabels.size(); i++) {
            if (round3teamNameLabels.get(i).getText().equals(teamToRemove.getTeamName())) {
                round3teamNameLabels.get(i).setText("");
            }
        }
        for (int i = 0; i < round4teamNameLabels.size(); i++) {
            if (round4teamNameLabels.get(i).getText().equals(teamToRemove.getTeamName())) {
                round4teamNameLabels.get(i).setText("");
            }
        }
        for (int i = 0; i < round5teamNameLabels.size(); i++) {
            if (round5teamNameLabels.get(i).getText().equals(teamToRemove.getTeamName())) {
                round5teamNameLabels.get(i).setText("");
            }
        }
        for (int i = 0; i < round6teamNameLabels.size(); i++) {
            if (round6teamNameLabels.get(i).getText().equals(teamToRemove.getTeamName())) {
                round6teamNameLabels.get(i).setText("");
            }
        }
        updateGroupRankings(0, teamToRemove);
        updateGroupRankings(1, teamToRemove);
        updateGroupRankings(2, teamToRemove);
        updateGroupRankings(3, teamToRemove);
        checkBenchMatch();
    }

    /**
     * Set the winner label
     *
     * @param text
     */
    public void setWinnerLabel(String text) {
        winnerLabel.setText(text);
    }

    /**
     * Add all the FXML ranking labels to array lists
     */
    public void addRankingLabels() {
        //Group A ranking.
        rankingsGroupA.add(lblGroupATeam1);
        rankingsGroupA.add(lblGroupATeam2);
        rankingsGroupA.add(lblGroupATeam3);
        rankingsGroupA.add(lblGroupATeam4);

        //Group B ranking
        rankingsGroupB.add(lblGroupBTeam1);
        rankingsGroupB.add(lblGroupBTeam2);
        rankingsGroupB.add(lblGroupBTeam3);
        rankingsGroupB.add(lblGroupBTeam4);

        //Group C ranking
        rankingsGroupC.add(lblGroupCTeam1);
        rankingsGroupC.add(lblGroupCTeam2);
        rankingsGroupC.add(lblGroupCTeam3);
        rankingsGroupC.add(lblGroupCTeam4);

        //Group D ranking
        rankingsGroupD.add(lblGroupDTeam1);
        rankingsGroupD.add(lblGroupDTeam2);
        rankingsGroupD.add(lblGroupDTeam3);
        rankingsGroupD.add(lblGroupDTeam4);
    }

    /**
     * Add all the FXML goal labels to array lists
     */
    public void addGoalLabels() {
        //Team goals round 1
        round1teamGoalLabels.add(lblRound1GroupAGoals1);
        round1teamGoalLabels.add(lblRound1GroupAGoals2);
        round1teamGoalLabels.add(lblRound1GroupAGoals3);
        round1teamGoalLabels.add(lblRound1GroupAGoals4);
        round1teamGoalLabels.add(lblRound1GroupBGoals1);
        round1teamGoalLabels.add(lblRound1GroupBGoals2);
        round1teamGoalLabels.add(lblRound1GroupBGoals3);
        round1teamGoalLabels.add(lblRound1GroupBGoals4);
        round1teamGoalLabels.add(lblRound1GroupCGoals1);
        round1teamGoalLabels.add(lblRound1GroupCGoals2);
        round1teamGoalLabels.add(lblRound1GroupCGoals3);
        round1teamGoalLabels.add(lblRound1GroupCGoals4);
        round1teamGoalLabels.add(lblRound1GroupDGoals1);
        round1teamGoalLabels.add(lblRound1GroupDGoals2);
        round1teamGoalLabels.add(lblRound1GroupDGoals3);
        round1teamGoalLabels.add(lblRound1GroupDGoals4);

        //Team goals round 2
        round2teamGoalLabels.add(lblRound2GroupAGoals1);
        round2teamGoalLabels.add(lblRound2GroupAGoals2);
        round2teamGoalLabels.add(lblRound2GroupAGoals3);
        round2teamGoalLabels.add(lblRound2GroupAGoals4);
        round2teamGoalLabels.add(lblRound2GroupBGoals1);
        round2teamGoalLabels.add(lblRound2GroupBGoals2);
        round2teamGoalLabels.add(lblRound2GroupBGoals3);
        round2teamGoalLabels.add(lblRound2GroupBGoals4);
        round2teamGoalLabels.add(lblRound2GroupCGoals1);
        round2teamGoalLabels.add(lblRound2GroupCGoals2);
        round2teamGoalLabels.add(lblRound2GroupCGoals3);
        round2teamGoalLabels.add(lblRound2GroupCGoals4);
        round2teamGoalLabels.add(lblRound2GroupDGoals1);
        round2teamGoalLabels.add(lblRound2GroupDGoals2);
        round2teamGoalLabels.add(lblRound2GroupDGoals3);
        round2teamGoalLabels.add(lblRound2GroupDGoals4);

        //Team goals round 3
        round3teamGoalLabels.add(lblRound3GroupAGoals1);
        round3teamGoalLabels.add(lblRound3GroupAGoals2);
        round3teamGoalLabels.add(lblRound3GroupAGoals3);
        round3teamGoalLabels.add(lblRound3GroupAGoals4);
        round3teamGoalLabels.add(lblRound3GroupBGoals1);
        round3teamGoalLabels.add(lblRound3GroupBGoals2);
        round3teamGoalLabels.add(lblRound3GroupBGoals3);
        round3teamGoalLabels.add(lblRound3GroupBGoals4);
        round3teamGoalLabels.add(lblRound3GroupCGoals1);
        round3teamGoalLabels.add(lblRound3GroupCGoals2);
        round3teamGoalLabels.add(lblRound3GroupCGoals3);
        round3teamGoalLabels.add(lblRound3GroupCGoals4);
        round3teamGoalLabels.add(lblRound3GroupDGoals1);
        round3teamGoalLabels.add(lblRound3GroupDGoals2);
        round3teamGoalLabels.add(lblRound3GroupDGoals3);
        round3teamGoalLabels.add(lblRound3GroupDGoals4);

        //Team goals round 4
        round4teamGoalLabels.add(lblRound4GroupAGoals1);
        round4teamGoalLabels.add(lblRound4GroupAGoals2);
        round4teamGoalLabels.add(lblRound4GroupAGoals3);
        round4teamGoalLabels.add(lblRound4GroupAGoals4);
        round4teamGoalLabels.add(lblRound4GroupBGoals1);
        round4teamGoalLabels.add(lblRound4GroupBGoals2);
        round4teamGoalLabels.add(lblRound4GroupBGoals3);
        round4teamGoalLabels.add(lblRound4GroupBGoals4);
        round4teamGoalLabels.add(lblRound4GroupCGoals1);
        round4teamGoalLabels.add(lblRound4GroupCGoals2);
        round4teamGoalLabels.add(lblRound4GroupCGoals3);
        round4teamGoalLabels.add(lblRound4GroupCGoals4);
        round4teamGoalLabels.add(lblRound4GroupDGoals1);
        round4teamGoalLabels.add(lblRound4GroupDGoals2);
        round4teamGoalLabels.add(lblRound4GroupDGoals3);
        round4teamGoalLabels.add(lblRound4GroupDGoals4);

        //Team goals round 5
        round5teamGoalLabels.add(lblRound5GroupAGoals1);
        round5teamGoalLabels.add(lblRound5GroupAGoals2);
        round5teamGoalLabels.add(lblRound5GroupAGoals3);
        round5teamGoalLabels.add(lblRound5GroupAGoals4);
        round5teamGoalLabels.add(lblRound5GroupBGoals1);
        round5teamGoalLabels.add(lblRound5GroupBGoals2);
        round5teamGoalLabels.add(lblRound5GroupBGoals3);
        round5teamGoalLabels.add(lblRound5GroupBGoals4);
        round5teamGoalLabels.add(lblRound5GroupCGoals1);
        round5teamGoalLabels.add(lblRound5GroupCGoals2);
        round5teamGoalLabels.add(lblRound5GroupCGoals3);
        round5teamGoalLabels.add(lblRound5GroupCGoals4);
        round5teamGoalLabels.add(lblRound5GroupDGoals1);
        round5teamGoalLabels.add(lblRound5GroupDGoals2);
        round5teamGoalLabels.add(lblRound5GroupDGoals3);
        round5teamGoalLabels.add(lblRound5GroupDGoals4);

        //Team goals round 6
        round6teamGoalLabels.add(lblRound6GroupAGoals1);
        round6teamGoalLabels.add(lblRound6GroupAGoals2);
        round6teamGoalLabels.add(lblRound6GroupAGoals3);
        round6teamGoalLabels.add(lblRound6GroupAGoals4);
        round6teamGoalLabels.add(lblRound6GroupBGoals1);
        round6teamGoalLabels.add(lblRound6GroupBGoals2);
        round6teamGoalLabels.add(lblRound6GroupBGoals3);
        round6teamGoalLabels.add(lblRound6GroupBGoals4);
        round6teamGoalLabels.add(lblRound6GroupCGoals1);
        round6teamGoalLabels.add(lblRound6GroupCGoals2);
        round6teamGoalLabels.add(lblRound6GroupCGoals3);
        round6teamGoalLabels.add(lblRound6GroupCGoals4);
        round6teamGoalLabels.add(lblRound6GroupDGoals1);
        round6teamGoalLabels.add(lblRound6GroupDGoals2);
        round6teamGoalLabels.add(lblRound6GroupDGoals3);
        round6teamGoalLabels.add(lblRound6GroupDGoals4);
    }

    /**
     * Add all the FXML team name labels to array lists
     */
    public void addTeamNameLabels() {
        //Team names for round 1
        round1teamNameLabels.add(lblRound1GroupATeam1);
        round1teamNameLabels.add(lblRound1GroupATeam2);
        round1teamNameLabels.add(lblRound1GroupATeam3);
        round1teamNameLabels.add(lblRound1GroupATeam4);
        round1teamNameLabels.add(lblRound1GroupBTeam1);
        round1teamNameLabels.add(lblRound1GroupBTeam2);
        round1teamNameLabels.add(lblRound1GroupBTeam3);
        round1teamNameLabels.add(lblRound1GroupBTeam4);
        round1teamNameLabels.add(lblRound1GroupCTeam1);
        round1teamNameLabels.add(lblRound1GroupCTeam2);
        round1teamNameLabels.add(lblRound1GroupCTeam3);
        round1teamNameLabels.add(lblRound1GroupCTeam4);
        round1teamNameLabels.add(lblRound1GroupDTeam1);
        round1teamNameLabels.add(lblRound1GroupDTeam2);
        round1teamNameLabels.add(lblRound1GroupDTeam3);
        round1teamNameLabels.add(lblRound1GroupDTeam4);

        //Team names for round 2
        round2teamNameLabels.add(lblRound2GroupATeam1);
        round2teamNameLabels.add(lblRound2GroupATeam2);
        round2teamNameLabels.add(lblRound2GroupATeam3);
        round2teamNameLabels.add(lblRound2GroupATeam4);
        round2teamNameLabels.add(lblRound2GroupBTeam1);
        round2teamNameLabels.add(lblRound2GroupBTeam2);
        round2teamNameLabels.add(lblRound2GroupBTeam3);
        round2teamNameLabels.add(lblRound2GroupBTeam4);
        round2teamNameLabels.add(lblRound2GroupCTeam1);
        round2teamNameLabels.add(lblRound2GroupCTeam2);
        round2teamNameLabels.add(lblRound2GroupCTeam3);
        round2teamNameLabels.add(lblRound2GroupCTeam4);
        round2teamNameLabels.add(lblRound2GroupDTeam1);
        round2teamNameLabels.add(lblRound2GroupDTeam2);
        round2teamNameLabels.add(lblRound2GroupDTeam3);
        round2teamNameLabels.add(lblRound2GroupDTeam4);

        //Team names for round 3
        round3teamNameLabels.add(lblRound3GroupATeam1);
        round3teamNameLabels.add(lblRound3GroupATeam2);
        round3teamNameLabels.add(lblRound3GroupATeam3);
        round3teamNameLabels.add(lblRound3GroupATeam4);
        round3teamNameLabels.add(lblRound3GroupBTeam1);
        round3teamNameLabels.add(lblRound3GroupBTeam2);
        round3teamNameLabels.add(lblRound3GroupBTeam3);
        round3teamNameLabels.add(lblRound3GroupBTeam4);
        round3teamNameLabels.add(lblRound3GroupCTeam1);
        round3teamNameLabels.add(lblRound3GroupCTeam2);
        round3teamNameLabels.add(lblRound3GroupCTeam3);
        round3teamNameLabels.add(lblRound3GroupCTeam4);
        round3teamNameLabels.add(lblRound3GroupDTeam1);
        round3teamNameLabels.add(lblRound3GroupDTeam2);
        round3teamNameLabels.add(lblRound3GroupDTeam3);
        round3teamNameLabels.add(lblRound3GroupDTeam4);

        //Team names for round 4
        round4teamNameLabels.add(lblRound4GroupATeam1);
        round4teamNameLabels.add(lblRound4GroupATeam2);
        round4teamNameLabels.add(lblRound4GroupATeam3);
        round4teamNameLabels.add(lblRound4GroupATeam4);
        round4teamNameLabels.add(lblRound4GroupBTeam1);
        round4teamNameLabels.add(lblRound4GroupBTeam2);
        round4teamNameLabels.add(lblRound4GroupBTeam3);
        round4teamNameLabels.add(lblRound4GroupBTeam4);
        round4teamNameLabels.add(lblRound4GroupCTeam1);
        round4teamNameLabels.add(lblRound4GroupCTeam2);
        round4teamNameLabels.add(lblRound4GroupCTeam3);
        round4teamNameLabels.add(lblRound4GroupCTeam4);
        round4teamNameLabels.add(lblRound4GroupDTeam1);
        round4teamNameLabels.add(lblRound4GroupDTeam2);
        round4teamNameLabels.add(lblRound4GroupDTeam3);
        round4teamNameLabels.add(lblRound4GroupDTeam4);

        //Team names for round 5
        round5teamNameLabels.add(lblRound5GroupATeam1);
        round5teamNameLabels.add(lblRound5GroupATeam2);
        round5teamNameLabels.add(lblRound5GroupATeam3);
        round5teamNameLabels.add(lblRound5GroupATeam4);
        round5teamNameLabels.add(lblRound5GroupBTeam1);
        round5teamNameLabels.add(lblRound5GroupBTeam2);
        round5teamNameLabels.add(lblRound5GroupBTeam3);
        round5teamNameLabels.add(lblRound5GroupBTeam4);
        round5teamNameLabels.add(lblRound5GroupCTeam1);
        round5teamNameLabels.add(lblRound5GroupCTeam2);
        round5teamNameLabels.add(lblRound5GroupCTeam3);
        round5teamNameLabels.add(lblRound5GroupCTeam4);
        round5teamNameLabels.add(lblRound5GroupDTeam1);
        round5teamNameLabels.add(lblRound5GroupDTeam2);
        round5teamNameLabels.add(lblRound5GroupDTeam3);
        round5teamNameLabels.add(lblRound5GroupDTeam4);

        //Team names for round 6
        round6teamNameLabels.add(lblRound6GroupATeam1);
        round6teamNameLabels.add(lblRound6GroupATeam2);
        round6teamNameLabels.add(lblRound6GroupATeam3);
        round6teamNameLabels.add(lblRound6GroupATeam4);
        round6teamNameLabels.add(lblRound6GroupBTeam1);
        round6teamNameLabels.add(lblRound6GroupBTeam2);
        round6teamNameLabels.add(lblRound6GroupBTeam3);
        round6teamNameLabels.add(lblRound6GroupBTeam4);
        round6teamNameLabels.add(lblRound6GroupCTeam1);
        round6teamNameLabels.add(lblRound6GroupCTeam2);
        round6teamNameLabels.add(lblRound6GroupCTeam3);
        round6teamNameLabels.add(lblRound6GroupCTeam4);
        round6teamNameLabels.add(lblRound6GroupDTeam1);
        round6teamNameLabels.add(lblRound6GroupDTeam2);
        round6teamNameLabels.add(lblRound6GroupDTeam3);
        round6teamNameLabels.add(lblRound6GroupDTeam4);
    }

    /**
     * Add FXML winner labels to arrays
     */
    public void addWinnerLabelsToArrays() {
        //Group A round 1-6
        winnerLabels.add(lblRound1GroupAWinner1);
        winnerLabels.add(lblRound1GroupAWinner2);
        winnerLabels.add(lblRound2GroupAWinner1);
        winnerLabels.add(lblRound2GroupAWinner2);
        winnerLabels.add(lblRound3GroupAWinner1);
        winnerLabels.add(lblRound3GroupAWinner2);
        winnerLabels.add(lblRound4GroupAWinner1);
        winnerLabels.add(lblRound4GroupAWinner2);
        winnerLabels.add(lblRound5GroupAWinner1);
        winnerLabels.add(lblRound5GroupAWinner2);
        winnerLabels.add(lblRound6GroupAWinner1);
        winnerLabels.add(lblRound6GroupAWinner2);
        //Group B round 1-6
        winnerLabels.add(lblRound1GroupBWinner1);
        winnerLabels.add(lblRound1GroupBWinner2);
        winnerLabels.add(lblRound2GroupBWinner1);
        winnerLabels.add(lblRound2GroupBWinner2);
        winnerLabels.add(lblRound3GroupBWinner1);
        winnerLabels.add(lblRound3GroupBWinner2);
        winnerLabels.add(lblRound4GroupBWinner1);
        winnerLabels.add(lblRound4GroupBWinner2);
        winnerLabels.add(lblRound5GroupBWinner1);
        winnerLabels.add(lblRound5GroupBWinner2);
        winnerLabels.add(lblRound6GroupBWinner1);
        winnerLabels.add(lblRound6GroupBWinner2);
        //Group C round 1-6
        winnerLabels.add(lblRound1GroupCWinner1);
        winnerLabels.add(lblRound1GroupCWinner2);
        winnerLabels.add(lblRound2GroupCWinner1);
        winnerLabels.add(lblRound2GroupCWinner2);
        winnerLabels.add(lblRound3GroupCWinner1);
        winnerLabels.add(lblRound3GroupCWinner2);
        winnerLabels.add(lblRound4GroupCWinner1);
        winnerLabels.add(lblRound4GroupCWinner2);
        winnerLabels.add(lblRound5GroupCWinner1);
        winnerLabels.add(lblRound5GroupCWinner2);
        winnerLabels.add(lblRound6GroupCWinner1);
        winnerLabels.add(lblRound6GroupCWinner2);
        //Group D round 1-6
        winnerLabels.add(lblRound1GroupDWinner1);
        winnerLabels.add(lblRound1GroupDWinner2);
        winnerLabels.add(lblRound2GroupDWinner1);
        winnerLabels.add(lblRound2GroupDWinner2);
        winnerLabels.add(lblRound3GroupDWinner1);
        winnerLabels.add(lblRound3GroupDWinner2);
        winnerLabels.add(lblRound4GroupDWinner1);
        winnerLabels.add(lblRound4GroupDWinner2);
        winnerLabels.add(lblRound5GroupDWinner2);
        winnerLabels.add(lblRound6GroupDWinner1);
        winnerLabels.add(lblRound6GroupDWinner2);
    }

}
