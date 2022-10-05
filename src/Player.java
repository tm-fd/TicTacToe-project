import java.util.Scanner;

public class Player {
    static Scanner input = new Scanner(System.in);
    //To check which player is playing
    static boolean player1 = true;
    private static char player;

    //getter for the player
    public static char getPlayer() {
        return player;
    }

    //sign letter to the player
    public static void playerSign() {
        if (player1) {
            player = 'X';
            System.out.println("Player 1 has sign 'X'");
        } else {
            player = 'O';
            System.out.println("Player 2 has sign 'O'");
        }
    }
    //get player's input X or O
    public static void startPlay(Board board) {
        //Row and Col
        int x;
        int y;
        //Get user entries (row and col)
        do {
            System.out.println("Please choose a row number");
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Please enter 0, 1 or 2");
            }
            x = input.nextInt();
        } while (x < 0 || x > 2);
        do {
            System.out.println("Please choose a column number");
            while (!input.hasNextInt()) {
                String st = input.next();
                System.out.println("Please enter 0, 1 or 2");
            }
            y = input.nextInt();
        } while (y < 0 || y > 2);
        //change the player
        player1 = !player1;
        //The player's char is placed into the array only if it is open
        board.getUserInputs(x, y, player);

    }
}
