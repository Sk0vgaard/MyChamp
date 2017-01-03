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
import javafx.scene.control.Label;
import mychamp.MyChamp;
import mychamp.be.Group;
import mychamp.gui.model.TeamModel;

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
    private Label lblRound2GroupATeam1;
    @FXML
    private Label lblRound2GroupATeam2;
    @FXML
    private Label lblRound2GroupAGoals1;
    @FXML
    private Label lblRound2GroupAGoals2;
    @FXML
    private Label lblRound2GroupAWinner1;
    @FXML
    private Label lblRound3GroupATeam1;
    @FXML
    private Label lblRound3GroupATeam2;
    @FXML
    private Label lblRound3GroupAGoals1;
    @FXML
    private Label lblRound3GroupAGoals2;
    @FXML
    private Label lblRound3GroupAWinner1;
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
    private Label lblRound2GroupATeam3;
    @FXML
    private Label lblRound2GroupATeam4;
    @FXML
    private Label lblRound2GroupAGoals3;
    @FXML
    private Label lblRound2GroupAGoals4;
    @FXML
    private Label lblRound2GroupAWinner2;
    @FXML
    private Label lblRound3GroupAWinner2;
    @FXML
    private Label lblRound4GroupATeam1;
    @FXML
    private Label lblRound4GroupATeam2;
    @FXML
    private Label lblRound4GroupAGoals1;
    @FXML
    private Label lblRound4GroupAGoals2;
    @FXML
    private Label lblRound4GroupAWinner1;
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
    private Label lblRound4GroupAWinner2;
    @FXML
    private Label lblRound5GroupATeam1;
    @FXML
    private Label lblRound5GroupATeam2;
    @FXML
    private Label lblRound5GroupAGoals1;
    @FXML
    private Label lblRound5GroupAGoals2;
    @FXML
    private Label lblRound5GroupAWinner1;
    @FXML
    private Label lblRound6GroupATeam1;
    @FXML
    private Label lblRound6GroupATeam2;
    @FXML
    private Label lblRound6GroupAGoals1;
    @FXML
    private Label lblRound6GroupAGoals2;
    @FXML
    private Label lblRound6GroupAWinner1;
    @FXML
    private Label lblRound5GroupAWinner2;
    @FXML
    private Label lblRound6GroupAWinner2;
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

    private ArrayList<Group> randomGroups;

    private TeamModel teamModel = TeamModel.getInstance();

    private static PlayOffController instance;

    public static PlayOffController getInstance() {
        return instance;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
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
        ArrayList<Label> labels = new ArrayList();
        labels.add(lblRound1GroupATeam1);
        labels.add(lblRound1GroupATeam2);
        labels.add(lblRound1GroupATeam3);
        labels.add(lblRound1GroupATeam4);
        labels.add(lblRound1GroupBTeam1);
        labels.add(lblRound1GroupBTeam2);
        labels.add(lblRound1GroupBTeam3);
        labels.add(lblRound1GroupBTeam4);
        labels.add(lblRound1GroupCTeam1);
        labels.add(lblRound1GroupCTeam2);
        labels.add(lblRound1GroupCTeam3);
        labels.add(lblRound1GroupCTeam4);
        labels.add(lblRound1GroupDTeam1);
        labels.add(lblRound1GroupDTeam2);
        labels.add(lblRound1GroupDTeam3);
        labels.add(lblRound1GroupDTeam4);

        //TODO ALH: Create a loop!
        labels.get(0).setText(randomGroups.get(0).getGroupTeams().get(0).getTEAM_NAME());
        labels.get(1).setText(randomGroups.get(0).getGroupTeams().get(1).getTEAM_NAME());
        labels.get(2).setText(randomGroups.get(0).getGroupTeams().get(2).getTEAM_NAME());
        labels.get(3).setText(randomGroups.get(0).getGroupTeams().get(3).getTEAM_NAME());

        labels.get(4).setText(randomGroups.get(1).getGroupTeams().get(0).getTEAM_NAME());
        labels.get(5).setText(randomGroups.get(1).getGroupTeams().get(1).getTEAM_NAME());
        labels.get(6).setText(randomGroups.get(1).getGroupTeams().get(2).getTEAM_NAME());
        labels.get(7).setText(randomGroups.get(1).getGroupTeams().get(3).getTEAM_NAME());

        labels.get(8).setText(randomGroups.get(2).getGroupTeams().get(0).getTEAM_NAME());
        labels.get(9).setText(randomGroups.get(2).getGroupTeams().get(1).getTEAM_NAME());
        labels.get(10).setText(randomGroups.get(2).getGroupTeams().get(2).getTEAM_NAME());
        labels.get(11).setText(randomGroups.get(2).getGroupTeams().get(3).getTEAM_NAME());

        labels.get(12).setText(randomGroups.get(3).getGroupTeams().get(0).getTEAM_NAME());
        labels.get(13).setText(randomGroups.get(3).getGroupTeams().get(1).getTEAM_NAME());
        labels.get(14).setText(randomGroups.get(3).getGroupTeams().get(2).getTEAM_NAME());
        labels.get(15).setText(randomGroups.get(3).getGroupTeams().get(3).getTEAM_NAME());
    }
}
