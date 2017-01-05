/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.dal;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import mychamp.be.Team;

/**
 *
 * @author Rasmus
 */
public class DAOManager {
    
    public static DAOManager instance;
    
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
}
