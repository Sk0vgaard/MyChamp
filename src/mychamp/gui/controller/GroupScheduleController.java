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

public class GroupScheduleController implements Initializable {

    @FXML
    private Label lblGroupName;
    @FXML
    private Label lblRound1Team1;
    @FXML
    private Label lblRound1Goal1;
    @FXML
    private Label Round1Winner;
    @FXML
    private Label lblRound2Team1;
    @FXML
    private Label lblRound2Team2;
    @FXML
    private Label lblRound2Goal1;
    @FXML
    private Label lblRound2Goal2;
    @FXML
    private Label Round2Winner;
    @FXML
    private Label lblRound3Team1;
    @FXML
    private Label lblRound3Team2;
    @FXML
    private Label lblRound3Goal1;
    @FXML
    private Label lblRound3Goal2;
    @FXML
    private Label Round3Winner;
    @FXML
    private Label lblRound4Team1;
    @FXML
    private Label lblRound4Goal1;
    @FXML
    private Label lblRound4Goal2;
    @FXML
    private Label Round4Winner;
    @FXML
    private Label lblRound4Team2;
    @FXML
    private Label lblRound5Goal1;
    @FXML
    private Label lblRound5Goal2;
    @FXML
    private Label Round5Winner;
    @FXML
    private Label lblRound5Team1;
    @FXML
    private Label lblRound5Team2;
    @FXML
    private Label lblRound6Goal1;
    @FXML
    private Label lblRound6Goal2;
    @FXML
    private Label lblRound1Team2;
    @FXML
    private Label Round6Winner;
    @FXML
    private Label lblRound6Team1;
    @FXML
    private Label lblRound6Team2;
    @FXML
    private Label lblRound1Goal2;
    @FXML
    private Label lblRound1Team3;
    @FXML
    private Label lblRound1Team4;
    @FXML
    private Label lblRound1Goal3;
    @FXML
    private Label lblRound1Goal4;
    @FXML
    private Label Round1Winner2;
    @FXML
    private Label lblRound2Team3;
    @FXML
    private Label lblRound2Team4;
    @FXML
    private Label lblRound2Goal3;
    @FXML
    private Label lblRound2Goal4;
    @FXML
    private Label Round2Winner2;
    @FXML
    private Label lblRound3Team3;
    @FXML
    private Label lblRound3Team4;
    @FXML
    private Label lblRound3Goal3;
    @FXML
    private Label lblRound3Goal4;
    @FXML
    private Label Round3Winner2;
    @FXML
    private Label lblRound4Team3;
    @FXML
    private Label lblRound4Team4;
    @FXML
    private Label lblRound4Goal3;
    @FXML
    private Label lblRound4Goal4;
    @FXML
    private Label Round4Winner2;
    @FXML
    private Label lblRound5Team3;
    @FXML
    private Label lblRound5Team4;
    @FXML
    private Label lblRound5Goal3;
    @FXML
    private Label lblRound5Goal4;
    @FXML
    private Label lblRound6Team3;
    @FXML
    private Label lblRound6Team4;
    @FXML
    private Label lblRound6Goal3;
    @FXML
    private Label lblRound6Goal4;
    @FXML
    private Label Round6Winner2;

    private Group selectedGroup;

    private static GroupScheduleController instance;

    private final ArrayList<Label> homeTeamNameLabels;
    private final ArrayList<Label> homeTeamGoalsLabels;
    private final ArrayList<Label> awayTeamNameLabels;
    private final ArrayList<Label> awayTeamGoalsLabels;

    private final ArrayList<Label> winnerLabels;

    public static GroupScheduleController getInstance() {
        return instance;
    }
    @FXML
    private Label Round5Winner2;

    public GroupScheduleController() {
        homeTeamNameLabels = new ArrayList<>();
        homeTeamGoalsLabels = new ArrayList<>();
        awayTeamNameLabels = new ArrayList<>();
        awayTeamGoalsLabels = new ArrayList<>();
        winnerLabels = new ArrayList<>();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        fillLabelArray();
    }

    /**
     * Sets the selected group
     *
     * @param group
     */
    public void setGroup(Group group) {
        selectedGroup = group;
        lblGroupName.setText(selectedGroup.getGroupName());
        loadGroupInformation();
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        goToView("PlayOffView");
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
     * Loads the group information
     */
    private void loadGroupInformation() {
        //Set home teams
        for (int i = 0; i < selectedGroup.getGroupMatches().size(); i++) {
            homeTeamNameLabels.get(i).setText(selectedGroup.getGroupMatches().get(i).getHomeTeam().getTeamName());
            homeTeamGoalsLabels.get(i).setText("" + selectedGroup.getGroupMatches().get(i).getHomeTeamScore());
        }
        //Set away teams
        for (int i = 0; i < selectedGroup.getGroupMatches().size(); i++) {
            awayTeamNameLabels.get(i).setText(selectedGroup.getGroupMatches().get(i).getAwayTeam().getTeamName());
            awayTeamGoalsLabels.get(i).setText("" + selectedGroup.getGroupMatches().get(i).getAwayTeamScore());
        }
        //Set winner
        for (int i = 0; i < selectedGroup.getGroupMatches().size(); i++) {
            //If the match has been played
            if (selectedGroup.getGroupMatches().get(i).getWinnerTeam() != null) {
                //Display the winner
                winnerLabels.get(i).setText(selectedGroup.getGroupMatches().get(i).getWinnerTeam().getTeamName());
            } else {
                //Or display draw if that is the case
                if (selectedGroup.getGroupMatches().get(i).getHomeTeamScore() == selectedGroup.getGroupMatches().get(i).getAwayTeamScore() && selectedGroup.getGroupMatches().get(i).getHomeTeamScore() != 0) {
                    winnerLabels.get(i).setText("Uafgjort");
                }
            }
        }
    }

    /**
     * Loads labels into an ArrayList
     */
    private void fillLabelArray() {
        //Home team
        homeTeamNameLabels.add(lblRound1Team1);
        homeTeamNameLabels.add(lblRound1Team3);
        homeTeamNameLabels.add(lblRound2Team1);
        homeTeamNameLabels.add(lblRound2Team3);
        homeTeamNameLabels.add(lblRound3Team1);
        homeTeamNameLabels.add(lblRound3Team3);
        homeTeamNameLabels.add(lblRound4Team1);
        homeTeamNameLabels.add(lblRound4Team3);
        homeTeamNameLabels.add(lblRound5Team1);
        homeTeamNameLabels.add(lblRound5Team3);
        homeTeamNameLabels.add(lblRound6Team1);
        homeTeamNameLabels.add(lblRound6Team3);
        //Home goals
        homeTeamGoalsLabels.add(lblRound1Goal1);
        homeTeamGoalsLabels.add(lblRound1Goal3);
        homeTeamGoalsLabels.add(lblRound2Goal1);
        homeTeamGoalsLabels.add(lblRound2Goal3);
        homeTeamGoalsLabels.add(lblRound3Goal1);
        homeTeamGoalsLabels.add(lblRound3Goal3);
        homeTeamGoalsLabels.add(lblRound4Goal1);
        homeTeamGoalsLabels.add(lblRound4Goal3);
        homeTeamGoalsLabels.add(lblRound5Goal1);
        homeTeamGoalsLabels.add(lblRound5Goal3);
        homeTeamGoalsLabels.add(lblRound6Goal1);
        homeTeamGoalsLabels.add(lblRound6Goal3);
        //Away team
        awayTeamNameLabels.add(lblRound1Team2);
        awayTeamNameLabels.add(lblRound1Team4);
        awayTeamNameLabels.add(lblRound2Team2);
        awayTeamNameLabels.add(lblRound2Team4);
        awayTeamNameLabels.add(lblRound3Team2);
        awayTeamNameLabels.add(lblRound3Team4);
        awayTeamNameLabels.add(lblRound4Team2);
        awayTeamNameLabels.add(lblRound4Team4);
        awayTeamNameLabels.add(lblRound5Team2);
        awayTeamNameLabels.add(lblRound5Team4);
        awayTeamNameLabels.add(lblRound6Team2);
        awayTeamNameLabels.add(lblRound6Team4);
        //Away goals
        awayTeamGoalsLabels.add(lblRound1Goal2);
        awayTeamGoalsLabels.add(lblRound1Goal4);
        awayTeamGoalsLabels.add(lblRound2Goal2);
        awayTeamGoalsLabels.add(lblRound2Goal4);
        awayTeamGoalsLabels.add(lblRound3Goal2);
        awayTeamGoalsLabels.add(lblRound3Goal4);
        awayTeamGoalsLabels.add(lblRound4Goal2);
        awayTeamGoalsLabels.add(lblRound4Goal4);
        awayTeamGoalsLabels.add(lblRound5Goal2);
        awayTeamGoalsLabels.add(lblRound5Goal4);
        awayTeamGoalsLabels.add(lblRound6Goal2);
        awayTeamGoalsLabels.add(lblRound6Goal4);

        //Winner labels
        winnerLabels.add(Round1Winner);
        winnerLabels.add(Round1Winner2);
        winnerLabels.add(Round2Winner);
        winnerLabels.add(Round2Winner2);
        winnerLabels.add(Round3Winner);
        winnerLabels.add(Round3Winner2);
        winnerLabels.add(Round4Winner);
        winnerLabels.add(Round4Winner2);
        winnerLabels.add(Round5Winner);
        winnerLabels.add(Round5Winner2);
        winnerLabels.add(Round6Winner);
        winnerLabels.add(Round6Winner2);
    }

}
