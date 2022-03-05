package com.murdermystery.murdermystery;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.*;
import java.util.Map.Entry;

import com.murdermystery.murdermystery.Player;

import org.springframework.expression.spel.ast.Selection;

public class GameState {

    private static final int TEST_DECK = 50; // allows the deck to be created for now
    private static final String TEST_NAME = "amogus"; // allows Person objects to be created for now

    private Chat chat;

    private HashMap<String, Player> idPlayers;
    private ArrayList<Card> activePile;
    private ArrayList<Card> discardPile;
    private int initHand;
    private int turn;
    private Boolean isDay;

    private SelectionRequest currentSelection;

    private List<Listener> listeners;

    public GameState() {
        this.idPlayers = new HashMap<String, Player>();
        this.activePile = new ArrayList<>();
        this.discardPile = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.chat = new Chat();
        this.chat.addListener(this::onUpdate);
        this.initHand = 3;
        this.turn = 0;
        this.isDay = true;
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void onUpdate() {
        for (Listener listener : this.listeners) {
            listener.onUpdate();
        }
    }

    // TO DO
    public void initDeck() {

    }

    public void initGame(int noPlayers) {
        // use below to find murderer
        int randomNum = randomFromRange(0, noPlayers); // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int counter = 0;
        // initialise every player
        for (Player player : idPlayers.values()) {
            // set current player to murderer if they are lucky
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

    // https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
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

    public Chat getChat() {
        return chat;
    }

    public void addPlayer(String id) {
        Player newPlayer = new Player("Unnamed");
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

    public void discard(Card card) {
        this.discardPile.add(card);
    }

    // inclusive min, exclusive max
    public int randomFromRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    public Boolean getDay() {
        return this.isDay;
    }

    public void changeDay() {
        this.isDay = !this.isDay;
    }

    public void requestSelection(Player target, SelectionRequest.SelectionType type,
            Consumer<SelectionRequest.SelectionResult> onCompletion) {
        this.currentSelection = new SelectionRequest(target, type, onCompletion);
    }

    public SelectionRequest getSelection() {
        return this.currentSelection;
    }

    public void selectPlayer(Player otherPlayer) {
        if (this.currentSelection != null) {
            SelectionRequest req = this.currentSelection;
            this.currentSelection = null;
            req.fulfil(otherPlayer);
        }
    }

    public void selectCard(Card otherCard) {
        if (this.currentSelection != null) {
            SelectionRequest req = this.currentSelection;
            this.currentSelection = null;
            req.fulfil(otherCard);
        }
    }

}
