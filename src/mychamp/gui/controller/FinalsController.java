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
import mychamp.be.Match;

public class FinalsController implements Initializable {

    @FXML
    private Label lblRankings;
    @FXML
    private Label lblRankings1;
    @FXML
    private Label lblRankings2;
    @FXML
    private Label lblRankings3;
    @FXML
    private Label lblQuarterTeamA1;
    @FXML
    private Label lblQuarterTeamB2;
    @FXML
    private Label lblQuarterTeamA2;
    @FXML
    private Label lblQuarterTeamB1;
    @FXML
    private Label lblQuarterTeamC1;
    @FXML
    private Label lblQuarterTeamD2;
    @FXML
    private Label lblQuarterTeamC2;
    @FXML
    private Label lblQuarterTeamD1;

    private static FinalsController instance;

    public static FinalsController getInstance() {
        return instance;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        // TODO
    }

    /**
     * Set the quarter finals
     *
     * @param finalTeams
     */
    public void setQuarterFinals(ArrayList<Match> finalTeams) {
        //Set first match
        lblQuarterTeamA1.setText(finalTeams.get(0).getHomeTeam().getTeamName());
        lblQuarterTeamB2.setText(finalTeams.get(0).getAwayTeam().getTeamName());
        //Set second match
        lblQuarterTeamB1.setText(finalTeams.get(1).getHomeTeam().getTeamName());
        lblQuarterTeamA2.setText(finalTeams.get(1).getAwayTeam().getTeamName());
        //Set third match
        lblQuarterTeamC1.setText(finalTeams.get(2).getHomeTeam().getTeamName());
        lblQuarterTeamD2.setText(finalTeams.get(2).getAwayTeam().getTeamName());
        //Set fourth match
        lblQuarterTeamC2.setText(finalTeams.get(3).getHomeTeam().getTeamName());
        lblQuarterTeamD1.setText(finalTeams.get(3).getAwayTeam().getTeamName());
    }

    /**
     * Switches to the PlayOffView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handlePlayoffButton(ActionEvent event) throws IOException {
        goToView("PlayOffView");
    }

    @FXML
    private void handleMenuButton(ActionEvent event) throws IOException {
        goToView("MenuView");
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
}
