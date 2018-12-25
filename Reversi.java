public class Reversi {
	// program's entry point
    public static void main(String[] args) {
		// instantiate a Reversi game panel
        new Reversi().start();
    }

	// object start point.
    private void start(){
		// initialize player to black chess.
        Chess player = Chess.BLACK;

		// instantiate chessboard size to 6 width and 6 height
        Chessboard chessboard = new Chessboard(6, 6)
				// initialize chessboard
                .initialize()
				// print chessboard chess
                .printArray(player);

		// if chessboard is not endable
        while (chessboard.continuable()){
			// alert player to input
            Chessboard.alert(player);

			// get player input and assign it into coordinate class.
            Coordinate coordinate = new Coordinate(ScannerSingleton.getSingleton().nextInt(), ScannerSingleton.getSingleton().nextInt(), player);

			// using method injectino of dependency injection to implement strategy pattern of design pattern.
            if (new ErrorCheckingContext(
                    new RangeErrorChecking(),
                    new EmptyErrorChecking(),
                    new FlippableErrorChecking())
                    .isValid(chessboard, coordinate)){
				// flip chessboard
                chessboard.flipBoard(chessboard, coordinate);

				// switch player
                player = chessboard.switchPlayer(player);

				// show chessboard current status to player
                chessboard.printArray(player);
            }
        }
		
		// print chessboard win stat
        chessboard.finish();
    }
}