package homework5;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class that holds helper methods that help play the game.
 * 
 * @author brian
 *
 */
public class Play {
    /**
     * Class to run the game. Only contains main method and helper variables and
     * methods.
     * 
     * @author brian
     *
     */
    static class Runner {
        /**
         * Checks to see if the game is still being played.
         */
        private static boolean play = true;
        /**
         * Checks to see if a player is currently redoing their move.
         */
        private static boolean redo = false;
        /**
         * Scanner object.
         */
        public static Scanner sc = new Scanner(System.in);
        /**
         * X coordinate of the last move.
         */
        private static int lastX = 0;
        /**
         * Y coordinate of the last move.
         */
        private static int lastY = 0;

        /**
         * Main method. Starts the game then gets user input for changing moves
         * and move coordinates.
         * 
         * @param args
         */
        public static void main(String[] args) {
            Play.firstMove();
            int count = 0;
            while (play) {
                count++;
                System.out.println(Board.getBoard());
                if (count > 1) {
                    System.out.print("Press Y to change your last move: ");
                }
                if (count == 1 || sc.next().toUpperCase().equals("Y")) {
                    changeMove();
                    System.out.print(move + " make your move(x y): ");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    redo = true;
                    Board.removeMove(lastX, lastY);
                    runGame(x, y);
                } else {
                    System.out.print(move + " make your move(x y): ");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    runGame(x, y);
                }
            }
        }

        /**
         * Helper method that runs the game.
         * 
         * @param x x coordinate of move.
         * @param y y coordinate of move.
         */
        public static void runGame(int x, int y) {
            if (Board.checkEmptySpot(x, y) || redo) {
                redo = false;
                addMove(x, y);
                lastX = x;
                lastY = y;
                changeMove();
            } else {
                System.out.println("BAD MOVE");
            }
            if (Win.checkWin() != '-') {
                System.out.println(Win.checkWin() + " wins!");
                play = false;
                System.out.println(Board.getBoard());
                System.out.print("Press Y to play again: ");
                if (sc.next().toUpperCase().equals("Y")) {
                    play = true;
                    Board.newGame();
                }
            }
        }

    }

    /**
     * The current move, can be either X or O.
     */
    private static char move;

    /**
     * Adds a move to the board using helper methods from the Board class.
     * 
     * @param x X coordinate of move being added.
     * @param y Y coordinate of move being added.
     */
    public static void addMove(int x, int y) {
        Board.setBoard(Board.getBoard().substring(0, Board.findIndex(x, y))
                + move
                + Board.getBoard().substring(Board.findIndex(x, y) + 1));
    }

    /**
     * Switches the inputted move letter to the opposite of the input.
     * 
     * @param move the inputted move letter.
     * @return the opposite of the inputted move.
     */
    public static char changeMove(char move) {
        if (move == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    /**
     * Switches the current move variable.
     */
    public static void changeMove() {
        if (move == 'X') {
            move = 'O';
        } else {
            move = 'X';
        }
    }

    /**
     * Sets a random first move.
     */
    public static void firstMove() {
        Board.newGame();
        int flip = (int) (Math.random() * (2));
        if (flip == 1) {
            setMove('X');
        } else {
            setMove('O');
        }
    }

    /**
     * Returns the current move type. can be X or O.
     * 
     * @return 'X' or 'O'
     */
    public static char getMove() {
        return move;
    }

    /**
     * Finds the move at a given coordinate.
     * 
     * @param x x coordinate.
     * @param y y coordinate.
     * @return char at that spot.
     */
    public static char getMove(int x, int y) {
        return Board.getBoard().charAt(Board.findIndex(x, y));
    }

    /**
     * Basic setter method for the move variables.
     * 
     * @param m inputted move.
     */
    public static void setMove(char m) {
        move = m;
    }

}
