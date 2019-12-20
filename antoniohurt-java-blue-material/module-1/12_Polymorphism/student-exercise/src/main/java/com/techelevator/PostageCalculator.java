package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class PostageCalculator {

	public static void main(String[] args) {

		int weightOfThePackageOunces = 15;
		
		int distance = 340;
		
		List<DeliveryDriver> clients = new ArrayList<DeliveryDriver>();
		clients.add(new PostalService(1));
		clients.add(new PostalService(2));
		clients.add(new PostalService(3));
	
		for ( DeliveryDriver driver : clients) {
			System.out.println(driver.getName());
		}
		

	}

}
