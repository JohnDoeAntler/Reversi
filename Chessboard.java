public class Chessboard { 
	// delcare 2D chess array indicate the chessboard
    private Chess[][] chessboard;

	// constructor
    public Chessboard(final int height, final int width){
        chessboard = new Chess[height][width];
    }

    // getter
    public Chess[][] getChessboard(){
        return chessboard;
    }

    // setter
    private Chessboard setChessboard(Chess[][] chessboard){
        this.chessboard = chessboard;
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
        return countChess(flipBoard(clone(this), coordinate))[coordinate.getPlayer().flip().ordinal()] < countChess(this)[coordinate.getPlayer().flip().ordinal()];
    }


    // chess-flipping method
    public Chessboard flipBoard(Chessboard chessboard, Coordinate coordinate){
        new FlipStrategyContext(
                new AssignStrategy(),
                new RowFlipStrategy(),
                new ColFlipStrategy(),
                new ObliqueFlipStrategy(),
                new OppositeObliqueFlipStrategy())
                .flip(chessboard, coordinate);

        return chessboard;
    }

    // condition-checking method
    public boolean continuable(){
        return countChess(this)[0] > 0;
    }

	// is player switchable method
    private boolean hasMovement(Chess player) {
        for (int i = 0; i < chessboard.length; i++)
            for (int j = 0; j < chessboard[0].length; j++)
                if (isFlippable(new Coordinate(i, j, player)) && chessboard[i][j] == Chess.EMPTY)
                    return true;

        return false;
    }

    // logging and information method
    public Chessboard printArray(Chess player){
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
    public static void alert(Chess player){
        System.out.printf("Please enter the position of '%d':\r\n", player.ordinal());
    }

	// show game end stat method
    public Chessboard finish(){
        int black = countChess(this)[Chess.BLACK.ordinal()];
        int white = countChess(this)[Chess.WHITE.ordinal()];

        System.out.printf("Game Finishes.\r\n" +
                "\t'1' - %d\r\n" +
                "\t'2' - %d\r\n" +
                "%s.", black, white, black == white ? "It's draw" : black > white ? "Black wins" : "White wins");

        return this;
    }

    // player-switching method
    public Chess switchPlayer(Chess player){
        return hasMovement(player.flip()) ? player.flip() : player;
    }

    // other method
    private Chessboard clone(Chessboard chessboard){
        Chess[][] arr = chessboard.chessboard;
        Chess[][] tmp = new Chess[arr.length][];

		// clone
        for(int i = 0; i < arr.length; i++)
            tmp[i] = arr[i].clone();

        return new Chessboard(chessboard.chessboard.length, chessboard.chessboard[0].length).setChessboard(tmp);
    }

	// count chessboard's chess method.
    private static int[] countChess(Chessboard chessboard){
        Chess[][] arr = chessboard.chessboard;

        int[] count = new int[3];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                count[arr[i][j].ordinal()]++;
            }
        }

        return count;
    }
}
