package com.murdermystery.murdermystery;

import java.util.*;
import java.util.Map.Entry;

public class Player {

    private String id;
    private String name;
    private ArrayList<Card> deck;
    private Boolean isMurderer;
    private Boolean isAlive;
    private Boolean turnDone;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
        this.deck = new ArrayList<Card>();
        this.isMurderer = false;
        this.isAlive = true;
        this.turnDone = false;
    }

    public Boolean getIsAlive() {
        return this.isAlive;
    }

    public Boolean getTurnDone() {
        return this.turnDone;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsMurderer() {
        return isMurderer;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setIsMurderer(Boolean bool) {
        this.isMurderer = bool;
    }

    public void setIsAlive(Boolean bool) {
        this.isAlive = bool;
    }

    public void setTurnDone(Boolean bool) {
        this.turnDone = bool;
    }

    public Card getCard(int id) {
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getID() == id) {
                return deck.get(i);
            }
        }
        return null;
    }

    public ArrayList<Card> removeCard(ArrayList<Card> deck, Card removedCard) {
        if (deck.contains(removedCard)) {
            deck.remove(removedCard);
        }
        return deck;
    }

    public static String getIdOfPlayer(Map<String, Player> players, Player player) {
        for (Entry<String, Player> entry : players.entrySet()) {
            if (entry.getValue().equals(player)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void addCard(Card card) {
        this.deck.add(card);
    }

}
