package com.murdermystery.murdermystery;

public class StealCard extends Card {

    public StealCard(int id) {
        this.id = id;
        name = "Steal Card";
        desc = "Allows the player to steal a card from another player";
    }

    public Boolean steal(Boolean isDay, Player stealer, Player victim, int toSteal) {
        if (isDay == true) {
            return false;
        } else if (victim.getDeck().size() == 0) {
            return false;
        }
        Card stolen = victim.getDeck().get(toSteal);
        victim.getDeck().remove(stolen);
        stealer.addCard(stolen);
        return true;
    }
}