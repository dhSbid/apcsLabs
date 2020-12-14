public class Main13 {
    public static void main(String[] args) {
        assert true;
        Card[][] board = Concentration.createRandomBoard();
        Concentration.printBoard(board);
        wait(1500);
        pr("\n\n\n");
        pr("Debugging: ");
        Concentration.printBoardFaceUp(board);
        pr("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        Concentration.play();



        //Card[] a = orderedDeck();
        //Card[][] b = makeBoard(a);
        //Concentration.printBoard(b);
        //pr("\n\n\n");
        //Concentration.printBoardFaceUp(b);
    }

    public static void pr(String s) {
        System.out.println(s);
    }

    public static Card[] orderedDeck () {
        Card[] rv = new Card[52];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = new Card(i % 13, i / 13, false);
        }
        return rv;
    }

    public static Card[][] makeBoard(Card[] deck) {
        Card[][] rv = new Card[7][8];

        //for (int i = 0; i < deck.length; i++) {
        //    rv[i / rv.length][i % rv.length] = deck[i];
        //}
        int row = -1;
        for (int i = 0; i < deck.length; i++) {
            if (i % 8 == 0) {
                row++;
            }
            rv[row][i % 8] = deck[i];
        }

        return rv;
    }

    public static void wait(int ms) { //adding a delay, in case I decide to add cpus
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}