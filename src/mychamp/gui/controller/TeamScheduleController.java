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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import mychamp.MyChamp;
import mychamp.be.Game;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.gui.model.TeamModel;

public class TeamScheduleController implements Initializable {

    @FXML
    private Label lblRound1Team1;
    @FXML
    private Label lblRound1Team2;
    @FXML
    private Label lblRound1Goal1;
    @FXML
    private Label lblRound1Goal2;
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
    private Label lblRound4Team2;
    @FXML
    private Label lblRound4Goal1;
    @FXML
    private Label lblRound4Goal2;
    @FXML
    private Label Round4Winner;
    @FXML
    private Label lblRound5Team1;
    @FXML
    private Label lblRound5Team2;
    @FXML
    private Label lblRound5Goal1;
    @FXML
    private Label lblRound5Goal2;
    @FXML
    private Label Round5Winner;
    @FXML
    private Label lblRound6Team1;
    @FXML
    private Label lblRound6Team2;
    @FXML
    private Label lblRound6Goal1;
    @FXML
    private Label lblRound6Goal2;
    @FXML
    private Label Round6Winner;
    @FXML
    private Label lblTeamPoints;
    @FXML
    private Label lblTeamPlacement;
    @FXML
    private ComboBox<String> comboTeamName;

    private final ArrayList<Match> listOfAllMatches;
    private final ArrayList<Match> listOfMatchesForSchedule;

    private final ArrayList<String> listOfTeamNames;

    private ArrayList<Team> listOfAllTeams;

    private final ArrayList<Label> homeTeamNameLabels;
    private final ArrayList<Label> awayTeamNameLabels;

    private final ArrayList<Label> homeTeamGoalsLabels;
    private final ArrayList<Label> awayTeamGoalsLabels;

    private final ArrayList<Label> winnerLabels;

    private Team selectedTeam;

    private final PlayOffController playOffController;
    @FXML
    private Label lblMatchesPlayed;
    @FXML
    private Label lblGoalDifferences;
    @FXML
    private Label lblTeamID;

    private static TeamScheduleController instance;

    public static TeamScheduleController getInstance() {
        return instance;
    }

    public TeamScheduleController() {
        playOffController = PlayOffController.getInstance();

        listOfAllTeams = new ArrayList<>();

        listOfAllMatches = new ArrayList();
        listOfMatchesForSchedule = new ArrayList();

        listOfTeamNames = new ArrayList();

        homeTeamNameLabels = new ArrayList();
        awayTeamNameLabels = new ArrayList();

        homeTeamGoalsLabels = new ArrayList();
        awayTeamGoalsLabels = new ArrayList();

        winnerLabels = new ArrayList();
    }

    /**
     * Load team info
     */
    public void loadTeamInfo() {
        initializeTeamLists();
        initializeAllMatches();
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
     * Pulls out the teams from the teamModel and puts their teamNames in the
     * comboBox.
     */
    private void initializeTeamLists() {
        //Configures the the names for the ComboBox
        listOfAllTeams.addAll(TeamModel.getInstance().getTeams());
        initializeTeamNames();
    }

    /**
     * Fill the array list with team names
     */
    private void initializeTeamNames() {
        for (Team team : listOfAllTeams) {
            String teamToAdd;
            teamToAdd = team.getTeamName();
            listOfTeamNames.add(teamToAdd);
        }
        comboTeamName.getItems().addAll(listOfTeamNames);
    }

    /**
     * Gets all matches and adds them to an ArrayList.
     */
    private void initializeAllMatches() {
        for (int i = 0; i < Game.AMOUNT_OF_GROUPS; i++) {
            listOfAllMatches.addAll(playOffController.getRandomGroups().get(i).getGroupMatches());
        }
    }

    /**
     * Loads labels into an ArrayList
     */
    private void fillLabelArray() {
        //Home team
        homeTeamNameLabels.clear();
        homeTeamNameLabels.add(lblRound1Team1);
        homeTeamNameLabels.add(lblRound2Team1);
        homeTeamNameLabels.add(lblRound3Team1);
        homeTeamNameLabels.add(lblRound4Team1);
        homeTeamNameLabels.add(lblRound5Team1);
        homeTeamNameLabels.add(lblRound6Team1);
        //Home goals
        homeTeamGoalsLabels.clear();
        homeTeamGoalsLabels.add(lblRound1Goal1);
        homeTeamGoalsLabels.add(lblRound2Goal1);
        homeTeamGoalsLabels.add(lblRound3Goal1);
        homeTeamGoalsLabels.add(lblRound4Goal1);
        homeTeamGoalsLabels.add(lblRound5Goal1);
        homeTeamGoalsLabels.add(lblRound6Goal1);
        //Away team
        awayTeamNameLabels.clear();
        awayTeamNameLabels.add(lblRound1Team2);
        awayTeamNameLabels.add(lblRound2Team2);
        awayTeamNameLabels.add(lblRound3Team2);
        awayTeamNameLabels.add(lblRound4Team2);
        awayTeamNameLabels.add(lblRound5Team2);
        awayTeamNameLabels.add(lblRound6Team2);
        //Away goals
        awayTeamGoalsLabels.clear();
        awayTeamGoalsLabels.add(lblRound1Goal2);
        awayTeamGoalsLabels.add(lblRound2Goal2);
        awayTeamGoalsLabels.add(lblRound3Goal2);
        awayTeamGoalsLabels.add(lblRound4Goal2);
        awayTeamGoalsLabels.add(lblRound5Goal2);
        awayTeamGoalsLabels.add(lblRound6Goal2);
        //Winners
        winnerLabels.clear();
        winnerLabels.add(Round1Winner);
        winnerLabels.add(Round2Winner);
        winnerLabels.add(Round3Winner);
        winnerLabels.add(Round4Winner);
        winnerLabels.add(Round5Winner);
        winnerLabels.add(Round6Winner);
    }

    /**
     * Moves back to the playoff view
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        goToView(MyChamp.PLAYOFF_VIEW);
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
     * Shows the team's info when chosen in the comboBox.
     *
     * @param event
     */
    @FXML
    private void handleOnHidden(Event event) {
        //Clears the lists
        listOfAllMatches.clear();
        listOfMatchesForSchedule.clear();

        //Adds all matches to an ArrayList
        initializeAllMatches();

        //Finds out which team to show.
        String teamToView = comboTeamName.getValue();

        //Adds the matches the team is involved in to an ArrayList.
        makeMatchListForSpecificTeam(teamToView);

        //Displays the matches of the selected team.
        displaySchedule(listOfMatchesForSchedule);

        setPlacementForTeam(teamToView);

        setMatchesPlayedForTeam();

        setGoalDiffences();

        setTeamID();
    }

    /**
     * Fill list of matches for a specific team
     *
     * @param teamToView
     */
    private void makeMatchListForSpecificTeam(String teamToView) {
        for (Match match : listOfAllMatches) {
            if (teamToView.equals(match.getAwayTeam().getTeamName()) || teamToView.equals(match.getHomeTeam().getTeamName())) {
                listOfMatchesForSchedule.add(match);
                if (teamToView.equals(match.getHomeTeam().getTeamName())) {
                    selectedTeam = match.getHomeTeam();
                } else {
                    selectedTeam = match.getAwayTeam();
                }
            }
        }
    }

    /**
     * Displays the schedule for a specific team
     *
     * @param listOfMatchesForSchedule
     */
    private void displaySchedule(ArrayList<Match> listOfMatchesForSchedule) {
        for (int i = 0; i < listOfMatchesForSchedule.size(); i++) {
            //Set home team names
            homeTeamNameLabels.get(i).setText(listOfMatchesForSchedule.get(i).getHomeTeam().getTeamName());
            //Set away team names
            awayTeamNameLabels.get(i).setText(listOfMatchesForSchedule.get(i).getAwayTeam().getTeamName());
            //Set home team goals
            homeTeamGoalsLabels.get(i).setText("" + listOfMatchesForSchedule.get(i).getHomeTeamScore());
            //Set away team goals
            awayTeamGoalsLabels.get(i).setText("" + listOfMatchesForSchedule.get(i).getAwayTeamScore());
        }
        //Set winner
        for (int i = 0; i < listOfMatchesForSchedule.size(); i++) {
            //If the match has been played
            if (listOfMatchesForSchedule.get(i).getWinnerTeam() != null) {
                //Display the winner
                winnerLabels.get(i).setText(listOfMatchesForSchedule.get(i).getWinnerTeam().getTeamName());
            } else {
                //Or display draw if that is the case
                if (listOfMatchesForSchedule.get(i).getHomeTeamScore() == listOfMatchesForSchedule.get(i).getAwayTeamScore() && listOfMatchesForSchedule.get(i).getHomeTeamScore() != 0) {
                    winnerLabels.get(i).setText("Uafgjort");
                }
            }
        }
        //Set points for team
        lblTeamPoints.setText("" + selectedTeam.getPoints());

    }

    /**
     * Displays the teams placement
     */
    private void setPlacementForTeam(String teamToView) {
        int teamPlacement = 0;
        //Set placement for team
        for (ArrayList<Label> groupRanking : playOffController.getRankingLabels()) {
            for (Label teamInGroup : groupRanking) {
                if (teamInGroup.getText().equals(teamToView)) {
                    teamPlacement = groupRanking.indexOf(teamInGroup) + 1;
                }
            }
        }

        lblTeamPlacement.setText("" + teamPlacement);
    }

    /**
     * Updates the matches played for this team
     */
    private void setMatchesPlayedForTeam() {
        int totalGames = selectedTeam.getWins() + selectedTeam.getLosses();
        lblMatchesPlayed.setText("" + totalGames);
    }

    /**
     * Sets the goal difference for the team (Goals scored - Goals taken)
     */
    private void setGoalDiffences() {
        lblGoalDifferences.setText("" + selectedTeam.getGoalDifference());
    }

    /**
     * Sets the ID for the team
     */
    private void setTeamID() {
        lblTeamID.setText("" + selectedTeam.getID());
    }
}
