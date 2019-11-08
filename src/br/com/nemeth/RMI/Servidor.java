package br.com.nemeth.RMI;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;


public class Servidor implements ServidorInterface {
    private List<String> servidores;
    private int id;
    private Controller controller;

    public Servidor(Controller controller) throws RemoteException{
        this.controller = controller;
        servidores = new ArrayList<String>();
        Registry reg = null;
        reg = LocateRegistry.createRegistry(1099);
        reg.rebind("Main", this);
        System.out.println("Server ONLINE");

    }

    @Override
    public boolean conectar(String endereco, int porta) {
        if (ping(endereco,porta)) {
            servidores.add(endereco);
            return true;
        }
        return false;
    }



    private boolean ping(String endereco, int porta){
        System.out.println("Pigando "+endereco + "" + porta);
        try {
            Registry ping = LocateRegistry.getRegistry(endereco, porta);
            if (ping != null){
                return true;
            }
        } catch (RemoteException e) {
            System.out.println("Falha ao pingar "+endereco + ":"+porta);
            e.printStackTrace();
        }
        return false;
    }

    publig int getId(){
        return this.id;
    }

    public List<String> getServidores() {
        return servidores;
    }

    @Override
    public boolean enviarMensagem(Mensagem mensagem) {
        if (mensagem.getIdEvento <= controller.getText().size()){
            return false;
        }
        return true;
    }

    @Override
    public boolean confirma(Mensagem mensagem){
       controller.addCaractere(mensagem.getMensagem());
    }
}
