package freecell.view;

import freecell.model.Pile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class PileView {

	protected static final Color highlight = new Color(1, 1, 0, 0.6);
	protected final Pile pile;
	private boolean isSelected = false;

	public PileView(Pile pile) {
		this.pile = pile;
	}

	public Pile getPile() {
		return pile;
	}

	public abstract void paint(GraphicsContext gc, double x, double y);

	public boolean isSelected() {
		return isSelected;
	}

	public void toggleSelected() {
		isSelected = !isSelected;
	}

}