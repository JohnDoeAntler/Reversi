package com.c010ur1355.Reversi.ErrorChecking;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Model.Coordinate;

public class FlippableErrorChecking implements IErrorChecking {
    @Override
    public boolean isValid(Chessboard chessboard, Coordinate coordinate) {
        if (!chessboard.isFlippable(coordinate)){
            System.out.println("Error - invalid move.");
            return false;
        }
        return true;
    }
}
