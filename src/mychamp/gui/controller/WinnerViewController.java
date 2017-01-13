/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import mychamp.MyChamp;
import mychamp.be.Team;

/**
 * FXML Controller class
 *
 * @author Mathias
 */
public class WinnerViewController implements Initializable {

    @FXML
    private Label lblWinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
    public void setlblWinner(Team team) {
        lblWinner.setText(team.getTeamName());
    }
}
