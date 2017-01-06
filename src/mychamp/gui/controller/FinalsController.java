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
import javafx.stage.Modality;
import javafx.stage.Stage;
import mychamp.MyChamp;
import mychamp.be.Match;
import mychamp.be.Team;
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
    private Label lblQuarterGoalB1;
    @FXML
    private Label lblQuarterGoalA2;
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
    private Button btnBack;
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

    private static FinalsController instance;

    private final TeamModel teamModel = TeamModel.getInstance();

    private final GroupModel groupModel = GroupModel.getInstance();

    private ArrayList<Match> quarterFinalMatches;
    
    private final ArrayList<Label> top8Labels = new ArrayList<>();
    
    private final ArrayList<Label> last8Labels = new ArrayList<>();

    private final ArrayList<Match> semiFinalMatches;

    private final ArrayList<Match> finalMatches;

    private final ArrayList<ArrayList<Match>> allMatches;

    private final Team mockTeam;

    private final Match semiMatch1;

    private final Match semiMatch2;

    private final Match finalMatch;

    private Stage primStage;

    public static FinalsController getInstance() {
        return instance;
    }
    

    public FinalsController() {
        mockTeam = new Team("", "", "");
        semiFinalMatches = new ArrayList<>();
        finalMatches = new ArrayList<>();
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
    }
    
    /**
     * Add labels to arrays.
     */
    private void addLabelsToArrayList(){
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
     * Update the quarter finals
     */
    public void updateQuarterFinals() {
        //Set first match
        lblQuarterTeamA1.setText(quarterFinalMatches.get(0).getHomeTeam().getTeamName());
        lblQuarterGoalA1.setText("" + quarterFinalMatches.get(0).getHomeTeamScore());
        lblQuarterTeamB2.setText(quarterFinalMatches.get(0).getAwayTeam().getTeamName());
        lblQuarterGoalB2.setText("" + quarterFinalMatches.get(0).getAwayTeamScore());
        //Set second match
        lblQuarterTeamB1.setText(quarterFinalMatches.get(1).getHomeTeam().getTeamName());
        lblQuarterGoalB1.setText("" + quarterFinalMatches.get(1).getHomeTeamScore());
        lblQuarterTeamA2.setText(quarterFinalMatches.get(1).getAwayTeam().getTeamName());
        lblQuarterGoalA2.setText("" + quarterFinalMatches.get(1).getAwayTeamScore());
        //Set third match
        lblQuarterTeamC1.setText(quarterFinalMatches.get(2).getHomeTeam().getTeamName());
        lblQuarterGoalC1.setText("" + quarterFinalMatches.get(2).getHomeTeamScore());
        lblQuarterTeamD2.setText(quarterFinalMatches.get(2).getAwayTeam().getTeamName());
        lblQuarterGoalD2.setText("" + quarterFinalMatches.get(2).getAwayTeamScore());
        //Set fourth match
        lblQuarterTeamC2.setText(quarterFinalMatches.get(3).getHomeTeam().getTeamName());
        lblQuarterGoalC2.setText("" + quarterFinalMatches.get(3).getHomeTeamScore());
        lblQuarterTeamD1.setText(quarterFinalMatches.get(3).getAwayTeam().getTeamName());
        lblQuarterGoalD1.setText("" + quarterFinalMatches.get(3).getAwayTeamScore());
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

    /**
     * Opens the match details window
     */
    private void matchClicked(int stage, int match, Label winnerLabel) {
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
            Match matchToSend = quarterFinalMatches.get(0);

            //Loads the modals controller to send match.
            MatchDetailsController mdController = loader.getController();
            mdController.setCurrentMatch(matchToSend);

            //Shows the modal and waits for it to close before continuing reading the code.
            editStage.showAndWait();

            //Update goal information
            updateQuarterFinals();

            //Set the winner of the match
            if (matchToSend.getWinnerTeam() != null) {
                winnerLabel.setText(PlayOffController.WINNER_TEAM_TEXT + matchToSend.getWinnerTeam().getTeamName());
            } else {
                winnerLabel.setText(PlayOffController.WINNER_DRAW_TEXT);
            }

            //Advance the winner
            switch (match) {
                case 0:
                    lblSemiTeam1.setText(matchToSend.getWinnerTeam().getTeamName());
                    lblSemiGoal1.setText("" + matchToSend.getHomeTeamScore());
                    semiFinalMatches.get(0).setHomeTeam(matchToSend.getWinnerTeam());
                    break;
                case 1:
                    lblSemiTeam2.setText(matchToSend.getWinnerTeam().getTeamName());
                    lblSemiGoal2.setText("" + matchToSend.getHomeTeamScore());
                    semiFinalMatches.get(0).setAwayTeam(matchToSend.getWinnerTeam());
                    break;
                case 2:
                    lblSemiTeam3.setText(matchToSend.getWinnerTeam().getTeamName());
                    lblSemiGoal3.setText("" + matchToSend.getHomeTeamScore());
                    semiFinalMatches.get(1).setHomeTeam(matchToSend.getWinnerTeam());
                    break;
                case 3:
                    lblSemiTeam4.setText(matchToSend.getWinnerTeam().getTeamName());
                    lblSemiGoal4.setText("" + matchToSend.getHomeTeamScore());
                    semiFinalMatches.get(1).setAwayTeam(matchToSend.getWinnerTeam());
                    break;
                case 4:
                    lblFinalTeam1.setText(matchToSend.getWinnerTeam().getTeamName());
                    lblFinalGoal1.setText("" + matchToSend.getHomeTeamScore());
                    finalMatches.get(0).setHomeTeam(matchToSend.getWinnerTeam());
                    break;
                case 5:
                    lblFinalTeam2.setText(matchToSend.getWinnerTeam().getTeamName());
                    lblFinalGoal2.setText("" + matchToSend.getHomeTeamScore());
                    finalMatches.get(0).setAwayTeam(matchToSend.getWinnerTeam());
                    break;
                default:
                    System.out.println("This was the last match! \nThe winner is " + matchToSend.getWinnerTeam().getTeamName());
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
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
                matchClicked(0, 0, lblQuarterWinner1);
                break;
            case "13":
                matchClicked(0, 1, lblQuarterWinner2);
                break;
            case "15":
                matchClicked(0, 2, lblQuarterWinner3);
                break;
            case "17":
                matchClicked(0, 3, lblQuarterWinner4);
                break;
            case "33":
                matchClicked(1, 0, lblSemiWinner1);
                break;
            case "35":
                matchClicked(1, 1, lblSemiWinner2);
                break;
            case "54":
                matchClicked(2, 0, lblWinner);
                break;
            default:
                System.out.println("WTF!?");
                break;
        }
    }

    @FXML
    private void handleBackToMenu(ActionEvent event) throws IOException {
        goToView("MenuView");
    }    
    
    /**
     * Set the names of the 8 baddest teams. 
     */
    public void setLast8RankNames(){
        ArrayList<Team> teams = teamModel.getSortedUnqualifiedTeams();
        for(int i = 0; i < teams.size(); i++){
            last8Labels.get(i).setText(teams.get(i).getTeamName());
        }
    }
}
