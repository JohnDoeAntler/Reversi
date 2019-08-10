package com.c010ur1355.Reversi.ErrorChecking;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Model.Coordinate;

public class ErrorCheckingContext {
	// strategy array
    private IErrorChecking[] errorChecking;

	// constructor
    public ErrorCheckingContext(IErrorChecking... errorChecking) {
        this.errorChecking = errorChecking;
    }

    public boolean isValid(Chessboard chessboard, Coordinate coordinate){
        for (int i = 0; i < errorChecking.length; i++)
            if (!errorChecking[i].isValid(chessboard, coordinate))
                return false;

        return true;
    }
}
