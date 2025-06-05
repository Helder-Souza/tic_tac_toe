package com.game.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.controlsfx.control.Notifications;

public class GameNotifications {

    private static final String GAME_TITLE = "Jogo da Velha";
    private static final String GAME_STARTED = "Jogo iniciado com sucesso";
    private static final String INVALID_PLAYERS_INPUT = "Jogadores com nomes inválidos";
    private static final String GAME_DRAW = "Deu Velha!!";
    private static final String SCORE_TITLE = "Placar";
    private static final String STYLE_PLAYER_ONE = "-fx-fill: #ff6700;";
    private static final String STYLE_PLAYER_TWO = "-fx-fill: #004398;";

    public static Notifications notifications = Notifications.create().position(Pos.CENTER).title(GAME_TITLE);

    public void success() {
        notifications.text(GAME_STARTED).showInformation();
    }

    public void error() {
        notifications.text(INVALID_PLAYERS_INPUT).showError();
    }

    public void draw() {
        notifications.text(GAME_DRAW).showInformation();
    }

    public void showScoreboard(int pointsPlayerOne, int pointsPlayerTwo) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        DialogPane dialogPane = new DialogPane();
        alert.setTitle(SCORE_TITLE);
        dialogPane.setPrefWidth(300);
        dialogPane.setPrefHeight(100);
        Text scorePlayerOne = new Text(String.valueOf(pointsPlayerOne));
        Text textVersus = new Text(" - ");
        Text scorePlayerTwo = new Text(String.valueOf(pointsPlayerTwo));
        scorePlayerOne.setStyle(STYLE_PLAYER_ONE);
        scorePlayerTwo.setStyle(STYLE_PLAYER_TWO);
        Font font = Font.font("System", FontWeight.BOLD, 35);
        scorePlayerOne.setFont(font);
        textVersus.setFont(font);
        scorePlayerTwo.setFont(font);
        Label label = new Label();
        label.setGraphic(new HBox(scorePlayerOne, textVersus, scorePlayerTwo));
        StackPane stackPane = new StackPane(label);
        stackPane.setMaxWidth(Double.MAX_VALUE);
        dialogPane.setContent(stackPane);
        ButtonType buttonType = new ButtonType("Ok", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(buttonType);
        Button closeButton = (Button) dialogPane.lookupButton(buttonType);
        closeButton.setOnAction(e -> alert.hide());
        alert.setDialogPane(dialogPane);
        alert.showAndWait();
    }
}
