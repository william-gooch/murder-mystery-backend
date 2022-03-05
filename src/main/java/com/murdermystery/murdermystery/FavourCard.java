package com.murdermystery.murdermystery;

import java.util.*;

public class FavourCard extends Card {

    public Boolean favour(GameState gd, Player userPlayer, Player otherPlayer, Card favourCard, Card targetCard) {
        if (gd.getDay() == false) {
            return false;
        }
        Map<String, Player> players = gd.getPlayers();
        List<Player> playerList = new ArrayList<>(players.values());
        ArrayList<Card> userDeck = userPlayer.getDeck();
        ArrayList<Card> otherDeck = otherPlayer.getDeck();

        // validation and favouring
        if (playerList.contains(userPlayer) && playerList.contains(otherPlayer)
                && otherDeck.contains(targetCard)) {
            userDeck.remove(this);
            otherDeck.remove(targetCard);
            userDeck.add(targetCard);

            players.get(Player.getIdOfPlayer(players, userPlayer)).setDeck(userDeck);
            players.get(Player.getIdOfPlayer(players, otherPlayer)).setDeck(otherDeck);
        } else {
            // will bring up error
        }
        return true;
    }
}
