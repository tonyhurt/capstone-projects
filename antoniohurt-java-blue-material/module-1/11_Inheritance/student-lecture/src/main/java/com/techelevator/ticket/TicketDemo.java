package com.techelevator.ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDemo {

	public static void main(String[] args) {

		Ticket regularTicket = new Ticket(25);

		System.out.println("Total Price: " + regularTicket.getTotalPrice());

		WillCallTicket willCallTicket = new WillCallTicket(20, "John");

		System.out.println("Total Will Call Price: " + willCallTicket.getTotalPrice());
		
		Under21Ticket minorTicket = new Under21Ticket(15, 3);
		
		System.out.println("Total Under 21 Price: " + minorTicket.getTotalPrice);
		
		Ticket ticket2 = new WillCallTicket(19, "Steve");
		Ticket ticket3 = new Under21Ticket(14, 2);
		Ticket ticket4 = new Ticket(80);
		
		List<Ticket> ticketsSold = new ArrayList<Ticket>();
		
		ticketsSold.add(regularTicket);
		ticketsSold.add(ticket4);
		ticketsSold.add(ticket2);
		ticketsSold.add(ticket3);
		ticketsSold.add(WillCallTicket);
		ticketsSold.add(minorTicket);
		
		for (Ticket t : ticketsSold) {
			System.out.println(t.getTicketType() + " : " + t.getTotalPrice() + " - " + t.getHalfPrice());
		}
		
	}

}
