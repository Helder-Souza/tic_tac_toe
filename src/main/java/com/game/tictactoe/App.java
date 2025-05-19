package com.game.tictactoe;

import java.io.IOException;
import org.controlsfx.control.Notifications;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    private Stage janela;
    private Scene cena1;
    private Scene cena2;

    private String background = "-fx-background-color: #ebebeb;";

    JogoControlador cont = new JogoControlador();

    Button btSair = btSair();

    @Override
    public void start(Stage primaryStage) throws Exception {
        janela = primaryStage;

        CriarCena1();

        janela.setTitle("Jogo da Velha");
        janela.setScene(cena1);
        janela.show();
    }

    private void CriarCena1() throws Exception {

        Label label1 = new Label("Nome Jogador 1:");
        label1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        label1.setTextFill(Color.valueOf("#ff6700"));
        TextField jogador1 = new TextField();

        Label label2 = new Label("Nome Jogador 2:");
        label2.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        label2.setTextFill(Color.valueOf("#004398"));
        TextField jogador2 = new TextField();

        HBox hbox = new HBox(7);

        GridPane cena1Pane = new GridPane();
        cena1Pane.setAlignment(Pos.CENTER);

        Button bt = new Button("Iniciar Jogo");
        bt.setMinSize(150, 20);
        bt.setStyle("-fx-background-color: linear-gradient(to right, " +
                "#ff6700, #004398);");
        bt.setTextFill(Color.WHITE);

        cena1Pane.add(bt, 0, 0);
        cena1Pane.setPadding(new Insets(10));
        cena1Pane.setHgap(10);
        cena1Pane.setAlignment(Pos.CENTER);

        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(label1, jogador1);

        HBox box2 = new HBox(7);
        box2.setAlignment(Pos.CENTER);
        box2.getChildren().addAll(label2, jogador2);

        HBox box3 = new HBox();
        ImageView imageView = new ImageView(new Image(String.valueOf(App.class.getResource("logo.png"))));
        box3.getChildren().add(imageView);
        box3.setAlignment(Pos.CENTER);
        box3.setStyle("-fx-padding: 10px 20px 30px 20px;");

        VBox vert = new VBox();
        vert.getChildren().addAll(box3, hbox, box2);
        vert.setAlignment(Pos.CENTER);
        vert.setSpacing(10);
        vert.setStyle(background);

        cena1 = new Scene(vert, 800, 600);
        ((VBox) cena1.getRoot()).getChildren().add(cena1Pane);

        bt.setOnAction(e -> {
            boolean jogador1Valido = !jogador1.getText().isEmpty() && !jogador1.getText().equalsIgnoreCase(jogador2.getText());
            boolean jogador2Valido = !jogador2.getText().isEmpty() && !jogador2.getText().equalsIgnoreCase(jogador1.getText());

            try {
                CriarCena2(jogador1.getText(), jogador2.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if(jogador1Valido && jogador2Valido) {
                Notifications.create()
                        .position(Pos.CENTER)
                        .title("Jogo da Velha")
                        .text("Jogo iniciado com sucesso!")
                        .showInformation();
                janela.setScene(cena2);
            } else {
                Notifications.create()
                        .position(Pos.CENTER)
                        .title("Jogo da Velha")
                        .text("Jogadores com nomes inválidos")
                        .showError();
            }
        });
    }

    private void CriarCena2(String nome1, String nome2) throws IOException {

        Label label1 = new Label(nome1);
        label1.setText(label1.getText().toUpperCase());
        label1.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #ff6700;");
        Label label2 = new Label(nome2);
        label2.setText(label2.getText().toUpperCase());
        label2.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #004398;");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(label1, label2);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(350);
        hbox.setPadding(new Insets(10, 10, 80, 10));
        hbox.setStyle(background);

        GridPane pane = new GridPane();
        pane.setStyle(background);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pane.add(BotaoCampo.criarBotaoCampo(), i, j);
            }
        }

        HBox boxBotoes = new HBox();
        boxBotoes.getChildren().add(btSair);

        VBox box = new VBox();
        box.setStyle(background);

        box.setAlignment(Pos.CENTER);
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setStyle("-fx-padding: 30px 20px 30px 20px;");

        cena2 = new Scene(box, 800, 600);
        ((VBox) cena2.getRoot()).getChildren().addAll(hbox, pane, btSair);
    }

    public Button btSair() {
        Button btSair = new Button("Sair");
        btSair.setMinSize(150, 20);
        btSair.setStyle("-fx-background-color: linear-gradient(to right, " +
                "#ff6700, #004398);");
        btSair.setTextFill(Color.WHITE);
        btSair.setOnAction(e -> {
            Platform.exit();
        });
        return btSair;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

