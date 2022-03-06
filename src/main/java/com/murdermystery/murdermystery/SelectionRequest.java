package com.murdermystery.murdermystery;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public class SelectionRequest {
    public enum SelectionType {
        PlayerSelection,
        CardSelection
    }

    public class SelectionResult {
        private Player player;
        private Card card;
        private SelectionType type;

        public SelectionResult(Player player, SelectionType type) {
            this.player = player;
            this.type = type;
        }

        public SelectionResult(Card card, SelectionType type) {
            this.card = card;
            this.type = type;
        }

        public Player getPlayer() {
            return this.player;
        }

        public Card getCard() {
            return this.card;
        }

        public SelectionType getType() {
            return this.type;
        }
    }

    private Player target;
    private SelectionType type;
    private Consumer<SelectionResult> onCompletion;

    public SelectionRequest(Player target, SelectionType type, Consumer<SelectionResult> onCompletion) {
        this.target = target;
        this.type = type;
        this.onCompletion = onCompletion;
    }

    public Player getPlayer() {
        return this.target;
    }

    public SelectionType getType() {
        return this.type;
    }

    public void fulfil(Player player) {
        onCompletion.accept(new SelectionResult(player, SelectionType.PlayerSelection));
    }

    public void fulfil(Card card) {
        onCompletion.accept(new SelectionResult(card, SelectionType.CardSelection));
    }
}
