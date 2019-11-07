package br.com.nemeth;

import br.com.nemeth.RMI.Servidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

import java.rmi.RemoteException;

public class Controller {

    private Servidor servidor = null;

    public void initialize(){
        try {
            servidor = new Servidor();
        }catch (RemoteException e) {
            System.out.println("Falha ao instanciar servidor");
            e.printStackTrace();
        }
    }

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

    @FXML
    void conectar(ActionEvent event) {
        System.out.println("conectar");
    }

    @FXML
    void sincronizar(ActionEvent event) {
        System.out.println("conectar");

    }
}
