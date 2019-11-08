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
        Mensagem m = new Mensagem(servidor.getId(), text.getText(), event.getText());

        for (String: servidor.getServidores()) {
            Registry registry = LocateRegistry.getRegistry(endereco, 1099);
            ServidorInterface si = (ServidorInterface) registry.lookup("Main");
            if (si != null){
                if (!si.enviarMensagem(m)){
                    throw new Exception();
                }
            }
        }
        for (String: servidor.getServidores()) {
            Registry registry = LocateRegistry.getRegistry(endereco, 1099);
            ServidorInterface si = (ServidorInterface) registry.lookup("Main");
            if (si != null){
                if (si.confirma(m)){
                    throw new Exception();
                }
            }
        }
    }

    @FXML
    void conectar(ActionEvent event) {
        System.out.println("conectar");
    }

    @FXML
    void sincronizar(ActionEvent event) {

    }

    public addCaractere(String caractere){
        text.setText(text.getText()+caractere);
    }
}
