package service;

import model.Board;
import java.util.Scanner;

public class MediumComputer extends ComputerPlayer {
    
    public MediumComputer(char symbol) {
        super(symbol, "Computer (Medium)");
    }
    
    @Override
    public int[] getMove(Board board, Scanner scanner) {
        int[][] emptyCells = getEmptyCells(board);
        
        if (emptyCells.length == 0) {
            return null;
        }
        
        int[] winningMove = getWinningMove(board, symbol);
        if (winningMove != null) {
            return winningMove;
        }
        
        char opponentSymbol = (symbol == 'X') ? 'O' : 'X';
        int[] blockingMove = getWinningMove(board, opponentSymbol);
        if (blockingMove != null) {
            return blockingMove;
        }
        
        if (board.isValidMove(1, 1)) {
            return new int[]{1, 1};
        }
        
        int[][] corners = {{0,0}, {0,2}, {2,0}, {2,2}};
        for (int[] corner : corners) {
            if (board.isValidMove(corner[0], corner[1])) {
                return corner;
            }
        }
        
        int randomIndex = r.nextInt(emptyCells.length);
        return emptyCells[randomIndex];
    }
}