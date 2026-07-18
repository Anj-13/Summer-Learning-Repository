package model;

import java.io.Serializable;

public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String assessmentName;
    private double score;
    private double weight;

    public Grade(int id, String assessmentName, double score, double weight) {
        this.id = id;
        this.assessmentName = assessmentName;
        this.score = score;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Grade{id=%d, assessment='%s', score=%.1f, weight=%.1f%%}",
                id, assessmentName, score, weight);
    }
}
