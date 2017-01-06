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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    private TeamModel teamModel = TeamModel.getInstance();

    private GroupModel groupModel = GroupModel.getInstance();

    private ArrayList<Match> quarterFinalMatches;
    
    private final ArrayList<Label> top8Labels = new ArrayList<>();
    
    private final ArrayList<Label> last8Labels = new ArrayList<>();

    public static FinalsController getInstance() {
        return instance;
    }
    @FXML
    private Label lblQuarterGoalC2;
    @FXML
    private Label lblQuarterGoalD1;
    @FXML
    private Button btnBack;
    

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

    @FXML
    private void handleMatchClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println("You clicked button " + clickedButton.getId());
    }

    @FXML
    private void handleBackToMenu(ActionEvent event) throws IOException{
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
