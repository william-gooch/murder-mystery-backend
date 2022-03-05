package com.murdermystery.murdermystery;

import java.util.*;

import com.murdermystery.murdermystery.SelectionRequest.SelectionType;

public class FavourCard extends Card {

    public Boolean favour(GameState gd, Player userPlayer) {
        if (gd.getDay() == false) {
            return false;
        }
        Map<String, Player> players = gd.getPlayers();
        List<Player> playerList = new ArrayList<>(players.values());
        ArrayList<Card> userDeck = userPlayer.getDeck();

        gd.requestSelection(userPlayer, SelectionType.PlayerSelection, (result) -> {
            Player otherPlayer = result.getPlayer();
            ArrayList<Card> otherDeck = otherPlayer.getDeck();
            gd.requestSelection(otherPlayer, SelectionType.CardSelection, (cardResult) -> {
                Card targetCard = cardResult.getCard();
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
            });
        });
        return true;
    }
}
