package com.murdermystery.murdermystery;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import com.murdermystery.murdermystery.Player;

public class GameState {

    private static final int TEST_DECK = 50; // allows the deck to be created for now
    private static final String TEST_NAME = "amogus"; // allows Person objects to be created for now

    private HashMap<String,Player> idPlayers;
    private ArrayList<Card> activePile;
    private ArrayList<Card> discardPile;
    private int initHand;
    private int turn;
    private Boolean isDay;

    public void GameState() {
        this.idPlayers = new HashMap<String,Player>();
        this.initHand = 3;
        this.turn = 0;
        this.isDay = true;
    }

    // TO DO
    public void initDeck() {

    }

    public void initGame(int noPlayers) {
        // use below to find murderer
        int randomNum = randomFromRange(0, noPlayers);  //https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int counter = 0;
        //initialise every player
        for (Player player : idPlayers.values()) {
             //set current player to murderer if they are lucky
             if (counter == randomNum) {
                player.setIsMurderer(true);
            }
            // give the player their hand
            for (int j = 0; j < initHand; j++) {
                player.addCard(drawCard());
            }   
            counter++;
        }

        // deal cards to players
    }
    //https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    public void shuffleDeck() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = activePile.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = this.activePile.get(index);
            this.activePile.set(index, this.activePile.get(i));
            this.activePile.set(i, a);
        }
    }
    
    public HashMap<String, Player> getPlayers() {
        return idPlayers;
    }

    public void addPlayer(String id, String name) {
        Player newPlayer = new Player(name);
        idPlayers.put(id, newPlayer);
    }

    public Card drawCard() {
        int size = this.activePile.size() - 1;
        
        // if the deck empties, replace it with the discard pile
        if (size == 0) {
            activePile = discardPile;
            discardPile = new ArrayList<Card>();
        }
        Card ret = activePile.get(size);
        activePile.remove(size);
        return ret;
    }

    // inclusive min, exclusive max
    public int randomFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public void changeDay() {
        this.isDay = !this.isDay;
    }

}   
