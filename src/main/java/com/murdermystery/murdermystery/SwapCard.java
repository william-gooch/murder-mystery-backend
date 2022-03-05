package com.murdermystery.murdermystery;

import java.util.Arrays;
import java.util.*;

public class SwapCard extends Card {
    public SwapCard(int id) {
        this.id = id;
        desc = "Use this to swap one card with another player";
    }

    public GameState swap(Player userPlayer, Player otherPlayer, Card swapCard, Card userCard, Card targetCard, GameState gd) {
        //lists
        Player[] players = gd.getPlayers();
        List<Player> playerList = new ArrayList<>(Arrays.asList(players));
        ArrayList<Card> userDeck = userPlayer.getDeck();
        ArrayList<Card> otherDeck = otherPlayer.getDeck();

        // validation and swapping
        if (playerList.contains(userPlayer) && playerList.contains(otherPlayer)
                && userDeck.contains(userCard) && otherDeck.contains(targetCard)) {
            userDeck.remove(this);
            userDeck.remove(userCard);
            otherDeck.add(userCard);
            otherDeck.remove(targetCard);
            userDeck.add(targetCard);

            players.get(Player.getIdOfPlayer(players, userPlayer)).setDeck(userDeck);
            players.get(Player.getIdOfPlayer(players, otherPlayer)).setDeck(otherDeck);
        } else {
            // will bring up error
        }
        return gd;
    }
}