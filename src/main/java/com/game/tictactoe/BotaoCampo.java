package com.game.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BotaoCampo extends Button {
    private static int jogadas = 1;

    private int linha;
    private int coluna;

    private static int primeiraLinhaCompleta;
    private static int segundaLinhaCompleta;
    private static int terceiraLinhaCompleta;

    private static int primeiraColunaCompleta;
    private static int segundaColunaCompleta;
    private static int TerceiraColunaCompleta;

    private static int diagonal1;
    private static int diagonal2;

    private static int pl1;
    private static int pl2;

    public BotaoCampo() {
        setPrefSize(75, 75);
        setAlignment(Pos.CENTER);
        setFont(Font.font("System", FontWeight.BOLD, 35));
        setStyle("-fx-background-color: #c0c0c0;");
        this.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Node botao = (Node) event.getTarget();
                linha = GridPane.getRowIndex(botao);
                coluna = GridPane.getColumnIndex(botao);

                if (getText() != "") {
                    setText(getText());
                } else {
                    jogadas--;
                    if (jogadas % 2 == 0) {
                        setText("o");
                        setTextFill(Color.valueOf("#004398"));
                    } else {
                        setText("x");
                        setTextFill(Color.valueOf("#ff6700"));
                    }
                    checaLinhas();
                    checaColunas();
                    checaDiagonais();
                    venc();
                }
            }
        });
    }

    public static Button criarBotaoCampo() {
        jogadas++;
        return new BotaoCampo();
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void checaLinhas() {

        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 0) {
            primeiraLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 0) {
            primeiraLinhaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 0) {
            primeiraLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 0) {
            primeiraLinhaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 0) {
            primeiraLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 0) {
            primeiraLinhaCompleta--;
        }

        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 1) {
            segundaLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 1) {
            segundaLinhaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 1) {
            segundaLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 1) {
            segundaLinhaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 1) {
            segundaLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 1) {
            segundaLinhaCompleta--;
        }

        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 2) {
            terceiraLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 2) {
            terceiraLinhaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 2) {
            terceiraLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 2) {
            terceiraLinhaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 2) {
            terceiraLinhaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 2) {
            terceiraLinhaCompleta--;
        }
    }

    public void checaColunas() {

        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 0) {
            primeiraColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 0) {
            primeiraColunaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 1) {
            primeiraColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 1) {
            primeiraColunaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 2) {
            primeiraColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 2) {
            primeiraColunaCompleta--;
        }

        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 0) {
            segundaColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 0) {
            segundaColunaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 1) {
            segundaColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 1) {
            segundaColunaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 2) {
            segundaColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 2) {
            segundaColunaCompleta--;
        }

        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 0) {
            TerceiraColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 0) {
            TerceiraColunaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 1) {
            TerceiraColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 1) {
            TerceiraColunaCompleta--;
        }
        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 2) {
            TerceiraColunaCompleta++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 2) {
            TerceiraColunaCompleta--;
        }
    }

    public void checaDiagonais() {
        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 0) {
            diagonal1++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 0) {
            diagonal1--;
        }
        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 1) {
            diagonal1++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 1) {
            diagonal1--;
        }
        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 2) {
            diagonal1++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 2) {
            diagonal1--;
        }

        if (this.getText().equals("x") && this.getColuna() == 2 && this.getLinha() == 0) {
            diagonal2++;
        } else if (this.getText().equals("o") && this.getColuna() == 2 && this.getLinha() == 0) {
            diagonal2--;
        }
        if (this.getText().equals("x") && this.getColuna() == 1 && this.getLinha() == 1) {
            diagonal2++;
        } else if (this.getText().equals("o") && this.getColuna() == 1 && this.getLinha() == 1) {
            diagonal2--;
        }
        if (this.getText().equals("x") && this.getColuna() == 0 && this.getLinha() == 2) {
            diagonal2++;
        } else if (this.getText().equals("o") && this.getColuna() == 0 && this.getLinha() == 2) {
            diagonal2--;
        }

    }

    public void venc() {
        if (primeiraLinhaCompleta == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (primeiraLinhaCompleta == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        }
        if (segundaLinhaCompleta == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (segundaLinhaCompleta == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        }
        if (terceiraLinhaCompleta == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (terceiraLinhaCompleta == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        }
        if (primeiraColunaCompleta == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (primeiraColunaCompleta == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        }
        if (segundaColunaCompleta == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (segundaColunaCompleta == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        }
        if (TerceiraColunaCompleta == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (TerceiraColunaCompleta == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        }
        if (diagonal1 == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (diagonal1 == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        }
        if (diagonal2 == 3) {
            pl1++;
            mostrarPlacar();
            zerarJogo();
        } else if (diagonal2 == -3) {
            pl2++;
            mostrarPlacar();
            zerarJogo();
        } else if (jogadas == 1) {
            mostrarPlacarEmpate();
            zerarJogo();
        }
    }

    private void zerarJogo() {
        Parent parent = this.getParent();
        if (parent instanceof GridPane) {
            GridPane gridPane = (GridPane) parent;
            for (Node node : gridPane.getChildren()) {
                if (node instanceof BotaoCampo) {
                    BotaoCampo botao = (BotaoCampo) node;
                    botao.setText("");
                }
            }
        }
        jogadas = 10;
        primeiraLinhaCompleta = 0;
        segundaLinhaCompleta = 0;
        terceiraLinhaCompleta = 0;
        primeiraColunaCompleta = 0;
        segundaColunaCompleta = 0;
        TerceiraColunaCompleta = 0;
        diagonal1 = 0;
        diagonal2 = 0;
    }

    public void mostrarPlacar() {
        Alert alert = new Alert(AlertType.NONE);
        DialogPane dialogPane = new DialogPane();
        alert.setTitle("Placar");
        dialogPane.setPrefWidth(300);
        dialogPane.setPrefHeight(100);

        Text text1 = new Text(String.valueOf(pl1));
        Text text2 = new Text(" - ");
        Text text3 = new Text(String.valueOf(pl2));

        text1.setStyle("-fx-fill: #ff6700;");
        text3.setStyle("-fx-fill: #004398;");
        Font font = Font.font("System", FontWeight.BOLD, 35);
        text1.setFont(font);
        text2.setFont(font);
        text3.setFont(font);

        Label label = new Label();
        label.setGraphic(new HBox(text1, text2, text3));
        StackPane stackPane = new StackPane(label);
        stackPane.setMaxWidth(Double.MAX_VALUE);
        dialogPane.setContent(stackPane);

        ButtonType buttonType = new ButtonType("Ok", ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(buttonType);
        Button closeButton = (Button) dialogPane.lookupButton(buttonType);
        closeButton.setOnAction(e -> alert.hide());

        alert.setDialogPane(dialogPane);
        alert.showAndWait();
    }

    public void mostrarPlacarEmpate() {
        Alert alert = new Alert(AlertType.NONE);
        DialogPane dialogPane = new DialogPane();
        alert.setTitle("Velha");
        dialogPane.setPrefWidth(300);
        dialogPane.setPrefHeight(100);

        Text text = new Text("Deu velha!!!");

        text.setStyle("-fx-fill: #008000;");
        Font font = Font.font("System", FontWeight.BOLD, 35);
        text.setFont(font);

        Label label = new Label();
        label.setGraphic(new HBox(text));
        StackPane stackPane = new StackPane(label);
        stackPane.setMaxWidth(Double.MAX_VALUE);
        dialogPane.setContent(stackPane);

        ButtonType buttonType = new ButtonType("Ok", ButtonData.CANCEL_CLOSE);
        dialogPane.getButtonTypes().add(buttonType);
        Button closeButton = (Button) dialogPane.lookupButton(buttonType);
        closeButton.setOnAction(e -> alert.hide());

        alert.setDialogPane(dialogPane);
        alert.showAndWait();
    }
}
