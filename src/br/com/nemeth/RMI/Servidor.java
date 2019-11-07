package br.com.nemeth.RMI;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;


public class Servidor implements ServidorInterface {
    private List<String> servidores;
    private int id;

    public Servidor() throws RemoteException{
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


    @Override
    public boolean enviarMensagem() {
        return false;
    }


    private boolean ping(String endereco, int porta){
        System.out.println("Pigando "+endereco + "" + porta);
        try {
            Registry ping = LocateRegistry.getRegistry(endereco, porta);
//            cliente =

        } catch (RemoteException e) {
            System.out.println("Falha ao pingar "+endereco + ":"+porta);
            e.printStackTrace();
        }
        return false;
    }
}
