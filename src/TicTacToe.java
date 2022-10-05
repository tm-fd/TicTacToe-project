
public class TicTacToe {

    public static void main(String[] args) {
        Board board = new Board();
        boolean gameOn = true;
        // clean out the arrays
        board.startGame();
        // loops the tic-tac-toe game while the game is on
        do {
            board.initBoard();
            // Other player plays
            Player.playerSign();
            do {
                Player.startPlay(board);
            } while (!board.checkUserInput);

            //Checks if the game is over
            if (board.gameOver()) {
                board.winner();
            } else if (board.checkNoWinGame()) {
                board.noWinner();
            }
        }while (gameOn);
    }
}
