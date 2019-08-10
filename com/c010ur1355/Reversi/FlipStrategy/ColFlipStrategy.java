package com.c010ur1355.Reversi.FlipStrategy;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Enum.Chess;
import com.c010ur1355.Reversi.Model.Coordinate;

public class ColFlipStrategy implements IStrategy {
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {
        
        int y = coordinate.getY();
        int x = coordinate.getX();

        Chess step = coordinate.getPlayer();

        int stridx;
        int endidx;

        stridx = endidx = x;

        //horizontal left
        for (int i = x - 1; i >= 0; i--){
            if (chessboard.getChess(y, i) == Chess.EMPTY){
                break;
            }else if (chessboard.getChess(y, i) == step){
                stridx = i;
                break;
            }
        }

        //horizontal right
        for (int i = x + 1; i < chessboard.getWidth(); i++){
            if (chessboard.getChess(y, i) == Chess.EMPTY){
                break;
            }else if (chessboard.getChess(y, i) == step){
                endidx = i;
                break;
            }
        }

        //flip
        for (int i = stridx; i < endidx + 1; i++){
            chessboard.setChess(y, i, step);
        }
    }
}
