package com.murdermystery.murdermystery;

public class AccuseCard extends Card {
    public AccuseCard(int id) {
        this.id = id;
        desc = "Use this card to make an accusation about the full nature of the murder.";
    }
    public GameState accuse(GameState gd, Player userPlayer, Card accuseCard) {
        return gd;
    }
}
