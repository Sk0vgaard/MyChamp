/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mychamp.be.Team;

/**
 *
 * @author Rasmus
 */
public class DAOManager {
    
    public static DAOManager instance;
    
    private ArrayList<Team> savedTeams;
    
    public static DAOManager getInstance(){
        if(instance == null){
            instance = new DAOManager();
        }
        return instance;
    }
    
    /**
     * Save the ArrayLists that is parsed.
     * @param teams 
     */
    public void saveTeams(ArrayList<Team> teams){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teams.data"))){
            oos.writeObject(teams);
            System.out.println("Teams saved");
        } catch (IOException ex) {
            System.out.println("Teams save Error " + ex);
        }
    }
    
    /**
     * Load "teams.data" and return it in an ArrayList.
     * @return 
     */
    public ArrayList<Team> getTeamsFromFile(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teams.data"))){
            savedTeams = (ArrayList<Team>) ois.readObject();
            System.out.println("Loadedd songs!");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Teams read Error: " + ex);
        }
        return savedTeams;
    }
    
    /**
     * Checks if "teams.data" exits.
     * @return 
     */
    public boolean isTeamsThere(){
        return new File("teams.data").exists();        
    }
}
