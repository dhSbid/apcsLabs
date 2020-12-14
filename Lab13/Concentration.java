import java.util.Scanner;

public class Concentration {


    public static void printBoard (Card[][] a) {
        for (int i = 0; i < a[0].length; i++)  {
            print("\t" + (i + 1));
        }
        pr("");

        for (int i = 0; i < a.length; i++) {
            print("" + (i + 1));
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != null) {
                    print("\t" + a[i][j].cardToString());
                } else {
                    print("\t--");
                }
            }
            pr("");

        }
        pr("");
    }

    public static void printBoardFaceUp (Card[][] a) {
        for (int i = 0; i < a[0].length; i++)  {
            print("\t" + (i + 1));
        }
        pr("");

        for (int i = 0; i < a.length; i++) {
            print("" + (i + 1));
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != null) {
                    print("\t" + a[i][j].ignoreFaceUp());
                } else {
                    print("\t--");
                }
            }
            pr("");

        }
        pr("");
    }

    public static void swap (Card[] all, int one, int two) {
        Card storage = all[one];
        all[one] = all[two];
        all[two] = storage;
    }

    public static Card[] createRandomDeck () {
        Card[] rv = Main13.orderedDeck();

        for (int i = 0; i < rv.length; i++) {
            int randNum = (int) (Math.random() * rv.length);
            swap(rv, i, randNum); 
        }

        return rv;
    }

    public static Card[][] createRandomBoard () {
        Card[] deck = createRandomDeck();
        Card[][] board = Main13.makeBoard(deck);
        return board;
    }

    public static int cardsLeft(Card[][] board) {
        int rv = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != null) {
                    rv++;
                }
            }
        }

        return rv;
    }

    public static int max (int[] a) {
        int largest = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                largest = i;
            }
        }

        return largest;
    }

    public static void printScores (int[] a) {
        pr("Current score lineup:");
        for (int i = 0; i < a.length; i++) {
            pr("\tPlayer " + (i + 1) + " has " + a[i] +  " points.");
        }
    }

    public static void play () {
        Scanner scan = new Scanner(System.in);
        Card[][] board = createRandomBoard();
        pr("\n\n");
        pr("(for debugging)");
        printBoardFaceUp(board);

        pr("Number of players: ");
        int players = scan.nextInt();
        if (players < 1) {
            players = 1;
        }
        if (players > Integer.MAX_VALUE){
            players = Integer.MAX_VALUE;
        }
        int[] scores = new int[players];
        int turnNum = 1;

        pr("\n\nStarting game");
        printBoard(board);
        pr("---------------------------------------------");

        while (cardsLeft(board) > 0) {
            Main13.wait(1000);
            pr("\n\nTurn " + turnNum + "--------------------------------------------");
            for (int i = 0; i < players; i++) {
                turn(scan, i, scores, board);
            }
            printScores(scores);
            turnNum++;
        }

        print("Player " + (max(scores) + 1) + " is the winner.");
    }

    public static void turn (Scanner scan, int num, int[] scores, Card[][] board){
        pr("Player " + (num + 1) + "'s turn: ");
        
        int m1 = move(scan, board);
        Card c1 = board[(m1 / 10) - 1][(m1 % 10) - 1];
        if (c1 != null) {
            c1.show();
        }
        printBoard(board);


        int m2 = move(scan, board);
        Card c2 = board[(m2 / 10) - 1][(m2 % 10) - 1];
        if (c2 != null) {
            c2.show();
        }
        printBoard(board);

        if (c1 == null || c2 == null) {
            pr("well, since you chose a card that clearly doesn't exist, enjoy the loss of a turn :/");
            if (c1 != null) {
                c1.hide();
            }
            if (c2 != null) {
                c2.hide();
            }
        } else {
            if (c1.face == c2.face && c1 != c2) {
                board[(m1 / 10) - 1][(m1 % 10) - 1] = null;
                board[(m2 / 10) - 1][(m2 % 10) - 1] = null;           
                scores[num]++;
                pr("\nPoint get!");
                Main13.wait(1000);
                turn(scan, num, scores, board);
            } else {
                c1.hide();
                c2.hide();
            }
        }


    }

    public static int move (Scanner scan, Card[][] board) {
        pr("\tEnter move(rc, ex: 34. 99 for cpu): ");
        int what = scan.nextInt();
        
        while (("" + what).length() != 2) {
            pr("repite, por favor: ");
            what = scan.nextInt();
        }

        if (what == 99) {
            pr("You have declared yourself incapable, a cpu will take over for you. ");
            int rand1 = (int) (Math.random() * 7);
            int rand2 = (int) (Math.random() * 8);
            while (board[rand1][rand2] == null) {
                rand1 = (int) (Math.random() * 7);
                rand2 = (int) (Math.random() * 8);
            }
            
            Main13.wait(1000);
            pr("\nThe Cpu has spoken. Your move was " + (rand1 * 8 + rand2));
            return (rand1 * 8 + rand2);
        }

        if (what % 10 > 8) {    //validating column
            what = what / 10 * 10 + 8;
        } else if (what % 10 < 1) {
            what = what / 10 * 10 + 1;
        }

        if (what / 10 > 7) {    //validating row
            what = what % 10 + 70;
        } else if (what / 10 < 1) {
            what = what % 10 + 10;
        }

        return what;
    }

    public static void pr(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }
}