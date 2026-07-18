package service;

import model.Player;
import ui.HumanPlayer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerFactory {

    public static Player createPlayer(char symbol, int type, String name) {
        switch (type) {
            case 1:
                return new HumanPlayer(symbol, name);
            case 2:
                return new EasyComputer(symbol);
            case 3:
                return new MediumComputer(symbol);
            case 4:
                return new HardComputer(symbol);
            default:
                return new HumanPlayer(symbol, name);
        }
    }

    public static int choosePlayerType(Scanner scanner, int playerNumber) {
        System.out.println("\nSelect type for Player " + playerNumber + ":");
        System.out.println("1. Human");
        System.out.println("2. Computer (Easy - Random)");
        System.out.println("3. Computer (Medium - Blocks wins)");
    System.out.println("4. Computer (Hard - Unbeatable AI)");
        System.out.print("Enter choice : ");

        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.print("Please enter a number between 1 and 4: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid number: ");
                scanner.nextLine();
            }
        }
    }
}