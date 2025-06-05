package com.game.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Arrays;

public class GameButton extends Button {

    private int value;
    private static int moves = 9;
    private String text;
    private int row;
    private int column;
    private static int[] rows = new int[3];
    private static int[] columns = new int[3];
    private static int[] diagonals = new int[2];
    private static int pointsPlayerOne;
    private static int pointsPlayerTwo;

    private final GameNotifications gameNotifications = new GameNotifications();

    public GameButton() {
        setPrefSize(75, 75);
        setAlignment(Pos.CENTER);
        setFont(Font.font("System", FontWeight.BOLD, 35));
        setStyle("-fx-background-color: #c0c0c0;");
        this.setOnAction(actionEvent -> {
            if(moves % 2 == 0) {
                text = "o";
            } else {
                text = "x";
            }
            setTextColorAndValue(text);
            startAndTrackButtons();
            checkWinner();
        });
    }

    private void startAndTrackButtons() {
        row = GridPane.getRowIndex(this);
        column = GridPane.getColumnIndex(this);
        checkRows();
        checkColumns();
        checkDiagonals();
    }

    private void setTextColorAndValue(String text) {
        setText(text);
        switch (text) {
            case "x":
                setTextFill(Color.valueOf("#ff6700"));
                setValue(1);
                break;
            case "o":
                setTextFill(Color.valueOf("#004398"));
                setValue(-1);
                break;
        }
        moves--;
    }

    public void checkRows() {
        switch (this.getRow()) {
            case 0:
                rows[0] += this.getValue();
                break;
            case 1:
                rows[1] += this.getValue();
                break;
            case 2:
                rows[2] += this.getValue();
                break;
        }
    }

    public void checkColumns() {
        switch (this.getColumn()) {
            case 0:
                columns[0] += this.getValue();
                break;
            case 1:
                columns[1] += this.getValue();
                break;
            case 2:
                columns[2] += this.getValue();
                break;
        }
    }

    public void checkDiagonals() {
        if(this.getRow() == this.getColumn()) {
            diagonals[0] += this.getValue();
        }
        if((this.getRow() == 0 && this.getColumn() == 2)
                || (this.getRow() == 1 && this.getColumn() == 1)
                || (this.getRow() == 2 && this.getColumn() == 0)) {
            diagonals[1] += this.getValue();
        }
    }

    private void resetGameAndShowScore() {
        resetGame();
        gameNotifications.showScoreboard(pointsPlayerOne, pointsPlayerTwo);
    }

    public void checkWinner() {
        for(int row: rows) {
            if(row == 3) {
                pointsPlayerOne++;
                resetGameAndShowScore();
                return;
            } else if(row == -3) {
                pointsPlayerTwo++;
                resetGameAndShowScore();
                return;
            }
        }
        for(int column: columns) {
            if(column == 3) {
                pointsPlayerOne++;
                resetGameAndShowScore();
                return;
            } else if(column == -3) {
                pointsPlayerTwo++;
                resetGameAndShowScore();
                return;
            }
        }
        for(int diagonal: diagonals) {
            if(diagonal == 3) {
                pointsPlayerOne++;
                resetGameAndShowScore();
                return;
            } else if(diagonal == -3) {
                pointsPlayerTwo++;
                resetGameAndShowScore();
                return;
            }
        }
        if(moves == 0) {
            gameNotifications.draw();
            resetGameAndShowScore();
        }
    }

    private void resetGame() {
        Parent parent = this.getParent();
        if (parent instanceof GridPane gridPane) {
            for (Node node : gridPane.getChildren()) {
                if (node instanceof GameButton button) {
                    button.setText("");
                }
            }
        }
        moves = 9;
        Arrays.fill(rows, 0);
        Arrays.fill(columns, 0);
        Arrays.fill(diagonals, 0);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
