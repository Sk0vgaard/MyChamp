/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.gui.model.TeamModel;

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
    private final int MATCH_OVER = 1;

    private Stage stage;

    private Match match;
    private Team homeTeam;
    private Team awayTeam;
    
    ObservableList<Team> teamsToDelete;

    private final TeamModel teamModel;

    public MatchDetailsController() {
        teamModel = TeamModel.getInstance();
        teamsToDelete = FXCollections.observableArrayList();
    }

    private final PlayOffController poController = PlayOffController.getInstance();

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
//            poController.updateGoals();
            poController.updateGoals();
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
     * Grants the teams their points, respective to a win, loss or draw Also
     * records the goal scored for the match.
     */
    private void givePointsToWinner() {
        int homeScore = Integer.parseInt(txtOneScore.getText());
        int awayScore = Integer.parseInt(txtTwoScore.getText());

        //Save the goals of the match to the match.
        match.setHomeTeamScore(homeScore);
        match.setAwayTeamScore(awayScore);

        //Save the amount of goals scored and taken for the teams.
        homeTeam.setGoalsScored(homeScore);
        homeTeam.setGoalsTaken(awayScore);
        awayTeam.setGoalsScored(awayScore);
        awayTeam.setGoalsTaken(homeScore);

        if (homeScore > awayScore) {
            homeTeam.setPoints(WINNER_POINTS);
            homeTeam.setWins(MATCH_OVER);
            awayTeam.setLosses(MATCH_OVER);
        } else if (homeScore == awayScore) {
            homeTeam.setPoints(DRAW_POINTS);
            awayTeam.setPoints(DRAW_POINTS);
        } else {
            awayTeam.setPoints(WINNER_POINTS);
            awayTeam.setWins(MATCH_OVER);
            homeTeam.setLosses(MATCH_OVER);
        }

    }

    private Alert teamRemoveDialog(Team teamToDelete) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bekræftelsesdialog");
        alert.setHeaderText("Er du sikker på du vil slette holdet: " + "\n\n" + teamToDelete.getTeamName());
        alert.setContentText("Tryk 'OK' for at slette.");
        return alert;
    }

    @FXML
    private void handleDeleteHomeTeam(ActionEvent event) {
        Alert alert;
        alert = teamRemoveDialog(homeTeam);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            teamsToDelete.add(homeTeam);
            teamModel.deleteTeam(teamsToDelete);
            for (Team team : teamModel.getTeams()) {
                System.out.println(team.getTeamName());
            }
        }
    }

    @FXML
    private void handleDeleteAwayTeam(ActionEvent event) {
        Alert alert;
        alert = teamRemoveDialog(awayTeam);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            teamsToDelete.add(awayTeam);
            teamModel.deleteTeam(teamsToDelete);
            for (Team team : teamModel.getTeams()) {
                System.out.println(team.getTeamName());
            }
        }
    }
}
