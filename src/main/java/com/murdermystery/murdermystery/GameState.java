package com.murdermystery.murdermystery;

import java.util.*;

import com.murdermystery.murdermystery.Player;

public class GameState {

     private static final int TEST_DECK = 50; //allows the deck to be created for now
     private static final String TEST_NAME = "amogus"; //allows Person objects to be created for now

    private HashMap<String,Player> idPlayers;
    private Card[] fullDeck = new Card[TEST_DECK];
    private int deckPointer = TEST_DECK - 1;
    private int initHand = 3;

    public void GameState() {
        this.idPlayers = new ArrayList<String,String>();
    }

    public void initGame(int noPlayers) {
        // use below to find murderer
        int randomNum = ThreadLocalRandom.current().nextInt(0, noPlayers);  //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        //initialise every player
        for (Player player : idPlayers.values()) {
             //set current player to murderer if they are lucky
             if (i == randomNum) {
                this.player.setIsMurderer(true);
            }
            //give the player their hand
            for (int j = 0; j < initHand; j++) {
                this.players.add(fullDeck[deckPointer]);
                deckPointer--;
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
            int a = this.fullDeck[index];
            this.fullDeck[index] = this.fullDeck[i];
            this.fullDeck[i] = a;
        }
    }
    
    public Player[] getPlayers() {
        return players;
    }

    public void setPlayer(String id, String name) {
        Player newPlayer = new Player(name);
        idPlayers.put(id, newPlayer);
    }
}   
