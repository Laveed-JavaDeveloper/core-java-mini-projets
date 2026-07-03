package com.miniDataBase.model;

import java.io.*;
import java.util.*;

import com.miniDataBase.pojo.Student;

public class StudentDataBase {
    private static final String FILE_NAME = "Students.ser";
    private final List<Student> studentList;

    public StudentDataBase() {
        this.studentList = loadFromFile();
    }

    // ADD
    public void add(Student s) {
        studentList.add(s);
        saveToFile();
    }

    // COUNT
    public int count() {
        return studentList.size();
    }

    // RETURN EMPTY LIST
    public boolean isEmpty() {
        return studentList.isEmpty();
    }

    // GET ALL DETAILS
    public List<Student> getAll() {
        return studentList;
    }

    // SEARCH
    public boolean exists(int studentNumber, String course, String studentName) {
        Student temp = new Student(studentNumber, "", course, 0);
        return studentList.contains(temp);
    }

    // RETRIEVE
    public Student retrieve(int studentNumber, String course) {
        Student temp = new Student(studentNumber, "", course, 0);
        int index = studentList.indexOf(temp);

        if (index != -1) {
            return studentList.get(index);
        }
        return null;
    }

    // UPDATE
    public boolean update(int studentNumber, String course, String studentName, double fee) {
        // FIX: Changed 'sno' to 'studentNumber' to match the parameter
        Student s = retrieve(studentNumber, course);

        if (s != null) {
            s.setStudentName(studentName);
            s.setFee(fee);
            saveToFile();
            return true;
        }
        return false;
    }

    // REMOVE
    public boolean remove(int studentNumber, String course) {
        Student temp = new Student(studentNumber, "", course, 0);
        boolean removed = studentList.remove(temp);

        if (removed) {
            saveToFile();
        }
        return removed;
    }

    // REPLACE
    public boolean replace(int index, Student s) {
        if (index >= 0 && index < studentList.size()) {
            studentList.set(index, s);
            saveToFile();
            return true;
        }
        return false;
    }

    // INSERT
    public boolean insert(int index, Student s) {
        if (index >= 0 && index <= studentList.size()) {
            studentList.add(index, s);
            saveToFile();
            return true;
        }
        return false;
    }

    // SAVE
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);
        } catch (IOException e) {
            System.err.println("Error saving database to file: " + e.getMessage());
        }
    }

    // LOAD
    @SuppressWarnings("unchecked")
    private List<Student> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Student>) ois.readObject();
        } catch (Exception e) {
            System.err.println("Error loading database, creating new dataset: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
