package com.c010ur1355.Reversi.Model;

import com.c010ur1355.Reversi.Enum.Chess;

public class Coordinate {
    private int x;
    private int y;
    private Chess player;

	// constructor
    public Coordinate(int y, int x, Chess player){
        this.y = y;
        this.x = x;
        this.player = player;
    }

    // x field getter
    public int getX() {
        return x;
    }

    // y field getter
    public int getY() {
        return y;
    }

    // player field getter
    public Chess getPlayer() {
        return player;
    }
}