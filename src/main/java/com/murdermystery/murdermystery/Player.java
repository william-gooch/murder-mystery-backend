package com.murdermystery.murdermystery;

public class Player {

    private int id;
    private String name;
    private Card[] deck;
    private RoleCard role;
    private Boolean isMurderer;
    
    public Player(int id, String name, Card[] deck, RoleCard role, Boolean isMurderer) {
        this.id = id;
        this.name = name;
        this.deck = deck;
        this.role = role;
        this.isMurderer = isMurderer;
    }

}
