package com.c010ur1355.Reversi.FlipStrategy;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Model.Coordinate;

public class AssignStrategy implements IStrategy {
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {
        chessboard.setChess(coordinate.getY(), coordinate.getX(), coordinate.getPlayer());
    }
}
