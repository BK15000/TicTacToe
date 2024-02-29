package homework5;

/**
 * Class for the board and its helper methods.
 * 
 * @author brian
 *
 */
public class Board {
    /**
     * String variable ta\hat holds the board of the current game.
     */
    private static String board;
    /**
     * Holds the index of all the playable positions on the board.
     */
    private static int index[] = { 12, 14, 16, 22, 24, 26, 32, 34, 36 };

    /**
     * Finds the index based off an input x and y coordinate.
     * 
     * @param x X coordinate of move.
     * @param y Y coordinate of move.
     * @return The index.
     */
    public static int findIndex(int x, int y) {
        if (y == 1) {
            return index[x - 1];
        } else if (y == 2) {
            return index[x + 2];
        }
        return index[x + 5];
    }

    /**
     * Checks to see if a spot at a coordinate point has already been played.
     * 
     * @param x X coordinate of move.
     * @param y Y coordinate of move.
     * @return true if the spot is playable and false if not.
     */
    public static boolean checkEmptySpot(int x, int y) {
        if (board.charAt(findIndex(x, y)) != '-') {
            return false;
        }
        return true;
    }

    /**
     * Switches the move at a coordinate to the opposite.
     * 
     * @param x X coordinate to be changed.
     * @param y Y coordinate to be changed.
     */
    public static void changeSpot(int x, int y) {
        char newMove = Play.changeMove(Play.getMove());
        setBoard(getBoard().substring(0, findIndex(x, y)) + newMove
                + getBoard().substring(findIndex(x, y) + 1));
    }

    /**
     * Resets the board with a default value of " 1 2 3\n1 |-|-|-|\n2 |-|-|-|\n3
     * |-|-|-|".
     */
    public static void newGame() {
        board = "   1 2 3\n1 |-|-|-|\n2 |-|-|-|\n3 |-|-|-|";
    }

    /**
     * Simple getter method for the board.
     * 
     * @return the board.
     */
    public static String getBoard() {
        return board;
    }

    /**
     * Setter method for the board.
     * 
     * @param b desired board to be set.
     */
    public static void setBoard(String b) {
        board = b;
    }

    /**
     * Removes move at index.
     * 
     * @param x X coordinate to be removed.
     * @param y Y coordinate to be removed.
     */
    public static void removeMove(int x, int y) {
        setBoard(getBoard().substring(0, findIndex(x, y)) + '-'
                + getBoard().substring(findIndex(x, y) + 1));
    }

}
