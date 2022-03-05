package com.murdermystery.murdermystery;

public class AccuseCard extends Card {

    public AccuseCard(int id) {
        this.id = id;
        name = "Accuse Card";
        desc = "Use this card to make an accusation about the full nature of the murder.";
    }

    @Override
    public boolean isPlayable() {
        return true;
    }

    public Boolean accuse(GameState gd, Player userPlayer) {
        if (userPlayer.getIsAlive() == false) {
            return false;
        }
        userPlayer.getDeck().remove(this);
        gd.discard(this);
        return true;
    }
}
