/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import mychamp.MyChamp;
import mychamp.be.Game;
import mychamp.be.Match;
import mychamp.be.Team;
import mychamp.bll.FileManager;
import mychamp.bll.GroupManager;
import mychamp.bll.RankingManager;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

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
    @FXML
    private Label lblQuarterGoalA1;
    @FXML
    private Label lblQuarterGoalB2;
    @FXML
    private Label lblQuarterGoalC1;
    @FXML
    private Label lblQuarterGoalD2;
    @FXML
    private Label lblSemiTeam1;
    @FXML
    private Label lblSemiTeam2;
    @FXML
    private Label lblSemiGoal1;
    @FXML
    private Label lblSemiGoal2;
    @FXML
    private Label lblSemiTeam3;
    @FXML
    private Label lblSemiTeam4;
    @FXML
    private Label lblSemiGoal3;
    @FXML
    private Label lblSemiGoal4;
    @FXML
    private Label lblFinalTeam1;
    @FXML
    private Label lblFinalTeam2;
    @FXML
    private Label lblFinalGoal1;
    @FXML
    private Label lblFinalGoal2;
    @FXML
    private Label lblQuarterGoalC2;
    @FXML
    private Label lblQuarterGoalD1;
    @FXML
    private Label lblQuarterWinner1;
    @FXML
    private Label lblQuarterWinner2;
    @FXML
    private Label lblQuarterWinner3;
    @FXML
    private Label lblQuarterWinner4;
    @FXML
    private Label lblSemiWinner1;
    @FXML
    private Label lblSemiWinner2;
    @FXML
    private Label lblWinner;
    @FXML
    private Label lblRank1;
    @FXML
    private Label lblRank2;
    @FXML
    private Label lblRank3;
    @FXML
    private Label lblRank4;
    @FXML
    private Label lblRank5;
    @FXML
    private Label lblRank6;
    @FXML
    private Label lblRank7;
    @FXML
    private Label lblRank8;
    @FXML
    private Label lblRank9;
    @FXML
    private Label lblRank10;
    @FXML
    private Label lblRank11;
    @FXML
    private Label lblRank12;
    @FXML
    private Label lblRank13;
    @FXML
    private Label lblRank14;
    @FXML
    private Label lblRank15;
    @FXML
    private Label lblRank16;
    @FXML
    private Label lblQuarterGoalB1;
    @FXML
    private Label lblQuarterGoalA2;

    private static FinalsController instance;

    private final TeamModel teamModel = TeamModel.getInstance();

    private final RankingManager rankingManager = RankingManager.getInstance();

    private final ArrayList<Label> teamNameLabels = new ArrayList<>();

    private final ArrayList<Label> winnerLabels = new ArrayList<>();

    private final ArrayList<Label> top8Labels = new ArrayList<>();

    private final ArrayList<Label> last8Labels = new ArrayList<>();

    private final ArrayList<Match> semiFinalMatches;

    private ArrayList<Match> quarterFinalMatches;

    private ArrayList<Match> finalMatches;

    private ArrayList<ArrayList<Match>> allMatches;

    private final Team mockTeam;

    private final Match semiMatch1;

    private final Match semiMatch2;

    private final Match finalMatch;

    private Label winnerLabel;

    private Stage primStage;

    public static FinalsController getInstance() {
        return instance;
    }

    public FinalsController() {
        mockTeam = new Team("", "", "");
        quarterFinalMatches = new ArrayList<>(4);
        semiFinalMatches = new ArrayList<>(2);
        finalMatches = new ArrayList<>(1);
        allMatches = new ArrayList<>();
        semiMatch1 = new Match("", mockTeam, mockTeam);
        semiMatch2 = new Match("", mockTeam, mockTeam);
        semiFinalMatches.add(semiMatch1);
        semiFinalMatches.add(semiMatch2);
        finalMatch = new Match(null, mockTeam, mockTeam);
        finalMatches.add(finalMatch);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        addLabelsToArrayList();
        initilizeDesign();
    }

    /**
     * Load saved Finals
     */
    public void loadSavedFinals() {
        addLabelsToArrayList();
        allMatches = GroupModel.getInstance().getFinalMatchesFromFile();
        if (FileManager.getInstance().isTop8There()) {
            GroupManager.getInstance().loadSavedTop8();
        }
        loadSavedMatchesIntoTournament();
        updateFinalsInformation();
    }

    /**
     * Add savedMatches to stage matches
     */
    private void loadSavedMatchesIntoTournament() {
        quarterFinalMatches.clear();
        semiFinalMatches.clear();
        finalMatches.clear();
        quarterFinalMatches.addAll(allMatches.get(0));
        semiFinalMatches.addAll(allMatches.get(1));
        finalMatches.addAll(allMatches.get(2));
    }

    /**
     * Add labels to arrays.
     */
    private void addLabelsToArrayList() {
        //Add labels to top8Labels.
        top8Labels.add(lblRank1);
        top8Labels.add(lblRank2);
        top8Labels.add(lblRank3);
        top8Labels.add(lblRank4);
        top8Labels.add(lblRank5);
        top8Labels.add(lblRank6);
        top8Labels.add(lblRank7);
        top8Labels.add(lblRank8);
        //Add labels to last8Labels.
        last8Labels.add(lblRank9);
        last8Labels.add(lblRank10);
        last8Labels.add(lblRank11);
        last8Labels.add(lblRank12);
        last8Labels.add(lblRank13);
        last8Labels.add(lblRank14);
        last8Labels.add(lblRank15);
        last8Labels.add(lblRank16);
    }

    /**
     * Load match information
     */
    public void updateFinalsInformation() {
        updateQuarterFinals();
        updateSemiFinals();
        updateFinale();
        updateGoals();
        updateWinners();
        setTop8Rankings();
        setLast8RankNames();
    }

    /**
     * Update winners
     */
    public void updateWinners() {
        //For each winner in quarter finals update the winner label
        for (int i = 0; i < quarterFinalMatches.size(); i++) {
            if (quarterFinalMatches.get(i).getWinnerTeam() != null) {
                winnerLabels.get(i).setText(Game.WINNER_TEAM_TEXT + quarterFinalMatches.get(i).getWinnerTeam().getTeamName());
            }
        }
        //For each winner in semi finals update the winner label
        for (int i = 0; i < semiFinalMatches.size(); i++) {
            if (semiFinalMatches.get(i).getWinnerTeam() != null) {
                winnerLabels.get(i + 4).setText(Game.WINNER_TEAM_TEXT + semiFinalMatches.get(i).getWinnerTeam().getTeamName());
            }
        }
        //For each winner in the finale update the winner label
        for (int i = 0; i < finalMatches.size(); i++) {
            if (finalMatches.get(i).getWinnerTeam() != null) {
                winnerLabels.get(i + 6).setText(Game.WINNER_TEAM_TEXT + finalMatches.get(i).getWinnerTeam().getTeamName());
            }
        }
    }

    /**
     * Update the semi finals
     */
    public void updateSemiFinals() {
        //Set first match
        lblSemiTeam1.setText(semiFinalMatches.get(0).getHomeTeam().getTeamName());
        lblSemiTeam2.setText(semiFinalMatches.get(0).getAwayTeam().getTeamName());
        //Set second match
        lblSemiTeam3.setText(semiFinalMatches.get(1).getHomeTeam().getTeamName());
        lblSemiTeam4.setText(semiFinalMatches.get(1).getAwayTeam().getTeamName());
    }

    /**
     * Update the finale
     */
    public void updateFinale() {
        lblFinalTeam1.setText(finalMatches.get(0).getHomeTeam().getTeamName());
        lblFinalTeam2.setText(finalMatches.get(0).getAwayTeam().getTeamName());
    }

    /**
     * Update the quarter finals
     */
    public void updateQuarterFinals() {
        //Set first match
        lblQuarterTeamA1.setText(quarterFinalMatches.get(0).getHomeTeam().getTeamName());
        lblQuarterTeamB2.setText(quarterFinalMatches.get(0).getAwayTeam().getTeamName());
        //Set second match
        lblQuarterTeamA2.setText(quarterFinalMatches.get(1).getHomeTeam().getTeamName());
        lblQuarterTeamB1.setText(quarterFinalMatches.get(1).getAwayTeam().getTeamName());
        //Set third match
        lblQuarterTeamC1.setText(quarterFinalMatches.get(2).getHomeTeam().getTeamName());
        lblQuarterTeamD2.setText(quarterFinalMatches.get(2).getAwayTeam().getTeamName());
        //Set fourth match
        lblQuarterTeamC2.setText(quarterFinalMatches.get(3).getHomeTeam().getTeamName());
        lblQuarterTeamD1.setText(quarterFinalMatches.get(3).getAwayTeam().getTeamName());
    }

    /**
     * Update goals for the finals
     */
    public void updateGoals() {
        //Update goals for quarter finals
        //First match
        lblQuarterGoalA1.setText("" + quarterFinalMatches.get(0).getHomeTeamScore());
        lblQuarterGoalB2.setText("" + quarterFinalMatches.get(0).getAwayTeamScore());
        //Second match
        lblQuarterGoalB1.setText("" + quarterFinalMatches.get(1).getHomeTeamScore());
        lblQuarterGoalA2.setText("" + quarterFinalMatches.get(1).getAwayTeamScore());
        //Third match
        lblQuarterGoalC1.setText("" + quarterFinalMatches.get(2).getHomeTeamScore());
        lblQuarterGoalD2.setText("" + quarterFinalMatches.get(2).getAwayTeamScore());
        //Fourth match
        lblQuarterGoalC2.setText("" + quarterFinalMatches.get(3).getHomeTeamScore());
        lblQuarterGoalD1.setText("" + quarterFinalMatches.get(3).getAwayTeamScore());

        //Update semi finals
        //First match
        lblSemiGoal1.setText("" + semiFinalMatches.get(0).getHomeTeamScore());
        lblSemiGoal2.setText("" + semiFinalMatches.get(0).getAwayTeamScore());
        //Second match
        lblSemiGoal3.setText("" + semiFinalMatches.get(1).getHomeTeamScore());
        lblSemiGoal4.setText("" + semiFinalMatches.get(1).getAwayTeamScore());

        //Update Finale
        lblFinalGoal1.setText("" + finalMatches.get(0).getHomeTeamScore());
        lblFinalGoal2.setText("" + finalMatches.get(0).getAwayTeamScore());
    }

    /**
     * Set the quarter finals
     *
     * @param quarterFinalMatches
     */
    public void setQuarterFinals(ArrayList<Match> quarterFinalMatches) {
        this.quarterFinalMatches = quarterFinalMatches;
        updateQuarterFinals();
        allMatches.add(quarterFinalMatches);
        allMatches.add(semiFinalMatches);
        allMatches.add(finalMatches);
    }

    /**
     * Switches to the PlayOffView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handlePlayoffButton(ActionEvent event) throws IOException {
        goToView(MyChamp.PLAYOFF_VIEW);
    }

    @FXML
    private void handleMenuButton(ActionEvent event) throws IOException {
        goToView(MyChamp.MENU_VIEW);
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
     * Opens the match details window
     */
    private void matchClicked(int matchNumber, int stage, int groupMatch, Label winnerLabel) {
        //Set the current winner label
        this.winnerLabel = winnerLabel;
        try {
            //Grab hold of the curret stage.
            primStage = (Stage) lblQuarterGoalA1.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mychamp/gui/view/MatchDetailsView.fxml"));
            Parent root = loader.load();
            Stage editStage = new Stage();
            editStage.setScene(new Scene(root));

            //Create new modal window from the FXMLLoader.
            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(primStage);

            //Finds the match that has been clicked on
            Match matchToSend = allMatches.get(stage).get(groupMatch);

            //Loads the modals controller to send match.
            MatchDetailsController mdController = loader.getController();
            mdController.setFinalsActive();
            mdController.setCurrentMatch(matchToSend);

            //Shows the modal and waits for it to close before continuing reading the code.
            editStage.showAndWait();

            //Update goal information
            updateQuarterFinals();
            updateGoals();

            //Advance the winner
            switch (matchNumber) {
                case 0:
                    //If the match is not a draw
                    if (matchToSend.getWinnerTeam() != null) {
                        //Get the winner of the match send it to the first team on semifinal match 1
                        lblSemiTeam1.setText(matchToSend.getWinnerTeam().getTeamName());
                        semiFinalMatches.get(0).setHomeTeam(matchToSend.getWinnerTeam());
                    } else {
                        //Get the best of the two teams who played
                        //Using these lines to get the "winning" team in case of draw to update rankings. TODO RKL: Clean this method. You wanna do it Adam or should I?
                        Team winningTeam = rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam());
                        matchToSend.setWinnerTeam(winningTeam);
                        lblSemiTeam1.setText(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()).getTeamName());
                        semiFinalMatches.get(0).setHomeTeam(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()));
                    }
                    //Updates the rankings
                    teamModel.addTeamToTop8Teams(matchToSend.getLoserTeam());
                    break;
                case 1:
                    if (matchToSend.getWinnerTeam() != null) {
                        //Get the winner of the match send it to the first team on semifinal match 1
                        lblSemiTeam2.setText(matchToSend.getWinnerTeam().getTeamName());
                        semiFinalMatches.get(0).setAwayTeam(matchToSend.getWinnerTeam());
                    } else {
                        //Get the best of the two teams who played
                        //Using these lines to get the "winning" team in case of draw to update rankings. TODO RKL: Clean this method. You wanna do it Adam or should I?
                        Team winningTeam = rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam());
                        matchToSend.setWinnerTeam(winningTeam);
                        lblSemiTeam2.setText(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()).getTeamName());
                        semiFinalMatches.get(0).setAwayTeam(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()));

                    }
                    //Updates the rankings
                    teamModel.addTeamToTop8Teams(matchToSend.getLoserTeam());
                    break;
                case 2:
                    if (matchToSend.getWinnerTeam() != null) {
                        lblSemiTeam3.setText(matchToSend.getWinnerTeam().getTeamName());
                        semiFinalMatches.get(1).setHomeTeam(matchToSend.getWinnerTeam());
                    } else {
                        //Get the best of the two teams who played
                        //Using these lines to get the "winning" team in case of draw to update rankings. TODO RKL: Clean this method. You wanna do it Adam or should I?
                        Team winningTeam = rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam());
                        matchToSend.setWinnerTeam(winningTeam);
                        lblSemiTeam3.setText(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()).getTeamName());
                        semiFinalMatches.get(1).setHomeTeam(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()));
                    }
                    //Updates the rankings
                    teamModel.addTeamToTop8Teams(matchToSend.getLoserTeam());
                    break;
                case 3:
                    if (matchToSend.getWinnerTeam() != null) {
                        lblSemiTeam4.setText(matchToSend.getWinnerTeam().getTeamName());
                        semiFinalMatches.get(1).setAwayTeam(matchToSend.getWinnerTeam());
                    } else {
                        //Get the best of the two teams who played
                        //Using these lines to get the "winning" team in case of draw to update rankings. TODO RKL: Clean this method. You wanna do it Adam or should I?
                        Team winningTeam = rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam());
                        matchToSend.setWinnerTeam(winningTeam);
                        lblSemiTeam4.setText(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()).getTeamName());
                        semiFinalMatches.get(1).setAwayTeam(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()));
                    }
                    //Updates the rankings
                    teamModel.addTeamToTop8Teams(matchToSend.getLoserTeam());
                    break;
                case 4:
                    if (matchToSend.getWinnerTeam() != null) {
                        lblFinalTeam1.setText(matchToSend.getWinnerTeam().getTeamName());
                        finalMatches.get(0).setHomeTeam(matchToSend.getWinnerTeam());
                    } else {
                        //Get the best of the two teams who played
                        //Using these lines to get the "winning" team in case of draw to update rankings. TODO RKL: Clean this method. You wanna do it Adam or should I?
                        Team winningTeam = rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam());
                        matchToSend.setWinnerTeam(winningTeam);
                        lblFinalTeam1.setText(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()).getTeamName());
                        finalMatches.get(0).setHomeTeam(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()));
                    }
                    //Updates the rankings
                    teamModel.addTeamToTop8Teams(matchToSend.getLoserTeam());
                    break;
                case 5:
                    if (matchToSend.getWinnerTeam() != null) {
                        lblFinalTeam2.setText(matchToSend.getWinnerTeam().getTeamName());
                        finalMatches.get(0).setAwayTeam(matchToSend.getWinnerTeam());
                    } else {
                        //Get the best of the two teams who played
                        //Using these lines to get the "winning" team in case of draw to update rankings. TODO RKL: Clean this method. You wanna do it Adam or should I?
                        Team winningTeam = rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam());
                        matchToSend.setWinnerTeam(winningTeam);
                        lblFinalTeam2.setText(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()).getTeamName());
                        finalMatches.get(0).setAwayTeam(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()));
                    }
                    //Updates the rankings
                    teamModel.addTeamToTop8Teams(matchToSend.getLoserTeam());
                    break;
                default:
                    if (matchToSend.getWinnerTeam() == null) {
                        matchToSend.setWinnerTeam(rankingManager.rankTwoTeamsAgainstEachOther(matchToSend.getHomeTeam(), matchToSend.getAwayTeam()));
                    }
                    showWinnerModal();
                    //Updates the rankings
                    teamModel.addTeamToTop8Teams(matchToSend.getWinnerTeam());
                    teamModel.addTeamToTop8Teams(matchToSend.getLoserTeam());
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        //Update the top 8 rankings
        setTop8Rankings();
        saveFinals();
    }

    /**
     * Save finals data
     */
    public void saveFinals() {
        //Save finals
        GroupModel.getInstance().setFinalMatches(allMatches);
        GroupModel.getInstance().saveFinalMatches();
    }

    /**
     * Handle the match clicked
     *
     * @param event
     */
    @FXML
    private void handleMatchClick(ActionEvent event
    ) {
        Button clickedButton = (Button) event.getSource();

        String buttonId = clickedButton.getId();

        switch (buttonId) {
            case "11":
                matchClicked(0, 0, 0, lblQuarterWinner1);
                break;
            case "13":
                matchClicked(1, 0, 1, lblQuarterWinner2);
                break;
            case "15":
                matchClicked(2, 0, 2, lblQuarterWinner3);
                break;
            case "17":
                matchClicked(3, 0, 3, lblQuarterWinner4);
                break;
            case "33":
                matchClicked(4, 1, 0, lblSemiWinner1);
                break;
            case "35":
                matchClicked(5, 1, 1, lblSemiWinner2);
                break;
            case "54":
                matchClicked(6, 2, 0, lblWinner);
                break;
            default:
                System.out.println("WTF!?");
                break;
        }
    }

    private void handleBackToMenu(ActionEvent event) throws IOException {
        goToView(MyChamp.MENU_VIEW);
    }

    /**
     * Set the names of the 8 baddest teams.
     */
    public void setLast8RankNames() {
        ArrayList<Team> teams = GroupManager.getInstance().getSortedUnqualifiedTeams();
        for (int i = 0; i < teams.size(); i++) {
            last8Labels.get(i).setText(teams.get(i).getTeamName());
        }
    }

    /**
     * Set the names of the 8 best teams.
     */
    public void setTop8Rankings() {
        ArrayList<Team> teams = GroupManager.getInstance().getSortedTopTeams();
        int startingValue = top8Labels.size() - teams.size();
        for (int i = startingValue; i < top8Labels.size(); i++) {
            top8Labels.get(i).setText(teams.get(i - startingValue).getTeamName());
        }

        //Stuff to check if rankings is correct
//        for (int i = 0; i < teams.size(); i++) {
//            System.out.println(teams.get(i).getPoints() + " : "
//                    + teams.get(i).getGoalDifference() + " : "
//                    + teams.get(i).getGoalsScored() + " : "
//                    + teams.get(i).getWinLossRatio() + " : "
//                    + teams.get(i).getGoalsTaken() + " : "
//                    + teams.get(i).getTeamName());
//        }
//        System.out.println("--------------------------------------");
    }

    /**
     * Set text on the current winner label
     *
     * @param text
     */
    public void setWinnerLabel(String text) {
        winnerLabel.setText(text);
    }

    /**
     * Add all team labels to array
     */
    private void addNameLabelsToArray() {
        teamNameLabels.add(lblQuarterTeamA1);
        teamNameLabels.add(lblQuarterTeamA2);
        teamNameLabels.add(lblQuarterTeamB1);
        teamNameLabels.add(lblQuarterTeamB2);
        teamNameLabels.add(lblQuarterTeamC1);
        teamNameLabels.add(lblQuarterTeamC2);
        teamNameLabels.add(lblQuarterTeamD1);
        teamNameLabels.add(lblQuarterTeamD2);
        teamNameLabels.add(lblSemiTeam1);
        teamNameLabels.add(lblSemiTeam2);
        teamNameLabels.add(lblSemiTeam3);
        teamNameLabels.add(lblSemiTeam4);
        teamNameLabels.add(lblFinalTeam1);
        teamNameLabels.add(lblFinalTeam2);
    }

    /**
     * Add winner labels to array
     */
    public void addWinnerLabelsToArray() {
        winnerLabels.add(lblQuarterWinner1);
        winnerLabels.add(lblQuarterWinner2);
        winnerLabels.add(lblQuarterWinner3);
        winnerLabels.add(lblQuarterWinner4);
        winnerLabels.add(lblSemiWinner1);
        winnerLabels.add(lblSemiWinner2);
        winnerLabels.add(lblWinner);
    }

    /**
     * Initialize design of all labels
     */
    public void initilizeDesign() {
        addNameLabelsToArray();
        addWinnerLabelsToArray();
        //Reset Team name labels
        for (Label teamNameLabel : teamNameLabels) {
            teamNameLabel.setText("");
        }
        for (Label winner : winnerLabels) {
            winner.setText("");
        }
        lblQuarterGoalA1.setText("0");
        lblQuarterGoalA2.setText("0");
        lblQuarterGoalB1.setText("0");
        lblQuarterGoalB1.setText("0");
        lblQuarterGoalB2.setText("0");
        lblQuarterGoalC1.setText("0");
        lblQuarterGoalC2.setText("0");
        lblQuarterGoalD1.setText("0");
        lblQuarterGoalD2.setText("0");
        lblSemiGoal1.setText("0");
        lblSemiGoal2.setText("0");
        lblSemiGoal3.setText("0");
        lblSemiGoal4.setText("0");
        lblFinalGoal1.setText("0");
        lblFinalGoal2.setText("0");
        //Reset rankings
        for (Label top8Label : top8Labels) {
            top8Label.setText("");
        }
        for (Label last8Label : last8Labels) {
            last8Label.setText("");
        }
    }

    private void handleScreenshotBtn(ActionEvent event) throws
            AWTException, IOException {
        // capture the whole screen

        BufferedImage screencapture = new Robot().createScreenCapture(
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        // Save as PNG
        File file = new File("Screenshot.png");
        ImageIO.write(screencapture, "png", file);

        // Save as JPEG
        //File file = new File("screencapture.jpg");
        //ImageIO.write(screencapture, "jpg", file);
        System.out.println("Det Virker");

        //Kilde http://www.rgagnon.com/javadetails/java-0489.html
    }

    /**
     * Removes the team labels from the tournament
     *
     * @param team
     */
    public void removeTeamLabelsFromTournament(Team team) {
        for (Label teamNameLabel : teamNameLabels) {
            if (teamNameLabel.getText().equals(team.getTeamName())) {
                teamNameLabel.setText("");
            }
        }
    }

    /**
     *
     * @return all matches from finals
     */
    public ArrayList<ArrayList<Match>> getAllMatches() {
        return allMatches;
    }
    
    private void showWinnerModal() throws IOException {
        //Grab hold of the finals stage.
        primStage = (Stage) lblFinalGoal1.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mychamp/gui/view/WinnerView.fxml"));
        Parent root = loader.load();
        Stage editStage = new Stage();
        editStage.setScene(new Scene(root));

        //Create new modal window from the FXMLLoader.
        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(primStage);

        //Loads the modals controller to send match.
        WinnerViewController wvController = loader.getController();
        
        //
        editStage.show();
        
        wvController.setlblWinner(finalMatch.getWinnerTeam());
    }
}
