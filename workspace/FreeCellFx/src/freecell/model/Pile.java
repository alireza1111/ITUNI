package freecell.model;

import freecell.model.Card;

public interface Pile extends Iterable<Card> {

	/**
	 * Adds a card to the top of the pile.
	 */
	void addCard(Card card);

	/**
	 * Removes the top card from the pile.
	 */
	Card removeCard();

	/**
	 * Returns true if the contents of another pile can be moved to this pile.
	 */
	boolean canMoveFrom(Pile other);

	/**
	 * Moves cards from another pile to this pile, if the tryMove is valid.
	 *
	 * @return the number of cards moved (i.e., possibly 0)
	 */
	int moveFrom(Pile other);

	/**
	 * Moves cards from another pile to this pile, whether or not the tryMove is
	 * valid.
	 */
	void moveFromBlindly(Pile other, int numCards);

	/**
	 * Returns the top card in the pile, if a card is present.
	 */
	Card topCard();

	/**
	 * Returns true if the contents of the pile are in order.
	 */
	boolean isInOrder();

	/**
	 * Clears the contents of the pile.
	 */
	void clear();

	/**
	 * Returns true if the pile is empty.
	 */
	boolean isEmpty();

	/**
	 * Returns the size of the pile.
	 */
	int size();

}