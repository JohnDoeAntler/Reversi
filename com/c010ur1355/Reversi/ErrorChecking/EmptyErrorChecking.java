package com.c010ur1355.Reversi.ErrorChecking;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Enum.Chess;
import com.c010ur1355.Reversi.Model.Coordinate;

public class EmptyErrorChecking implements IErrorChecking {
    @Override
    public boolean isValid(Chessboard chessboard, Coordinate coordinate) {
        if (chessboard.getChess(coordinate) != Chess.EMPTY){
            System.out.println("Error - input cell is not empty.");
            return false;
        }
        return true;
    }
}
