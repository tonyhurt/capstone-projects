package com.techelevator.ticket;

import java.math.BigDecimal;

public class Under21Ticket {
	
	public class Under21Ticket extends Ticket {
		
		private BigDecimal upCharge;
		
		public Under21Ticket(double price, double noDrinkSurcharge) {
			super(price, "Under 21");
			upCharge = new BigDecimal(noDrinkSurcharge);
		}
		
		@Override
		public BigDecimal getFee() {
			return super.getFee().add(upCharge);
		}
	}

}
