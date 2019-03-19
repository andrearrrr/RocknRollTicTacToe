/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 * @package Game (backend)
 *
 * GameState class, for backend logic handling, determining the winner, determining if the game
 * is still active (not won/not a draw), changing players between turns
 *
 * */

package ca.cmpt213.asn4.tictactoe.game;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    final int NUM_ROWS = 4;
    final int NUM_COLS = 4;
    final int TOTAL_SQUARES = 16;

    private GameboardLogic board;
    private Player playerBeatles;
    private Player playerStones;
    private Player currentPlayer;
    private int numMoves;
    private boolean gameActive;
    private List<Sequence> allSequences;

    public GameState() {

        //Board of all blank tiles
        board = new GameboardLogic();
        playerBeatles = new Player(1);
        playerStones = new Player(2);

        //Beatles (1) always goes first
        currentPlayer = playerBeatles;
        numMoves = 0;
        gameActive = true;
        allSequences = new ArrayList<Sequence>();

    }

    //When calling nextMove(), check boolean and if false is returned, end the game
    //else if true, keep looping through gameplay
    //Returns the current player's int if they win, otherwise:
    //3=draw, 4=continue
    public int nextMove(int row, int col) {

        if (!isDraw() && isGameActive()) {

            int currentSymbol = currentPlayer.getBackendBandSymbol();

            //Sets the backend int for the Tile object in the board
            board.setCell(row, col, currentSymbol);

            numMoves ++;

            //Game won by currentplayer, return their symbol
            if (!isGameActive()) {

                return currentPlayer.getBackendBandSymbol();

            }

            //No winner
            else if (isDraw()) {

                return 3;

            }

            nextPlayer();

        }

        //Continue
        return 4;

    }

    //For switching between players
    public void nextPlayer() {

        if (currentPlayer.equals(playerBeatles)) {

            currentPlayer = playerStones;

        } else {

            currentPlayer = playerBeatles;

        }

    }

    //All squares are full, no more moves to make, nobody won
    public boolean isDraw() {

        return numMoves == TOTAL_SQUARES;

    }

    private void getAllCombos() {

        //Horizontal
        for (int y = 0; y < NUM_COLS; y++) {

            allSequences.add(new Sequence(board.getTile(0, y), board.getTile(1, y), board.getTile(2, y), board.getTile(3, y)));

        }

        //Vertical
        for (int x = 0; x < NUM_ROWS; x++) {

            allSequences.add(new Sequence(board.getTile(x, 0), board.getTile(x, 1), board.getTile(x, 2), board.getTile(x, 3)));

        }

        //Diagonals (2)
        allSequences.add(new Sequence(board.getTile(0, 0), board.getTile(1,1), board.getTile(2,2), board.getTile(3,3)));
        allSequences.add(new Sequence(board.getTile(0, 3), board.getTile(1, 2), board.getTile(2, 1), board.getTile(3, 0)));

    }

    public boolean isGameActive() {

        getAllCombos();

        for (Sequence c : allSequences) {

            if (c.isWinningSequence()) {

                gameActive = false;
                break;

            }

        }

        return gameActive;

    }

    public GameboardLogic getBoard() {

        return board;

    }

    public int getCurrentPlayer() {

        return currentPlayer.getBackendBandSymbol();

    }

}
