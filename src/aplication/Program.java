package aplication;

import boardgame.Board;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            UI.printBord(chessMatch.getPieces());
            System.out.println();
            System.out.println("Source: ");
            ChessPosition source = UI.readChessposition(sc);
            System.out.println();
            System.out.println("Target");
            ChessPosition tartget = UI.readChessposition(sc);

            ChessPiece capturedPiece = chessMatch.performaChessMove(source,tartget);



        }

    }
}
