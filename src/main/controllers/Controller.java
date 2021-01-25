package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import main.models.hilo01;
import main.models.hilo02;
import main.models.hilo03;

import java.util.concurrent.Semaphore;

public class Controller {
    hilo01 hiloA;
    hilo02 hiloB;
    hilo03 hiloC;
    @FXML
    private Button btnIniciar;

    @FXML
    private Button btnDetener;

    @FXML
    private Button btnSalir;

    @FXML
    void btnDetenerOnMouseClicked(MouseEvent event) {
        hiloA.interrupt();
        hiloB.interrupt();
        hiloC.interrupt();
    }

    @FXML
    void btnIniciarOnMouseClicked(MouseEvent event) {
        Semaphore mutex = new Semaphore(0);

        hiloA = new hilo01(mutex);
        hiloB = new hilo02(mutex);
        hiloC = new hilo03(mutex);

        hiloA.start();
        hiloB.start();
        hiloC.start();
    }

    @FXML
    void btnSalirOnMouseClicked(MouseEvent event) {
        System.exit(1);
    }

}
