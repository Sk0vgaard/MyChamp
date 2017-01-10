/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import mychamp.MyChamp;
import mychamp.gui.model.TeamModel;

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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ADVARSEL");
        alert.setHeaderText(" Tryk 'Ja' for at starte en ny turnering. \n Tryk 'Nej' for at tilføje/fjerne hold til/fra turneringen. \n "
                + "Tryk 'Fortryd' for at komme tilbage til menuen.");
        ButtonType yesButton = new ButtonType("Ja", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("Nej", ButtonBar.ButtonData.NO);
        ButtonType cancelButton = new ButtonType("Fortryd", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yesButton, noButton, cancelButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == yesButton) {
                if (TeamModel.getInstance().getTeamsAsArrayList().size() > 0) {
                    TeamModel.getInstance().clearTeams();
                    try {
                        goToView("MyChamp");
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }

            } else if (type == noButton) {
                try {
                    goToView("MyChamp");
                } catch (IOException ex) {
                    System.out.println("Fejl: " + ex);
                }
            }
        });
    }

    @FXML
    private void handleTeamEditButton(ActionEvent event) throws IOException {
        goToView("EditTeamView");
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
