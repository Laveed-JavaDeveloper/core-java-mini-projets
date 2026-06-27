package com.projects.elevator;
import java.util.Scanner;

public class SmartElevatorSimulation {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {


            ElevatorController controller = new ElevatorController(3, new ClosestElevatorStrategy());

            System.out.println("==========================================");
            System.out.println("   SMART ELEVATOR SYSTEM (OOP DEMO)       ");
            System.out.println("==========================================");
            controller.printSystemStatus();

            while (true) {
                System.out.print("\nEnter floor to request (0-10) or -1 to exit: ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty. Please enter a choice.");
                    continue;
                }

                try {
                    int floor = Integer.parseInt(input);

                    if (floor == -1) {
                        System.out.println("System shutting down...");
                        break;
                    }
                    if (floor < 0 || floor > 10) {
                        System.out.println("Invalid floor. Please choose 0-10.");
                        continue;
                    }

                    controller.requestElevator(floor);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
        }
    }
}