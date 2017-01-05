/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mychamp.be.Team;
import mychamp.gui.model.TeamModel;

/**
 * FXML Controller class
 *
 * @author mathi
 */
public class EditTeamController implements Initializable {

    @FXML
    private Label lblTeamAmount;
    @FXML
    private TableView<Team> tableTeams;
    @FXML
    private TableColumn<Team, String> clmID;
    @FXML
    private TableColumn<Team, String> clmTeam;
    @FXML
    private TextField txtTeamName;
    @FXML
    private TextField txtTeamID;
    @FXML
    private TextField txtTeamField;
    @FXML
    private TextField txtTeamSchool;
    @FXML
    private JFXButton btnEdit;

    private MyChampController mcController = MyChampController.getIntance();
    private TeamModel teamModel = TeamModel.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeTables();
        txtTeamID.setDisable(true);
    }


    /**
     * Fills the tables with information about the teams
     */
    private void initializeTables() {
        tableTeams.setItems(teamModel.getTeams());
        clmID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        clmTeam.setCellValueFactory(new PropertyValueFactory<>("teamName"));
    }
    private boolean isTableSelected() {
        if (tableTeams.getSelectionModel().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Display the information of the team.
     */
    private void displayTeamInfo() {
        Team team = (Team) tableTeams.getSelectionModel().getSelectedItem();
        txtTeamID.setText(team.getID() + "");
        txtTeamName.setText(team.getTeamName());
        txtTeamField.setText(team.getHomeField());
        txtTeamSchool.setText(team.getSchool());
    }
    
    
    @FXML
    private void handleDeleteSelectedTeam(ActionEvent event) {
        deleteTeam();
    }
    
    @FXML
    public void deleteTeam() throws NullPointerException {
        try {
            ObservableList<Team> teamsToDelete = tableTeams.getSelectionModel().getSelectedItems();
            Alert alert;
            if (teamsToDelete.size() > 1) {
                alert = removeManyItems();
            } else {
                alert = teamRemoveDialog(teamsToDelete.get(0));
            }

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                teamModel.deleteTeam(teamsToDelete);
                if (!isTableSelected()) {
                    txtTeamName.clear();
                    txtTeamField.clear();
                    txtTeamSchool.clear();
                    txtTeamID.clear();
                } else {
                    displayTeamInfo();
                }
            }
            updateTeamMount();
        } catch (NullPointerException e) {
            System.out.println("Choose a team to delete.");
        }
    }

    /**
     * Select more than one team
     */
    @FXML
    private void handleKeyShortCuts(KeyEvent event) {
        if (event.isControlDown() | event.isShiftDown()) {
            tableTeams.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        } else {
            tableTeams.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
        if (event.getCode().equals(KeyCode.DELETE)) {
            deleteTeam();
        }
    }

    /**
     * Makes the textfields editable when clicked, then changes the button to
     * "save" and saves the data in the textfields in the teams list.
     *
     * @param event
     */
    @FXML
    private void handleEditSelectedTeam(ActionEvent event) {
        mcController.editSave();
    }

    /**
     * Deletes the selected teams.
     *
     * @param event
     */

    @FXML
    private void handleFinish(ActionEvent event) {

    }

    /**
     * Pops up a warning dialog telling the user, there are missing information.
     */
    private void warningDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Advarsel");
        alert.setTitle("Manglende information.");
        alert.setContentText("Vær venlig at udfylde alle informationerne.");
        alert.showAndWait();
    }
    /**
     * Create a dialog to remove many items
     *
     * @return
     */
    private Alert removeManyItems() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bekræftelsesdialog");
        alert.setHeaderText("Er du sikker på du vil slette holdene?");
        alert.setContentText("Tryk 'OK' for at slette.");
        return alert;
    }
    /**
     * Create a team remove dialog
     *
     * @param teamToDelete
     * @return
     */
    private Alert teamRemoveDialog(Team teamToDelete) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bekræftelsesdialog");
        alert.setHeaderText("Er du sikker på du vil slette holdet: " + "\n\n" + teamToDelete.getTeamName());
        alert.setContentText("Tryk 'OK' for at slette.");
        return alert;
    }
    /**
     * Updates the teams total
     */
    public void updateTeamMount() {
        lblTeamAmount.setText("" + teamModel.getTeams().size());
    }
    
}
