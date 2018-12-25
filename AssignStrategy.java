public class AssignStrategy implements IStrategy { 
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {
        chessboard.getChessboard()[coordinate.getY()][coordinate.getX()] = coordinate.getPlayer();
    }
}
