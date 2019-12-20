package com.techelevator.shoppingcart;

public class ShoppingCart {

	private int totalNumberOfItems;
	private double totalAmountOwed;

	private double averagePricePerItem;

	

	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}

	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}  

	public void empty() {
		totalAmountOwed = 0;
		totalNumberOfItems = 0;
	}

	public void addItems(int numberOfItems, double pricePerItem) {
		totalNumberOfItems += numberOfItems;
		totalAmountOwed += (pricePerItem * numberOfItems);
	}

	public double getAveragePricePerItem() {
		if (totalNumberOfItems == 0) {
			return 0.0;
		} else {
			return totalAmountOwed / totalNumberOfItems;

		}

	}

}
