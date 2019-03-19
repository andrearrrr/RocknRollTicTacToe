/** CMPT 213, Assignment 4, Question 2 - TicTacToe w/ JavaFX
 * @version 1
 * @author Andrea Renney, 301312472, arenney@sfu.ca
 *
 * Main class, extending the JavaFX Application class.
 * Handles setting the Scene and Stage, and starting the game (including the new game button)
 *
 * */

package ca.cmpt213.asn4.tictactoe;

import ca.cmpt213.asn4.tictactoe.UI.GameboardFX;
import ca.cmpt213.asn4.tictactoe.game.GameState;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private Button newGameButton;

    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        newGameButton = new Button("New game");

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        startGame(primaryStage);

        newGameButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {

                try {
                    startGame(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });

    }

    public void startGame(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Beatles vs. Rolling Stones TicTacToe");

        GameState currentGame = new GameState();
        GameboardFX newUI = new GameboardFX(currentGame);

        primaryStage.setScene(newUI.createGrid(newGameButton));
        primaryStage.show();

    }

}
