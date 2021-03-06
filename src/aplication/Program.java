package aplication;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.*;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        while (!chessMatch.getcheckMate()) {
         try {


             UI.printMatch(chessMatch, captured);
             System.out.println();
             System.out.println("Source: ");
             ChessPosition source = UI.readChessposition(sc);

             boolean[][]possibleMoves = chessMatch.possibleMoves(source);

             UI.printBord(chessMatch.getPieces(), possibleMoves);

             System.out.println();
             System.out.println("Target");
             ChessPosition tartget = UI.readChessposition(sc);

             ChessPiece capturedPiece = chessMatch.performaChessMove(source, tartget);

             if(capturedPiece != null){
                 captured.add(capturedPiece);
             }

             if(chessMatch.getPromoted() != null){
                 System.out.println("Enter piece for promotion(B/N/R/Q)");
                 String type = sc.nextLine().toUpperCase();
                 while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")){
                     System.out.println(" Invalid Value! Enter piece for promotion(B/N/R/Q)");
                     type = sc.nextLine().toUpperCase();
                 }
                 chessMatch.replacePromotedPiece(type);
             }
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
        UI.printMatch(chessMatch, captured);
    }
}
