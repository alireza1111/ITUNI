package freecell.model;


import java.util.Deque;
import java.util.LinkedList;

import freecell.model.MoveAction;

/**
 * Records moves to enable redo and undo actions.
 */
public class MoveTracker {

	private final Deque<MoveAction> nextMoves = new LinkedList<>();
	private final Deque<MoveAction> previousMoves = new LinkedList<>();

	public void clearMoves() {
		nextMoves.clear();
		previousMoves.clear();
	}

	public boolean hasLastMove() {
		return !previousMoves.isEmpty();
	}

	public MoveAction getLastMove() {
		MoveAction lastMove = previousMoves.pop();
		nextMoves.push(lastMove);
		return lastMove;
	}

	public boolean hasNextMove() {
		return !nextMoves.isEmpty();
	}

	public MoveAction getNextMove() {
		MoveAction nextMove = nextMoves.pop();
		previousMoves.push(nextMove);
		return nextMove;
	}

	public void addMove(MoveAction move) {
		MoveAction nextMove = nextMoves.peek();

		/*
		 * If there is a saved next move and it differs from the player's move,
		 * clear the remaining next moves because the paths have diverged.
		 */
		if (move.equals(nextMove)) {
			nextMoves.pop();
		} else {
			nextMoves.clear();
		}
		previousMoves.push(move);
	}

}