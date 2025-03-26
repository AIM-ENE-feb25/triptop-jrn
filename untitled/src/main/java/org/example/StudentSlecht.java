package org.example;

public class StudentSlecht {

        private String name;
        private int grade;

        public StudentSlecht(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getGrade() {
            return grade;
        }

        public void saveToDatabase() {
            System.out.println("Saving student " + name + " to database.");
        }

        public void printReport() {
            System.out.println("Report for " + name + ": Grade - " + grade);
        }
    }

