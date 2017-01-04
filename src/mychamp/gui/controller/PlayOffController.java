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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mychamp.MyChamp;
import mychamp.be.Group;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class PlayOffController implements Initializable {

    @FXML
    private Label lblRound1GroupATeam1;
    @FXML
    private Label lblRound1GroupATeam2;
    @FXML
    private Label lblRound1GroupAGoals1;
    @FXML
    private Label lblRound1GroupAGoals2;
    @FXML
    private Label lblRound1GroupAWinner1;
    @FXML
    private Label lblRound1GroupATeam3;
    @FXML
    private Label lblRound1GroupATeam4;
    @FXML
    private Label lblRound1GroupAGoals3;
    @FXML
    private Label lblRound1GroupAGoals4;
    @FXML
    private Label lblRound1GroupAWinner2;
    @FXML
    private Label lblRound1GroupBTeam1;
    @FXML
    private Label lblRound1GroupBTeam2;
    @FXML
    private Label lblRound1GroupBGoals1;
    @FXML
    private Label lblRound1GroupBGoals2;
    @FXML
    private Label lblRound1GroupBWinner1;
    @FXML
    private Label lblRound1GroupBTeam3;
    @FXML
    private Label lblRound1GroupBTeam4;
    @FXML
    private Label lblRound1GroupBGoals3;
    @FXML
    private Label lblRound1GroupBGoals4;
    @FXML
    private Label lblRound1GroupBWinner2;
    @FXML
    private Label lblRound1GroupCTeam1;
    @FXML
    private Label lblRound1GroupCTeam2;
    @FXML
    private Label lblRound1GroupCGoals1;
    @FXML
    private Label lblRound1GroupCGoals2;
    @FXML
    private Label lblRound1GroupCWinner1;
    @FXML
    private Label lblRound1GroupCTeam3;
    @FXML
    private Label lblRound1GroupCTeam4;
    @FXML
    private Label lblRound1GroupCGoals3;
    @FXML
    private Label lblRound1GroupCGoals4;
    @FXML
    private Label lblRound1GroupCWinner2;
    @FXML
    private Label lblRound1GroupDTeam1;
    @FXML
    private Label lblRound1GroupDTeam2;
    @FXML
    private Label lblRound1GroupDGoals1;
    @FXML
    private Label lblRound1GroupDGoals2;
    @FXML
    private Label lblRound1GroupDWinner1;
    @FXML
    private Label lblRound1GroupDTeam3;
    @FXML
    private Label lblRound1GroupDTeam4;
    @FXML
    private Label lblRound1GroupDGoals3;
    @FXML
    private Label lblRound1GroupDGoals4;
    @FXML
    private Label lblRound1GroupDWinner2;
    @FXML
    private Label lblRound2GroupATeam1;
    @FXML
    private Label lblRound2GroupAGoals1;
    @FXML
    private Label lblRound2GroupAWinner1;
    @FXML
    private Label lblRound2GroupATeam2;
    @FXML
    private Label lblRound2GroupAGoals2;
    @FXML
    private Label lblRound2GroupATeam3;
    @FXML
    private Label lblRound2GroupAGoals3;
    @FXML
    private Label lblRound2GroupAWinner2;
    @FXML
    private Label lblRound2GroupATeam4;
    @FXML
    private Label lblRound2GroupAGoals4;
    @FXML
    private Label lblRound2GroupBTeam1;
    @FXML
    private Label lblRound2GroupBGoals1;
    @FXML
    private Label lblRound2GroupBWinner1;
    @FXML
    private Label lblRound2GroupBTeam2;
    @FXML
    private Label lblRound2GroupBGoals2;
    @FXML
    private Label lblRound2GroupBTeam3;
    @FXML
    private Label lblRound2GroupBGoals3;
    @FXML
    private Label lblRound2GroupBWinner2;
    @FXML
    private Label lblRound2GroupBTeam4;
    @FXML
    private Label lblRound2GroupBGoals4;
    @FXML
    private Label lblRound2GroupCTeam1;
    @FXML
    private Label lblRound2GroupCTeam2;
    @FXML
    private Label lblRound2GroupCWinner1;
    @FXML
    private Label lblRound2GroupCTeam3;
    @FXML
    private Label lblRound2GroupCWinner2;
    @FXML
    private Label lblRound2GroupCTeam4;
    @FXML
    private Label lblRound2GroupDTeam1;
    @FXML
    private Label lblRound2GroupDGoals1;
    @FXML
    private Label lblRound2GroupDWinner1;
    @FXML
    private Label lblRound2GroupDTeam2;
    @FXML
    private Label lblRound2GroupDTeam3;
    @FXML
    private Label lblRound2GroupDGoals3;
    @FXML
    private Label lblRound2GroupDTeam4;
    @FXML
    private Label lblRound2GroupDGoals4;
    @FXML
    private Label lblRound2GroupCGoals1;
    @FXML
    private Label lblRound2GroupCGoals2;
    @FXML
    private Label lblRound2GroupCGoals3;
    @FXML
    private Label lblRound2GroupCGoals4;
    @FXML
    private Label lblRound2GroupDGoals2;

    private ArrayList<Group> randomGroups;
    
    private Stage primStage;

    private final ArrayList<Label> Round1teamNameLabels = new ArrayList();
    private final ArrayList<Label> Round2teamNameLabels = new ArrayList();
    private final ArrayList<Label> Round1teamGoalLabels = new ArrayList();
    private final ArrayList<Label> Round2teamGoalLabels = new ArrayList();

    private static PlayOffController instance;

    public static PlayOffController getInstance() {
        return instance;
    }
    @FXML
    private GridPane PlayOffGridPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        addLabelsToArrayList();
    }

    /**
     * Switches to the FinalsView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleFinalsButton(ActionEvent event) throws IOException {
        goToView("FinalsView");
    }

    @FXML
    private void handleMenuButton(ActionEvent event) throws IOException {
        goToView("MenuView");
    }

    @FXML
    private void handleTeamButton(ActionEvent event) throws IOException {
        goToView("TeamScheduleView");
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
     * Set the random groups
     *
     * @param randomGroups
     */
    public void setRandomGroups(ArrayList<Group> randomGroups) {
        this.randomGroups = randomGroups;
    }

    /**
     * Update PlayOffView information
     */
    public void setGroupInformation() {
        //For every group
        for (int a = 0; a < 4; a++) {
            //For every team in the group
            for (int l = 0; l < randomGroups.get(a).getGroupTeams().size(); l++) {
                //Assign the team name to the group
                Round1teamNameLabels.get(0).setText(randomGroups.get(a).getGroupTeams().get(l).getTeamName());
                Round2teamNameLabels.get(0).setText(randomGroups.get(a).getGroupTeams().get(l).getTeamName());
                Round1teamNameLabels.remove(0);
                Round2teamNameLabels.remove(0);

                //Start team with 0 goals
                Round1teamGoalLabels.get(0).setText("0");
                Round2teamGoalLabels.get(0).setText("0");
                Round1teamGoalLabels.remove(0);
                Round2teamGoalLabels.remove(0);
            }
        }
    }

    /**
     * Fill up ArrayLists with labels
     */
    private void addLabelsToArrayList() {
        //Team names for round 1
        Round1teamNameLabels.add(lblRound1GroupATeam1);
        Round1teamNameLabels.add(lblRound1GroupATeam2);
        Round1teamNameLabels.add(lblRound1GroupATeam3);
        Round1teamNameLabels.add(lblRound1GroupATeam4);
        Round1teamNameLabels.add(lblRound1GroupBTeam1);
        Round1teamNameLabels.add(lblRound1GroupBTeam2);
        Round1teamNameLabels.add(lblRound1GroupBTeam3);
        Round1teamNameLabels.add(lblRound1GroupBTeam4);
        Round1teamNameLabels.add(lblRound1GroupCTeam1);
        Round1teamNameLabels.add(lblRound1GroupCTeam2);
        Round1teamNameLabels.add(lblRound1GroupCTeam3);
        Round1teamNameLabels.add(lblRound1GroupCTeam4);
        Round1teamNameLabels.add(lblRound1GroupDTeam1);
        Round1teamNameLabels.add(lblRound1GroupDTeam2);
        Round1teamNameLabels.add(lblRound1GroupDTeam3);
        Round1teamNameLabels.add(lblRound1GroupDTeam4);
        //Team names for round 2
        Round2teamNameLabels.add(lblRound2GroupATeam1);
        Round2teamNameLabels.add(lblRound2GroupATeam2);
        Round2teamNameLabels.add(lblRound2GroupATeam3);
        Round2teamNameLabels.add(lblRound2GroupATeam4);
        Round2teamNameLabels.add(lblRound2GroupBTeam1);
        Round2teamNameLabels.add(lblRound2GroupBTeam2);
        Round2teamNameLabels.add(lblRound2GroupBTeam3);
        Round2teamNameLabels.add(lblRound2GroupBTeam4);
        Round2teamNameLabels.add(lblRound2GroupCTeam1);
        Round2teamNameLabels.add(lblRound2GroupCTeam2);
        Round2teamNameLabels.add(lblRound2GroupCTeam3);
        Round2teamNameLabels.add(lblRound2GroupCTeam4);
        Round2teamNameLabels.add(lblRound2GroupDTeam1);
        Round2teamNameLabels.add(lblRound2GroupDTeam2);
        Round2teamNameLabels.add(lblRound2GroupDTeam3);
        Round2teamNameLabels.add(lblRound2GroupDTeam4);

        //Team goals round 1
        Round1teamGoalLabels.add(lblRound1GroupAGoals1);
        Round1teamGoalLabels.add(lblRound1GroupAGoals2);
        Round1teamGoalLabels.add(lblRound1GroupAGoals3);
        Round1teamGoalLabels.add(lblRound1GroupAGoals4);
        Round1teamGoalLabels.add(lblRound1GroupBGoals1);
        Round1teamGoalLabels.add(lblRound1GroupBGoals2);
        Round1teamGoalLabels.add(lblRound1GroupBGoals3);
        Round1teamGoalLabels.add(lblRound1GroupBGoals4);
        Round1teamGoalLabels.add(lblRound1GroupCGoals1);
        Round1teamGoalLabels.add(lblRound1GroupCGoals2);
        Round1teamGoalLabels.add(lblRound1GroupCGoals3);
        Round1teamGoalLabels.add(lblRound1GroupCGoals4);
        Round1teamGoalLabels.add(lblRound1GroupDGoals1);
        Round1teamGoalLabels.add(lblRound1GroupDGoals2);
        Round1teamGoalLabels.add(lblRound1GroupDGoals3);
        Round1teamGoalLabels.add(lblRound1GroupDGoals4);

        //Team goals round 2
        Round2teamGoalLabels.add(lblRound2GroupAGoals1);
        Round2teamGoalLabels.add(lblRound2GroupAGoals2);
        Round2teamGoalLabels.add(lblRound2GroupAGoals3);
        Round2teamGoalLabels.add(lblRound2GroupAGoals4);
        Round2teamGoalLabels.add(lblRound2GroupBGoals1);
        Round2teamGoalLabels.add(lblRound2GroupBGoals2);
        Round2teamGoalLabels.add(lblRound2GroupBGoals3);
        Round2teamGoalLabels.add(lblRound2GroupBGoals4);
        Round2teamGoalLabels.add(lblRound2GroupCGoals1);
        Round2teamGoalLabels.add(lblRound2GroupCGoals2);
        Round2teamGoalLabels.add(lblRound2GroupCGoals3);
        Round2teamGoalLabels.add(lblRound2GroupCGoals4);
        Round2teamGoalLabels.add(lblRound2GroupDGoals1);
        Round2teamGoalLabels.add(lblRound2GroupDGoals2);
        Round2teamGoalLabels.add(lblRound2GroupDGoals3);
        Round2teamGoalLabels.add(lblRound2GroupDGoals4);
    }

    private void handleMatchClicked(int matchNumber) throws IOException {
        try {
        //Grab hold of the curret stage.
        primStage = (Stage) lblRound1GroupATeam1.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mychamp/gui/view/MatchDetailsView.fxml"));
        Parent root = loader.load();
       
        //Loads the modals controller to send info.
        MatchDetailsController mdController = loader.getController();

        Stage editStage = new Stage();
        editStage.setScene(new Scene(root));

        //Create new modal window from the FXMLLoader.
        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(primStage);
        
        //Shows the modal.
        editStage.show();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    @FXML
    private void handleMatch00(ActionEvent event) {
        System.out.println("yayaya!");
    }

    @FXML
    private void handleMatch01(ActionEvent event) {
        
    }

    @FXML
    private void handleMatch02(ActionEvent event) {
        
    }

    @FXML
    private void handleMatch03(ActionEvent event) {
    }

    @FXML
    private void handleMatch04(ActionEvent event) {
    }

    @FXML
    private void handleMatch05(ActionEvent event) {
    }

    @FXML
    private void handleMatch06(ActionEvent event) {
    }

    @FXML
    private void handleMatch07(ActionEvent event) {
    }

    @FXML
    private void handleMatch10(ActionEvent event) {
    }

    @FXML
    private void handleMatch11(ActionEvent event) {
    }

    @FXML
    private void handleMatch12(ActionEvent event) {
    }

    @FXML
    private void handleMatch13(ActionEvent event) {
    }

    @FXML
    private void handleMatch14(ActionEvent event) {
    }

    @FXML
    private void handleMatch15(ActionEvent event) {
    }

    @FXML
    private void handleMatch16(ActionEvent event) {
    }

    @FXML
    private void handleMatch17(ActionEvent event) {
    }
}
