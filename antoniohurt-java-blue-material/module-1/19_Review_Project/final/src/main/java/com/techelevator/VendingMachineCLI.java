package com.techelevator;

import java.util.Map;

import com.techelevator.inventory.CsvInventoryReader;
import com.techelevator.inventory.Inventory;
import com.techelevator.inventory.InventoryReader;
import com.techelevator.inventory.exception.InventoryReaderException;
import com.techelevator.items.Slot;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;
	private VendingMachine vendingMachine;
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws InventoryReaderException {
		
		String fileName = menu.getFileNameFromUser();
		InventoryReader inventoryReader = new CsvInventoryReader(fileName);
		Inventory inventory = new Inventory(inventoryReader);
		vendingMachine = new VendingMachine(inventory);
		
		
		
		while (true) {
			String choice = (String) menu.getSelectionFromUser(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				displayVendingItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}
	
	private void displayVendingItems() {
		Map<String, Slot> slots = vendingMachine.getItems();
		menu.displayAllItems(slots);
	}

	

	public static void main(String[] args) throws InventoryReaderException {
		Menu menu = new Menu();
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
