package com.murdermystery.murdermystery;

public class AccuseCard extends Card {
    
    public Boolean accuse(Player userPlayer, Card accuseCard) {
        if (userPlayer.getIsAlive() == false) {
            return false;
        }
        userPlayer.removeCard(userPlayer.getDeck(), accuseCard);
        return true;
    }
}
