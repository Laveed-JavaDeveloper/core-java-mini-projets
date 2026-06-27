package com.projects.calculator;
import com.projects.calculator.Calculator;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calc = new Calculator(); // Instance of our calculator logic

        System.out.println("=========Simple_Calculator_App=========");

        System.out.print("Enter Value For Number 1 :: ");
        double num1 = scan.nextDouble();

        System.out.print("Enter Any 1 Operator (+, -, *, /, %) :: ");
        char op = scan.next().charAt(0);

        System.out.print("Enter Value For Number 2 :: ");
        double num2 = scan.nextDouble();

        double result = 0;
        boolean validOperation = true;

        switch (op) {
            case '+':
                result = calc.add(num1, num2);
                break;
            case '-':
                result = calc.subtract(num1, num2);
                break;
            case '*':
                result = calc.multiply(num1, num2);
                break;
            case '/':
                result = calc.divide(num1, num2);
                // If division resulted in NaN, we shouldn't treat it as a normal success printout
                if (Double.isNaN(result)) validOperation = false;
                break;
            case '%':
                result = calc.mod(num1, num2);
                if (Double.isNaN(result)) validOperation = false;
                break;
            default:
                System.out.println("Error: Invalid Operator Entered");
                validOperation = false; // FIXED: Set to false so it doesn't print the final layout
                break;
        }

        if (validOperation) {
            System.out.println("------------------------------------------");
            System.out.println("THE RESULT OF " + num1 + " " + op + " " + num2 + " : " + result);
            System.out.println("==========================================");
        }

        scan.close();
    }
}