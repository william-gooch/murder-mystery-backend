package com.murdermystery.murdermystery;

public class Card {
    private int id;
    private String desc;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //overrides equals to check two Cards
    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        if(!(o instanceof Card)) {
            return false;
        }
        Card c = (Card) o;
        return id == c.getID() && desc.equals(c.getDesc());
    }
}