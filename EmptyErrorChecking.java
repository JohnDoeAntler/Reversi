public class EmptyErrorChecking implements IErrorChecking { 
    @Override
    public boolean isValid(Chessboard chessboard, Coordinate coordinate) {
        Chess[][] arr = chessboard.getChessboard();
        int y = coordinate.getY();
        int x = coordinate.getX();

        if (arr[y][x] != Chess.EMPTY){
            System.out.println("Error - input cell is not empty.");
            return false;
        }
        return true;
    }
}
