package br.com.nemeth.RMI;

import java.io.Serializable;

public final class Mensagem implements Serializable {
    private int idSerial;
    private int idEvento;
    private String mensagem;

    public int getIdEvento() {
        return idEvento;
    }

    public int getIdSerial() {
        return idSerial;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Mensagem(int idSerial, int idEvento, String mensagem) {
        this.idSerial = idSerial;
        this.idEvento = idEvento;
        this.mensagem = mensagem;
    }
}
