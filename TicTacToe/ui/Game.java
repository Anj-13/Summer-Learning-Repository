package ui;

import model.Board;
import model.Player;
import service.PlayerFactory;
import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scn;
    private boolean gameRunning;

    public Game() {
        this.board = new Board();
        this.scn = new Scanner(System.in);
        this.gameRunning = true;
        setupPlayers();
    }

    private void setupPlayers() {
        System.out.println("===== TIC TAC TOE =====");
        System.out.println("Welcome! Let's set up the game.\n");
        
        System.out.println("=== Player 1 (X) ===");
        System.out.print("Enter name for Player 1 (or press Enter for default): ");
        String name1 = scn.nextLine().trim();
        if (name1.isEmpty()) name1 = "Player 1";
        int type1 = PlayerFactory.choosePlayerType(scn, 1);
        player1 = PlayerFactory.createPlayer('X', type1, name1);
        
        System.out.println("\n=== Player 2 (O) ===");
        System.out.print("Enter name for Player 2 (or press Enter for default): ");
        String name2 = scn.nextLine().trim();
        if (name2.isEmpty()) name2 = "Player 2";
        int type2 = PlayerFactory.choosePlayerType(scn, 2);
        player2 = PlayerFactory.createPlayer('O', type2, name2);
        
        System.out.println("\n=== Match Setup ===");
        System.out.println(player1 + " vs " + player2);
        System.out.println("Player X goes first!\n");
        
        currentPlayer = player1;
    }

    public void startGame() {
        while (gameRunning) {
            board.printBoard();
            
            System.out.println("\n" + currentPlayer + "'s turn");
            
            int[] move = currentPlayer.getMove(board, scn);
            
            if (move == null) {
                System.out.println("No moves available!");
                break;
            }
            
            int row = move[0];
            int col = move[1];
            
            boolean moveValid = board.makeMove(row, col, currentPlayer.getSymbol());
            
            if (!moveValid) {
                System.out.println("Invalid move! Try again.");
                continue;
            }
            
            if (checkWin()) {
                board.printBoard();
                System.out.println("\n " + currentPlayer + " WINS!");
                if (!playAgain()) {
                    gameRunning = false;
                } else {
                    resetGame();
                }
            } else if (checkDraw()) {
                board.printBoard();
                System.out.println("\n IT'S A DRAW!");
                if (!playAgain()) {
                    gameRunning = false;
                } else {
                    resetGame();
                }
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        }
        
        System.out.println("\nThanks for playing!");
        scn.close();
    }

    private boolean checkWin() {
        char symbol = currentPlayer.getSymbol();
        for (int row = 0; row < 3; row++) {
            if (board.getCell(row, 0) == symbol &&
                board.getCell(row, 1) == symbol &&
                board.getCell(row, 2) == symbol) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board.getCell(0, col) == symbol &&
                board.getCell(1, col) == symbol &&
                board.getCell(2, col) == symbol) {
                return true;
            }
        }

        if (board.getCell(0, 0) == symbol &&
            board.getCell(1, 1) == symbol &&
            board.getCell(2, 2) == symbol) {
            return true;
        }
        
        if (board.getCell(0, 2) == symbol &&
            board.getCell(1, 1) == symbol &&
            board.getCell(2, 0) == symbol) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        return board.isFull() && !checkWin();
    }

    private boolean playAgain() {
        System.out.print("Do you want to play again? (y/n): ");
        String response = scn.next().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }

    private void resetGame() {
        board.reset();
        currentPlayer = player1;
        System.out.println("\n=== NEW GAME ===\n");
    }
}