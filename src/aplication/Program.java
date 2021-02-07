package aplication;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
         try {


             UI.printMatch(chessMatch);
             System.out.println();
             System.out.println("Source: ");
             ChessPosition source = UI.readChessposition(sc);

             boolean[][]possibleMoves = chessMatch.possibleMoves(source);

             UI.printBord(chessMatch.getPieces(), possibleMoves);

             System.out.println();
             System.out.println("Target");
             ChessPosition tartget = UI.readChessposition(sc);

             ChessPiece capturedPiece = chessMatch.performaChessMove(source, tartget);
         }
         catch (ChessException e){
             System.out.println(e.getMessage());
             sc.nextLine();
         }
         catch (InputMismatchException e){
             System.out.println(e.getMessage());
             sc.nextLine();
         }


        }
    }
}
