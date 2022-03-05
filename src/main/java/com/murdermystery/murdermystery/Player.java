package com.murdermystery.murdermystery;

import java.util.*;
import java.util.Map.Entry;

public class Player {

    private String name;
    private ArrayList<Card> deck;
    private Boolean isMurderer;
    private Boolean isAlive;

    public Player(String name) {
        this.name = name;
        this.deck = deck;
        this.isMurderer = false;
        this.isAlive = true;
    }

    public Boolean getIsAlive() {
        return this.isAlive;
    }

    public ArrayList<Card> getDeck() {
        return deck;
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

    public void setIsMurderer(Boolean bool) {
        this.isMurderer = bool;
    }

    public void setIsAlive(Boolean bool) {
        this.isAlive = bool;
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
