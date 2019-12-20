package com.techelevator.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.inventory.exception.InventoryReaderException;
import com.techelevator.items.Candy;
import com.techelevator.items.Chips;
import com.techelevator.items.Drink;
import com.techelevator.items.Gum;
import com.techelevator.items.Item;
import com.techelevator.items.Slot;

public class CsvInventoryReader implements InventoryReader {

	private String fileName;
	
	public CsvInventoryReader(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public Map<String, Slot> read() throws InventoryReaderException {
		
		Map<String, Slot> slots = new LinkedHashMap<String, Slot>();
		
		File file = new File(fileName);
		
		try (Scanner fileScanner = new Scanner(file)) {
			
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] parts = line.split("\\|");
				slots.put(parts[0], createSlotFromParts(parts));
			}
			
		} catch (FileNotFoundException e) {
			throw new InventoryReaderException(e);
		}
		
		
		return slots;
	}
	
	private Slot createSlotFromParts(String[] parts) {
		
		Item item = null;
		double price = Double.parseDouble(parts[2]);
		
		switch (parts[3]) {
			case "Chip":
				item = new Chips(parts[1], price );
				break;
			case "Candy":
				item = new Candy(parts[1], price);
				break;
			case "Drink":
				item = new Drink(parts[1], price);
				break;
			case "Gum":
				item = new Gum(parts[1], price);
				break;
		}
		
		//TODO: Replace magic number
		return new Slot(item, 5);
	}

}
