package com.game.tictactoe;

import org.controlsfx.control.Notifications;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class JogoControlador {

    @FXML
    private TextField jogador1;

    @FXML
    private TextField jogador2;

    private String pl1;
    private String pl2;

    public JogoControlador() {

    }

    public void validar() {
        boolean jogador1Valido = !jogador1.getText().isEmpty() && !jogador1.getText().equalsIgnoreCase(jogador2.getText());
        boolean jogador2Valido = !jogador2.getText().isEmpty() && !jogador2.getText().equalsIgnoreCase(jogador1.getText());

        if(jogador1Valido && jogador2Valido) {
            pl1 = jogador1.getText();
            pl2 = jogador2.getText();
            Notifications.create()
                    .position(Pos.CENTER)
                    .title("Jogo da Velha")
                    .text("Jogo iniciado com sucesso!")
                    .showInformation();
        } else {
            Notifications.create()
                    .position(Pos.CENTER)
                    .title("Jogo da Velha")
                    .text("Jogadores com nomes inválidos")
                    .showError();
        }
    }

    public String getPl1() {
        return pl1;
    }

    public String getPl2() {
        return pl2;
    }

}
