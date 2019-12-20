package com.techelevator.items;

public class Slot {

	private Item item;
	private int stock;
	
	public Slot(Item item, int stock) {
		this.item = item;
		this.stock = stock;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public boolean isSoldOut() {
		return stock < 1;
	}
	
}
