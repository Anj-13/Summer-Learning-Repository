package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Module implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private List<Grade> grades;

    public Module(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public boolean removeGrade(int gradeId) {
        return grades.removeIf(g -> g.getId() == gradeId);
    }

    @Override
    public String toString() {
        return String.format("Module{id=%d, name='%s', grades=%d}", id, name, grades.size());
    }
}
