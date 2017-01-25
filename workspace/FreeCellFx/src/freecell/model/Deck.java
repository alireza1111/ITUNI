package freecell.model;


import freecell.model.Card.Rank;
import freecell.model.Card.Suit;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a deck with the ability to deal and shuffle.
 */
public class Deck {

	private Deque<Card> cards = new LinkedList<>();

	private Deck() {
	}

	/**
	 * Makes a 52-card, unshuffled deck.
	 */
	public static Deck newDeck() {
		Deck deck = new Deck();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				deck.cards.push(new Card(rank, suit));
			}
		}
		return deck;
	}

	/**
	 * Deals a card from the top of the deck.
	 */
	public Card deal() {
		return cards.pop();
	}

	/**
	 * Shuffles the deck.
	 */
	@SuppressWarnings("unchecked")
	public void shuffle() {
		Collections.shuffle((List<Card>) cards);
	}

	@Override
	public String toString() {
		return cards.toString();
	}
}