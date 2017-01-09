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

    ArrayList<Team> listOfAllTeams;
    
    ArrayList<Match> listOfAllMatches;
    ArrayList<Match> listOfMatchesForSchedule;
    
    ArrayList<String> listOfTeamNames;
    
    private final ArrayList<Label> homeTeamNameLabels;
    private final ArrayList<Label> awayTeamNameLabels;
    
    private final ArrayList<Label> homeTeamGoalsLabels;
    private final ArrayList<Label> awayTeamGoalsLabels;
    
    private final ArrayList<Label> winnerLabels;
    
    private final TeamModel teamModel;
    
    private final PlayOffController playOffController;

    public TeamScheduleController() {
        teamModel = TeamModel.getInstance();
        playOffController = PlayOffController.getInstance();
        
        
        //Initializes all lists.
        listOfAllTeams = new ArrayList();
        
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeTeamLists();
        fillLabelArray();
    }
    /**
     * Pulls out the teams from the teamModel and puts their teamNames in the comboBox.
     */
    private void initializeTeamLists() {
        
        //Configures the the names for the ComboBox
        listOfAllTeams.addAll(teamModel.getTeams());
        initializeTeamNames();
    }

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
        for (int i = 0; i < 4; i++) {
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
     * Shows the team's info when chosen in the comboBox.
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
        
        //Displays the team's points.
        displayPoints(teamToView);
    }
    
    private void makeMatchListForSpecificTeam(String teamToView){
        for (Match match : listOfAllMatches) {
            if (teamToView.equals(match.getAwayTeam().getTeamName()) || teamToView.equals(match.getHomeTeam().getTeamName())) {
                listOfMatchesForSchedule.add(match);
            }
        }
    }

    private void displaySchedule(ArrayList<Match> listOfMatchesForSchedule) {
        //Set home team names
        for (int i = 0; i < listOfMatchesForSchedule.size(); i++) {
            homeTeamNameLabels.get(i).setText(listOfMatchesForSchedule.get(i).getHomeTeam().getTeamName());
        }
        //Set away team names
        for (int i = 0; i < listOfMatchesForSchedule.size(); i++) {
            awayTeamNameLabels.get(i).setText(listOfMatchesForSchedule.get(i).getAwayTeam().getTeamName());
        }
        //Set home team goals
        for (int i = 0; i < listOfMatchesForSchedule.size(); i++) {
            homeTeamGoalsLabels.get(i).setText("" + listOfMatchesForSchedule.get(i).getHomeTeamScore());
        }
        //Set away team goals
        for (int i = 0; i < listOfMatchesForSchedule.size(); i++) {
            awayTeamGoalsLabels.get(i).setText("" + listOfMatchesForSchedule.get(i).getAwayTeamScore());
        }
        //Set winner
        for (int i = 0; i < listOfMatchesForSchedule.size(); i++) {
            if (listOfMatchesForSchedule.get(i).getWinnerTeam() != null) {
                winnerLabels.get(i).setText(listOfMatchesForSchedule.get(i).getWinnerTeam().getTeamName());
            } else {
                winnerLabels.get(i).setText("Ikke spillet");
            }
        }
    }

    /**
     * Sets the points label.
     * @param teamToView 
     */
    private void displayPoints(String teamToView) {
        
        //TODO MSP: Fix the list with teams. It only contains 1 team, many times.
        for (Team team : teamModel.getTeamsAsArrayList()) {
                System.out.println(teamToView + " " + team.getPoints());
            if (team.getTeamName().equals(teamToView)) {
                lblTeamPoints.setText("" + team.getPoints());
            }
        }
    }
    
    
}
