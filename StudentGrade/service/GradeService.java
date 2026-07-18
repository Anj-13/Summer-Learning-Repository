package service;

import model.Grade;
import model.Module;

import java.util.ArrayList;
import java.util.List;

public class GradeService {
    private List<Module> modules;
    private int nextModuleId = 1;
    private int nextGradeId = 1;

    public GradeService() {
        this.modules = new ArrayList<>();
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
        recalculateIds();
    }

    private void recalculateIds() {
        nextModuleId = 1;
        nextGradeId = 1;
        for (Module m : modules) {
            if (m.getId() >= nextModuleId) {
                nextModuleId = m.getId() + 1;
            }
            for (Grade g : m.getGrades()) {
                if (g.getId() >= nextGradeId) {
                    nextGradeId = g.getId() + 1;
                }
            }
        }
    }

    public Module addModule(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Module name cannot be empty.");
        }
        Module module = new Module(nextModuleId++, name.trim());
        modules.add(module);
        return module;
    }

    public boolean deleteModule(int moduleId) {
        return modules.removeIf(m -> m.getId() == moduleId);
    }

    public Module findModule(int moduleId) {
        for (Module m : modules) {
            if (m.getId() == moduleId) {
                return m;
            }
        }
        return null;
    }

    public Grade addGrade(int moduleId, String assessmentName, double score, double weight) {
        Module module = findModule(moduleId);
        if (module == null) {
            return null;
        }
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        if (weight <= 0 || weight > 100) {
            throw new IllegalArgumentException("Weight must be between 0 and 100.");
        }
        Grade grade = new Grade(nextGradeId++, assessmentName, score, weight);
        module.addGrade(grade);
        return grade;
    }

    public boolean deleteGrade(int moduleId, int gradeId) {
        Module module = findModule(moduleId);
        if (module == null) {
            return false;
        }
        return module.removeGrade(gradeId);
    }

    public double calculateModuleAverage(int moduleId) {
        Module module = findModule(moduleId);
        if (module == null || module.getGrades().isEmpty()) {
            return 0.0;
        }

        double totalWeight = 0;
        double weightedSum = 0;

        for (Grade g : module.getGrades()) {
            weightedSum += g.getScore() * (g.getWeight() / 100.0);
            totalWeight += g.getWeight() / 100.0;
        }

        if (totalWeight == 0) {
            return 0.0;
        }

        return weightedSum / totalWeight;
    }

    public Grade findHighestGrade(int moduleId) {
        Module module = findModule(moduleId);
        if (module == null || module.getGrades().isEmpty()) {
            return null;
        }

        Grade highest = module.getGrades().get(0);
        for (Grade g : module.getGrades()) {
            if (g.getScore() > highest.getScore()) {
                highest = g;
            }
        }
        return highest;
    }

    public Grade findLowestGrade(int moduleId) {
        Module module = findModule(moduleId);
        if (module == null || module.getGrades().isEmpty()) {
            return null;
        }

        Grade lowest = module.getGrades().get(0);
        for (Grade g : module.getGrades()) {
            if (g.getScore() < lowest.getScore()) {
                lowest = g;
            }
        }
        return lowest;
    }
}
