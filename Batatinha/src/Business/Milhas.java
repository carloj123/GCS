package Business;

import Persistence.Cliente;

import java.util.HashMap;

public class Milhas{

    HashMap<Cliente, Integer> milhasPorCliente;

    public Milhas(){

        this.milhasPorCliente = new HashMap<>();

    }

    public void addMilha(Cliente c){

        if(milhasPorCliente.containsKey(c)){
            milhasPorCliente.put(c, (milhasPorCliente.get(c) + 100));
        }
        else{
            milhasPorCliente.put(c,100);
        }
    }

    public boolean usaMilhas(Cliente c, int milhas){

        if(milhasPorCliente.containsKey(c)){
            milhasPorCliente.put(c, (milhasPorCliente.get(c) - milhas));
            return true;
        }
        else{
            return false;
        }

    }

    public boolean apagarSocio(Cliente c){
        if(milhasPorCliente.containsKey(c)){
            milhasPorCliente.remove(c);
            return true;
        }
        else{
            return false;
        }
    }

}
