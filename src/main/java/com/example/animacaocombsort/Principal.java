package com.example.animacaocombsort;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import java.util.LinkedHashMap;
import java.util.Random;

public class Principal extends Application {
    AnchorPane pane;
    Button botao_inicio, valor1, valor2, sinal, distText, distValue;
    Text codigo, title;
    private Button vet[];
    int TL = 8;
    Circle cod;
    Line linha1, linha2, distancia;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CombSort");
        pane = new AnchorPane();

        title = new Text();
        title.setText("Comb Sort");
        title.setStyle("-fx-font: 25 arial;");
        title.setLayoutX(100);
        title.setLayoutY(100);

        pane.getChildren().add(title);

        botao_inicio = new Button();
        botao_inicio.setLayoutX(10);
        botao_inicio.setLayoutY(200);
        botao_inicio.setText("ORDENAR");
        botao_inicio.setOnAction(e -> {
            combSort();
        });
        pane.getChildren().add(botao_inicio);

        vet = new Button[TL];

        for (int i = 0, j = 100; i < TL; i++, j += 80) {
            vet[i] = new Button("" + new Random().nextInt(12));
            vet[i].setLayoutX(j);
            vet[i].setLayoutY(300);
            vet[i].setMinHeight(40);
            vet[i].setMinWidth(40);
            vet[i].setFont(new Font(14));
            vet[i].setStyle("-fx-background-color: lightgrey;");
            pane.getChildren().add(vet[i]);
        }

        codigo = new Text();
        codigo.setStyle("-fx-font: 20 arial;");
        codigo.setText("public void combSort() {\n" +
                "|       int dist = TL - 1, aux;\n|\n" +
                "|       dist /= 1.3;\n" +
                "|       while(dist > 0) {\n" +
                "|       |        for(int i=0, j=dist; j<TL; i++, j++) {\n" +
                "|       |        |        if(vet[i] > vet[j]) {\n" +
                "|       |        |        |        aux = vet[i];\n" +
                "|       |        |        |        vet[i] = vet[j];\n" +
                "|       |        |        |        vet[j] = aux;\n" +
                "|       |        |        }\n" +
                "|       |        }\n" +
                "|       |        dist /= 1.3;\n" +
                "|       }\n" +
                "}");
        codigo.setLayoutX(900);
        codigo.setLayoutY(200);

        cod = new Circle(5, Color.RED);
        cod.setLayoutX(880);//40
        cod.setLayoutY(195);//23

        pane.getChildren().add(codigo);
        pane.getChildren().add(cod);

        valor1 = new Button();
        valor1.setLayoutX(250);
        valor1.setLayoutY(200);
        valor1.setMinHeight(40);
        valor1.setMinWidth(40);
        valor1.setFont(new Font(14));
        valor1.setStyle("-fx-background-color: lightgrey;");

        valor2 = new Button();
        valor2.setLayoutX(350);
        valor2.setLayoutY(200);
        valor2.setMinHeight(40);
        valor2.setMinWidth(40);
        valor2.setFont(new Font(14));
        valor2.setStyle("-fx-background-color: lightgrey;");

        sinal = new Button();
        sinal.setLayoutX(300);
        sinal.setLayoutY(200);
        sinal.setMinHeight(40);
        sinal.setMinWidth(40);
        sinal.setFont(new Font(14));
        sinal.setStyle("-fx-background-color: lightgrey;");
        sinal.setText(">");

        distText = new Button();
        distText.setLayoutX(100);
        distText.setLayoutY(500);
        distText.setMinHeight(40);
        distText.setMinWidth(80);
        distText.setFont(new Font(14));
        distText.setStyle("-fx-background-color: lightgrey;");
        distText.setText("DIST =");

        distValue = new Button();
        distValue.setLayoutX(170);
        distValue.setLayoutY(500);
        distValue.setMinHeight(40);
        distValue.setMinWidth(40);
        distValue.setFont(new Font(14));
        distValue.setStyle("-fx-background-color: lightgrey;");

        pane.getChildren().add(distText);
        pane.getChildren().add(distValue);
        pane.getChildren().add(valor1);
        pane.getChildren().add(valor2);
        pane.getChildren().add(sinal);

        linha1 = new Line();
        linha2 = new Line();
        distancia = new Line();

        linha1.setStartX(120);
        linha1.setStartY(350);
        linha1.setEndX(120);
        linha1.setEndY(370);

        linha2.setStartX(680);
        linha2.setStartY(350);
        linha2.setEndX(680);
        linha2.setEndY(370);

        distancia.setStartX(120);
        distancia.setStartY(370);
        distancia.setEndX(680);
        distancia.setEndY(370);

        pane.getChildren().add(linha1);
        pane.getChildren().add(linha2);
        pane.getChildren().add(distancia);

        Scene scene = new Scene(pane, 800, 600);
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
    }

    public void move_botoes(int pos1, int pos2, int dist) {
//permutação na tela
        for (int i = 0; i < 10; i++) {
            Platform.runLater(() -> vet[pos1].setLayoutY(vet[pos1].getLayoutY() + 5));
            Platform.runLater(() -> vet[pos2].setLayoutY(vet[pos2].getLayoutY() - 5));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < dist / 5; i++) {
            Platform.runLater(() -> vet[pos1].setLayoutX(vet[pos1].getLayoutX() + 5));
            Platform.runLater(() -> vet[pos2].setLayoutX(vet[pos2].getLayoutX() - 5));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            Platform.runLater(() -> vet[pos1].setLayoutY(vet[pos1].getLayoutY() - 5));
            Platform.runLater(() -> vet[pos2].setLayoutY(vet[pos2].getLayoutY() + 5));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//permutação na memória
        Button aux = vet[pos1];
        vet[pos1] = vet[pos2];
        vet[pos2] = aux;
    }


    //QUICKSORT
    public void combSort() {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                int dist = TL - 1, i, j;

                moveDot(1, 1);
                int finalDist = dist;
                Platform.runLater(() -> {
                    distValue.setText("" + finalDist);
                });
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                dist /= 1.3;
                moveDot(3, 1);
                while (dist > 0) {
                    i = 0;
                    j = dist;

                    int finalDist1 = dist;
                    Platform.runLater(() -> {
                        distValue.setText("" + finalDist1);
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    moveDot(4, 1);

                    while (j < TL) {
                        moveDot(5, 2);
                        colorGrey(valor1, valor2, sinal);
                        setDist(i, j);
                        comparacao(vet[i].getText(), vet[j].getText());
                        moveDot(6, 3);
                        if (Integer.parseInt(vet[i].getText()) > Integer.parseInt(vet[j].getText())) {
                            colorGreen(valor1, valor2, sinal);
                            moveDot(8, 4);
                            move_botoes(i, j, (j - i) * 80);
                        }
                        else {
                            colorRed(valor1, valor2, sinal);
                        }
                        i++;
                        j++;
                    }
                    dist /= 1.3;
                    moveDot(12, 2);
                }

                for (i = 0; i < TL; i++) {
                    int finalI = i;
                    Platform.runLater(() -> {
                        vet[finalI].setStyle("-fx-background-color: lightgreen;");
                    });
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                linha1.setStartX(0);
                linha1.setStartY(0);
                linha1.setEndX(0);
                linha1.setEndY(0);

                linha2.setStartX(0);
                linha2.setStartY(0);
                linha2.setEndX(0);
                linha2.setEndY(0);

                distancia.setStartX(0);
                distancia.setStartY(0);
                distancia.setEndX(0);
                distancia.setEndY(0);



                return null;
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    public void comparacao(String a, String b) {
        Platform.runLater(() -> {
            valor1.setText(a);
            valor2.setText(b);
        });
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void moveDot(int lin, int col) {
        int i = 880, j = 195;

        Platform.runLater(() -> {
            cod.setLayoutX(i + col * 45);
            cod.setLayoutY(j + lin * 23);
        });
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDist(int i, int j) {
        int dist1 = 120 + i * 80;
        int dist2 = 120 + j * 80;
        Platform.runLater(() -> {
            linha1.setStartX(dist1);
            linha1.setEndX(dist1);

            linha2.setStartX(dist2);
            linha2.setEndX(dist2);

            distancia.setStartX(dist1);
            distancia.setEndX(dist2);
        });
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void colorGreen(Button bt1, Button bt2, Button bt3) {
        Platform.runLater(() -> {
            bt1.setStyle("-fx-background-color: lightgreen;");
            bt2.setStyle("-fx-background-color: lightgreen;");
            bt3.setStyle("-fx-background-color: lightgreen;");
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void colorGrey(Button bt1, Button bt2, Button bt3) {
        Platform.runLater(() -> {
            bt1.setStyle("-fx-background-color: lightgrey;");
            bt2.setStyle("-fx-background-color: lightgrey;");
            bt3.setStyle("-fx-background-color: lightgrey;");
        });
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void colorRed(Button bt1, Button bt2, Button bt3) {
        Platform.runLater(() -> {
            bt1.setStyle("-fx-background-color: #ff5555;");
            bt2.setStyle("-fx-background-color: #ff5555;");
            bt3.setStyle("-fx-background-color: #ff5555;");
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}