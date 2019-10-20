package br.com.nemeth.RMI;

import java.rmi.Remote;

public interface ServidorInterface extends Remote {

    boolean conectar();
    boolean enviarMensagem();
}
