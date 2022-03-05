package com.murdermystery.murdermystery.config;

import java.io.IOException;
import java.util.HashMap;

import com.murdermystery.murdermystery.GameState;
import com.murdermystery.murdermystery.Player;

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
        // add player to game
        JSONObject toSend = new JSONObject(game);
        session.sendMessage(new TextMessage(toSend.toString()));
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
        }
    }

    public void setName(WebSocketSession session, String gameId) throws IOException {
        // set player name
    }
}
