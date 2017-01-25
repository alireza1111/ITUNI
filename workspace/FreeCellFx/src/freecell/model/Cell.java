package freecell.model;


public class Cell extends AbstractPile {

	@Override
	public boolean canMoveFrom(Pile other) {
		return isEmpty() && !other.isEmpty();
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