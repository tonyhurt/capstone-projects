package com.techelevator.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> listOfCards = new ArrayList<Card>();

	private final static String[] suits = { "c", "s", "d", "h" };
	private final static String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };

	public Deck() {

		for (String suit : suits) {
			for (String rank : ranks) {
				Card currentCard = new Card(suit, rank);
				listOfCards.add(currentCard);

			}
		}

	}

	public void shuffle() {
		Collections.shuffle(listOfCards);
	}

	public Card deal() {
		if (size() != 0) {
			return listOfCards.remove(0);
		} else {
			return null;
		}
	}

	public void addCard(Card card) {
		listOfCards.add(card);
	}

	// Delegate method
	public int size() {
		return listOfCards.size();
	}

	private void flip() {
		for (Card card : listOfCards) {
			card.flip();
		}
	}

	public String toString() {
		// flip
		// get the cards as string
		// flip
		// return the string
		String deckAString = "Deck [listOfCards=" + listOfCards + "]";
		flip();
		return deckAString;
	}
}
