/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 * @package Game (backend)
 *
 * Sequence class
 * Consists of an array of Tile objects, and checks the array to see if it's a winning
 * sequence of Tiles (4 in a row)
 *
 * */

package ca.cmpt213.asn4.tictactoe.game;

import ca.cmpt213.asn4.tictactoe.UI.TileFX;

public class Sequence {

    private Tile[] tiles;

    public Sequence(Tile... tiles) {

        this.tiles = tiles;

    }

    public boolean isWinningSequence() {

        //An empty tile
        if (tiles[0].getBackendSymbol() == 0) {

            return false;

        }

        return tiles[0].getBackendSymbol() == tiles[1].getBackendSymbol()
                && tiles[0].getBackendSymbol() == tiles[2].getBackendSymbol()
                && tiles[0].getBackendSymbol() == tiles[3].getBackendSymbol();

    }

}
