package com.murdermystery.murdermystery.config;

import java.io.IOException;
import java.util.HashMap;

import com.murdermystery.murdermystery.*;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class GameSocketHandler extends TextWebSocketHandler {

    GameState game;

    public GameSocketHandler() {
        this.game = new GameState();
    }

    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        this.game.addListener(() -> this.sendUpdate(session));
        this.game.addPlayer(session.getId());
        game.onUpdate();
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        String payload = message.getPayload();
        JSONObject jsonObject = new JSONObject(payload);
        switch (jsonObject.get("event").toString()) {
            case "SET_NAME":
                this.setName(session, jsonObject.get("name").toString());
                return;
            case "SEND_CHAT_MESSAGE":
                this.sendMessage(session, jsonObject.get("message").toString());
                return;
            case "START_GAME":
                this.startGame(session);
                return;
            case "PLAY_CARD":
                this.playCard(session, Integer.parseInt(jsonObject.get("cardIndex").toString()), jsonObject);
                return;
        }
    }

    public void setName(WebSocketSession session, String newName) {
        game.getPlayers().get(session.getId()).setName(newName);
        game.onUpdate();
    }

    public void sendMessage(WebSocketSession session, String message) {
        game.getChat().sendMessage(message, game.getPlayers().get(session.getId()));
        game.getChat().onUpdate();
    }

    public void startGame(WebSocketSession session) {
        game.shuffleDeck();
        game.initGame(game.getPlayers().size());
        game.onUpdate();
    }

    public void playCard(WebSocketSession session, int cardIndex, JSONObject args) {
        Player player = game.getPlayers().get(session.getId());
        Card card = player.getCard(cardIndex);
        if (card instanceof FavourCard) {
            Player otherPlayer = game.getPlayers().get(args.get("otherPlayerId").toString());
            Card otherCard = otherPlayer.getDeck().get(Integer.parseInt(args.get("otherCardIndex").toString()));
            ((FavourCard) card).favour(game, player, otherPlayer, otherCard);
        } else if (card instanceof AccuseCard) {
            Player otherPlayer = game.getPlayers().get(args.get("otherPlayerId").toString());
            ((AccuseCard) card).accuse(game, otherPlayer);
        } else if (card instanceof SwapCard) {
            Player otherPlayer = game.getPlayers().get(args.get("otherPlayerId").toString());
            Card playerCard = player.getDeck().get(Integer.parseInt(args.get("playerCardIndex").toString()));
            Card otherCard = otherPlayer.getDeck().get(Integer.parseInt(args.get("otherCardIndex").toString()));
            ((SwapCard) card).swap(player, otherPlayer, playerCard, otherCard, game);
        }
    }

    public void sendUpdate(WebSocketSession session) {
        try {
            JSONObject gameObj = new JSONObject(game);
            gameObj.put("cards", new JSONObject(game.getPlayers().get(session.getId()).getDeck()));
            JSONObject toSend = new JSONObject();
            toSend.put("event", "UPDATE");
            toSend.put("state", gameObj);
            session.sendMessage(new TextMessage(toSend.toString()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
