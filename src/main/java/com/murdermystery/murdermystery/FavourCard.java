package com.murdermystery.murdermystery;

import java.util.*;

public class FavourCard extends Card {
    
    public GameState favour(GameState gd, Player userPlayer, Player otherPlayer, Card favourCard, Card targetCard) {

        Player[] players = gd.getPlayers();
        List<Player> playerList = new ArrayList<>(Arrays.asList(players));
        ArrayList<Card> userDeck = userPlayer.getDeck();
        ArrayList<Card> otherDeck = otherPlayer.getDeck();

        //validation and favouring
        if(playerList.contains(userPlayer) && playerList.contains(otherPlayer) 
            && otherDeck.contains(targetCard)) {
                userDeck.remove(favourCard);
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
