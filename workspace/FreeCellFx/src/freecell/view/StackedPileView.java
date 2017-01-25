package freecell.view;

import freecell.model.Pile;
import freecell.model.Card;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StackedPileView extends PileView {

	public StackedPileView(Pile pile) {
		super(pile);
	}

	@Override
	public void paint(GraphicsContext gc, double x, double y) {
		if (pile.isEmpty()) {
			// draw an outline
			gc.setStroke(Color.YELLOW);
			gc.strokeRect(x, y, Card.width, Card.height);
		} else {
			// draw the top card
			gc.drawImage(pile.topCard().image(), x, y);
		}
		if (isSelected()) {
			gc.setFill(highlight);
			gc.fillRect(x, y, Card.width, Card.height);
		}
	}

}