package com.game.tictactoe;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class BuildLabels {

    public BuildLabels() {
    }

    public Label labelPlayer(Paint paint) {
        Label labelPlayer = new Label("Nome Jogador: ");
        labelPlayer.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        labelPlayer.setTextFill(paint);
        return labelPlayer;
    }

    public Label labelNamePlayer(Paint paint, Player player) {
        Label labelName = new Label(player.getText().toUpperCase());
        labelName.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        labelName.setTextFill(paint);
        return labelName;
    }

}
