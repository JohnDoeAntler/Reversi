package com.c010ur1355.Reversi.FlipStrategy;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Model.Coordinate;

public interface IStrategy {
    void flip(Chessboard chessboard, Coordinate coordinate);
}
