public class Card {

    public int face;
    public int suit;
    public boolean isFaceUp;

    public static final String[] SUITS = {"S", "H", "C", "D"};
    public static final String[] FACES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K"};

    public Card () {
        face = 0;
        suit = 0;
        isFaceUp = false;
    }

    public Card (int face, int suit, boolean faceUp) {
        //face goes from 0-12
        //suit goes from 0-3
        this.face = clamp(0, 12, face);
        this.suit = clamp(0, 3, suit);
        this.isFaceUp = faceUp;
    }

    public String cardToString () {
        //mwahahaha implicit null check by not making this static
        if (isFaceUp) {
            return SUITS[suit] + FACES[face];
        }
        return "??";
    }

    public String ignoreFaceUp () {
        return SUITS[suit] + FACES[face];
    }

    public void show() {
        isFaceUp = true;
    }

    public void hide() {
        isFaceUp = false;
    }

    public static int clamp (int min, int max, int current) {
        if (current < min) {
            return min;
        } else if (current > max) {
            return max;
        } else {
            return current;
        }
    }
}