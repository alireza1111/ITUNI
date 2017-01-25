package freecell.view;


import freecell.model.Card;
import freecell.model.Game;
import freecell.model.Pile;
import freecell.view.CascadingPileView;
import freecell.view.PileView;
import freecell.view.StackedPileView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class GameCanvas extends Canvas {

	private final Game game;
	private final GraphicsContext gc;
	private final PileView[] pileViews;

	private PileView fromPile;
	private boolean winMessageShown;

	public GameCanvas(Game game, double width, double height) {
		super(width, height);
		this.game = game;
		this.gc = getGraphicsContext2D();
		this.pileViews = constructPileViews(game);
		setOnMouseClicked(new MouseClickHandler());
		updateView();
	}

	private static PileView[] constructPileViews(Game game) {
		List<PileView> list = new ArrayList<>();
		for (Pile pile : game.getCells()) {
			list.add(new StackedPileView(pile));
		}
		for (Pile pile : game.getFoundations()) {
			list.add(new StackedPileView(pile));
		}
		for (Pile pile : game.getTableaux()) {
			list.add(new CascadingPileView(pile));
		}
		return list.toArray(new PileView[16]);
	}

	private void checkEndingConditions() {
		if (winMessageShown) {
			return;
		}
		if (game.isWon()) {
			winMessageShown = true;
			new Alert(Alert.AlertType.INFORMATION, "You won!").showAndWait();
		} else if (game.isLost()) {
			new Alert(Alert.AlertType.INFORMATION, "You lost!").showAndWait();
		}
	}

	private PileView findPile(double x, double y) {
		int columnIndex = 0;
		x -= 15;
		while (x > 90) {
			x -= 90;
			columnIndex++;
		}
		boolean columnPressed = x < Card.width;
		if (!columnPressed) {
			return null;
		}
		if (y > 15 && y < 15 + Card.height) {
			return pileViews[columnIndex];
		}
		if (y > 120) {
			PileView pileView = pileViews[columnIndex + 8];
			Pile pile = pileView.getPile();
			double pileHeight = 120 + (pile.size() - 1) * CascadingPileView.CARD_MARGIN + Card.height;
			if (y < pileHeight) {
				return pileView;
			}
		}
		return null;
	}

	public void updateView() {
		gc.clearRect(0, 0, super.getWidth(), super.getHeight());
		double x = 15;
		for (int i = 0; i < 8; i++) {
			pileViews[i].paint(gc, x, 15);
			x += 90;
		}
		x = 15;
		for (int i = 8; i < 16; i++) {
			pileViews[i].paint(gc, x, 120);
			x += 90;
		}
	}

	public EventHandler<ActionEvent> getNewGameAction() {
		return e -> {
			game.newGame();
			winMessageShown = false;
			if (fromPile != null && fromPile.isSelected()) {
				fromPile.toggleSelected();
			}
			fromPile = null;
			updateView();
		};
	}

	public EventHandler<ActionEvent> getUndoAction() {
		return e -> {
			game.undo();
			updateView();
		};
	}

	public EventHandler<ActionEvent> getRedoAction() {
		return e -> {
			game.redo();
			updateView();
		};
	}

	private class MouseClickHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent e) {
			PileView clickedPile = findPile(e.getX(), e.getY());
			if (clickedPile == null) {
				if (fromPile != null) {
					fromPile.toggleSelected();
				}
				fromPile = null;
				updateView();
				return;
			}
			if (fromPile == null) {
				fromPile = clickedPile;
				fromPile.toggleSelected();
				updateView();
				return;
			}
			if (fromPile == clickedPile) {
				// Double click: try moving to a foundation.
				fromPile.toggleSelected();
				for (int i = 4; i < 8; i++) {
					if (game.tryMove(fromPile.getPile(), pileViews[i].getPile())) {
						checkEndingConditions();
						break;
					}
				}
				fromPile = null;
				updateView();
			} else {
				// Try moving to other cell.
				fromPile.toggleSelected();
				if (game.tryMove(fromPile.getPile(), clickedPile.getPile())) {
					checkEndingConditions();
				}
				fromPile = null;
				updateView();
			}
		}
	}

}