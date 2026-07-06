import java.util.Scanner;

public abstract class Player {
    protected char symbol;
    protected String name;

    public Player(char symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }

    public char getSymbol(){
        return symbol;
    }
    public String getName() {
        return name;
    }

    public abstract int[] getMove(Board board, Scanner scn);

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}
