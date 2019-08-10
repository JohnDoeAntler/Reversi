package com.c010ur1355.Reversi.FlipStrategy;

import com.c010ur1355.Reversi.Core.Chessboard;
import com.c010ur1355.Reversi.Enum.Chess;
import com.c010ur1355.Reversi.Model.Coordinate;

public class OppositeObliqueFlipStrategy implements IStrategy {
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {

        int y = coordinate.getY();
        int x = coordinate.getX();

        Chess chess = coordinate.getPlayer();

        int[] stridx = new int[2];
        int[] endidx = new int[2];

        stridx[0] = endidx[0] = y;
        stridx[1] = endidx[1] = x;

        //right-up
        for (int i = y - 1,
             j = x + 1;
             i >=0
             && j < chessboard.getWidth();
             i--,
             j++){
            if (chessboard.getChess(i, j) == Chess.EMPTY){
                break;
            }else if (chessboard.getChess(i, j) == chess){
                stridx[0] = i;
                stridx[1] = j;
                break;
            }
        }

        //left-down
        for (int i = y + 1,
             j = x - 1;
             i < chessboard.getHeight()
             && j >= 0;
             i++,
             j--){
            if (chessboard.getChess(i, j)  == Chess.EMPTY){
                break;
            }else if (chessboard.getChess(i, j) == chess){
                endidx[0] = i;
                endidx[1] = j;
                break;
            }
        }

        //flip
        for (int i = stridx[0],
             j = stridx[1];
             i < endidx[0] + 1
             && j >= endidx[1];
             i++,
             j--){
            chessboard.setChess(i, j, chess);
        }
    }
}