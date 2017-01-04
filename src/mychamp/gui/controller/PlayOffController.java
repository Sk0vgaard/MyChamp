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
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mychamp.MyChamp;
import mychamp.be.Group;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.gui.model.GroupModel;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
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
    private Label lblRound5GroupCWinner11;
    @FXML
    private Label lblRound6GroupCTeam2;
    @FXML
    private Label lblRound6GroupCGoals2;
    @FXML
    private Label lblRound6GroupCTeam3;
    @FXML
    private Label lblRound6GroupCGoals3;
    @FXML
    private Label lblRound5GroupCWinner21;
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

    private ArrayList<Group> randomGroups;

    private Stage primStage;

    private final ArrayList<Label> round1teamNameLabels = new ArrayList();
    private final ArrayList<Label> round2teamNameLabels = new ArrayList();
    private final ArrayList<Label> round3teamNameLabels = new ArrayList();
    private final ArrayList<Label> round4teamNameLabels = new ArrayList();
    private final ArrayList<Label> round5teamNameLabels = new ArrayList();
    private final ArrayList<Label> round6teamNameLabels = new ArrayList();

    private final ArrayList<Label> round1teamGoalLabels = new ArrayList();
    private final ArrayList<Label> round2teamGoalLabels = new ArrayList();
    private final ArrayList<Label> round3teamGoalLabels = new ArrayList();
    private final ArrayList<Label> round4teamGoalLabels = new ArrayList();
    private final ArrayList<Label> round5teamGoalLabels = new ArrayList();
    private final ArrayList<Label> round6teamGoalLabels = new ArrayList();

    private static PlayOffController instance;

    public static PlayOffController getInstance() {
        return instance;
    }
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        addLabelsToArrayList();
    }

    /**
     * Switches to the FinalsView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleFinalsButton(ActionEvent event) throws IOException {
        goToView("FinalsView");
    }

    @FXML
    private void handleMenuButton(ActionEvent event) throws IOException {
        goToView("MenuView");
    }

    @FXML
    private void handleTeamButton(ActionEvent event) throws IOException {
        goToView("TeamScheduleView");
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
        setRoundOne();
        setRoundTwo();
        setRoundThree();
        setRoundFour();
        setRoundFive();
        setRoundSix();
        setGoals();
    }

    /**
     * Set goals for all teams
     */
    private void setGoals() {
        for (int i = 0; i < 16; i++) {
            //Start all teams with 0 goals
            round1teamGoalLabels.get(0).setText("0");
            round1teamGoalLabels.remove(0);
            round2teamGoalLabels.get(0).setText("0");
            round2teamGoalLabels.remove(0);
            round3teamGoalLabels.get(0).setText("0");
            round3teamGoalLabels.remove(0);
            round4teamGoalLabels.get(0).setText("0");
            round4teamGoalLabels.remove(0);
            round5teamGoalLabels.get(0).setText("0");
            round5teamGoalLabels.remove(0);
            round6teamGoalLabels.get(0).setText("0");
            round6teamGoalLabels.remove(0);

        }
    }

    /**
     * Set information for round 1
     */
    private void setRoundOne() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        Team teamOne = null;
        Team teamTwo = null;
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            //Set label for first team in current group
            round1teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round1teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Create the first match of the group
            Match groupMatch1 = new Match(randomGroups.get(i).getGroupTeams().get(0).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            //Set label for third team in current group
            round1teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round1teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Create the second match of the group
            Match groupmatch2 = new Match(randomGroups.get(i).getGroupTeams().get(2).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Remove labels from the list
            round1teamNameLabels.remove(0);
            round1teamNameLabels.remove(0);
            round1teamNameLabels.remove(0);
            round1teamNameLabels.remove(0);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set information for round 2
     */
    private void setRoundTwo() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        Team teamOne = null;
        Team teamTwo = null;
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            //Set label for first team in current group
            round2teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round2teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Create the first match of the group
            Match groupMatch1 = new Match(randomGroups.get(i).getGroupTeams().get(0).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(3);
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            //Set label for third team in current group
            round2teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round2teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Create the second match of the group
            Match groupmatch2 = new Match(randomGroups.get(i).getGroupTeams().get(3).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Remove labels from the list
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set information for round 3
     */
    private void setRoundThree() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        Team teamOne = null;
        Team teamTwo = null;
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Set label for first team in current group
            round3teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round3teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Create the first match of the group
            Match groupMatch1 = new Match(randomGroups.get(i).getGroupTeams().get(1).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(3);
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            //Set label for third team in current group
            round3teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round3teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Create the second match of the group
            Match groupmatch2 = new Match(randomGroups.get(i).getGroupTeams().get(3).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Remove labels from the list
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set information for round 4
     */
    private void setRoundFour() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        Team teamOne = null;
        Team teamTwo = null;
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(0);
            teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            //Set label for first team in current group
            round4teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round4teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Create the first match of the group
            Match groupMatch1 = new Match(randomGroups.get(i).getGroupTeams().get(0).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = randomGroups.get(i).getGroupTeams().get(2);
            //Set label for third team in current group
            round4teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round4teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Create the second match of the group
            Match groupmatch2 = new Match(randomGroups.get(i).getGroupTeams().get(1).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Remove labels from the list
            round4teamNameLabels.remove(0);
            round4teamNameLabels.remove(0);
            round4teamNameLabels.remove(0);
            round4teamNameLabels.remove(0);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set information for round 5
     */
    private void setRoundFive() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        Team teamOne = null;
        Team teamTwo = null;
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Set label for first team in current group
            round5teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round5teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Create the first match of the group
            Match groupMatch1 = new Match(randomGroups.get(i).getGroupTeams().get(2).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(1);
            teamTwo = randomGroups.get(i).getGroupTeams().get(3);
            //Set label for third team in current group
            round5teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round5teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Create the second match of the group
            Match groupmatch2 = new Match(randomGroups.get(i).getGroupTeams().get(1).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Remove labels from the list
            round5teamNameLabels.remove(0);
            round5teamNameLabels.remove(0);
            round5teamNameLabels.remove(0);
            round5teamNameLabels.remove(0);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Set information for round 6
     */
    private void setRoundSix() {
        ArrayList<Match> groupMatches = new ArrayList<>();
        Team teamOne = null;
        Team teamTwo = null;
        for (int i = 0; i < 4; i++) {
            teamOne = randomGroups.get(i).getGroupTeams().get(3);
            teamTwo = randomGroups.get(i).getGroupTeams().get(0);
            //Set label for first team in current group
            round6teamNameLabels.get(0).setText(teamOne.getTeamName());
            //Set label for second team in current group
            round6teamNameLabels.get(1).setText(teamTwo.getTeamName());
            //Create the first match of the group
            Match groupMatch1 = new Match(randomGroups.get(i).getGroupTeams().get(3).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupMatch1);
            //Clear the match teams to ge ready for the second match in the group
            teamOne = randomGroups.get(i).getGroupTeams().get(2);
            teamTwo = randomGroups.get(i).getGroupTeams().get(1);
            //Set label for third team in current group
            round6teamNameLabels.get(2).setText(teamOne.getTeamName());
            //Set label for fourth team in current group
            round6teamNameLabels.get(3).setText(teamTwo.getTeamName());
            //Create the second match of the group
            Match groupmatch2 = new Match(randomGroups.get(i).getGroupTeams().get(2).getHomeField(), teamOne, teamTwo);
            groupMatches.add(groupmatch2);
            //Remove labels from the list
            round6teamNameLabels.remove(0);
            round6teamNameLabels.remove(0);
            round6teamNameLabels.remove(0);
            round6teamNameLabels.remove(0);
            //Add group matches to the array
            randomGroups.get(i).addGroupMatches(groupMatches);
            //Clear current groupMatchs
            groupMatches.clear();
        }
    }

    /**
     * Fill up ArrayLists with labels
     */
    private void addLabelsToArrayList() {
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

        //Team names for round 5
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

    private void MatchClicked(int group, int match) throws IOException {
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

//            //Shows the modal.
            editStage.show();
//            //Loads the modals controller to send match.
            MatchDetailsController mdController = loader.getController();
            mdController.setCurrentMatch(matchToSend);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

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
                    MatchClicked(0, 0);
                    break;
                case "01":
                    MatchClicked(0, 1);
                    break;
                case "02":
                    MatchClicked(1, 0);
                    break;
                case "03":
                    MatchClicked(1, 1);
                    break;
                case "04":
                    MatchClicked(2, 0);
                    break;
                case "05":
                    MatchClicked(2, 1);
                    break;
                case "06":
                    MatchClicked(3, 0);
                    break;
                case "07":
                    MatchClicked(3, 1);
                    break;
                case "10":
                    MatchClicked(0, 2);
                    break;
                case "11":
                    MatchClicked(0, 3);
                    break;
                case "12":
                    MatchClicked(1, 2);
                    break;
                case "13":
                    MatchClicked(1, 3);
                    break;
                case "14":
                    MatchClicked(2, 2);
                    break;
                case "15":
                    MatchClicked(2, 3);
                    break;
                case "16":
                    MatchClicked(3, 2);
                    break;
                case "17":
                    MatchClicked(3, 3);
                    break;
                /*TODO ALH: The rest of the buttons needs to be put into this switch!
                    1.First create a button in scenebuilder
                    2.Then give it an id (the same as its coordinate!)
                    3.Then make sure the onAction is set to call this method (handleMatchClick)
                    4. Then you simply save it and add a new case here for the buttonNumber
                    5. The MatchClicked will the send the group and the match to the new window method
                 */
                default:
                    System.out.println("WTF?");
                    break;
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}
