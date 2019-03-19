/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 * @package Game (backend)
 *
 * GameboardLogic class (backend version of the gameboard)
 * Holds the backend array which is used for determining if the game is active/won/draw
 *
 * */
package ca.cmpt213.asn4.tictactoe.game;

public class GameboardLogic {

    final int NUM_ROWS = 4;
    final int NUM_COLS = 4;

    //I'm using a 2D array of Tile objects here, rather than a 2D array of ints,
    //but the Tile object basically just stores an int (0, 1, or 2); using Tile
    //objects just seems more descriptive and easier to work with than simple ints
    private Tile [][] gameCells;

    //A blank board to start
    public GameboardLogic() {

        //4x4 array, 16 cells total
        gameCells = new Tile[NUM_ROWS][NUM_COLS];

        //0 = empty, 1 = Beatles, 2 = Rolling Stones
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {

                gameCells[i][j] = new Tile(0);

            }
        }
    }

    public void setCell(int row, int col, int cellVal) {

        gameCells[row][col].setBackendSymbol(cellVal);

    }

    public Tile getTile(int row, int col) {

        return gameCells[row][col];

    }

    public int getTileSymbol(int row, int col) {

        return gameCells[row][col].getBackendSymbol();

    }

}
