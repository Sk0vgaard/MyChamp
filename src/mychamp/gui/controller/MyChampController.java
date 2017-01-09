/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mychamp.MyChamp;
import mychamp.be.Team;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

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
    @FXML
    private TextField txtTeamSchool;

    private final int MINIMUM_NUMBER_OF_TEAMS = 12;
    private final int MAX_NUMBER_OF_TEAMS = 16;

    private final TeamModel teamModel;
    private final GroupModel groupModel;

    private PlayOffController playOffController;
    private static MyChampController instance;
    private TableView.TableViewSelectionModel<Team> selectedView;

    private final ArrayList<TextField> txtFieldList;
    @FXML
    private JFXButton btnEdit;

    public static MyChampController getIntance() {
        return instance;
    }
    @FXML
    private JFXButton btnBack;

    public MyChampController() {
        teamModel = TeamModel.getInstance();
        groupModel = GroupModel.getInstance();
        txtFieldList = new ArrayList<>();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        txtTeamID.setDisable(true);
        initializeTextFieldList();
        initializeDesign();
        initializeTables();
        setListeners();

    }

    /**
     * Adds the txtFields to the txtFieldList.
     */
    private void initializeTextFieldList() {
        txtFieldList.add(txtTeamField);
        txtFieldList.add(txtTeamSchool);
        txtFieldList.add(txtTeamName);
    }

    /**
     * Sets the initial design
     */
    private void initializeDesign() {
        lblTeamAmount.setText("0");
        updateTeamMount();

        for (TextField textField : txtFieldList) {
            textField.setDisable(true);
        }
    }

    /**
     * Fills the tables with information about the teams
     */
    private void initializeTables() {
        tableTeams.setItems(teamModel.getTeams());
        clmID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        clmTeam.setCellValueFactory(new PropertyValueFactory<>("teamName"));

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
        txtTeamName.setText(team.getTeamName());
        txtTeamField.setText(team.getHomeField());
        txtTeamSchool.setText(team.getSchool());
    }

    /**
     * Makes the textfields editable when clicked, then changes the button to
     * "save" and saves the data in the textfields in the teams list.
     *
     * @param event
     */
    @FXML
    private void handleEditSelectedTeam(ActionEvent event) throws NullPointerException {
        try {
            if (isTableSelected()) {
                if (btnEdit.getText().equals("Rediger")) {
                    for (TextField textField : txtFieldList) {
                        textField.setDisable(false);
                    }
                    btnEdit.setText("Gem");
                } else if (btnEdit.getText().equals("Gem")) {
                    for (TextField textField : txtFieldList) {
                        textField.setDisable(true);
                    }
                    btnEdit.setText("Rediger");
                }
                tableTeams.getSelectionModel().getSelectedItem().setHomeField(txtTeamField.getText());
                tableTeams.getSelectionModel().getSelectedItem().setSchool(txtTeamSchool.getText());
                tableTeams.getSelectionModel().getSelectedItem().setTeamName(txtTeamName.getText());
                refreshTable();
            }
        } catch (NullPointerException e) {
            System.out.println("Choose a team to edit.");
        }
    }

    /**
     * Create a dialog to remove many items
     *
     * @return
     */
    private Alert removeManyItems() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Bekræftelsesdialog");
        alert.setHeaderText("Er du sikker på du vil slette holdet: " + "\n\n" + teamToDelete.getTeamName());
        alert.setContentText("Tryk 'OK' for at slette.");
        return alert;
    }

    private boolean isTableSelected() {
        if (tableTeams.getSelectionModel().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Deletes the selected team(s).
     *
     * @param event
     */
    @FXML
    private void handleDeleteSelectedTeam(ActionEvent event) {
        deleteTeam();
    }

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
     * Switches to the PlayOffView.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleStartTournament(ActionEvent event) throws IOException {
        //Checks if there is the minimum required numbers of teams in the tournament.
        if (teamModel.getTeamsAsArrayList().size() >= MINIMUM_NUMBER_OF_TEAMS) {
            groupModel.createRandomGroups();

            MyChamp.switchScene("PlayOffView");
            playOffController = PlayOffController.getInstance();
            playOffController.setRandomGroups(groupModel.getGroups());
            playOffController.setPlayOffInformation();
            teamModel.saveTeamsToFile();
            groupModel.savePlayOffGroups();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Turneringen kan ikke startes");
            alert.setHeaderText("Der er for få hold til at turneringen kan startes...");
            alert.setContentText("Tilføj flere hold for at starte turneringen.");
            alert.show();
        }
    }

    /**
     * Adds a Team.
     *
     * @param event
     */
    @FXML
    private void handleAddTeam(ActionEvent event) {
        // Only adds teams when it is lower than MAX_NUMBER_OF_TEAMS (16).
        if (tableTeams.getItems().size() < MAX_NUMBER_OF_TEAMS) {
            //Check to see if all information is present.
            if (!txtNewTeamName.getText().equals("")
                    || !txtNewTeamField.getText().equals("")
                    || !txtNewTeamSchool.getText().equals("")) {
                teamModel.addTeam(new Team(
                        txtNewTeamName.getText(),
                        txtNewTeamField.getText(),
                        txtNewTeamSchool.getText()));
                //Clears the fields for information.
                txtNewTeamName.clear();
                txtNewTeamField.clear();
                txtNewTeamSchool.clear();
            } else {
                warningDialog();
            }
            updateTeamMount();
        } else {
            maxTeamsDialog();
            
        }

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
    private void maxTeamsDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Der kan ikke blive tilføjet flere teams.");
        alert.setTitle("Advarsel");
        alert.setContentText("Max antal teams er: " + MAX_NUMBER_OF_TEAMS);
        alert.showAndWait();
    }

    /**
     * Refreshes the table on changes
     */
    public void refreshTable() {
        for (int i = 0; i < tableTeams.getColumns().size(); i++) {
            ((TableColumn) (tableTeams.getColumns().get(i))).setVisible(false);
            ((TableColumn) (tableTeams.getColumns().get(i))).setVisible(true);
        }
    }

    /**
     * Updates the teams total
     */
    public void updateTeamMount() {
        lblTeamAmount.setText("" + teamModel.getTeams().size());
    }

    @FXML
    private void handleBackToMenu(ActionEvent event) throws IOException {
        goToView("MenuView");
    }

    private void goToView(String view) throws IOException {
        MyChamp.switchScene(view);
    }
}
