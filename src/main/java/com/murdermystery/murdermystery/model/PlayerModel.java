package com.murdermystery.murdermystery.model;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.murdermystery.murdermystery.Player;

public class PlayerModel implements Serializable {
    String name;
    List<CardModel> deck;
    Boolean isMurderer;

    public PlayerModel(Player player) {
        this.name = player.getName();
        this.deck = player.getDeck().stream()
                .map(CardModel::new)
                .collect(Collectors.toList());
        this.isMurderer = player.getIsMurderer();
    }
}
