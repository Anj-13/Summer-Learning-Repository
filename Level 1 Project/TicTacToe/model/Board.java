package model;

public class Board {
    private final char[][] board;

    public Board() {
        this.board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void printBoard() {
    for (int row = 0; row < 3; row++) {
        System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
        if (row < 2) {
            System.out.println("-----------");
        }
    }
}

    public boolean isValidMove(int row, int col) {
        return isValidCell(row, col) && board[row][col] == ' ';
    }

    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (!isValidMove(row, col)) {
            return false;
        }

        board[row][col] = symbol;
        return true;
    }

    public void clearCell(int row, int col) {
        if (isValidCell(row, col)) {
            board[row][col] = ' ';
        }
    }

    public char getCell(int row, int col) {
        if (!isValidCell(row, col)) {
            throw new IllegalArgumentException("Invalid board coordinates: Row " + row + ", Col " + col);
        }
        return board[row][col];
    }

    public boolean isFull() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public void reset() {
        initializeBoard();
    }
}