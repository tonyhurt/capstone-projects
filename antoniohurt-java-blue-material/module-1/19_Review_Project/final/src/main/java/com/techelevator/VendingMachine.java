package com.techelevator;

import java.util.Map;

import com.techelevator.inventory.Inventory;
import com.techelevator.items.Slot;

public class VendingMachine {

	private Inventory inventory;
	
	public VendingMachine(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Map<String, Slot> getItems() {
		return inventory.getSlots();
	}
	
}
