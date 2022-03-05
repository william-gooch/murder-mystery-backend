package com.murdermystery.murdermystery;

public class AccuseCard extends Card {

    public AccuseCard(int id) {
        this.id = id;
        desc = "Use this card to make an accusation about the full nature of the murder.";
    }

    public Boolean accuse(GameState gd, Player userPlayer) {
        if (userPlayer.getIsAlive() == false) {
            return false;
        }
        userPlayer.getDeck().remove(this);
        return true;
    }
}
