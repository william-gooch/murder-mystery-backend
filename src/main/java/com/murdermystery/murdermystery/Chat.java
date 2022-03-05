package com.murdermystery.murdermystery;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private ArrayList<ChatMessage> messages;

    private List<Listener> listeners;

    public Chat() {
        this.messages = new ArrayList<>();
        this.listeners = new ArrayList<>();
    }

    public void addListener(Listener listener) {
        this.listeners.add(listener);
    }

    public void onUpdate() {
        for (Listener listener : this.listeners) {
            listener.onUpdate();
        }
    }

    public void sendMessage(String message, Player player) {
        this.messages.add(new ChatMessage(message, player));
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }
}
