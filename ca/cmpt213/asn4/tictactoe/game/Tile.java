/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 * @package Game (backend)
 *
 * Tile class (backend)
 * It's really just an int stored here, in a more descriptive/accessible way
 * 0 = Empty, 1 = Beatles, 2 = Rolling Stones
 *
 * */

package ca.cmpt213.asn4.tictactoe.game;

public class Tile {

    //Will be 0=empty, 1=Beatles, 2=Rolling Stones
    int backendSymbol;

    public Tile (int backendSymbol) {

        this.backendSymbol = backendSymbol;

    }

    public int getBackendSymbol() {

        return backendSymbol;

    }

    public void setBackendSymbol(int symbol) {

        this.backendSymbol = symbol;

    }

}
