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

        gd.requestSelection(userPlayer, SelectionType.EvidenceSelection, (m) -> {
            TotalEvidence e = m.getEvidence();
            Player murdererM = e.getPlayer();
            int weaponM = e.getWeapon();
            int timeM = e.getTime();
            int dayM = e.getDay();
            int locationM = e.getLocation();
            if (murdererM.getIsMurderer()) {
                if (weaponM == gd.getWC().getID() && timeM == gd.getTC().getID()
                        && dayM == gd.getDC().getID()
                        && locationM == gd.getLC().getID()) {

                }
            }
        });
        return true;
    }
}
