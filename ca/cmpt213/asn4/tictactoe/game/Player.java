/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 * @package Game (backend)
 *
 * Player class
 * Just holds an int to represent which player this is
 * 1 = Beatles, 2 = Rolling Stones
 *
 * */

package ca.cmpt213.asn4.tictactoe.game;

public class Player {

    private int backendBandSymbol;

    //1 = Beatles, 2 = Stones
    public Player(int band) {

        backendBandSymbol = band;

    }

    public int getBackendBandSymbol() {

        return backendBandSymbol;

    }

}
