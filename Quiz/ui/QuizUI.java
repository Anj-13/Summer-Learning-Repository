package ui;

import service.QuizService;
import storage.ScoreManager;
import java.util.Scanner;

public class QuizUI {
    private static Scanner scan;
    private static QuizService quizService;
    private static ScoreManager scoreManager;

    public static void start() {
        scan = new Scanner(System.in);
        quizService = new QuizService(scan);
        scoreManager = new ScoreManager();

        while (true) {
            menu();
            System.out.print("Enter choice: ");
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                scan.nextLine();
                choice(choice);
            } else {
                scan.next();
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }

    private static void menu() {
        System.out.println("==== Quiz App ====\r\n"
                + "1. Start Quiz\r\n"
                + "2. View High Score\r\n"
                + "3. Exit");
    }

    private static void choice(int c) {
        switch (c) {
            case 1 -> quizGame();
            case 2 -> viewScore();
            case 3 -> exit();
            default -> System.out.println("Invalid choice, please choose again");
        }
    }

    private static void quizGame() {
        int score = quizService.startQuiz();
        quizService.showResult(score);
        scoreManager.saveScore(score);
    }

    private static void viewScore() {
        scoreManager.viewHighScores();
    }

    private static void exit() {
        System.out.println("Thank you for playing! Goodbye!");
        System.exit(0);
    }
}
