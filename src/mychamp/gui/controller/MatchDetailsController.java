/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mychamp.be.Match;
import mychamp.be.Team;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class MatchDetailsController implements Initializable {

    @FXML
    private Label lblOneName;
    @FXML
    private Label lblOneGoals;
    @FXML
    private Label lblTwoName;
    @FXML
    private Label lblTwoGoal;
    @FXML
    private TextField txtOneScore;
    @FXML
    private TextField txtTwoScore;

    private final int WINNER_POINTS = 3;
    private final int DRAW_POINTS = 1;

    private Stage stage;

    private Match match;
    private Team homeTeam;
    private Team awayTeam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Set the Teams so it's possible to get the data.
     *
     * @param match
     */
    public void setCurrentMatch(Match match) {
        this.match = match;
        homeTeam = match.getHomeTeam();
        awayTeam = match.getAwayTeam();
        setMatchInfo();
    }

    /**
     * Set the initial information about the teams in the match
     */
    private void setMatchInfo() {
        lblOneName.setText(homeTeam.getTeamName());
        lblTwoName.setText(awayTeam.getTeamName());
        lblOneGoals.setText("" + match.getHomeTeamScore());
        lblTwoGoal.setText("" + match.getAwayTeamScore());
    }

    /**
     * Updates the match with the new information
     *
     * @param event
     */
    @FXML
    private void handleSaveButton(ActionEvent event) {
        if (isDataPresent()) {
            givePointsToWinner();
            stage = (Stage) lblOneName.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ugyldige informationer");
            alert.setHeaderText("De indtastede informationer er ikke gyldige");
            alert.setContentText("Indtast venligst gyldige informationer");
            alert.showAndWait();
        }
    }

    /**
     * Closes the modal.
     *
     * @param event
     */
    @FXML
    private void handleBackButton(ActionEvent event) {
        stage = (Stage) lblOneName.getScene().getWindow();
        stage.close();
    }

    /**
     * Checks if there is valid data in the textfields.
     *
     * @return
     */
    private boolean isDataPresent() {
        if (txtOneScore.getText().equals("")
                || !txtOneScore.getText().matches("[0-9]*[0-9]")
                || txtTwoScore.getText().equals("")
                || !txtTwoScore.getText().matches("[0-9]*[0-9]")) {
            return false;
        }
        return true;
    }

    /**
     * Grants the teams their points, respective to a win, loss or draw
     */
    private void givePointsToWinner() {
        int homeScore = Integer.parseInt(txtOneScore.getText());
        int awayScore = Integer.parseInt(txtTwoScore.getText());

        if (homeScore > awayScore) {
            homeTeam.setPoints(WINNER_POINTS);
        } else if (homeScore == awayScore) {
            homeTeam.setPoints(DRAW_POINTS);
            awayTeam.setPoints(DRAW_POINTS);
        } else {
            awayTeam.setPoints(WINNER_POINTS);
        }

    }
}
