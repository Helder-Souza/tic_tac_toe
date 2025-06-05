package com.game.tictactoe;

import javafx.scene.control.TextField;

public class Player extends TextField {

    public boolean isValid(Player playerTwo) {
        if(this.getText().isEmpty() || playerTwo.getText().isEmpty()) {
            clear(playerTwo);
            return false;
        } else if (this.getText().equalsIgnoreCase(playerTwo.getText())) {
            clear(playerTwo);
            return false;
        }
        return true;
    }

    public void clear(Player player2) {
        this.setText("");
        player2.setText("");
    }
}
