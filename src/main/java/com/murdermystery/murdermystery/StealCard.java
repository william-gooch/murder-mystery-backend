package com.murdermystery.murdermystery;

import java.util.concurrent.ThreadLocalRandom;

import com.murdermystery.murdermystery.SelectionRequest.SelectionType;

public class StealCard extends Card {

    public StealCard(int id) {
        this.id = id;
        name = "Steal Card";
        desc = "Allows the player to steal a card from another player";
    }

    @Override
    public boolean isPlayable() {
        return true;
    }

    public Boolean steal(GameState gd, Player stealer) {
        if (gd.getDay() == true) {
            return false;
        }
        gd.requestSelection(stealer, SelectionType.PlayerSelection, (result) -> {
            Player victim = result.getPlayer();
            if (victim.getDeck().size() == 0) {
                return;
            }
            int cardIndex = ThreadLocalRandom.current().nextInt(0, victim.getDeck().size());
            Card stolen = victim.getDeck().get(cardIndex);
            victim.getDeck().remove(stolen);
            stealer.addCard(stolen);
        });
        return true;
    }
}