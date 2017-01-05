/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import mychamp.be.Team;
import mychamp.dal.DAOManager;

/**
 *
 * @author Rasmus
 */
public class FileManager {
    
    public static FileManager instance;
    
    private DAOManager daoManager = DAOManager.getInstance();
    
    public static FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }
    
    /**
     * Calls the data acces layer to save the songs.
     * @param teams 
     */
    public void saveTeams(ArrayList<Team> teams){
        daoManager.saveTeams(teams);
    }
}
