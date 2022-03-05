package com.murdermystery.murdermystery;

import java.util.*;

public class Player {

    private String name;
    private ArrayList<Card> deck;
    private Boolean isMurderer;
    
    public Player(String name) {
        this.name = name;
        this.deck = deck;
        this.isMurderer = false;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
    public void setIsMurderer(Boolean bool) {
        this.isMurderer = bool;
    }

    public Card getCard(int id) {
        for(int i = 0; i < deck.size(); i++) {
            if(deck.get(i).getID() == id) {
                return deck.get(i);
            }
        }
        return null;
    }

    public ArrayList<Card> removeCard(ArrayList<Card> deck, Card removedCard) {
        if(deck.contains(removedCard)) {
            deck.remove(removedCard);
        }
        return deck;
    }

    public static int getIndexOfPlayer(Player[] players, Player player) {
        for(int i = 0; i < players.length; i++) {
            if(players[i].equals(player)) {
                return i;
            }
        }
        return -1;
    }

    public void addCard(Card card) {
        this.deck.add(card);
    }

}
