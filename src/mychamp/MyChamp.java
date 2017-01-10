/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import mychamp.be.Group;
import mychamp.be.Team;
import mychamp.bll.FileManager;
import mychamp.dal.DAOManager;
import mychamp.gui.model.GroupModel;
import mychamp.gui.model.TeamModel;

/**
 *
 * @author gta1
 */
public class MyChamp extends Application {

    public static Scene playOffView;
    public static Scene finalsView;
    public static Scene menuView;
    public static Scene myChampView;
    public static Scene teamScheduleView;
    public static Scene groupScheduleView;
    public static Scene editTeamView;

    public static Stage primStage;

    @Override
    public void start(Stage stage) throws Exception {
        //Getting a reference to the Stage.
        primStage = stage;

        createScenes();

        Parent root = FXMLLoader.load(getClass().getResource("gui/view/MenuView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
        loadSavedData();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * If there is any previous data. Load it.
     */
    private void loadSavedData(){
        TeamModel teamModel = TeamModel.getInstance();
        GroupModel groupModel = GroupModel.getInstance();
        
        ArrayList<Team> loadedTeams = teamModel.getTeamsFromFile();
        if(loadedTeams != null){
            teamModel.addNewListOfTeams(loadedTeams);
        }
        
        ArrayList<Group> loadedPlayOffGroups = groupModel.getPlayOffGroupsFromFile();
        if(loadedPlayOffGroups != null){
            groupModel.setGroups(loadedPlayOffGroups);
            System.out.println("PlayOffGroups loaded!");
        }else{
            System.out.println("PlayOffGroups not loaded!");
        }
    }

    /**
     * Switches the scene in the stage.
     *
     * @param view the view which scenes you want to switch to. The string must
     * have a capital letter first.
     */
    public static void switchScene(String view) {
        switch (view) {
            case "PlayOffView": {
                primStage.setScene(playOffView);
                break;
            }
            case "FinalsView": {
                primStage.setScene(finalsView);
                break;
            }
            case "MyChamp": {
                primStage.setScene(myChampView);
                break;
            }
            case "TeamScheduleView": {
                primStage.setScene(teamScheduleView);
                break;
            }
            case "GroupScheduleView": {
                primStage.setScene(groupScheduleView);
                break;
            }
            case "EditTeamView": {
                primStage.setScene(editTeamView);
                break;
            }
            default: {
                primStage.setScene(menuView);
                break;
            }
        }
        //Sets the stage in the middle of the screen
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primStage.setX((primScreenBounds.getWidth() - primStage.getWidth()) / 2);
        primStage.setY((primScreenBounds.getHeight() - primStage.getHeight()) / 2);
    }

    /**
     * Creates all scenes used in the program.
     *
     * @throws IOException
     */
    private void createScenes() throws IOException {
        playOffView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/PlayOffView.fxml")));
        finalsView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/FinalsView.fxml")));
        menuView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/MenuView.fxml")));
        myChampView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/MyChamp.fxml")));
        teamScheduleView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/TeamScheduleView.fxml")));
        groupScheduleView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/GroupScheduleView.fxml")));
        editTeamView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/EditTeamView.fxml")));
    }
}
