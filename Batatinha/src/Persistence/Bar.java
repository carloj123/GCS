package Batatinha.src.Persistence;

import Batatinha.src.Business.*;
import Batatinha.src.Persistence.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bar {
    private HashMap<String, Cliente> clientes;
    private HashMap<String, Cliente> socios;
    private HashMap<String, Cliente> pessoas;
    private List<Cliente> clientesFixo;
    private List<Cliente> sociosFixo;
    private Milhas milhas;

    public Bar() {
        this.clientes = new HashMap<>();
        this.socios = new HashMap<>();
        this.pessoas = new HashMap<>();
        this.clientesFixo = new ArrayList<>();
        this.sociosFixo = new ArrayList<>();
        this.milhas  = new Milhas();
    }

    public void add(String s, Cliente c) {
        if (c.getNumSocio() != 0) {
            socios.put(c.getCpf(), c);
            sociosFixo.add(c);
            milhas.addMilha(c);

        } else {
            clientes.put(c.getCpf(), c);
            clientesFixo.add(c);

        }
        pessoas.put(c.getNome(), c);
    }

    public ArrayList<String> pessoasNoBar() {
        ArrayList<String> pessoas = new ArrayList<>();

        for (String key : clientes.keySet()) {
            pessoas.add(clientes.get(key).getNome());
        }
        for (String key : socios.keySet()) {
            pessoas.add(socios.get(key).getNome());
        }

        return pessoas;
    }

    public ArrayList<Cliente> pessoasNoBar(int i) {
        ArrayList<Cliente> pessoas = new ArrayList<>();

        for (String key : clientes.keySet()) {
            pessoas.add(clientes.get(key));
        }
        for (String key : socios.keySet()) {
            pessoas.add(socios.get(key));
        }

        return pessoas;
    }

    public Cliente pessoaNoBar(String cpf) {

        if (clientes.get(cpf) != null)
            return clientes.get(cpf);

        else if (socios.get(cpf) != null)
            return socios.get(cpf);

        return null;

    }

    public void saiuDoBarNome(String nome) {

        if (clientes.containsKey(pessoas.get(nome).getCpf()))
            clientes.remove(pessoas.get(nome).getCpf());

        else
            socios.remove(pessoas.get(nome).getCpf());
    }

    public void saiuDoBar(String cpf) {

        if (clientes.containsKey(cpf)) {
            clientes.remove(cpf);
        }

        else {
            socios.remove(cpf);
        }
    }

    public double porcentagemSociosNoBar() {

        int total = pessoasNoBar().size();
        int quantSocio = socios.size();

        double perSocio = (quantSocio * 100) / total;

        return perSocio ;

    }

    public double porcentagemNSociosNoBar(){

        int total = pessoasNoBar().size();
        int quantiNSocio = clientes.size();

        double percNSocio = (quantiNSocio * 100) / total;

        return percNSocio;
    }

    public double porcentagemSociosDia() {

        int total = pessoas.size();
        int quantSocio = socios.size();

        double perSocio = (quantSocio * 100) / total;

        return perSocio;

    }

    public double porcentagemNSociosDia(){

        int total = pessoas.size();
        int quantiNSocio = clientes.size();

        double percNSocio = (quantiNSocio * 100) / total;

        return percNSocio;
    }

    public int quantidadeSociosBar() {

        return socios.size();

    }

    public int quantidadeNSociosBar(){
        return clientes.size();
    }

    public double percentualMascBar() {

        int quantMasc = 0;
        int cont = 0;

        for (Cliente c : pessoasNoBar(0)) {
            if (c.getGenero() == 'M') {
                quantMasc++;
            }
            cont++;
        }

        double perHom = (quantMasc * 100) / cont;

        return perHom;
    }

    public double percentualFemBar(){
        int cont = 0;
        int quantFem = 0;

        for (Cliente c : pessoasNoBar(0)) {
            if (c.getGenero() == 'F') {
                quantFem++;
            }
            cont++;
        }


        double percMul = (quantFem * 100) / cont;

        return percMul;

    }

    public int quantidadePessoasDia(){
        return pessoas.size();
    }
    
    public void escreveArquivo() throws IOException{
    	
    	File arquivo = new File("Users/User/Desktop/Lista_Clientes.txt");
    	
    	if(!arquivo.exists()){
    		arquivo.createNewFile();
    	}
    	
    	BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
    	
    	for(String key: pessoas.keySet()){
    		
    		if(pessoas.get(key).getNumSocio()==0){
    			bw.write(key + " - " + "cliente\n");
    		}
    		else{
    			bw.write(key + " - " + "socio\n");
    		}
    		
    	}
    	bw.close();
    	
    	
    }

}
