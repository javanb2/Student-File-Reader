package org.example;

import java.util.*;

public class Student {
    private String studentName;
    private Map<String, List<Integer>> grades;

    public Student(String studentName) {
        this.studentName = studentName;
        this.grades = new HashMap<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void addGrade(String subject, int grade){
        grades.putIfAbsent(subject, new ArrayList<>());
        grades.get(subject).add(grade);
    }
    public Map<String, List<Integer>> getGrades() {
        return grades;
    }

    public double getAverage(String subject) {
        List<Integer> gradesList = grades.get(subject);
        return gradesList.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
    public int getMax(String subject) {
        return Collections.max(grades.get(subject));
    }

    public int getMin(String subject) {
        return Collections.min(grades.get(subject));
    }
}
