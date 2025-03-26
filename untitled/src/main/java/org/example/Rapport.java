package org.example;

public class Rapport {
    public void printReport(Student student) {
        System.out.println("Report for " + student.getName() + ": Grade - " + student.getGrade());
    }
}
