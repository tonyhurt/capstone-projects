package com.techelevator.inventory;

import java.util.Map;

import com.techelevator.inventory.exception.InventoryReaderException;
import com.techelevator.items.Slot;

public class Inventory {

	private InventoryReader reader;
	
	private Map<String, Slot> slots;
	
	public Inventory(InventoryReader reader) throws InventoryReaderException {
		this.reader = reader;
		stock();
	}
	
	public Map<String, Slot> getSlots() {
		return this.slots;
	}
	
	private void stock() throws InventoryReaderException {
		slots =reader.read();
	}
}
