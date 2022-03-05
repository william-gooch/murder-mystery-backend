package com.murdermystery.murdermystery;

import java.util.Arrays;
import java.util.*;

public class SwapCard extends Card {
    
    public GameState activity(Player userPlayer, Player otherPlayer, Card swapCard, Card userCard, Card targetCard, GameState gd) {
        //lists
        Player[] players = gd.getPlayers();
        List<Player> playerList = new ArrayList<>(Arrays.asList(players));
        ArrayList<Card> userDeck = userPlayer.getDeck();
        ArrayList<Card> otherDeck = otherPlayer.getDeck();

        //validation and swapping
        if(playerList.contains(userPlayer) && playerList.contains(otherPlayer) 
            && userDeck.contains(userCard) && otherDeck.contains(targetCard)) {
                userDeck.remove(swapCard);
                userDeck.remove(userCard);
                otherDeck.add(userCard);
                otherDeck.remove(targetCard);
                userDeck.add(targetCard);

                players[Player.getIndexOfPlayer(players, userPlayer)].setDeck(userDeck);
                players[Player.getIndexOfPlayer(players, otherPlayer)].setDeck(otherDeck);

                gd.setPlayers(players);
        }
        else {
            //will bring up error
        }
        return gd;
    }
}