package freecell.model;


import freecell.util.DoubleKeyedMap;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Represents a playing card with the ability to turn between its face and
 * backside images.
 */
public class Card {

	private static DoubleKeyedMap<Rank, Suit, Image> faceImages;
	public static final Image backImage = new Image("/freecell/image/Legal.png");
	public static final double width = backImage.getWidth();
	public static final double height = backImage.getHeight();

	public final Rank rank;
	public final Suit suit;
	public final Color color;
	private boolean faceUp;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		this.color = suit.color();
		this.faceUp = false;
	}

	/**
	 * Returns the backside image of a card.
	 */
	public static Image backImage() {
		return backImage;
	}

	/**
	 * Returns the face image of a card.
	 */
	public static Image faceImage(Rank rank, Suit suit) {
		if (faceImages == null) {
			faceImages = new DoubleKeyedMap<>();
		}
		if (!faceImages.contains(rank, suit)) {
			faceImages.put(rank, suit, new Image("/freecell/image/" + rank.value + suit.firstLetter + ".png"));
		}
		return faceImages.get(rank, suit);
	}

	/**
	 * Returns the card's face image if its face is up or its backside image
	 * otherwise.
	 */
	public Image image() {
		return faceUp ? faceImage(rank, suit) : backImage();
	}

	/**
	 * Turns the card over, negating its face up status.
	 */
	public void turn() {
		faceUp = !faceUp;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Card)) {
			return false;
		}
		Card card = (Card) other;
		return rank == card.rank && suit == card.suit;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	public enum Rank {
		ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

		/**
		 * 1 for Ace up to 13 for King.
		 */
		public final int value = ordinal() + 1;
	}

	public enum Suit {
		SPADES, HEARTS, DIAMONDS, CLUBS;

		/**
		 * S for SPADES, H for HEARTS, D for DIAMONDS, or C for CLUBS.
		 */
		public final Character firstLetter = name().charAt(0);

		/**
		 * Black or red.
		 */
		public Color color() {
			return (this == SPADES || this == CLUBS) ? Color.BLACK : Color.RED;
		}
	}
}