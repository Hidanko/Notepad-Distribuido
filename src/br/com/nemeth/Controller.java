package br.com.nemeth;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private TextArea text;

    @FXML
    private Button buttonConectar;

    @FXML
    private Button buttonSincronizar;

    @FXML
    void teclaPressionada(KeyEvent event) {
        System.out.println(event.getText());
    }
}
