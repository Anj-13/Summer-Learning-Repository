package model;

public class Question {
    int id;
    String questionText;
    String[] options;
    int correctAnswerIndex;

    public Question(int id, String questionText, String[] options, int correctAnswerIndex) {
        this.id = id;
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
