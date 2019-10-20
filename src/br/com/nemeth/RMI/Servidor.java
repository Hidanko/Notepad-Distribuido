package br.com.nemeth.RMI;
import java.rmi.server.UnicastRemoteServer;


public class Servidor extends UnicastRemoteServer implements ServidorInterface {

    private int id;

    public Servidor(){

    }

    @Override
    public boolean conectar() {
        return false;
    }

    @Override
    public boolean enviarMensagem() {
        return false;
    }
}
