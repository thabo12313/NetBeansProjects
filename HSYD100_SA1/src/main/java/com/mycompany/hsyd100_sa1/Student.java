/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hsyd100_sa1;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 * 05HA2310394
 * @author thabo
 */
public class Student { 
    private String name;
    private int[] Grades;
    
    // Constructor to initialize the student's name
    public Student(String name) {
        this.name = name;
        this.Grades = new int[0]; // Initialize grades as an empty array
    }

    // Method to add a grade to the student's grades array
    public void addGrade(int grade) {
        int[] newGrades = new int[Grades.length + 1];
        for (int i = 0; i < Grades.length; i++) {
            newGrades[i] = Grades[i];
        }
        newGrades[Grades.length] = grade;
        Grades = newGrades;
    }

    // Method to calculate and return the average grade
    public double calculateAverageGrade() {
        if (Grades.length == 0) {
            return 0.0; // Avoid division by zero
        }

        int totalGrades = 0;
        for (int grade : Grades) {
            totalGrades += grade;
        }

        return (double) totalGrades / Grades.length;
    }

    // Method to return the grade status based on the average grade
    public String getGradeStatus() {
        double averageGrade = calculateAverageGrade();
        if (averageGrade >= 60) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
    
    public int calculateTotalGradePoints() {
    int totalGradePoints = 0;
    int i = 0;
    while (i < Grades.length) {
        int grade = Grades[i];
        totalGradePoints += grade;
        i++;
    }
        return totalGradePoints;
    }    
    

    public static void main(String[] args) {
        Student student = new Student("John");

        student.addGrade(80);
        student.addGrade(75);
        student.addGrade(90);
        student.addGrade(85);

        System.out.println("Student: " + student.name);
        System.out.println("Grades: " + java.util.Arrays.toString(student.Grades));
        System.out.println("Average grade: " + student.calculateAverageGrade());
        System.out.println("Grade status: " + student.getGradeStatus());
        System.out.println("Total grade points: " + student.calculateTotalGradePoints());
    }
}

        
        
        

