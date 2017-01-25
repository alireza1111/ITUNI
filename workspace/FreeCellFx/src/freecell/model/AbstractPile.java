package freecell.model;


import freecell.model.Card;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

abstract class AbstractPile implements Pile {

	private Deque<Card> stack = new ArrayDeque<>();

	@Override
	public void addCard(Card card) {
		stack.push(card);
	}

	@Override
	public Card removeCard() {
		return stack.pop();
	}

	@Override
	public Card topCard() {
		return stack.peek();
	}

	@Override
	public void clear() {
		stack.clear();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public int size() {
		return stack.size();
	}

	@Override
	public Iterator<Card> iterator() {
		return stack.descendingIterator();
	}

}