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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    
    private Team homeTeam;
    private Team awayTeam;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    /**
     * Set the Teams so it's possible to get the data.
     * @param homeTeam
     * @param awayTeam 
     */
    public void setTeamData(Team homeTeam, Team awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @FXML
    private void handleSaveButton(ActionEvent event) {
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
    }
    
    
    
}
