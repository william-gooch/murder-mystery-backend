package com.murdermystery.murdermystery;

public class SwapCard extends Card implements IActivityCard {
    
    public GameState activity() {
        return new GameState();
    }
}
