package com.projects.elevator;
import java.util.ArrayList;
import java.util.List;

public class ClosestElevatorStrategy implements DispatchStrategy {
    @Override
    public Elevator selectElevator(List<Elevator> elevators, int targetFloor) {
        if (elevators == null || elevators.isEmpty()) {
            return null;
        }

        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - targetFloor);

            if (distance < minDistance) {
                minDistance = distance;
                bestElevator = e;
            }
        }
        return bestElevator;
    }
}
