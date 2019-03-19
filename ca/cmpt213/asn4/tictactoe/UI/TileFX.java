/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 * @package UI
 *
 * TileFX class, a UI class to represent a Tile
 * The UI version of a tile in the grid - sets the images for tiles in the grid using ImageView
 * */

package ca.cmpt213.asn4.tictactoe.UI;

import ca.cmpt213.asn4.tictactoe.game.Tile;
import javafx.scene.image.Image;

import javax.swing.text.html.ImageView;
import java.io.File;
import java.net.MalformedURLException;

public class TileFX {

    int backendTile;
    Image tileImage;

    public TileFX(int backendTileSymbol) {

        this.backendTile = backendTile;
        String localUrl = null;

        //Black square
        if (backendTileSymbol == 0) {

            //Empty (black square) image
            File emptyFile = new File("/Users/andrearenney/IdeaProjects/A4 TicTacToe/src/Images/empty.jpg");
            try {
                localUrl = emptyFile.toURI().toURL().toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            tileImage = new Image(localUrl, 100, 100, false, false);

        }

        else if (backendTileSymbol == 1) {

            //Beatles image
            File beatlesFile = new File("/Users/andrearenney/IdeaProjects/A4 TicTacToe/src/Images/beatles.jpg");
            try {
                localUrl = beatlesFile.toURI().toURL().toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            tileImage = new Image(localUrl, 100, 100, false, false);

        }

        else if (backendTileSymbol == 2) {

            //Rolling Stones image
            File stonesFile = new File("/Users/andrearenney/IdeaProjects/A4 TicTacToe/src/Images/stones.jpg");
            try {
                localUrl = stonesFile.toURI().toURL().toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            tileImage = new Image(localUrl, 100, 100, false, false);

        }

    }

    public Image getTileImage() {

        return tileImage;

    }

    public int getBackendTile() {

        return backendTile;

    }

}
