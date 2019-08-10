package com.c010ur1355.Reversi.FlipStrategy;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Enum.Chess;
import com.c010ur1355.Reversi.Model.Coordinate;

public class RowFlipStrategy implements IStrategy {
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {
        
        int y = coordinate.getY();
        int x = coordinate.getX();

        Chess chess = coordinate.getPlayer();

        int stridx;
        int endidx;

        stridx = endidx = y;

        // vertical up
        for (int i = y - 1; i >= 0; i--){
            if (chessboard.getChess(i, x) == Chess.EMPTY){
                break;
            }else if (chessboard.getChess(i, x) == chess){
                stridx = i;
                break;
            }
        }

        //vertical down
        for (int i = y + 1; i < chessboard.getHeight(); i++){
            if (chessboard.getChess(i, x) == Chess.EMPTY){
                break;
            }else if (chessboard.getChess(i, x) == chess){
                endidx = i;
                break;
            }
        }

        //flip
        for (int i = stridx; i < endidx + 1; i++){
            chessboard.setChess(i, x, chess);
        }
    }
}