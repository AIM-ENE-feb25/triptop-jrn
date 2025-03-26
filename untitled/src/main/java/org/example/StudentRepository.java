package org.example;

public class StudentRepository {
    public void save(Student student) {
        System.out.println("Saving student " + student.getName() + " to database.");
    }
}
