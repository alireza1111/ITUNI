package freecell.model;



import java.util.ArrayList;
import java.util.List;

import freecell.model.MoveAction;
import freecell.model.Cell;
import freecell.model.Foundation;
import freecell.model.Pile;
import freecell.model.Tableau;

public class Game {
	private List<Cell> cells = new ArrayList<>(4);
	private List<Foundation> foundations = new ArrayList<>(4);
	private List<Tableau> tableaux = new ArrayList<>(8);
	private MoveTracker moveTracker = new MoveTracker();

	public Game() {
		for (int i = 0; i < 4; i++) {
			cells.add(new Cell());
			foundations.add(new Foundation());
		}
		for (int i = 0; i < 8; i++)
			tableaux.add(new Tableau());
		newGame();
	}

	public List<Cell> getCells() {
		return cells;
	}

	public List<Foundation> getFoundations() {
		return foundations;
	}

	public List<Tableau> getTableaux() {
		return tableaux;
	}

	/**
	 * Moves cards from one pile to another, if the move is valid.
	 */
	public boolean tryMove(Pile fromPile, Pile toPile) {
		int cardsMoved = toPile.moveFrom(fromPile);
		if (cardsMoved > 0) {
			moveTracker.addMove(new MoveAction(fromPile, toPile, cardsMoved));
			return true;
		}
		return false;
	}

	/**
	 * Redo a move that was previously undone.
	 *
	 * @return true if another redo can be performed
	 */
	public boolean redo() {
		if (moveTracker.hasNextMove()) {
			moveTracker.getNextMove().redo();
		}
		return moveTracker.hasNextMove();
	}

	/**
	 * Undo a previous move.
	 *
	 * @return true if another undo can be performed
	 */
	public boolean undo() {
		if (moveTracker.hasLastMove()) {
			moveTracker.getLastMove().undo();
		}
		return moveTracker.hasLastMove();
	}

	/**
	 * Returns true if the game cannot be lost.
	 */
	public boolean isWon() {
		for (Pile pile : tableaux) {
			if (!pile.isInOrder()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if the game cannot be won.
	 */
	public boolean isLost() {
		// Are free cells full?
		for (Pile pile : cells) {
			if (pile.isEmpty()) {
				return false;
			}
		}
		// Can you not move to any tableau?
		for (Pile pile : tableaux) {
			for (Pile tableau : tableaux) {
				if (pile.canMoveFrom(tableau)) {
					return false;
				}
			}
			for (Pile cell : cells) {
				if (pile.canMoveFrom(cell)) {
					return false;
				}
			}
		}
		// Can you not move to any home cell?
		for (Pile pile : foundations) {
			for (Pile tableau : tableaux) {
				if (pile.canMoveFrom(tableau)) {
					return false;
				}
			}
			for (Pile cell : cells) {
				if (pile.canMoveFrom(cell)) {
					return false;
				}
			}
		}
		return true;
	}

	public void newGame() {
		Deck deck = Deck.newDeck();
		deck.shuffle();
		moveTracker.clearMoves();
		tableaux.forEach(Pile::clear);
		cells.forEach(Pile::clear);
		foundations.forEach(Pile::clear);
		// Deal 6 cards to each tableau.
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				Card card = deck.deal();
				card.turn();
				tableaux.get(j).addCard(card);
			}
		}
		// Deal an additional card to first 4.
		for (int i = 0; i < 4; i++) {
			Card card = deck.deal();
			card.turn();
			tableaux.get(i).addCard(card);
		}
	}

}