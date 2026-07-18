package service;

import model.Board;
import model.Player;
import java.util.Random;

public abstract class ComputerPlayer extends Player{
    protected Random r;

    public ComputerPlayer(char symbol, String name) {
        super(symbol, name);
        this.r = new Random();
    }

    protected int[] getWinningMove(Board board, char symbol) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.isValidMove(row, col)) {
                    board.makeMove(row, col, symbol);
                    
                    boolean wins = checkWin(board, symbol);
                    board.clearCell(row, col);
                    
                    if (wins) {
                        return new int[]{row, col};
                    }
                }
            }
        }
        return null;
    }
    protected boolean checkWin(Board board, char symbol) {
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
     protected int[][] getEmptyCells(Board board) {
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.isValidMove(row, col)) {
                    count++;
                }
            }
        }
        
        int[][] emptyCells = new int[count][2];
        int index = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.isValidMove(row, col)) {
                    emptyCells[index][0] = row;
                    emptyCells[index][1] = col;
                    index++;
                }
            }
        }
        return emptyCells;
    }
}