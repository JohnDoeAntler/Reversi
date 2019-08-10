package com.c010ur1355.Reversi.FlipStrategy;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Model.Coordinate;

public class FlipStrategyContext {
	// strategy array
    private IStrategy[] strategies;

	// constructor
    public FlipStrategyContext(IStrategy... strategies){
        this.strategies = strategies;
    }

    public void flip(Chessboard chessboard, Coordinate coordinate){
        for (IStrategy strategy : strategies){
            strategy.flip(chessboard, coordinate);
        }
    }
}