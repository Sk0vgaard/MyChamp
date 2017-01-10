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
import mychamp.be.Game;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

/**
 * FXML Controller class
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

    private Stage stage;

    private Match match;
    private Team homeTeam;
    private Team awayTeam;

    private final TeamModel teamModel;

    private final PlayOffController poController;

    private final FinalsController finalsController;

    private boolean inFinals;

    public MatchDetailsController() {
        teamModel = TeamModel.getInstance();
        poController = PlayOffController.getInstance();
        finalsController = FinalsController.getInstance();
        inFinals = false;
    }

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
        //Check if match is played
        if (!match.isPlayed()) {
            givePoints();
        } else {
            //If the match is already played just update the score and points
            if (match.getHomeTeamScore() > match.getAwayTeamScore()) {
                //Take away the last winning points from winner
                homeTeam.retractPoints(Game.WINNER_POINTS);
            } else if (match.getHomeTeamScore() < match.getAwayTeamScore()) {
                //Take away the last winning points from winner
                awayTeam.retractPoints(Game.WINNER_POINTS);
            } else {
                //If it was a draw, retract draw points from both teams
                homeTeam.retractPoints(Game.DRAW_POINTS);
                awayTeam.retractPoints(Game.DRAW_POINTS);
            }
            //Retract goals scored
            homeTeam.retractGoalsScored(match.getHomeTeamScore());
            awayTeam.retractGoalsScored(match.getAwayTeamScore());
            //Give new points to teams
            givePoints();
        }

    }

    /**
     * Give points to teams
     */
    private void givePoints() {
        //Check if there is text in the input fields
        if (isTextPresent()) {
            givePointsToWinner();
            stage = (Stage) lblOneName.getScene().getWindow();
            stage.close();
            match.setIsPlayed();
            poController.updateGoals();
            //If there is no text display input validation warning
        } else {
            displayInvalidInputWarning();
        }
    }

    /**
     * Display a warning for invalid input
     */
    private void displayInvalidInputWarning() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ugyldige informationer");
        alert.setHeaderText("De indtastede informationer er ikke gyldige");
        alert.setContentText("Indtast venligst gyldige informationer");
        alert.showAndWait();
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
    private boolean isTextPresent() {
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
            //Set the winner of the match label
            homeTeam.addPoints(Game.WINNER_POINTS);
            homeTeam.addWin();
            awayTeam.addLoss();
            match.setWinnerTeam(homeTeam);
            //If we're not in the finals update winner label in PlayOff
            if (!inFinals) {
                poController.setWinnerLabel(Game.WINNER_TEAM_TEXT + match.getWinnerTeam().getTeamName());
            } else {
                //Else we'll update the winner label in the finals
                finalsController.setWinnerLabel(Game.WINNER_TEAM_TEXT + match.getWinnerTeam().getTeamName());
            }
        } else if (homeScore < awayScore) {
            awayTeam.addPoints(Game.WINNER_POINTS);
            awayTeam.addWin();
            homeTeam.addLoss();
            match.setWinnerTeam(awayTeam);
            if (!inFinals) {
                poController.setWinnerLabel(Game.WINNER_TEAM_TEXT + match.getWinnerTeam().getTeamName());
            } else {
                //Else we'll update the winner label in the finals
                finalsController.setWinnerLabel(Game.WINNER_TEAM_TEXT + match.getWinnerTeam().getTeamName());
            }
        } else if (homeScore == awayScore && homeScore != 0) {
            //Set draw text
            homeTeam.addPoints(Game.DRAW_POINTS);
            awayTeam.addPoints(Game.DRAW_POINTS);
            if (!inFinals) {
                poController.setWinnerLabel(Game.WINNER_DRAW_TEXT);
            } else {
                //Else we'll update the winner label in the finals
                finalsController.setWinnerLabel(Game.WINNER_DRAW_TEXT);
            }
        } else {
            //Do absolutely nothing, since user most likely regretted his actions!
        }

    }

    /**
     * Display an alert dialog to remove a team
     *
     * @param teamToDelete
     * @return
     */
    private Alert teamRemoveDialog(Team teamToDelete) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bekræftelsesdialog");
        alert.setHeaderText("Er du sikker på du vil slette holdet: " + "\n\n" + teamToDelete.getTeamName());
        alert.setContentText("Tryk 'OK' for at slette.");
        return alert;
    }

    /**
     * Display an alert to delete the home team
     *
     * @param event
     */
    @FXML
    private void handleDeleteHomeTeam(ActionEvent event) {
        Alert alert;
        alert = teamRemoveDialog(homeTeam);

        Optional<ButtonType> result = alert.showAndWait();

        ObservableList<Team> teamsToDelete = FXCollections.observableArrayList();
        teamsToDelete.add(homeTeam);

        if (result.get() == ButtonType.OK) {
            //Remove team from teams
            teamModel.deleteTeam(teamsToDelete);
            //Remove team name labels
            poController.removeTeamLabelsFromTournament(homeTeam);
            //Remove team from matches
            GroupModel.getInstance().removeTeamFromGroupMatches(homeTeam);
            //Update benched games
            poController.checkBenchMatch();
        }
    }

    /**
     * Display an alert to delete the away team
     *
     * @param event
     */
    @FXML
    private void handleDeleteAwayTeam(ActionEvent event) {
        Alert alert;
        alert = teamRemoveDialog(awayTeam);

        Optional<ButtonType> result = alert.showAndWait();
        ObservableList<Team> teamsToDelete = FXCollections.observableArrayList();
        teamsToDelete.add(awayTeam);

        if (result.get() == ButtonType.OK) {
            teamModel.deleteTeam(teamsToDelete);
            poController.removeTeamLabelsFromTournament(awayTeam);
            GroupModel.getInstance().removeTeamFromGroupMatches(awayTeam);
        }
    }

    /**
     * Set the finals as being active
     */
    public void setFinalsActive() {
        inFinals = true;
    }
}
