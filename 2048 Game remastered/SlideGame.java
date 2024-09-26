import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

/**
 * This class represents a SlideGame, an implementation of the game 2048.
 * The game includes diagonal moves.
 *
 * @author Ali Nawaf
 */
public class SlideGame extends Application {
    private int gridSizeRows = 4;
    private int gridSizeCols = 4;

    private Button[][] buttons;
    private GameBoard gameBoard;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            if (getParameters().getRaw().size() >= 2) {
                gridSizeRows = Math.max(1, Integer.parseInt(getParameters().getRaw().get(0)));
                gridSizeCols = Math.max(1, Integer.parseInt(getParameters().getRaw().get(1)));
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            System.out.println("Invalid arguments. Using default grid size: 4x4");
        }

        gameBoard = new GameBoard(gridSizeRows, gridSizeCols);

        GridPane grid = new GridPane();
        buttons = new Button[gridSizeRows][gridSizeCols];

        initializeBoard(grid);

        Scene scene = new Scene(grid, 80 * gridSizeCols, 80 * gridSizeRows);
        primaryStage.setTitle("SlideGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Initializes the game board with buttons.
     *
     * @param grid The GridPane to hold the buttons
     */
    private void initializeBoard(GridPane grid) {
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        for (int row = 0; row < gridSizeRows; row++) {
            for (int col = 0; col < gridSizeCols; col++) {
                Button button = new Button();
                button.setMinSize(80, 80);
                button.setStyle("-fx-font-size:20");
                buttons[row][col] = button;
                grid.add(button, col, row);

                int finalRow = row;
                int finalCol = col;
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        handleButtonClick(finalRow, finalCol);
                    }
                });
            }
        }

        initializeStartingTile();
    }

    /**
     * Initializes the starting tile with the number 1.
     */
    private void initializeStartingTile() {
        Random random = new Random();
        int row = random.nextInt(gridSizeRows);
        int col = random.nextInt(gridSizeCols);
        gameBoard.setNumber(row, col, 1);
        buttons[row][col].setText("1");
    }

    /**
     * Handles the button click event.
     *
     * @param row The row of the clicked button
     * @param col The column of the clicked button
     */
    private void handleButtonClick(int row, int col) {
        if (row == 0 && col == 0) {
            gameBoard.slideUpLeft();
        } else if (row == 0 && col == gridSizeCols - 1) {
            gameBoard.slideUpRight();
        } else if (row == gridSizeRows - 1 && col == 0) {
            gameBoard.slideDownLeft();
        } else if (row == gridSizeRows - 1 && col == gridSizeCols - 1) {
            gameBoard.slideDownRight();
        } else if (row == 0) {
            gameBoard.slideUp();
        } else if (row == gridSizeRows - 1) {
            gameBoard.slideDown();
        } else if (col == 0) {
            gameBoard.slideLeft();
        } else if (col == gridSizeCols - 1) {
            gameBoard.slideRight();
        }
        updateUI();
    }

    /**
     * Updates the UI with the current state of the game board.
     */
    private void updateUI() {
        for (int row = 0; row < gridSizeRows; row++) {
            for (int col = 0; col < gridSizeCols; col++) {
                int value = gameBoard.getNumber(row, col);
                buttons[row][col].setText(value == 0 ? "" : String.valueOf(value));
            }
        }
    }
}
