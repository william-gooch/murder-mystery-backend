package com.murdermystery.murdermystery;

import java.util.Arrays;

import com.murdermystery.murdermystery.SelectionRequest.SelectionType;

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

    public Boolean swap(GameState gd, Player userPlayer) {
        // lists
        HashMap<String, Player> players = gd.getPlayers();
        List<Player> playerList = new ArrayList<>(players.values());
        ArrayList<Card> userDeck = userPlayer.getDeck();
        gd.requestSelection(userPlayer, SelectionType.PlayerSelection, (playerResult) -> {
            Player otherPlayer = playerResult.getPlayer();
            ArrayList<Card> otherDeck = otherPlayer.getDeck();

            gd.requestSelection(userPlayer, SelectionType.CardSelection, (userCardResult) -> {
                Card userCard = userCardResult.getCard();
                gd.requestSelection(otherPlayer, SelectionType.CardSelection, (otherCardResult) -> {
                    Card targetCard = otherCardResult.getCard();
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

                        gd.endTurn();
                    } else {
                        // will bring up error
                    }
                });
            });
        });
        return true;
    }
}