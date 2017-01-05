/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import mychamp.MyChamp;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
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
    private ComboBox<?> comboTeamName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
