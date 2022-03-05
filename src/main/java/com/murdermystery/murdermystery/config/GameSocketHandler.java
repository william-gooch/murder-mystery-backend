package com.murdermystery.murdermystery.config;

import java.io.IOException;
import java.util.HashMap;

import com.murdermystery.murdermystery.Chat;
import com.murdermystery.murdermystery.GameState;

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
        }
    }

    public void setName(WebSocketSession session, String newName) throws IOException {
        game.getPlayers().get(session.getId()).setName(newName);
        game.onUpdate();
    }

    public void sendMessage(WebSocketSession session, String message) throws IOException {
        game.getChat().sendMessage(message, game.getPlayers().get(session.getId()));
        game.getChat().onUpdate();
    }

    public void sendUpdate(WebSocketSession session) {
        try {
            JSONObject gameObj = new JSONObject(game);
            JSONObject toSend = new JSONObject();
            toSend.put("event", "UPDATE");
            toSend.put("state", gameObj);
            session.sendMessage(new TextMessage(toSend.toString()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
