import java.util.Scanner;

public class EasyComputer extends ComputerPlayer {
    
    public EasyComputer(char symbol) {
        super(symbol, "Computer (Easy)");
    }
    
    @Override
    public int[] getMove(Board board, Scanner scanner) {
        int[][] emptyCells = getEmptyCells(board);
        
        if (emptyCells.length == 0) {
            return null; // No moves available
        }
        
        int randomIndex = r.nextInt(emptyCells.length);
        return emptyCells[randomIndex];
    }
}