package freecell.model;


import freecell.model.Card;

import java.util.Deque;
import java.util.LinkedList;

public class Tableau extends AbstractPile {

	/**
	 * Maintains the ordering of the cards within the pile.
	 */
	private Deque<Integer> orderStack = new LinkedList<>();

	@Override
	public void addCard(Card card) {
		countAddedCard(card);
		super.addCard(card);
	}

	private void countAddedCard(Card card) {
		if (isEmpty() || orderStack.isEmpty()) {
			orderStack.push(1);
		} else if (card.color != topCard().color && card.rank.value == topCard().rank.value - 1) {
			orderStack.push(orderStack.pop() + 1);
		} else {
			orderStack.push(1);
		}
	}

	@Override
	public Card removeCard() {
		countRemovedCard();
		return super.removeCard();
	}

	private void countRemovedCard() {
		int topInOrder = orderStack.pop();
		if (topInOrder > 1) {
			orderStack.push(topInOrder - 1);
		}
	}

	@Override
	public boolean canMoveFrom(Pile other) {
		if (other.isEmpty()) {
			return false;
		}
		if (isEmpty()) {
			return true;
		}
		int rankDiff = topCard().rank.value - other.topCard().rank.value;
		if (rankDiff < 1) {
			return false;
		}
		if (other instanceof Foundation || other instanceof Cell) {
			return rankDiff == 1 && topCard().color != other.topCard().color;
		}
		if (other instanceof Tableau) {
			int otherTopInOrder = ((Tableau) other).topInOrder();
			if (otherTopInOrder >= rankDiff) {
				switch (rankDiff % 2) {
				case 0:
					return topCard().color == other.topCard().color;
				case 1:
					return topCard().color != other.topCard().color;
				}
			}
		}
		return false;
	}

	@Override
	public int moveFrom(Pile other) {
		if (!canMoveFrom(other)) {
			return 0;
		}
		if (other instanceof Foundation || other instanceof Cell) {
			addCard(other.removeCard());
			return 1;
		}
		if (other instanceof Tableau) {
			if (isEmpty()) {
				// Move all ordered cards to this pile
				int otherTopInOrder = ((Tableau) other).topInOrder();
				moveFrom(other, otherTopInOrder);
				return otherTopInOrder;
			} else {
				// Move ordered cards until they reach the current top card
				int rankDiff = topCard().rank.value - other.topCard().rank.value;
				moveFrom(other, rankDiff);
				return rankDiff;
			}
		}
		throw new IllegalStateException();
	}

	/**
	 * Moves {@code n} cards from the other pile to this pile.
	 */
	private void moveFrom(Pile other, int n) {
		Deque<Card> topCards = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			topCards.addLast(other.removeCard());
		}
		while (!topCards.isEmpty()) {
			addCard(topCards.removeLast());
		}
	}

	@Override
	public void moveFromBlindly(Pile other, int numCards) {
		moveFrom(other, numCards);
	}

	@Override
	public void clear() {
		super.clear();
		orderStack.clear();
	}

	@Override
	public boolean isInOrder() {
		return (orderStack.size() < 2);
	}

	/**
	 * Returns the number of cards in order at the top of the pile.
	 */
	public int topInOrder() {
		return orderStack.size() == 0 ? 0 : orderStack.peek();
	}

	@Override
	public String toString() {
		return orderStack.toString();
	}

}