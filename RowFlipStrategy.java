public class RowFlipStrategy implements IStrategy { 
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {
        Chess[][] tmp = chessboard.getChessboard();

        int y = coordinate.getY();
        int x = coordinate.getX();

        Chess chess = coordinate.getPlayer();

        int stridx;
        int endidx;

        stridx = endidx = y;

        // vertical up
        for (int i = y - 1; i >= 0; i--){
            if (tmp[i][x] == Chess.EMPTY){
                break;
            }else if (tmp[i][x] == chess){
                stridx = i;
                break;
            }
        }

        //vertical down
        for (int i = y + 1; i < tmp.length; i++){
            if (tmp[i][x] == Chess.EMPTY){
                break;
            }else if (tmp[i][x] == chess){
                endidx = i;
                break;
            }
        }

        //flip
        for (int i = stridx; i < endidx + 1; i++){
            tmp[i][x] = chess;
        }
    }
}