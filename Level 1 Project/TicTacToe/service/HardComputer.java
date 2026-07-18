package service;

import model.Board;
import java.util.Scanner;

public class HardComputer extends ComputerPlayer {
    
    public HardComputer(char symbol) {
        super(symbol, "Computer (Hard - Unbeatable)");
    }
    
    @Override
    public int[] getMove(Board board, Scanner scanner) {
        int[][] emptyCells = getEmptyCells(board);
        
        if (emptyCells.length == 0) {
            return null;
        }
        
        if (emptyCells.length == 1) {
            return emptyCells[0];
        }
        
        int[] bestMove = null;
        int bestScore = Integer.MIN_VALUE;
        
        for (int[] cell : emptyCells) {
            board.makeMove(cell[0], cell[1], symbol);
            
            int score = minimax(board, 0, false);
            
            board.clearCell(cell[0], cell[1]);
            
            if (score > bestScore) {
                bestScore = score;
                bestMove = cell;
            }
        }
        
        return bestMove;
    }
    
    private int minimax(Board board, int depth, boolean isMaximizing) {
        char opponentSymbol = (symbol == 'X') ? 'O' : 'X';
        
        if (checkWin(board, symbol)) {
            return 10 - depth;
        }
        if (checkWin(board, opponentSymbol)) {
            return depth - 10;
        }
        if (board.isFull()) {
            return 0;
        }
        
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            int[][] emptyCells = getEmptyCells(board);
            
            for (int[] cell : emptyCells) {
                board.makeMove(cell[0], cell[1], symbol);
                int score = minimax(board, depth + 1, false);
                board.clearCell(cell[0], cell[1]);
                bestScore = Math.max(score, bestScore);
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            int[][] emptyCells = getEmptyCells(board);
            
            for (int[] cell : emptyCells) {
                board.makeMove(cell[0], cell[1], opponentSymbol);
                int score = minimax(board, depth + 1, true);
                board.clearCell(cell[0], cell[1]);
                bestScore = Math.min(score, bestScore);
            }
            return bestScore;
        }
    }
}