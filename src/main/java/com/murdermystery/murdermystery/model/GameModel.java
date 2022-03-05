package com.murdermystery.murdermystery.model;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;

import com.murdermystery.murdermystery.Card;
import com.murdermystery.murdermystery.GameState;

public class GameModel implements Serializable {
    public Map<String, PlayerModel> players;
    public Card[] fullDeck;

    public GameModel(GameState state) {
        this.players = state.getPlayers().entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> (String) e.getKey(),
                        e -> (PlayerModel) new PlayerModel(e.getValue())));
    }
}
