package com.c010ur1355.Reversi.ErrorChecking;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Model.Coordinate;

public class RangeErrorChecking implements IErrorChecking {
    @Override
    public boolean isValid(Chessboard chessboard, Coordinate coordinate) {

        if (coordinate.getY() > chessboard.getHeight() - 1
            || coordinate.getY() < 0
            || coordinate.getX() > chessboard.getWidth() - 1
            || coordinate.getX() < 0){
            System.out.println("Error - input numbers should be 0 to 5!");
            return false;
        }

        return true;
    }
}
