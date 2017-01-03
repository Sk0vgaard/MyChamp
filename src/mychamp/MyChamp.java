/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author gta1
 */
public class MyChamp extends Application {
    
    public static Scene playOffView;
    public static Scene finalsView;
    public static Scene menuView;
    public static Scene myChampView;
    
    public static Stage primStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        //Getting a reference to the Stage.
        primStage = stage;
        //Creating all the scenes used in the program.
        playOffView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/PlayOffView.fxml")));
        finalsView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/FinalsView.fxml")));
        menuView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/MenuView.fxml")));
        myChampView = new Scene(FXMLLoader.load(getClass().getResource("gui/view/MyChamp.fxml")));
        
        Parent root = FXMLLoader.load(getClass().getResource("gui/view/MenuView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Switches the scene in the stage.
     * @param view the view which scenes you want to switch to. The string must have a capital letter first.
     */
    public static void switchScene(String view){
        switch (view){
            case "PlayOffView":{
                primStage.setScene(playOffView);
                break;
            }
            case "FinalsView":{
                primStage.setScene(finalsView);
                break;
            }
            case "MyChamp":{
                primStage.setScene(myChampView);
                break;
            }
            default: {
                primStage.setScene(menuView);
                break;
            }
        }
    }
}
