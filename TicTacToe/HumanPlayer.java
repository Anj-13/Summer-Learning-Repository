import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol) {
        super(symbol, "Human");
    }

    public HumanPlayer(char symbol, String name) {
        super(symbol, name);
    }

    @Override
    public int[] getMove(Board board, Scanner scn) {
        int[] move = new int[2];

        while (true) {
            try {
                System.out.print("Enter row: ");
                move[0] = scn.nextInt();
                System.out.print("Enter column: ");
                move[1] = scn.nextInt();

                if (board.isValidMove(move[0], move[1])) {
                    break;
                } else {
                    System.out.println("Invalid move! Cell is occupied or out of bounds.");
                }
            } catch (Exception e) {
                System.out.println("Please enter valid numbers!");
                scn.nextLine();
            }
        }

        return move;
    }
}
