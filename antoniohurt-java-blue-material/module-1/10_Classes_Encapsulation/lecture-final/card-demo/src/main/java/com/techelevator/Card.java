package com.techelevator;

public class Card {

	private String suit;
	private String rank;
	private boolean faceUp = false;
	private boolean vertical = true;
	
	
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}
	
	public boolean rotate() {
		vertical = !vertical;
		return vertical;
	}
	
	public String getSuit() {
		return suit;
	}
	public String getRank() {
		return rank;
	}
	public boolean isFaceUp() {
		return faceUp;
	}
	public boolean isVertical() {
		return vertical;
	}
	
	@Override
	public String toString() {
		if (faceUp) {
			return rank + suit;
		} else {
			return "##";
		}
	}
	
}
