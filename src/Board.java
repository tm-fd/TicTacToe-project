public class Board {
    // game rows and columns number
    private final int row = 3;
    private final int col = 3;
    // To count filled cell in the game
    public static int count = 0;
    // Define the game board as 2d array of chars
    private final char[][] board = new char[row][col];
    // To check if the cell is already filled or not
    boolean checkUserInput = true;

    //initialize a board
    public void initBoard() {
        System.out.println("  0 1 2  ");
        for (int row = 0; row < this.row; row++) {
            if (row == 0) {
                System.out.print('0');
            } else if (row == 1) {
                System.out.print('1');
            } else {
                System.out.print('2');
            }
            // one separator for every row
            System.out.print('|');
            for (int col = 0; col < this.col; col++) {
                System.out.print(board[row][col]);
                // one separator after every row and column
                System.out.print('|');
            }
            // new line
            System.out.println();
        }
        System.out.println("_____________");
    }

    //start new game with empty rows and columns
    public void startGame() {
        System.out.println("################ New game ################");
        for (int row = 0; row < this.row; row++) {
            for (int col = 0; col < this.col; col++) {
                board[row][col] = ' ';
            }
        }
    }

    // Put the user input in the board array
    public void getUserInputs(int x, int y, char input) {
        if (board[x][y] == 'X' || board[x][y] == 'O') {
            // Same player try again
            System.out.println("This cell has already been selected. Please try again.");
            checkUserInput = false;
            // Same player still playing
            Player.player1 = !Player.player1;
        } else {
            board[x][y] = input;
            checkUserInput = true;
            count++;
        }
    }

    // Check if there are similar three signs in row
    private boolean checkPlayerInput(char first, char second, char third) {
        return (first != ' ' && first == second && second == third);
    }

    // Check for the similar diagonal signs
    private boolean checkDiagonal() {
        return ((checkPlayerInput(board[0][0], board[1][1], board[2][2])) || (checkPlayerInput(board[0][2], board[1][1], board[2][0])));
    }

    // Check if there are similar signs in row in rows
    private boolean checkRows() {
        for (int row = 0; row < this.row; row++) {
            if (checkPlayerInput(board[row][0], board[row][1], board[row][2])) {
                return true;
            }
        }
        return false;
    }

    // Check if there are similar signs in row in columns
    private boolean checkCols() {
        for (int col = 0; col < this.col; col++) {
            if (checkPlayerInput(board[0][col], board[1][col], board[2][col])) {
                return true;
            }
        }
        return false;
    }

    // Check if the board is full of signs but no winners
    public boolean checkNoWinGame() {
        return (count == 9 && !(checkRows() || checkCols() || checkDiagonal()));
    }

    // Check for winners
    public boolean gameOver() {
        return (checkRows() || checkCols() || checkDiagonal());
    }

    // Print the winner
    public void winner() {
        System.out.println("{*}{*}{*}{*}{*}{*}{*}  " + Player.getPlayer() + " Player Wins!" + "  {*}{*}{*}{*}{*}{*}{*}");
        count = 0;
        initBoard();
        startGame();
    }

    // Print out no winner game
    public void noWinner() {
        System.out.println("/////////////// No winner ///////////////");
        count = 0;
        initBoard();
        startGame();
    }
}