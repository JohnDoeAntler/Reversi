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
