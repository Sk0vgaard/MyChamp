/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mychamp.be;

import java.util.ArrayList;

public class MockData {

    private static ArrayList<Team> mockTeams = new ArrayList<>();

    public static ArrayList<Team> getMockTeams() {
        Team aura = new Team("aura", "Hjerting", "Aura skolen");
        Team bohr = new Team("bohr", "Ådal", "Bohrskolen");
        Team cosmos = new Team("cosmos", "Spangsbjerg", "Cosmosskolen");
        Team fortuna = new Team("fortuna", "Skolegade", "Fortunaskolen");
        Team signature = new Team("signature", "Skads", "Signaturskolen");
        Team urban = new Team("urban", "Præstegård", "Urbanskolen");
        Team vader = new Team("vader", "Egebækvej", "Vadehavsskolen");
        Team international = new Team("international", "Guldager", "Esbjerg International School");
        Team realz = new Team("realz", "Kronprinsengade", "Esbjerg Realskole");
        Team freebies = new Team("freebiez", "Bramming", "Friskolen i Bramming");
        Team mark1 = new Team("mark1", "Stenhuggervej", "Markusskolen");
        Team ribber = new Team("ribber", "Simon Hansensvej", "Riberhus Privatskole");
        Team nico = new Team("nico", "Kirkegade", "Skt. Nicolaj Skole");
        Team handsome = new Team("handsome", "Spangsbjergkirkevej", "EASV");
        Team finance = new Team("finance", "Spangsbjergkirkevej", "EASV");
        Team last = new Team("last", "SomeRoad", "Last School of life");

        mockTeams.add(aura);
        mockTeams.add(bohr);
        mockTeams.add(cosmos);
        mockTeams.add(fortuna);
        mockTeams.add(signature);
        mockTeams.add(urban);
        mockTeams.add(vader);
        mockTeams.add(international);
        mockTeams.add(realz);
        mockTeams.add(freebies);
        mockTeams.add(mark1);
        mockTeams.add(ribber);
        mockTeams.add(nico);
        mockTeams.add(handsome);
        mockTeams.add(finance);
        mockTeams.add(last);

        return mockTeams;
    }

}
