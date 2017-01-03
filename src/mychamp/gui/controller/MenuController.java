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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class MenuController implements Initializable {
    
    @FXML
    private Label lblMenuBanner;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void handlePlayOffButton(ActionEvent event) throws IOException {
        goToView("PlayOffView");
    }

    @FXML
    private void handleFinalsButton(ActionEvent event) throws IOException {
        goToView("FinalsView");
    }

    @FXML
    private void handleNewTournamentButton(ActionEvent event) throws IOException {
        goToView("MyChamp");        
    }    
    
    /**
     * Goes to the view that is parsed.
     * @param view
     * @throws IOException 
     */
    private void goToView(String view) throws IOException{
        Stage primStage = (Stage) lblMenuBanner.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mychamp/gui/view/" + view + ".fxml"));
        Parent root = loader.load();
        primStage.setScene(new Scene(root));
    }    
}
