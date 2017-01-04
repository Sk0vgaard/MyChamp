/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.bll;

import java.util.ArrayList;
import mychamp.be.Match;

/**
 *
 * @author Rasmus
 */
public class RankingManager {
    public static RankingManager instance;
    
    private ArrayList<Match> groupMatches;
    
    public RankingManager(){
        
    }
    
    /**
     * Singleton of the RankingManager. Returns the instance of it.
     * @return 
     */
    public static RankingManager getInstance(){
        if(instance == null){
            instance = new RankingManager();
        }
        return instance;
    }
}
