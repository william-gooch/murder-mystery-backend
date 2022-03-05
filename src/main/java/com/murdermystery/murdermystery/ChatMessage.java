package com.murdermystery.murdermystery;

public class ChatMessage {
    private String message;
    private Player sender;

    public ChatMessage(String message, Player player) {
        this.message = message;
        this.sender = player;
    }

    public String getMessage() {
        return message;
    }

    public Player getSender() {
        return sender;
    }
}
