package com.game.tictactoe;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ButtonService {

    public Button buildButton(String name) {
        Button button = new Button(name);
        button.setMinSize(150, 20);
        button.setStyle("-fx-background-color: linear-gradient(to right, " + "#ff6700, #004398);");
        button.setTextFill(Color.WHITE);
        if(name.equalsIgnoreCase("sair")) {
            addExitAction(button);
        }
        return button;
    }

    private void addExitAction(Button button) {
        button.setOnAction(e -> {
            Platform.exit();
        });
    }

}
