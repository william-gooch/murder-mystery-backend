package com.murdermystery.murdermystery;

public class AccuseCard extends Card {
    public AccuseCard(int id) {
        this.id = id;
        desc = "Use this card to make an accusation about the full nature of the murder.";
    }
    
    public Boolean accuse(Player userPlayer, Card accuseCard) {
        if (userPlayer.getIsAlive() == false) {
            return false;
        }
        userPlayer.removeCard(userPlayer.getDeck(), accuseCard);
        return true;
    }
}
