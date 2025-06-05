package com.game.tictactoe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneFactory {

    private static final String BUTTON_EXIT = "Sair";
    private static final String BUTTON_START = "Iniciar Jogo";
    private static final String BACKGROUND = "-fx-background-color: #ebebeb;";
    private static final String PLAYER_ONE_COLOR = "#ff6700";
    private static final String PLAYER_TWO_COLOR = "#004398";
    private static final String GAME_LOGO = "logo.png";
    private static final String GAME_TITLE = "Jogo da Velha";
    private static final String GRIDPANE_STYLE = "-fx-padding: 30px 20px 30px 20px;";
    private static final String IMAGE_STYLE = "-fx-padding: 10px 20px 30px 20px;";

    private final BuildLabels buildLabels = new BuildLabels();
    private final ButtonService buttonService = new ButtonService();
    private final GameNotifications gameNotifications = new GameNotifications();

    Player player = new Player();
    Player player2 = new Player();
    Button buttonExit = buttonService.buildButton(BUTTON_EXIT);

    public void buildLoginScene(Stage stage) {
        Label labelPlayer = buildLabels.labelPlayer(Color.valueOf(PLAYER_ONE_COLOR));
        Label labelPlayer2 = buildLabels.labelPlayer(Color.valueOf(PLAYER_TWO_COLOR));
        HBox boxPlayerOne = new HBox(7);
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        Button buttonStart = buttonService.buildButton(BUTTON_START);
        gridPane.addRow(0, buttonExit, buttonStart);
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        boxPlayerOne.setAlignment(Pos.CENTER);
        boxPlayerOne.getChildren().addAll(labelPlayer, player);
        HBox boxPlayerTwo = new HBox(7);
        boxPlayerTwo.setAlignment(Pos.CENTER);
        boxPlayerTwo.getChildren().addAll(labelPlayer2, player2);
        HBox boxGameLogo = new HBox();
        ImageView imageView = new ImageView(new Image(String.valueOf(App.class.getResource(GAME_LOGO))));
        boxGameLogo.getChildren().add(imageView);
        boxGameLogo.setAlignment(Pos.CENTER);
        boxGameLogo.setStyle(IMAGE_STYLE);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(boxGameLogo, boxPlayerOne, boxPlayerTwo);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setStyle(BACKGROUND);
        Scene scene = new Scene(vBox, 800, 600);
        ((VBox) scene.getRoot()).getChildren().add(gridPane);
        stage.setTitle(GAME_TITLE);
        stage.setScene(scene);
        stage.show();
        buttonStart.setOnAction(e -> {
            if(!player.isValid(player2)) {
                gameNotifications.error();
            } else {
                gameNotifications.success();
                try {
                    buildGameScene(stage);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void buildGameScene(Stage stage) throws IOException {
        Label labelPlayer = new BuildLabels().labelNamePlayer(Color.valueOf(PLAYER_ONE_COLOR), player);
        Label labelPlayerTwo = new BuildLabels().labelNamePlayer(Color.valueOf(PLAYER_TWO_COLOR), player2);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(labelPlayer, labelPlayerTwo);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(350);
        hbox.setPadding(new Insets(10, 10, 80, 10));
        hbox.setStyle(BACKGROUND);
        GridPane pane = new GridPane();
        pane.setStyle(BACKGROUND);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane.add(new GameButton(), i, j);
            }
        }
        HBox boxExitButton = new HBox();
        boxExitButton.getChildren().add(buttonExit);
        VBox vBox = new VBox();
        vBox.setStyle(BACKGROUND);
        vBox.setAlignment(Pos.CENTER);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setStyle(GRIDPANE_STYLE);
        Scene scene = new Scene(vBox, 800, 600);
        ((VBox) scene.getRoot()).getChildren().addAll(hbox, pane, buttonExit);
        stage.setScene(scene);
    }
}
