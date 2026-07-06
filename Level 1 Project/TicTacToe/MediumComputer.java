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
        
        // 1. Check if computer can win
        int[] winningMove = getWinningMove(board, symbol);
        if (winningMove != null) {
            return winningMove;
        }
        
        // 2. Check if opponent can win (block them)
        char opponentSymbol = (symbol == 'X') ? 'O' : 'X';
        int[] blockingMove = getWinningMove(board, opponentSymbol);
        if (blockingMove != null) {
            return blockingMove;
        }
        
        // 3. Take center if available
        if (board.isValidMove(1, 1)) {
            return new int[]{1, 1};
        }
        
        // 4. Take corners if available
        int[][] corners = {{0,0}, {0,2}, {2,0}, {2,2}};
        for (int[] corner : corners) {
            if (board.isValidMove(corner[0], corner[1])) {
                return corner;
            }
        }
        
        // 5. Take any random move
        int randomIndex = r.nextInt(emptyCells.length);
        return emptyCells[randomIndex];
    }
}