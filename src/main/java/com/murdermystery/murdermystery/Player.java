package com.murdermystery.murdermystery;

public class Player {

    private int id;
    private String name;
    private Card[] deck;
    private RoleCard role;
    private Boolean isMurderer;
    
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.deck = deck;
        this.role = role;
        this.isMurderer = isMurderer;
    }

    public Card[] getDeck() {
        return deck;
    }

    public Card getCard(String id) {
        for(int i = 0; i < deck.length; i++) {
            if(deck[i].getID().equals(id)) {
                return deck[i];
            }
        }
        return null;
    }

}
