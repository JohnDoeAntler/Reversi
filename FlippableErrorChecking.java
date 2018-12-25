public class FlippableErrorChecking implements IErrorChecking { 
    @Override
    public boolean isValid(Chessboard chessboard, Coordinate coordinate) {
        if (!chessboard.isFlippable(coordinate)){
            System.out.println("Error - invalid move.");
            return false;
        }
        return true;
    }
}
