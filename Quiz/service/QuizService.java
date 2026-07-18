package service;

import model.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizService {
    private List<Question> questions;
    private int score;
    private int currentQuestionIndex;
    private Scanner scan;

    public QuizService(Scanner scan) {
        questions = new ArrayList<>();
        score = 0;
        currentQuestionIndex = 0;
        this.scan = scan;
        loadQuestions();
    }

    public QuizService() {
        this(new Scanner(System.in));
    }

    private void loadQuestions() {
        questions.clear();
        questions.add(new Question(1, "What is the capital of France?",
                new String[]{"London", "Berlin", "Paris", "Madrid"}, 2));
        questions.add(new Question(2, "Which planet is known as the Red Planet?",
                new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 1));
        questions.add(new Question(3, "What is 7 x 8?",
                new String[]{"54", "56", "48", "64"}, 1));
        questions.add(new Question(4, "Who wrote Romeo and Juliet?",
                new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"}, 1));
        questions.add(new Question(5, "What is the largest ocean on Earth?",
                new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3));
    }

    public int startQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        Collections.shuffle(questions);

        System.out.println("\n--- Quiz Started! ---\n");

        for (Question q : questions) {
            displayQuestion(q);
            int answer = getUserAnswer();
            if (answer == q.getCorrectAnswerIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: "
                        + q.getOptions()[q.getCorrectAnswerIndex()] + "\n");
            }
            currentQuestionIndex++;
        }

        return score;
    }

    private void displayQuestion(Question q) {
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + q.getQuestionText());
        String[] options = q.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private int getUserAnswer() {
        int answer = -1;
        while (true) {
            System.out.print("Enter your answer (1-" + questions.get(currentQuestionIndex).getOptions().length + "): ");
            if (scan.hasNextInt()) {
                answer = scan.nextInt() - 1;
                if (answer >= 0 && answer < questions.get(currentQuestionIndex).getOptions().length) {
                    break;
                }
            } else {
                scan.next();
            }
            System.out.println("Invalid option, please try again.");
        }
        return answer;
    }

    public void showResult(int score) {
        System.out.println("--- Quiz Finished! ---");
        int total = questions.size();
        System.out.println("Your score: " + score + " out of " + total);
        if (total == 0) {
            System.out.println("Percentage: 0.0%");
            return;
        }
        double percentage = (double) score / total * 100;
        System.out.printf("Percentage: %.1f%%\n", percentage);
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}
