package com.techelevator.TollBoothCalculator;

import java.util.ArrayList;
import java.util.List;

public class TollCalculator {  

	public static void main(String[] args) {
		List<Vehicle> vehicleToll = new ArrayList<Vehicle>();

		Car carNoTrailer = new Car(0, false);
		Car carWithTrailer = new Car(0, false);
		Tank tank = new Tank(0);
		Truck truck = new Truck(0);

		vehicleToll.add(carNoTrailer);
		vehicleToll.add(carWithTrailer);
		vehicleToll.add(tank);
		vehicleToll.add(truck);

Vehicle[] listOfVehicles = {carNoTrailer, carWithTrailer, tank, truck};
		
		System.out.printf("%-15s%-26s%-22s\n","Vehicle","Distance Traveled","Toll $");
		System.out.println("-----------------------------------------------");
		
		for(Vehicle thisVehicle : listOfVehicles) {
			String thisCar = thisVehicle.getClass().getSimpleName();
			int distance = (int) (Math.random()*240+10);
			double toll = thisVehicle.calculateToll(distance);
			System.out.printf("%-15s%-26s%-22s\n",thisCar,distance,toll);
		}

	}

}