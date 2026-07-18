package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreManager {
    private static final String SCORE_FILE = "highscore.txt";
    private List<Integer> highScores;

    public ScoreManager() {
        highScores = new ArrayList<>();
        loadScores();
    }

    private void loadScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SCORE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    highScores.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid score entry: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, start with empty scores
        } catch (IOException e) {
            System.out.println("Error reading high scores: " + e.getMessage());
        }
    }

    public void saveScore(int score) {
        highScores.add(score);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCORE_FILE))) {
            for (int s : highScores) {
                writer.write(String.valueOf(s));
                writer.newLine();
            }
            System.out.println("Score saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }

    public void viewHighScores() {
        if (highScores.isEmpty()) {
            System.out.println("\nNo high scores yet. Play a quiz first!\n");
            return;
        }

        System.out.println("\n--- High Scores ---");
        List<Integer> sorted = new ArrayList<>(highScores);
        sorted.sort((a, b) -> b - a);
        int limit = Math.min(sorted.size(), 5);
        for (int i = 0; i < limit; i++) {
            System.out.println((i + 1) + ". " + sorted.get(i));
        }
        System.out.println();
    }

    public int getHighScore() {
        if (highScores.isEmpty()) {
            return 0;
        }
        return highScores.stream().mapToInt(Integer::intValue).max().orElse(0);
    }
}
