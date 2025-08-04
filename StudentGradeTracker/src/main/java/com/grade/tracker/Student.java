package com.grade.tracker;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Double> grades;
    
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
    
    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    public double getHighestGrade() {
        if (grades.isEmpty()) return 0;
        return grades.stream().max(Double::compare).get();
    }
    
    public double getLowestGrade() {
        if (grades.isEmpty()) return 0;
        return grades.stream().min(Double::compare).get();
    }
    
    public String getName() {
        return name;
    }
    
    public List<Double> getGrades() {
        return grades;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student: ").append(name).append("\n");
        sb.append("Grades: ").append(grades.toString()).append("\n");
        sb.append("Average: ").append(String.format("%.2f", getAverageGrade())).append("\n");
        sb.append("Highest: ").append(getHighestGrade()).append("\n");
        sb.append("Lowest: ").append(getLowestGrade()).append("\n");
        return sb.toString();
    }
}
