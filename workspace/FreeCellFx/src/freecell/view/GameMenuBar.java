package freecell.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class GameMenuBar extends MenuBar {

	private final MenuItem newGame;
	private final MenuItem undoMove;
	private final MenuItem redoMove;
	private final MenuItem exitGame;

	public GameMenuBar() {
		super();
		newGame = new MenuItem("New");
		undoMove = new MenuItem("Undo");
		redoMove = new MenuItem("Redo");
		exitGame = new MenuItem("Exit");
		setAccelerators();
		Menu gameMenu = new Menu("Game");
		gameMenu.getItems().addAll(newGame, undoMove, redoMove, exitGame);
		super.getMenus().add(gameMenu);
	}

	private void setAccelerators() {
		newGame.setAccelerator(new KeyCodeCombination(KeyCode.F2));
		undoMove.setAccelerator(new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN));
		redoMove.setAccelerator(new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN));
		exitGame.setAccelerator(new KeyCodeCombination(KeyCode.ESCAPE));
	}

	public void setNewGameAction(EventHandler<ActionEvent> handler) {
		newGame.setOnAction(handler);
	}

	public void setUndoAction(EventHandler<ActionEvent> handler) {
		undoMove.setOnAction(handler);
	}

	public void setRedoAction(EventHandler<ActionEvent> handler) {
		redoMove.setOnAction(handler);
	}

	public void setExitAction(EventHandler<ActionEvent> handler) {
		exitGame.setOnAction(handler);
	}

}