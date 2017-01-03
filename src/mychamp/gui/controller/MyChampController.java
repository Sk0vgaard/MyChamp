/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mychamp.be.Team;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

/**
 *
 * @author gta1
 */
public class MyChampController implements Initializable {

    @FXML
    private Label lblTeamAmount;
    @FXML
    private TableView<Team> tableTeams;
    @FXML
    private TableColumn<Team, Integer> clmID;
    @FXML
    private TableColumn<Team, String> clmTeam;
    @FXML
    private TextField txtTeamName;
    @FXML
    private TextField txtTeamID;
    @FXML
    private TextField txtTeamField;
    @FXML
    private JFXTextField txtNewTeamName;
    @FXML
    private JFXTextField txtNewTeamField;
    @FXML
    private JFXTextField txtNewTeamSchool;

    private final TeamModel teamModel;

    private final GroupModel groupModel;

    private PlayOffController playOffController;

    public MyChampController() {
        teamModel = TeamModel.getInstance();
        groupModel = GroupModel.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeDesign();
        initializeTables();
        setListeners();
    }

    /**
     * Sets the initial design
     */
    private void initializeDesign() {
        lblTeamAmount.setText("0");
    }

    /**
     * Fills the tables with information about the teams
     */
    private void initializeTables() {
        tableTeams.setItems(teamModel.getTeams());
        clmID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        clmTeam.setCellValueFactory(new PropertyValueFactory<>("TEAM_NAME"));

    }

    /**
     * Adds a listener to tableTeams.
     */
    private void setListeners() {
        tableTeams.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Team>() {
            @Override
            public void changed(ObservableValue<? extends Team> observable, Team oldValue, Team newValue) {
                if (newValue != null) {
                    displayTeamInfo();
                }
            }
        });
    }

    /**
     * Display the information of the team.
     */
    private void displayTeamInfo() {
        Team team = (Team) tableTeams.getSelectionModel().getSelectedItem();
        txtTeamID.setText(team.getID() + "");
        txtTeamName.setText(team.getTEAM_NAME());
        txtTeamField.setText(team.getHOME_FIELD());
    }

    @FXML
    private void handleEditSelectedTeam(ActionEvent event) {
    }

    @FXML
    private void handleDeleteSelectedTeam(ActionEvent event) {
    }

    /**
     * Switches to the PlayOffView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleStartTournament(ActionEvent event) throws IOException {
        Stage primStage = (Stage) txtTeamName.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mychamp/gui/view/PlayOffView.fxml"));
        Parent root = loader.load();

        groupModel.createRandomGroups();

        primStage.setScene(new Scene(root));
        playOffController = PlayOffController.getInstance();
        playOffController.setRandomGroups(groupModel.getGroups());
        playOffController.setGroupInformation();
    }

    /**
     * Adds a Team.
     *
     * @param event
     */
    @FXML
    private void handleAddTeam(ActionEvent event) {
        Team teamToAdd = new Team(txtNewTeamName.getText(), txtNewTeamField.getText(), txtNewTeamSchool.getText());
        teamModel.addTeam(teamToAdd);
    }

}
