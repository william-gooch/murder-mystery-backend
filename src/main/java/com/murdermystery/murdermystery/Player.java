package com.murdermystery.murdermystery;

import java.util.*;

public class Player {



    private int id;
    private String name;
    private ArrayList<Card> deck;
    private RoleCard role;
    private Boolean isMurderer;
    
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.deck = deck;
        this.role = role;
        this.isMurderer = isMurderer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
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

}
