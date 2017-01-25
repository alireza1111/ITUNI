package freecell.model;

import static freecell.model.Card.Rank;
import static freecell.model.Card.Suit;

public class Foundation extends AbstractPile {

	@Override
	public boolean canMoveFrom(Pile other) {
		if (other.isEmpty()) {
			return false;
		}
		Rank otherRank = other.topCard().rank;
		Suit otherSuit = other.topCard().suit;
		if (isEmpty()) {
			return otherRank == Rank.ACE;
		}
		Rank thisRank = topCard().rank;
		Suit thisSuit = topCard().suit;
		return otherSuit == thisSuit && otherRank.value == thisRank.value + 1;
	}

	@Override
	public int moveFrom(Pile other) {
		if (canMoveFrom(other)) {
			addCard(other.removeCard());
			return 1;
		}
		return 0;
	}

	@Override
	public void moveFromBlindly(Pile other, int numCards) {
		if (numCards != 1) {
			throw new IllegalArgumentException("numCards must be 1");
		}
		addCard(other.removeCard());
	}

	@Override
	public boolean isInOrder() {
		return true;
	}

}