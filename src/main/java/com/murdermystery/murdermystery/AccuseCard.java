package com.murdermystery.murdermystery;

import java.util.*;

import com.murdermystery.murdermystery.SelectionRequest.SelectionType;

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
        if (!userPlayer.getIsAlive() && !gd.getDay()) {
            return false;
        }
        userPlayer.getDeck().remove(this);
        gd.discard(this);
        return true;
    }

    public Boolean deduction(GameState gd, Player userPlayer) {
        Map<String, Player> players = gd.getPlayers();
        Player murdererM = null;
        Card weaponM = null;
        Card timeM = null;
        Card dayM = null;
        Card locationM = null;

        gd.requestSelection(userPlayer, SelectionType.PlayerSelection, (m) -> {
           murdererM = m.getPlayer();
        });    
        gd.requestSelection(userPlayer, SelectionType.CardSelection, (w) -> {
            weaponM = w.getCard();
        });
        gd.requestSelection(userPlayer, SelectionType.CardSelection, (t) -> {
            timeM = t.getCard();
        });
        gd.requestSelection(userPlayer, SelectionType.CardSelection,  (d) -> {
            dayM = d.getCard();
        });
        gd.requestSelection(userPlayer, SelectionType.CardSelection, (l) -> {
            locationM = l.getCard();
        });
        if(murdererM.getIsMurderer()) {
            if(weaponM.equals(gd.getWC()) && timeM.equals(gd.getTC()) && dayM.equals(gd.getDC())
                && locationM.equals(gd.getLC())) {
                    return true;
                }
        }
        return false;
    }
}
