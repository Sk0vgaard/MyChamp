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
import mychamp.be.Team;
import mychamp.gui.model.TeamModel;

/**
 *
 * @author gta1
 */
public class MyChamp extends Application {

    public static final String PLAYOFF_VIEW = "playOffView";
    public static final String FINALS_VIEW = "finalsView";
    public static final String MENU_VIEW = "menuView";
    public static final String MY_CHAMP_VIEW = "myChampView";
    public static final String TEAM_SCHEDULE_VIEW = "teamScheduleView";
    public static final String GROUP_SCHEDULE_VIEW = "groupScheduleView";
    public static final String EDIT_TEAM_VIEW = "editTeamView";

    private static Scene playOffView;
    private static Scene finalsView;
    private static Scene menuView;
    private static Scene myChampView;
    private static Scene teamScheduleView;
    private static Scene groupScheduleView;
    private static Scene editTeamView;

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
    private void loadSavedData() {
        TeamModel teamModel = TeamModel.getInstance();

        ArrayList<Team> loadedTeams = teamModel.getTeamsFromFile();
        if (loadedTeams != null) {
            teamModel.addNewListOfTeams(loadedTeams);
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
            case PLAYOFF_VIEW: {
                primStage.setScene(playOffView);
                break;
            }
            case FINALS_VIEW: {
                primStage.setScene(finalsView);
                break;
            }
            case MY_CHAMP_VIEW: {
                primStage.setScene(myChampView);
                break;
            }
            case TEAM_SCHEDULE_VIEW: {
                primStage.setScene(teamScheduleView);
                break;
            }
            case GROUP_SCHEDULE_VIEW: {
                primStage.setScene(groupScheduleView);
                break;
            }
            case EDIT_TEAM_VIEW: {
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
