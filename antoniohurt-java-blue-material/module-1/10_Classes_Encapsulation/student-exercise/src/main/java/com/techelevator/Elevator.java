package com.techelevator;

public class Elevator {

private int currentFloor = 1;
private int numberOfFloors;
private boolean doorOpen;
//this.numberOfFloors points to the private variables

public Elevator(int totalNumberOfFloors) {
    this.numberOfFloors = totalNumberOfFloors;
}

//adding in
public void openDoor() {
    this.doorOpen = true;
}

public void closeDoor() {
    this.doorOpen = false;
}

public void goUp(int desiredFloor) {
    //open door 
    //desired floor has to be <= numberOfFloors
            //desiredFloor > currentFloor
    //if dooropen = to false
    if(!doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
        this.currentFloor = desiredFloor;
    }
     
}

public void goDown(int desiredFloor) {
    //closed door
    //desiredFloor >= 1
    //desiredFloor < currentFloor
    if(!doorOpen && desiredFloor >= 1 && desiredFloor < currentFloor) {
        this.currentFloor = desiredFloor;
    }
}

public int getCurrentFloor() {
    return currentFloor;
}
public int getNumberOfFloors() {
    return numberOfFloors;
}
public boolean isDoorOpen() {
    return doorOpen;
}
}
