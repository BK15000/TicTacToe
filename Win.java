package homework5;

/**
 * Class that checks the win for X and O in a game of tic tac toe.
 * 
 * @author brian
 *
 */
public class Win {
    /**
     * Checks to see if X is winning horizontally.
     * 
     * @return true if X is winning horizontal and false if not.
     */
    public static boolean checkXHorizontal() {
        for (int i = 0; i < 30; i += 10) {
            if (Board.getBoard().charAt(10 + i) == 'X'
                    && Board.getBoard().charAt(14 + i) == 'X'
                    && Board.getBoard().charAt(16 + i) == 'X') {
                return true;

            }
        }
        return false;
    }

    /**
     * Checks to see if O is winning horizontally.
     * 
     * @return true if O is winning horizontal and false if not.
     */
    public static boolean checkOHorizontal() {
        for (int i = 0; i < 30; i += 10) {
            if (Board.getBoard().charAt(12 + i) == 'O'
                    && Board.getBoard().charAt(14 + i) == 'O'
                    && Board.getBoard().charAt(16 + i) == 'O') {
                return true;

            }
        }
        return false;
    }

    /**
     * Checks to see if O is winning vertically.
     * 
     * @return true if O is winning vertically and false if not.
     */
    public static boolean checkOVertical() {
        for (int i = 0; i < 6; i += 2) {
            if (Board.getBoard().charAt(12 + i) == 'O'
                    && Board.getBoard().charAt(22 + i) == 'O'
                    && Board.getBoard().charAt(32 + i) == 'O') {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if X is winning vertically.
     * 
     * @return true if X is winning vertical and false if not.
     */
    public static boolean checkXVertical() {
        for (int i = 0; i < 6; i += 2) {
            if (Board.getBoard().charAt(12 + i) == 'X'
                    && Board.getBoard().charAt(22 + i) == 'X'
                    && Board.getBoard().charAt(32 + i) == 'X') {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if X is winning diagonally.
     * 
     * @return true if X is winning diagonal and false if not.
     */
    public static boolean checkXDiagonal() {
        if ((Board.getBoard().charAt(12) == 'X'
                && Board.getBoard().charAt(24) == 'X'
                && Board.getBoard().charAt(36) == 'X')
                || (Board.getBoard().charAt(16) == 'X'
                        && Board.getBoard().charAt(24) == 'X'
                        && Board.getBoard().charAt(32) == 'X')) {
            return true;
        }
        return false;
    }

    /**
     * Checks to see if O is winning diagonally.
     * 
     * @return true if O is winning diagonal and false if not.
     */
    public static boolean checkODiagonal() {
        if ((Board.getBoard().charAt(12) == 'O'
                && Board.getBoard().charAt(24) == 'O'
                && Board.getBoard().charAt(36) == 'O')
                || (Board.getBoard().charAt(16) == 'O'
                        && Board.getBoard().charAt(24) == 'O'
                        && Board.getBoard().charAt(32) == 'O')) {
            return true;
        }
        return false;
    }

    /**
     * Checks every win condition and returns the winner, a C for tie, or - if
     * the game is unfinished.
     * 
     * @return the winner, C for tie, - for unfinished.
     */
    public static char checkWin() {
        if (checkXDiagonal() || checkXVertical() || checkXHorizontal()) {
            return 'X';
        } else if (checkODiagonal() || checkOVertical() || checkOHorizontal()) {
            return 'O';
        } else if (!Board.getBoard().contains("-")) {
            return 'C';
        } else {
            return '-';
        }
    }
}
