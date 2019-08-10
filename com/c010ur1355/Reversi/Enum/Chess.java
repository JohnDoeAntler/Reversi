package com.c010ur1355.Reversi.Enum;

public enum Chess {
	// chess color
    EMPTY,
    BLACK, 
    WHITE;

	// flip chess to opposite color
    public Chess flip(){
        switch (this){
            case BLACK:
                return WHITE;
            case WHITE:
                return BLACK;
            default:
                throw new ClassCastException("Empty is not permitted to be flipped.");
        }
    }
}
