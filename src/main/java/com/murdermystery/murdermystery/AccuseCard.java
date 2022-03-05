package com.murdermystery.murdermystery;

public class AccuseCard extends Card {

    public Boolean accuse(GameState gd, Player userPlayer) {
        if (userPlayer.getIsAlive() == false) {
            return false;
        }
        userPlayer.getDeck().remove(this);
        return true;
    }
}
