import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.BoardException;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {

                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
    
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                
            } catch (ChessException e) {
                System.out.print(e.getMessage());
                sc.nextLine();
            } catch (BoardException e) {
                System.out.print(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.print(e.getMessage());
                sc.nextLine();
            } 
        }
    }
}
