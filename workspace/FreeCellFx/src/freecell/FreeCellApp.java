package freecell;


import freecell.model.Game;
import freecell.view.GameCanvas;
import freecell.view.GameMenuBar;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FreeCellApp extends Application {

	public static void main(String[] args) {
		launch(FreeCellApp.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setBackground(new Background(new BackgroundImage(new Image("/freecell/image/background.png"), BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

		Game game = new Game();
		GameMenuBar menuBar = new GameMenuBar();
		GameCanvas canvas = new GameCanvas(game, 731, 600);
		menuBar.setNewGameAction(canvas.getNewGameAction());
		menuBar.setUndoAction(canvas.getUndoAction());
		menuBar.setRedoAction(canvas.getRedoAction());
		menuBar.setExitAction(e -> Platform.exit());
		root.getChildren().addAll(menuBar, canvas);
		Scene scene = new Scene(root);

		stage.setTitle("FreeCell-Fx");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

}