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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mychamp.MyChamp;
import mychamp.be.Group;

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

    private ArrayList<Group> randomGroups;

    private final ArrayList<Label> round1teamNameLabels = new ArrayList();
    private final ArrayList<Label> round2teamNameLabels = new ArrayList();
    private final ArrayList<Label> round3teamNameLabels = new ArrayList();

    private final ArrayList<Label> round1teamGoalLabels = new ArrayList();
    private final ArrayList<Label> round2teamGoalLabels = new ArrayList();
    private final ArrayList<Label> round3teamGoalLabels = new ArrayList();

    private static PlayOffController instance;

    public static PlayOffController getInstance() {
        return instance;
    }

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
    }

    /**
     * Set information for round 1
     */
    private void setRoundOne() {
        //For every group
        for (int a = 0; a < 4; a++) {
            //For every team in the group
            for (int l = 0; l < randomGroups.get(a).getGroupTeams().size(); l++) {
                //Assign the team name to the group
                round1teamNameLabels.get(0).setText(randomGroups.get(a).getGroupTeams().get(l).getTeamName());
                round1teamNameLabels.remove(0);

                //Start team with 0 goals
                round1teamGoalLabels.get(0).setText("0");
                round1teamGoalLabels.remove(0);
                round2teamGoalLabels.get(0).setText("0");
                round2teamGoalLabels.remove(0);
            }
        }
    }

    /**
     * Set information for round 2
     */
    private void setRoundTwo() {

        for (int i = 0; i < 4; i++) {
            round2teamNameLabels.get(0).setText(randomGroups.get(i).getGroupTeams().get(0).getTeamName());
            round2teamNameLabels.get(1).setText(randomGroups.get(i).getGroupTeams().get(2).getTeamName());
            round2teamNameLabels.get(2).setText(randomGroups.get(i).getGroupTeams().get(3).getTeamName());
            round2teamNameLabels.get(3).setText(randomGroups.get(i).getGroupTeams().get(1).getTeamName());
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);
            round2teamNameLabels.remove(0);

        }
    }

    /**
     * Set information for round 3
     */
    private void setRoundThree() {
        for (int i = 0; i < 4; i++) {
            round3teamNameLabels.get(0).setText(randomGroups.get(i).getGroupTeams().get(1).getTeamName());
            round3teamNameLabels.get(1).setText(randomGroups.get(i).getGroupTeams().get(0).getTeamName());
            round3teamNameLabels.get(2).setText(randomGroups.get(i).getGroupTeams().get(3).getTeamName());
            round3teamNameLabels.get(3).setText(randomGroups.get(i).getGroupTeams().get(2).getTeamName());
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
            round3teamNameLabels.remove(0);
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
    }
}
