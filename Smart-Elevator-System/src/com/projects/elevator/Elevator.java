package com.projects.elevator;

public class Elevator {
    private final int id;
    private int currentFloor;
    private State state;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.state = State.IDLE;
    }


    public void moveTo(int targetFloor) {
        int distance = Math.abs(targetFloor - currentFloor);

        if (distance == 0) {
            System.out.println("Elevator " + id + " is already here!");
            return;
        }

        this.state = (targetFloor > currentFloor) ? State.MOVING_UP : State.MOVING_DOWN;

        System.out.println("\n[!] Dispatching Elevator " + id + " from Floor " + currentFloor + " to " + targetFloor + "...");

        while (currentFloor != targetFloor) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Elevator " + id + " movement was interrupted.");
                return;
            }

            if (state == State.MOVING_UP) {
                currentFloor++;
            } else {
                currentFloor--;
            }


            System.out.println("    [ Elevator " + id + " ] passing floor: " + currentFloor + " " + (state == State.MOVING_UP ? "↑" : "↓"));
        }

        this.state = State.IDLE;
        System.out.println("✅ Elevator " + id + " arrived at Floor " + currentFloor + ".\n");
    }


    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public State getState() { return state; }
}