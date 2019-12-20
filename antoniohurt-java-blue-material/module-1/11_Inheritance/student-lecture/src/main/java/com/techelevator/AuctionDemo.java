package com.techelevator;

import java.util.Scanner;

public class AuctionDemo {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		//Auction auction = new Auction("Book");
		BuyoutAuction auction = new BuyoutAuction ("Book", 10);
		Auction auction = buyout;

		System.out.println("Buy my " + auction.getItemForSale());

		while (true) {
			System.out.println("Enter your name >>>");
			String bidder = in.nextLine();
			System.out.println("Place your bid >>>");
			String amount = in.nextLine();

			int bid = Integer.parseInt(amount);

			Bid newBid = new Bid(bidder, bid);

			auction.placeBid(newBid);

			boolean isWinning = auction.placeBid(newBid);
		}

		// BuyoutAuction buyoutAuction = new BuyoutAuction("Record", 10);
		//
		// Auction buy = buyoutAuction;
		// Auction buyout = new BuyoutAuction("", 0);
		//
		//
		//
		// if (buy instanceof BuyoutAuction) {
		// BuyoutAuction backToBuyout = (BuyoutAuction) buy;
		// backToBuyout.
		// }
		// if (auction instanceof BuyoutAuction) {
		// System.out.println("No it isn't");
		// }

	}

}