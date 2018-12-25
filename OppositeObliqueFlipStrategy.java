public class OppositeObliqueFlipStrategy implements IStrategy { 
    @Override
    public void flip(Chessboard chessboard, Coordinate coordinate) {
        Chess[][] tmp = chessboard.getChessboard();

        int y = coordinate.getY();
        int x = coordinate.getX();

        Chess chess = coordinate.getPlayer();

        int[] stridx = new int[2];
        int[] endidx = new int[2];

        stridx[0] = endidx[0] = y;
        stridx[1] = endidx[1] = x;

        //right-up
        for (int i = y - 1,
             j = x + 1;
             i >=0
             && j < tmp[0].length;
             i--,
             j++){
            if (tmp[i][j] == Chess.EMPTY){
                break;
            }else if (tmp[i][j] == chess){
                stridx[0] = i;
                stridx[1] = j;
                break;
            }
        }

        //left-down
        for (int i = y + 1,
             j = x - 1;
             i < tmp.length
             && j >= 0;
             i++,
             j--){
            if (tmp[i][j] == Chess.EMPTY){
                break;
            }else if (tmp[i][j] == chess){
                endidx[0] = i;
                endidx[1] = j;
                break;
            }
        }

        //flip
        for (int i = stridx[0],
             j = stridx[1];
             i < endidx[0] + 1
             && j >= endidx[1];
             i++,
             j--){
            tmp[i][j] = chess;
        }
    }
}