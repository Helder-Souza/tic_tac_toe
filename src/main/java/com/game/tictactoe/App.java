package com.game.tictactoe;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private final SceneFactory sceneFactory = new SceneFactory();

    @Override
    public void start(Stage primaryStage) {
        sceneFactory.buildLoginScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

