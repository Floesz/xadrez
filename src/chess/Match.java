package chess;

import board.Board;
import board.Position;
import chess.pieces.Hook;
import chess.pieces.King;

public class Match {

    private Board board;

    public Match() {
        board = new Board(8,8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i = 0; i < board.getRows(); i++){
            for(int j = 0; j < board.getColumns(); j++){
                mat[i][j] =(ChessPiece) board.piece(i,j);
            }
        } return mat;
    }

    private void initialSetup(){
        board.placePiece(new Hook(board,Color.WHITE),new Position(1,2));
        board.placePiece(new King(board,Color.BLACK),new Position(4,0));
    }
}
