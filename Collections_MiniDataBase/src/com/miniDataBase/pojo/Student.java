package com.miniDataBase.pojo;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

// student class implements Serializable
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //Student fields
    private int studentNumber;
    private String studentName;
    private String course;
    private double fee;

    // parameterized constructor
    public Student(int studentNumber, String studentName, String course, double fee) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.course = course;
        this.fee = fee;
    }

    // getters & setters
    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getFee() {
        return fee;
    }

    // FIX: Renamed to setFee to match your StudentDataBase
    public void setFee(double fee) {
        this.fee = fee;
    }

    // equals using instanceof pattern matching
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Student other) {
            return this.studentNumber == other.studentNumber && this.course.equalsIgnoreCase(other.course);
        }
        return false;
    }

    // override hashCode  to prevent hashing errors
    @Override
    public int hashCode() {
        return Objects.hash(studentNumber, course.toLowerCase());
    }

    // OverRiding toString() to implement custom logic
    @Override
    public String toString() {
        return studentNumber + " | " + studentName + " | " + course + " | " + fee;
    }
}