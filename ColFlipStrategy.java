public class ColFlipStrategy implements IStrategy { 
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {
        Chess[][] tmp = chessboard.getChessboard();

        int y = coordinate.getY();
        int x = coordinate.getX();

        Chess step = coordinate.getPlayer();

        int stridx;
        int endidx;

        stridx = endidx = x;

        //horizontal left
        for (int i = x - 1; i >= 0; i--){
            if (tmp[y][i] == Chess.EMPTY){
                break;
            }else if (tmp[y][i] == step){
                stridx = i;
                break;
            }
        }

        //horizontal right
        for (int i = x + 1; i < tmp[0].length; i++){
            if (tmp[y][i] == Chess.EMPTY){
                break;
            }else if (tmp[y][i] == step){
                endidx = i;
                break;
            }
        }

        //flip
        for (int i = stridx; i < endidx + 1; i++){
            tmp[y][i] = step;
        }
    }
}
