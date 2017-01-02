/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import mychamp.be.Team;
import mychamp.gui.model.TeamModel;

/**
 *
 * @author gta1
 */
public class MyChampController implements Initializable {

    private Label label;
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

    public MyChampController() {
        teamModel = TeamModel.getInstance();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeDesign();
        initializeTables();
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
        clmID.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmTeam.setCellValueFactory(new PropertyValueFactory<>("teamName"));

    }

    @FXML
    private void handleEditSelectedTeam(ActionEvent event) {
    }

    @FXML
    private void handleDeleteSelectedTeam(ActionEvent event) {
    }

    @FXML
    private void handleStartTournament(ActionEvent event) {
    }

    @FXML
    private void handleAddTeam(ActionEvent event) {

    }

}