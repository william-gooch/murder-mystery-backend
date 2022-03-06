package com.murdermystery.murdermystery;

import com.murdermystery.murdermystery.SelectionRequest.SelectionType;

public class SaveKillCard extends Card {
    public SaveKillCard(int id) {
        this.id = id;
        name = "Save/Kill Card";
        desc = "Can protect a player from certain death, or allow the murderer a kill at nightfall";
    }

    @Override
    public boolean isPlayable() {
        return true;
    }

    public Boolean kill(GameState gd, Player killer) {
        gd.requestSelection(killer, SelectionType.PlayerSelection, (result) -> {
            Player toKill = result.getPlayer();
            String victim = toKill.getId();
            if (gd.isPlayerSafe(victim)) {
                return;
            }
            toKill.setIsAlive(false);
            ArrayList<Card> burn = toKill.getDeck();
            toKill.setDeck(new ArrayList<Card>());
            for (Card card : burn) {
                gd.discard(card);
            }
        });
        return true;
    }

    public Boolean save(GameState gd, Player saviour) {
        gd.requestSelection(saviour, SelectionType.PlayerSelection, (result) -> {
            Player toSave = result.getPlayer();
            if (toSave.getIsAlive() == false) {
                return;
            }
            gd.savePlayer(toSave.getId());
        });
        return true;
    }
}