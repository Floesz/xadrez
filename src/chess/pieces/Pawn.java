package chess.pieces;

import board.Board;
import board.Position;
import chess.ChessPiece;
import chess.Color;
import chess.Match;

public class Pawn extends ChessPiece {

    private Match match;

    public Pawn(Board board, Color color, Match match) {
        super(board, color);
        this.match = match;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {

            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)
                    && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)
                    && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // #specialmove en passant white
            if (position.getRow() == 3) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereAOpponentPiece(left) && getBoard().piece(left) == match.getEnPassantVulnerable()) {
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereAOpponentPiece(right) && getBoard().piece(right) == match.getEnPassantVulnerable()) {
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        }
        else {



            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)
                    && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)
                    && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereAOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            // #specialmove en passant black
            if (position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(left) && isThereAOpponentPiece(left) && getBoard().piece(left) == match.getEnPassantVulnerable()) {
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(right) && isThereAOpponentPiece(right) && getBoard().piece(right) == match.getEnPassantVulnerable()) {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }

        return mat;
    }


    @Override
    public String toString() {
        return "P";
    }
}
