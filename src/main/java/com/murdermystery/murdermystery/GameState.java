package com.murdermystery.murdermystery;

public class GameState {

    private static final int TEST_DECK = 50; //allows the deck to be created for now
    private static final String TEST_NAME = "amogus"; //allows Person objects to be created for now

    private Player[] players;
    private Card[] fullDeck = new Card[TEST_DECK];

    public GameState(int noPlayers) { //will be received from the front end
        players = new Player[noPlayers];
        for(int i = 0; i < players.length; i++) {
            players[i] = new Player(5000+i,TEST_NAME); //will be received from the front end
        }
    }
    
}
