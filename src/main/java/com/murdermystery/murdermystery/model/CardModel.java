package com.murdermystery.murdermystery.model;

import java.io.Serializable;

import com.murdermystery.murdermystery.Card;

public class CardModel implements Serializable {
    int id;
    String desc;

    public CardModel(Card card) {
        this.id = card.getID();
        this.desc = card.getDesc();
    }
}
