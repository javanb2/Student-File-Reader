package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileScanner {
    private Map<String, Student> students = new HashMap<>();
    public void addFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                String name = data[0].trim();
                students.putIfAbsent(name, new Student(name));
                String subject = data[1].trim();
                int grade = Integer.parseInt(data[2].trim());
                students.get(name).addGrade(subject, grade);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void printStats() {
        for (Student student : students.values()) {
            System.out.println("Student: " + student.getStudentName());
            for (String subject : student.getGrades().keySet()) {
                System.out.printf("  %s: Avg=%.2f, High=%d, Low=%d%n",
                        subject,
                        student.getAverage(subject),
                        student.getMax(subject),
                        student.getMin(subject));
            }
        }
    }

}
