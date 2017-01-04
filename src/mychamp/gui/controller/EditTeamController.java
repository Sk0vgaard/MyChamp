/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author mathi
 */
public class EditTeamController implements Initializable
{

    @FXML
    private Label lblTeamAmount;
    @FXML
    private TableView<?> tableTeams;
    @FXML
    private TableColumn<?, ?> clmID;
    @FXML
    private TableColumn<?, ?> clmTeam;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    /**
     * Select more than one team
     */
    @FXML
    private void handleKeyShortCuts(KeyEvent event)
    {
        if (event.isControlDown() | event.isShiftDown())
        {
            tableTeams.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        } else
        {
            tableTeams.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
        if (event.getCode().equals(KeyCode.DELETE))
        {
            mcController.deleteTeam();
        }
    }

    /**
     * Makes the textfields editable when clicked, then changes the button to
     * "save" and saves the data in the textfields in the teams list.
     * @param event
     */
    @FXML
    private void handleEditSelectedTeam(ActionEvent event)
    {
        mcController.editSave();
    }

    /**
     * Deletes the selected teams.
     *
     * @param event
     */
    @FXML
    private void handleDeleteSelectedTeam(ActionEvent event)
    {
        mcController.deleteTeam();
    }

    @FXML
    private void handleFinish(ActionEvent event)
    {

    }

}
