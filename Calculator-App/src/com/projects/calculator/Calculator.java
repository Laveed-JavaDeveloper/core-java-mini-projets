package com.projects.calculator;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        // FIXED: Check 'b' (the divisor), not 'a'
        if (b == 0) {
            System.out.println("Error:: Division by zero is not allowed");
            return Double.NaN;
        }
        return a / b;
    }

    public double mod(double a, double b) {
        // FIXED: Check 'b' (the divisor), not 'a'
        if (b == 0) {
            System.out.println("Error:: Modulo Division by zero is not allowed");
            return Double.NaN;
        }
        return a % b;
    }
}