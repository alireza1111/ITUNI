package freecell.model;

import freecell.model.Pile;

public class MoveAction implements Action {
	private final Pile fromPile;
	private final Pile toPile;
	private final int numCards;

	public MoveAction(Pile fromPile, Pile toPile, int numCards) {
		this.fromPile = fromPile;
		this.toPile = toPile;
		this.numCards = numCards;
	}

	@Override
	public void redo() {
		toPile.moveFromBlindly(fromPile, numCards);
	}

	@Override
	public void undo() {
		fromPile.moveFromBlindly(toPile, numCards);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof MoveAction)) {
			return false;
		}
		MoveAction action = (MoveAction) other;
		return fromPile == action.fromPile && toPile == action.toPile && numCards == action.numCards;
	}
}
