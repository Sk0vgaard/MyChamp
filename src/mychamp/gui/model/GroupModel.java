/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.gui.model;

import java.util.ArrayList;
import mychamp.be.Group;
import mychamp.bll.GroupManager;

public class GroupModel {

    private ArrayList<Group> randomGroups;

    private static GroupModel instance;

    private GroupManager groupManager;

    private TeamModel teamModel = TeamModel.getInstance();

    public static GroupModel getInstance() {
        if (instance == null) {
            instance = new GroupModel();
        }
        return instance;
    }

    private GroupModel() {
        randomGroups = new ArrayList<>();
    }

    /**
     *
     * @return the random groups
     */
    public ArrayList<Group> getGroups() {
        return randomGroups;
    }

    /**
     * Sends a request to the GroupManager for new random teams
     */
    public void createRandomGroups() {
        groupManager = GroupManager.getInstance(teamModel.getTeamsAsArrayList());
        randomGroups = groupManager.getNewRandomGroups();
    }

}
