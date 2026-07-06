/**
 * HardComputer.java - Uses Minimax algorithm to be unbeatable
 */
import java.util.Scanner;

public class HardComputer extends ComputerPlayer {
    
    public HardComputer(char symbol) {
        super(symbol, "Computer (Hard - Unbeatable)");
    }
    
    @Override
    public int[] getMove(Board board, Scanner scanner) {
        int[][] emptyCells = getEmptyCells(board);
        
        if (emptyCells.length == 0) {
            return null; // No moves available
        }
        
        // If only one move, take it
        if (emptyCells.length == 1) {
            return emptyCells[0];
        }
        
        // Use Minimax to find the best move
        int[] bestMove = null;
        int bestScore = Integer.MIN_VALUE;
        
        for (int[] cell : emptyCells) {
            // Try this move
            board.makeMove(cell[0], cell[1], symbol);
            
            // Calculate score for this move
            int score = minimax(board, 0, false);
            
            // Undo the move
            board.makeMove(cell[0], cell[1], ' ');
            
            // Update best move
            if (score > bestScore) {
                bestScore = score;
                bestMove = cell;
            }
        }
        
        return bestMove;
    }
    
    /**
     * Minimax algorithm for Tic Tac Toe
     * @param board The current board
     * @param depth Current depth in the tree
     * @param isMaximizing True if it's the computer's turn, false for opponent
     * @return Score of the board position
     */
    private int minimax(Board board, int depth, boolean isMaximizing) {
        char opponentSymbol = (symbol == 'X') ? 'O' : 'X';
        
        // Check terminal states
        if (checkWin(board, symbol)) {
            return 10 - depth; // Prefer quicker wins
        }
        if (checkWin(board, opponentSymbol)) {
            return depth - 10; // Prefer slower losses
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
                board.makeMove(cell[0], cell[1], ' ');
                bestScore = Math.max(score, bestScore);
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            int[][] emptyCells = getEmptyCells(board);
            
            for (int[] cell : emptyCells) {
                board.makeMove(cell[0], cell[1], opponentSymbol);
                int score = minimax(board, depth + 1, true);
                board.makeMove(cell[0], cell[1], ' ');
                bestScore = Math.min(score, bestScore);
            }
            return bestScore;
        }
    }
}