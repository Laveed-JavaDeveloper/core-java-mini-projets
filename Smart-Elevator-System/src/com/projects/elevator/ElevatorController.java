package com.projects.elevator;
import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;
    private final DispatchStrategy strategy;

    public ElevatorController(int numElevators, DispatchStrategy strategy) {
        this.elevators = new ArrayList<>();
        this.strategy = strategy;

        // Initialize Elevators
        for (int i = 1; i <= numElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public void requestElevator(int destinationFloor) {
        System.out.println("\n>>> Request received for Floor: " + destinationFloor);


        Elevator selected = strategy.selectElevator(elevators, destinationFloor);

        if (selected == null) {
            System.out.println(">>> Error: No available elevators to service the request.");
            return;
        }

        System.out.println(">>> System selected Elevator " + selected.getId() + " (Currently at Floor " + selected.getCurrentFloor() + ")");


        selected.moveTo(destinationFloor);

        printSystemStatus();
    }

    public void printSystemStatus() {
        System.out.println("--- SYSTEM STATUS ---");
        for (Elevator e : elevators) {
            System.out.printf("[ E%d | Floor %d | %s ] ", e.getId(), e.getCurrentFloor(), e.getState());
        }
        System.out.println("\n---------------------");
    }
}