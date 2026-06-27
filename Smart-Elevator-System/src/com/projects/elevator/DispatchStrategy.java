package com.projects.elevator;

import java.util.List;

public interface DispatchStrategy {
    Elevator selectElevator(List<Elevator> elevators, int targetFloor);
}