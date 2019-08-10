package com.c010ur1355.Reversi.Core;

import com.c010ur1355.Reversi.Enum.Chess;
import com.c010ur1355.Reversi.Model.Coordinate;
import com.c010ur1355.Reversi.FlipStrategy.*;

public class Chessboard {
	// delcare 2D chess array indicate the chessboard
    private Chess[][] chessboard;
    private Chess player;

	// constructors
    public Chessboard(int height, int width){
        this(new Chess[height][width]);
    }

    public Chessboard(Chess[][] chessboard){
        // set chessboard
        this.chessboard = chessboard;
        // initialize black chess as first movable chess
        this.player = Chess.BLACK;
    }

    // getters
    public Chess getChess(int y, int x){
        return chessboard[y][x];
    }

    public Chess getChess(Coordinate coordinate){
        return chessboard[coordinate.getY()][coordinate.getX()];
    }

    public int getWidth(){
        return chessboard[0].length;
    }

    public int getHeight(){
        return chessboard.length;
    }

    public Chess getPlayer(){
        return player;
    }

    // setters
    public Chessboard setChess(int y, int x, Chess type){
        chessboard[y][x] = type;
        return this;
    }

    public Chessboard setChess(Coordinate coordinate, Chess type){
        chessboard[coordinate.getY()][coordinate.getX()] = type;
        return this;
    }

    // initialization method
    public Chessboard initialize(){
        for (int i = 0; i < chessboard.length; i++)
            for (int j = 0; j < chessboard[0].length; j++)
                chessboard[i][j] = Chess.EMPTY;

        chessboard[2][2] = chessboard[3][3] = Chess.BLACK;
        chessboard[2][3] = chessboard[3][2] = Chess.WHITE;

        return this;
    }

    // flippable-checking method
    public boolean isFlippable(Coordinate coordinate){
        return clone().flip(coordinate).countChess()[coordinate.getPlayer().flip().ordinal()] < countChess()[coordinate.getPlayer().flip().ordinal()];
    }

    // chess-flipping method
    public Chessboard flip(Coordinate coordinate){
        new FlipStrategyContext(
            new AssignStrategy(),
            new RowFlipStrategy(),
            new ColFlipStrategy(),
            new ObliqueFlipStrategy(),
            new OppositeObliqueFlipStrategy())
            .flip(this, coordinate);

        return this;
    }

    // condition-checking method
    public boolean continuable(){
        return countChess()[0] > 0;
    }

	// is player switchable method
    private boolean hasMovement() {
        for (int i = 0; i < chessboard.length; i++)
            for (int j = 0; j < chessboard[0].length; j++)
                if (isFlippable(new Coordinate(i, j, player.flip())) && chessboard[i][j] == Chess.EMPTY)
                    return true;

        return false;
    }

    // logging and information method
    public Chessboard printArray(){
        System.out.println("    0 1 2 3 4 5\r\n  +------------");
        for(int i = 0; i < chessboard.length; i++){
            System.out.print(i + " |");
            for(int j = 0; j < chessboard[0].length; j++)
                System.out.printf("%2s", isFlippable(new Coordinate(i, j, player)) && chessboard[i][j] == Chess.EMPTY ? "-" : chessboard[i][j].ordinal());
            System.out.println();
        }
        return this;
    }

	// alert to input method
    public void alert(){
        System.out.printf("Please enter the position of '%d':\r\n", player.ordinal());
    }

	// show game end stat method
    public Chessboard finish(){
        int black = countChess()[Chess.BLACK.ordinal()];
        int white = countChess()[Chess.WHITE.ordinal()];

        System.out.printf("Game Finishes.\r\n" +
                "\t'1' - %d\r\n" +
                "\t'2' - %d\r\n" +
                "%s.", black, white, black == white ? "It's draw" : black > white ? "Black wins" : "White wins");

        return this;
    }

    // player-switching method
    public Chessboard switchPlayer(){
        player =  hasMovement() ? player.flip() : player;
        return this;
    }

    // other method
    public Chessboard clone(){
        Chess[][] tmp = new Chess[chessboard.length][];

		// clone
        for(int i = 0; i < chessboard.length; i++)
            tmp[i] = chessboard[i].clone();

        return new Chessboard(tmp);
    }

	// count chessboard's chess method.
    private int[] countChess(){
        Chess[][] arr = chessboard;

        int[] count = new int[3];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                count[arr[i][j].ordinal()]++;
            }
        }

        return count;
    }
}
