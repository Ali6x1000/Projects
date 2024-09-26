import java.util.Random;

/**
 * This class represents the game board for SlideGame.
 * It includes the game state and logic.
 * The game includes diagonal moves.
 * <p>
 * A tile may be blank or contain an integer. The game starts with all tiles blank except one tile
 * that contains the integer 1, chosen randomly.
 * <p>
 * A player makes a "move" by choosing a direction and all the non-blank tiles slide in that direction.
 * In the normal game, the possible directions are "up", "down", "right", and "left", but our game will
 * also add the diagonal directions "up-left", "up-right", "down-left", and "down-right".
 * <p>
 * Here is how a slide "left" works. The rest act similarly. In each row, each non-blank tile, starting
 * at the left most non-blank tile, is slid as far as it can go to the left. It stops when it either hits
 * the edge of the board or another non-blank tile. However, if the tile "hits" another tile with the same
 * value, the two tiles are "merged" by adding the sliding tile's value to the tile that it "hits".
 * <p>
 * For example, if the tiles in one row are {0, 1, 0, 2} (with 0 representing a blank), the result of sliding
 * left should be {1, 2, 0, 0} as first the 1 slides left until it gets to the left most edge, and the 2 is
 * then slid left until it hits the 1. The remaining two tiles in that row are now blank. If the tiles in one
 * row are {0, 1, 0, 1}, the result of sliding left should be {2, 0, 0, 0} as the left 1 slides left until it
 * gets to the edge of the board, and the second 1 slides left until it hits the 1 causing it to merge with the 1.
 * Now the leftmost tile stores the 2 (the result of the merge) and the rest of the tiles in that row are blank.
 * Since you slide the leftmost non-zero tile first, if a row has {0, 1, 1, 1, 1}, the result of sliding left should
 * be {2, 2, 0, 0, 0} and if the row has {0, 1, 1, 2, 0}, the result of sliding left should be {4, 0, 0, 0, 0}.
 * <p>
 * After the tiles are slid and merged in the desired direction, then one of the blank tiles on the board is
 * chosen at random and a 1 placed on that tile.
 * @author Ali Nawaf
 */
public class GameBoard {
    private final int rows;
    private final int cols;
    private final int[][] board;
    private final Random random;

    /**
     * Constructs a GameBoard object with the specified size.
     *
     * @param rows the number of rows in the game board
     * @param cols the number of columns in the game board
     */
    public GameBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new int[rows][cols];
        this.random = new Random();
    }

    /**
     * Sets the number at the specified row and column.
     *
     * @param row    the row of the tile
     * @param col    the column of the tile
     * @param number the number to be set
     */
    public void setNumber(int row, int col, int number) {
        board[row][col] = number;
    }

    /**
     * Gets the number at the specified row and column.
     *
     * @param row the row of the tile
     * @param col the column of the tile
     * @return the number at the specified row and column
     */
    public int getNumber(int row, int col) {
        return board[row][col];
    }

    /**
     * Slides the tiles to the left.
     */
    public void slideLeft() {
        for (int row = 0; row < rows; row++) {
            slideRowLeft(row);
        }
        addNewTile();
    }

    /**
     * Slides the tiles in the specified row to the left.
     *
     * @param row the row to slide
     */
    private void slideRowLeft(int row) {
        for (int col = 0; col < cols; col++) {
            for (int k = col + 1; k < cols; k++) {
                if (board[row][k] != 0) {
                    if (board[row][col] == 0) {
                        board[row][col] = board[row][k];
                        board[row][k] = 0;
                        col--;
                    } else if (board[row][col] == board[row][k]) {
                        board[row][col] *= 2;
                        board[row][k] = 0;
                    }
                    break;
                }
            }
        }
    }

    /**
     * Slides the tiles to the right.
     */
    public void slideRight() {
        for (int row = 0; row < rows; row++) {
            slideRowRight(row);
        }
        addNewTile();
    }

    /**
     * Slides the tiles in the specified row to the right.
     *
     * @param row the row to slide
     */
    private void slideRowRight(int row) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int k = col - 1; k >= 0; k--) {
                if (board[row][k] != 0) {
                    if (board[row][col] == 0) {
                        board[row][col] = board[row][k];
                        board[row][k] = 0;
                        col++;
                    } else if (board[row][col] == board[row][k]) {
                        board[row][col] *= 2;
                        board[row][k] = 0;
                    }
                    break;
                }
            }
        }
    }

    /**
     * Slides the tiles up.
     */
    public void slideUp() {
        for (int col = 0; col < cols; col++) {
            slideColumnUp(col);
        }
        addNewTile();
    }

    /**
     * Slides the tiles in the specified column up.
     *
     * @param col the column to slide
     */
    private void slideColumnUp(int col) {
        for (int row = 0; row < rows; row++) {
            for (int k = row + 1; k < rows; k++) {
                if (board[k][col] != 0) {
                    if (board[row][col] == 0) {
                        board[row][col] = board[k][col];
                        board[k][col] = 0;
                        row--;
                    } else if (board[row][col] == board[k][col]) {
                        board[row][col] *= 2;
                        board[k][col] = 0;
                    }
                    break;
                }
            }
        }
    }

    /**
     * Slides the tiles down.
     */
    public void slideDown() {
        for (int col = 0; col < cols; col++) {
            slideColumnDown(col);
        }
        addNewTile();
    }

    /**
     * Slides the tiles in the specified column down.
     *
     * @param col the column to slide
     */
    private void slideColumnDown(int col) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int k = row - 1; k >= 0; k--) {
                if (board[k][col] != 0) {
                    if (board[row][col] == 0) {
                        board[row][col] = board[k][col];
                        board[k][col] = 0;
                        row++;
                    } else if (board[row][col] == board[k][col]) {
                        board[row][col] *= 2;
                        board[k][col] = 0;
                    }
                    break;
                }
            }
        }
    }

    /**
     * Slides the tiles diagonally up and to the left.
     */
    public void slideUpLeft() {
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                for (int k = 1; k < rows; k++) {
                    if (row - k < 0 || col - k < 0) break;
                    if (board[row - k][col - k] != 0) {
                        if (board[row][col] == 0) {
                            board[row][col] = board[row - k][col - k];
                            board[row - k][col - k] = 0;
                            row--;
                            col--;
                        } else if (board[row][col] == board[row - k][col - k]) {
                            board[row][col] = 0;
                            board[row - k][col - k] *= 2;
                        }
                        break;
                    }
                }
            }
        }
        addNewTile();
    }

    /**
     * Slides the tiles diagonally up and to the right.
     */
    public void slideUpRight() {
        for (int row = 0; row < rows - 1; row++) {
            for (int col = cols - 1; col > 0; col--) {
                for (int k = 1; k < rows; k++) {
                    if (row - k < 0 || col + k >= cols) break;
                    if (board[row - k][col + k] != 0) {
                        if (board[row][col] == 0) {
                            board[row][col] = board[row - k][col + k];
                            board[row - k][col + k] = 0;
                            row--;
                            col++;
                        } else if (board[row][col] == board[row - k][col + k]) {
                            board[row][col] =0;
                            board[row - k][col + k] *= 2;
                        }
                        break;
                    }
                }
            }
        }
        addNewTile();
    }

    /**
     * Slides the tiles diagonally down and to the left.
     */
    public void slideDownLeft() {
        for (int row = rows - 1; row > 0; row--) {
            for (int col = 0; col < cols - 1; col++) {
                for (int k = 1; k < rows; k++) {
                    if (row + k >= rows || col - k < 0) break;
                    if (board[row + k][col - k] != 0) {
                        if (board[row][col] == 0) {
                            board[row][col] = board[row + k][col - k];
                            board[row + k][col - k] = 0;
                            row++;
                            col--;
                        } else if (board[row][col] == board[row + k][col - k]) {
                            board[row][col] = 0;
                            board[row + k][col - k] *= 2;
                        }
                        break;
                    }
                }
            }
        }
        addNewTile();
    }

    /**
     * Slides the tiles diagonally down and to the right.
     */
    public void slideDownRight() {
        for (int row = rows - 1; row > 0; row--) {
            for (int col = cols - 1; col > 0; col--) {
                for (int k = 1; k < rows; k++) {
                    if (row + k >= rows || col + k >= cols) break;
                    if (board[row + k][col + k] != 0) {
                        if (board[row][col] == 0) {
                            board[row][col] = board[row + k][col + k];
                            board[row + k][col + k] = 0;
                            row++;
                            col++;
                        } else if (board[row][col] == board[row + k][col + k]) {
                            board[row][col] = 0;
                            board[row + k][col + k] *= 2;
                        }
                        break;
                    }
                }
            }
        }
        addNewTile();
    }

    /**
     * Adds a new random tile to the board.
     */
    private void addNewTile() {
        // Check if the board is full
        boolean full = true;
        for (int[] row : board) {
            for (int tile : row) {
                if (tile == 0) {
                    full = false;
                    break;
                }
            }
            if (!full) break;
        }

        // If the board is full, do not add a new tile
        if (full) return;

        // Otherwise, add a new tile
        int row, col;
        do {
            row = random.nextInt(rows);
            col = random.nextInt(cols);
        } while (board[row][col] != 0);
        board[row][col] = 1;
    }

    /**
     * Main method to launch the game.
     * Passes the command line arguments to the launch method.
     * Once the start method has the parameters, uses them to set the game board dimensions.
     *
     * @param args command line arguments: rows cols
     */
    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;

        // Check if the user provided rows and cols arguments
        if (args.length == 2) {
            try {
                rows = Integer.parseInt(args[0]);
                cols = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default size: 4x4.");
            }
        } else if (args.length > 0) {
            System.out.println("Invalid input. Using default size: 4x4.");
        }

        SlideGame.launch(SlideGame.class, args);
    }
}
