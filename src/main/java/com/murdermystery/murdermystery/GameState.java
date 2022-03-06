package com.murdermystery.murdermystery;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.*;
import java.util.Map.Entry;

import com.murdermystery.murdermystery.Card;
import com.murdermystery.murdermystery.Player;

import org.springframework.expression.spel.ast.Selection;

public class GameState {

    private static final int TEST_DECK = 50; // allows the deck to be created for now
    private static final String TEST_NAME = "amogus"; // allows Person objects to be created for now

    private Chat chat;

    private HashMap<String, Player> idPlayers;
    private ArrayList<Card> activePile;
    private ArrayList<Card> discardPile;
    private HashSet<String> savedPlayerIds;
    private int initHand;
    private int turn;
    private Boolean isDay;
    private String scenario;
    private Player murderer;
    private WeaponCard wc;
    private TimeCard tc;
    private DayCard dc;
    private LocationCard lc;
    private SelectionRequest currentSelection;

    private List<Listener> listeners;

    public GameState() {
        this.idPlayers = new HashMap<String, Player>();
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
        Card[] deck = Card.getDeck();
        this.activePile = new ArrayList<Card>(Arrays.asList(deck));
        shuffleDeck();
    }

    public void initGame(int noPlayers) {
        initDeck();
        // use below to find murderer
        int randomNum = randomFromRange(0, noPlayers); // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
        int counter = 0;
        // initialise every player
        for (Player player : idPlayers.values()) {
            player.setDeck(new ArrayList<Card>());
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

    public boolean isPlayerSafe(String playerId) {
        return this.savedPlayerIds.contains(playerId);
    }

    public void savePlayer(String playerId) {
        this.savedPlayerIds.add(playerId);
    }

    public Chat getChat() {
        return chat;
    }

    public void addPlayer(String id) {
        Player newPlayer = new Player(id, "Unnamed");
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

    public void constructScenario() {
        this.wc = null;
        this.tc = null;
        this.dc = null;
        this.lc = null;

        for (Player player : idPlayers.values()) {
            if (player.getIsMurderer() == true) {
                murderer = player;
            }
        }

        for(int i = 0; i < activePile.size(); i++) {
            if(activePile.get(i) instanceof WeaponCard && wc == null) {
                wc = activePile.get(i);
                activePile.remove(wc);
                i = 0;
            } else if (activePile.get(i) instanceof TimeCard && tc == null) {
                tc = activePile.get(i);
                activePile.remove(tc);
                i = 0;
            } else if (activePile.get(i) instanceof DayCard && dc == null) {
                dc = activePile.get(i);
                activePile.remove(dc);
                i = 0;
            } else if (activePile.get(i) instanceof LocationCard && lc == null) {
                lc = activePile.get(i);
                activePile.remove(lc);
                i = 0;
            } else if (wc != null && tc != null && dc != null && lc != null) {
                scenario = "You are the murderer. You killed at " + tc.getName()
                    + ", on " + dc.getName() + ", in the " + lc.getName + ", with a " + wc.getName() + ".";
            }

        }
    }

}
