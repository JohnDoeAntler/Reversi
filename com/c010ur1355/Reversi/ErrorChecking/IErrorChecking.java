package com.c010ur1355.Reversi.ErrorChecking;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Model.Coordinate;

public interface IErrorChecking {
    boolean isValid(Chessboard chessboard, Coordinate coordinate);
}
