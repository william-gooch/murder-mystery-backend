package com.murdermystery.murdermystery;

import java.util.*;

public class GameState {

     private static final int TEST_DECK = 50; //allows the deck to be created for now
     private static final String TEST_NAME = "amogus"; //allows Person objects to be created for now

    private ArrayList<Player> players;
    private Card[] fullDeck = new Card[TEST_DECK];
    private int deckPointer = TEST_DECK - 1;
    private int initHand = 3;

    public void GameState() { //will be received from the front end
    }
    public void setUpPlayers(int noPlayers) {
        //create list of players
        players = new Player[noPlayers];
        // use below to find murderer
        int randomNum = ThreadLocalRandom.current().nextInt(0, noPlayers);  //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        //give the players their name
        for(int i = 0; i < noPlayers; i++) {
            players[i] = new Player(5000+i,TEST_NAME); //will be received from the front end
            if (i == randomNum) {
                player.isMurderer = true;
            }
            else {
                player.isMurderer = false;
            }
            for (int j = 0; j < initHand; j++) {
                
            }
        }

        //deal cards to players
    }
    // //https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    public void shuffleDeck() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = TEST_DECK - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = fullDeck[index];
            fullDeck[index] = fullDeck[i];
            fullDeck[i] = a;
        }
    public GameState() {
        
    }    
    
    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
}   
