package com.murdermystery.murdermystery;

public class TotalEvidence {
    private Player player;
    private int time;
    private int day;
    private int weapon;
    private int location;

    public TotalEvidence(Player player, int weapon, int time, int day, int location) {
        this.player = player;
        this.weapon = weapon;
        this.time = time;
        this.day = day;
        this.location = location;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTime() {
        return time;
    }

    public int getDay() {
        return day;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getLocation() {
        return location;
    }
}
