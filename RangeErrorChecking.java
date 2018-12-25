public class RangeErrorChecking implements IErrorChecking { 
    @Override
    public boolean isValid(Chessboard chessboard, Coordinate coordinate) {
        int y = coordinate.getY();
        int x = coordinate.getX();
        Chess[][] arr = chessboard.getChessboard();

        if (y > arr.length - 1
            || y < 0
            || x > arr[0].length - 1
            || x < 0){
            System.out.println("Error - input numbers should be 0 to 5!");
            return false;
        }

        return true;
    }
}
