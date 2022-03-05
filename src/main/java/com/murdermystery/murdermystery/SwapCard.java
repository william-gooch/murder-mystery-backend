package com.murdermystery.murdermystery;

import java.util.Arrays;
import java.util.*;

public class SwapCard extends Card {
    public SwapCard(int id) {
        this.id = id;
        name = "Swap Card";
        desc = "Use this to swap one card with another player";
    }

    @Override
    public boolean isPlayable() {
        return true;
    }

    public Boolean swap(Player userPlayer, Player otherPlayer, Card userCard, Card targetCard,
            GameState gd) {
        // lists
        HashMap<String, Player> players = gd.getPlayers();
        List<Player> playerList = new ArrayList<>(players.values());
        ArrayList<Card> userDeck = userPlayer.getDeck();
        ArrayList<Card> otherDeck = otherPlayer.getDeck();

        // validation and swapping
        if (playerList.contains(userPlayer) && playerList.contains(otherPlayer)
                && userDeck.contains(userCard) && otherDeck.contains(targetCard)) {
            userDeck.remove(this);
            gd.discard(this);
            userDeck.remove(userCard);
            otherDeck.add(userCard);
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