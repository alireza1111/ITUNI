package freecell.view;



import freecell.model.Pile;
import freecell.model.Card;
import freecell.model.Tableau;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CascadingPileView extends PileView {

	public static final int CARD_MARGIN = 22;
	public static final int TOP_MARGIN = 0;

	public CascadingPileView(Pile pile) {
		super(pile);
	}

	@Override
	public void paint(GraphicsContext gc, double x, double y) {
		if (pile.isEmpty()) {
			// draw an outline
			gc.setStroke(Color.YELLOW);
			gc.strokeRect(x, y, Card.width, Card.height);
			if (isSelected()) {
				// highlight empty cell
				gc.setFill(highlight);
				gc.fillRect(x, y, Card.width, Card.height);
			}
		} else {
			double yCurrent = y;
			// draw the cards in a cascade from top to bottom
			for (Card card : pile) {
				gc.drawImage(card.image(), x, yCurrent);
				yCurrent += CARD_MARGIN;
			}
			if (isSelected()) {
				// highlight ordered cards
				if (yCurrent > TOP_MARGIN) {
					yCurrent -= CARD_MARGIN;
				}
				int multiplier = ((Tableau) pile).topInOrder();
				int heightOfRect = (multiplier - 1) * CARD_MARGIN;
				gc.setFill(highlight);
				gc.fillRect(x, yCurrent - heightOfRect, Card.width, heightOfRect + Card.height);
			}
		}
	}

}