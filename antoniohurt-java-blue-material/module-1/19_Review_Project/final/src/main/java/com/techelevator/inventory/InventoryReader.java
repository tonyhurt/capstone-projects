package com.techelevator.inventory;

import java.util.Map;

import com.techelevator.inventory.exception.InventoryReaderException;
import com.techelevator.items.Slot;

public interface InventoryReader {

	public Map<String, Slot> read() throws InventoryReaderException ;
	
}
