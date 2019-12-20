package com.techelevator.ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticket {

	private BigDecimal price;
	private String ticketType;
	
	
	public Ticket(double price) {
		this(price, "Regular");
	}
	
	public Ticket(double price, String ticketType) {
		this.price = new BigDecimal(price);
		this.ticketType = ticketType;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getTicketType() {
		return ticketType;
	}
	
	public BigDecimal getFee() {
		return price.multiply(new BigDecimal(.20));
	}
	
	public BigDecimal getTotalPrice() {
		BigDecimal totalCost = price.add(getFee());
		totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);
		return totalCost;
	}
	
	public BigDecimal getHalfPrice() {
		return getTotalPrice().divide(new BigDecimal(2)).setScale(2, RoundingMode.HALF_EVEN);
	}
	
	
}
