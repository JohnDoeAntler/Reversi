package com.c010ur1355.Reversi.Core;

import com.c010ur1355.Reversi.Model.Coordinate;
import com.c010ur1355.Reversi.Service.ScannerSingleton;
import com.c010ur1355.Reversi.ErrorChecking.*;

public class Reversi {
	// object start point.
    public void start(){
		// instantiate chessboard size to 6 width and 6 height
        Chessboard chessboard = new Chessboard(6, 6)
				// initialize chessboard
                .initialize()
				// print chessboard chess
                .printArray();

		// if chessboard is not endable
        while (chessboard.continuable()){
			// alert player to input
            chessboard.alert();

			// get player input and assign it into coordinate class.
            Coordinate coordinate = new Coordinate(ScannerSingleton.getSingleton().nextInt(), ScannerSingleton.getSingleton().nextInt(), chessboard.getPlayer());

			// using method injectino of dependency injection to implement strategy pattern of design pattern.
            if (new ErrorCheckingContext(
                    new RangeErrorChecking(),
                    new EmptyErrorChecking(),
                    new FlippableErrorChecking())
                    .isValid(chessboard, coordinate)){

				// flip chessboard
                chessboard.flip(coordinate);

				// switch player
                chessboard.switchPlayer();

				// show chessboard current status to player
                chessboard.printArray();
            }
        }
		
		// print chessboard win stat
        chessboard.finish();
    }
}