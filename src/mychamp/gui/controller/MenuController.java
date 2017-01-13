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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import mychamp.MyChamp;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    /**
     * Goes to the playOffsView
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handlePlayOffButton(ActionEvent event) throws IOException {
        goToView(MyChamp.PLAYOFF_VIEW);
        if (GroupModel.getInstance().isGroupsDataThere()) {
            PlayOffController.getInstance().loadSavedPlayOffs();
        }
    }

    /**
     * Goes to the finalsView
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleFinalsButton(ActionEvent event) throws IOException {
        goToView(MyChamp.FINALS_VIEW);
        if (GroupModel.getInstance().isFinalDataThere()) {
            PlayOffController.getInstance().loadSavedPlayOffs();
            FinalsController.getInstance().loadSavedFinals();
        }
    }

    /**
     * Goes to the myChampView
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleNewTournamentButton(ActionEvent event) throws IOException {
        if (TeamModel.getInstance().getTeamsAsArrayList().isEmpty()) {
            try {
                goToView(MyChamp.MY_CHAMP_VIEW);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
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
                            goToView(MyChamp.MY_CHAMP_VIEW);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }
                    }

                } else if (type == noButton) {
                    try {
                        goToView(MyChamp.MY_CHAMP_VIEW);
                    } catch (IOException ex) {
                        System.out.println("Fejl: " + ex);
                    }
                }
            });
        }
        MyChampController.getIntance().updateTeamMount();
    }

    /**
     * Goes to the editTeamView
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleTeamEditButton(ActionEvent event) throws IOException {
        goToView(MyChamp.EDIT_TEAM_VIEW);
        EditTeamController.getIntance().updateTeamAmount();
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
