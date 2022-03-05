package com.murdermystery.murdermystery;

public class saveKillCard extends Card{
    public saveKillCard(int id) {
        this.id = id;
        name = "Save/Kill Card";
        desc = "Can protect a player from certain death, or allow the murderer a kill at nightfall";
    }

    public Boolean kill (Player killer, Player toKill, Player saved) {
        String murderer = killer.getName();
        String victim = toKill.getName();
        String safe = saved.getName();
        if (murderer.equals(victim)) {
            return false;
        }
        else if (victim.equals(safe)) {
            return false;
        }
        toKill.setIsAlive(false);
        return true;
    }

    public Boolean save (Player toSave) {
        if (toSave.getIsAlive() == false) {
            return false;
        }
        return true;
    }
}