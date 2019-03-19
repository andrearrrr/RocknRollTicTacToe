/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 * @package UI
 *
 * GameboardFX class, a UI class
 * Sets the JavaFX UI and handles the interaction with the user in the form of mouseclicks
 * on ImageView objects in a GridPane
 * Interacts with the GameState class to use the backend logic to determine win/draw/active game
 *
 * */

package ca.cmpt213.asn4.tictactoe.UI;

import ca.cmpt213.asn4.tictactoe.game.GameState;
import ca.cmpt213.asn4.tictactoe.game.GameboardLogic;
import ca.cmpt213.asn4.tictactoe.game.Tile;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import java.io.File;

public class GameboardFX {

    private GameState currentGame;
    Label winnerLabel;
    GridPane newBoard;
    private int xCoord;
    private int yCoord;

    public GameboardFX(GameState currentGame) {

        this.currentGame = currentGame;
        winnerLabel = new Label("Currently playing...");

    }

    public Scene createGrid(Button newGameButton) {

        Text title = new Text("Beatles vs. Rolling Stones TicTacToe!");

        newBoard = new GridPane();
        newBoard.setHgap(10);
        newBoard.setVgap(10);
        newBoard.setPadding(new Insets(20));

        //0 = empty, 1 = X, 2 = 'O'
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                TileFX newTileFX = new TileFX(currentGame.getBoard().getTileSymbol(i, j));
                ImageView newNode = new ImageView(newTileFX.getTileImage());
                newBoard.add(newNode, i, j);
                newNode.addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageClickHandler());

            }

        }

        HBox hBox = new HBox(10);

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(winnerLabel, newGameButton);

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(title, newBoard, hBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(15));

        Scene scene1 = new Scene(vBox, 470, 600);

        return scene1;

    }

    class ImageClickHandler implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent e) {

            int resultOfNextMove;

            xCoord = newBoard.getRowIndex(((ImageView)e.getSource()));
            yCoord = newBoard.getColumnIndex(((ImageView)e.getSource()));

            //Check for if image clicked is blank i.e. its symbol == 0
            if (currentGame.getBoard().getTileSymbol(xCoord, yCoord) == 0) {

                //Beatles = 1
                if (currentGame.getCurrentPlayer() == 1) {

                    TileFX replaceImage = new TileFX(1);

                    ((ImageView)e.getSource()).setImage(replaceImage.getTileImage());
                    xCoord = newBoard.getRowIndex(((ImageView)e.getSource()));
                    yCoord = newBoard.getColumnIndex(((ImageView)e.getSource()));

                    resultOfNextMove = currentGame.nextMove(xCoord, yCoord);

                }

                //Stones = 2
                else {

                    TileFX replaceImage = new TileFX(2);

                    ((ImageView)e.getSource()).setImage(replaceImage.getTileImage());                    xCoord = newBoard.getRowIndex(((ImageView)e.getSource()));
                    yCoord = newBoard.getColumnIndex(((ImageView)e.getSource()));

                    resultOfNextMove = currentGame.nextMove(xCoord, yCoord);

                }

                //Now check if the game is won/draw/still active

                if (resultOfNextMove == currentGame.getCurrentPlayer()) {

                    if (currentGame.getCurrentPlayer() == 1) {

                        winnerLabel.setText("Beatles won!");

                        //This stops allowing clicks, not a big deal but may as well
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {

                                currentGame.getBoard().setCell(i, j, 1);

                            }

                        }

                        return;

                    }

                    else {

                        winnerLabel.setText("Rolling Stones won!");

                        //This stops allowing clicks, not a big deal but may as well
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {

                                currentGame.getBoard().setCell(i, j, 2);

                            }

                        }

                        return;

                    }


                }

                else if (resultOfNextMove == 3) {

                    //is draw
                    winnerLabel.setText("No winner!");

                    //This stops allowing clicks, not a big deal but may as well
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {

                            currentGame.getBoard().setCell(i, j, 3);

                        }

                    }

                    return;

                }

                else {

                    //continue playing,
                    return;

                }
            }

            else {

                //don't change the image, do nothing, they can try clicking elsewhere
                return;

            }
        }
    }
}
