package app;

import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Match;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Match match = new Match();
        List<ChessPiece> captured = new ArrayList<>();

        while (!match.getCheckMate()){

         try {
             UI.clearScreen();
             UI.printMatch(match,captured);
             System.out.println();
             System.out.print("Source: ");
             ChessPosition source = UI.readChessPosition(sc);

             boolean[][] possibleMoves = match.possibleMoves(source);
             UI.clearScreen();
             UI.printBoard(match.getPieces(),possibleMoves);
             System.out.println();
             System.out.print("Target: ");
             ChessPosition target = UI.readChessPosition(sc);

             ChessPiece capturedPiece = match.performChessMove(source, target);

             if(capturedPiece != null){
                 captured.add(capturedPiece);
             }
         }
         catch (ChessException e){
             System.out.println(e.getMessage());
             sc.nextLine();
         } catch (InputMismatchException e) {
             System.out.println(e.getMessage());
             sc.nextLine();
         }

        }
        UI.clearScreen();
        UI.printMatch(match,captured);

    }
}
