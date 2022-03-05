package com.murdermystery.murdermystery;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import com.murdermystery.murdermystery.Player;

public class GameState {

    private static final int TEST_DECK = 50; // allows the deck to be created for now
    private static final String TEST_NAME = "amogus"; // allows Person objects to be created for now

    private HashMap<String, Player> idPlayers;
    private Card[] fullDeck = new Card[TEST_DECK];
    private int deckPointer = TEST_DECK - 1;
    private int initHand = 3;

    public List<Listener> listeners;

    public GameState() {
        this.idPlayers = new HashMap<String, Player>();
        this.listeners = new ArrayList<>();
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    private void onUpdate() {
        for (Listener listener : this.listeners) {
            listener.onUpdate();
        }
    }

    public void initGame(int noPlayers) {
        // use below to find murderer
        int randomNum = ThreadLocalRandom.current().nextInt(0, noPlayers); // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int i = 0;
        // initialise every player
        for (Entry<String, Player> entry : idPlayers.entrySet()) {
            // set current player to murderer if they are lucky
            if (i == randomNum) {
                entry.getValue().setIsMurderer(true);
            }
            // give the player their hand
            for (int j = 0; j < initHand; j++) {
                entry.getValue().addCard(fullDeck[deckPointer]);
                deckPointer--;
            }
            i++;
        }

        // deal cards to players
        onUpdate();
    }

    // //https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    public void shuffleDeck() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = TEST_DECK - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = this.fullDeck[index];
            this.fullDeck[index] = this.fullDeck[i];
            this.fullDeck[i] = a;
        }
        onUpdate();
    }

    public Map<String, Player> getPlayers() {
        return idPlayers;
    }

    public void addPlayer(String id) {
        Player newPlayer = new Player("Unnamed");
        idPlayers.put(id, newPlayer);
        onUpdate();
    }
}
