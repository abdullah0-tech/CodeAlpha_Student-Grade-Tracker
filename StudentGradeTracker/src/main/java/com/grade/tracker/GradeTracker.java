package com.grade.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeTracker {
    private List<Student> students;
    private Scanner scanner;
    
    public GradeTracker() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully!");
    }
    
    public void addGrade() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudent(name);
        
        if (student != null) {
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            student.addGrade(grade);
            System.out.println("Grade added successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
    
    public void displaySummary() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }
        
        System.out.println("\n=== Student Summary ===");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    private Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
    
    public void run() {
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== Student Grade Tracker ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Display Summary");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    addGrade();
                    break;
                case "3":
                    displaySummary();
                    break;
                case "4":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        tracker.run();
    }
}
