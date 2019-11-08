package br.com.nemeth.RMI;

import java.rmi.Remote;

public interface ServidorInterface extends Remote {

    boolean conectar(String endereco, int porta);
    boolean enviarMensagem(Mensagem mensagem);
    boolean confirma(Mensagem mensagem);
}

