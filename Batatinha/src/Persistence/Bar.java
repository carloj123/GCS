package Batatinha.src.Persistence;

import Batatinha.src.Business.*;
import Batatinha.src.Persistence.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
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
		this.milhas = new Milhas();
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

	public Cliente pessoaNoBar(String nome, int i) {
		if (pessoas.containsKey(nome)) {
			if (clientes.containsKey(pessoas.get(nome).getCpf()))
				return clientes.get(pessoas.get(nome).getCpf());

			else if (socios.containsKey(pessoas.get(nome).getCpf()))
				return socios.get(pessoas.get(nome).getCpf());

			else
				return null;

		}

		return null;
	}

	public boolean saiuDoBarNome(String nome) {
		if (pessoas.containsKey(nome)) {
			if (clientes.containsKey(pessoas.get(nome).getCpf())) {
				clientes.remove(pessoas.get(nome).getCpf());
				return true;
			} else {
				socios.remove(pessoas.get(nome).getCpf());
				return true;
			}
		}
		return false;
	}

	public boolean saiuDoBar(String cpf) {

		if (clientes.containsKey(cpf)) {
			clientes.remove(cpf);
			return true;
		}

		else if (socios.containsKey(cpf)) {
			socios.remove(cpf);
			return true;
		}
		return false;
	}

	public double porcentagemSociosNoBar() {

		int total = pessoasNoBar().size();
		int quantSocio = socios.size();

		double perSocio = (quantSocio * 100) / total;

		return perSocio;

	}

	public double porcentagemNSociosNoBar() {

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

	public double porcentagemNSociosDia() {

		int total = pessoas.size();
		int quantiNSocio = clientes.size();

		double percNSocio = (quantiNSocio * 100) / total;

		return percNSocio;
	}

	public int quantidadeSociosBar() {

		return socios.size();

	}

	public int quantidadeNSociosBar() {
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

	public double percentualFemBar() {
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

	public int quantidadePessoasDia() {
		return pessoas.size();
	}

	public void escreveArquivo() throws IOException {

		File arquivo = new File("Users/User/Desktop/Lista_Clientes.txt");

		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));

		for (String key : pessoas.keySet()) {

			if (pessoas.get(key).getNumSocio() == 0) {
				bw.write(key + " - " + "cliente\n");
			} else {
				bw.write(key + " - " + "socio\n");
			}

		}
		bw.close();
	}

	public boolean verificaCPF(String cpf) {
		int[] num = new int[11];
		for (int i = 0; i < cpf.length(); i++) {
			Character cpfVet = cpf.charAt(i);
			num[i] = Integer.parseInt(cpfVet.toString());
		}

		int aux = 0;
		int count = 10;
		for (int j = 0; j < num.length - 2; j++) {
			aux = aux + (num[j] * count);
			count--;
		}

		aux = -(aux % 11) + 11;

		if (aux > 9) {
			aux = 0;
		}

		int aux1 = 0;
		int count1 = 11;
		for (int k = 0; k < num.length - 2; k++) {
			aux1 = aux1 + (num[k] * count1);
			count1--;
		}

		aux1 = -(aux1 % 11) + 11;

		if (num[9] == aux && num[10] == aux1) {
			return true;
		}

		return false;
	}

	public boolean verificaIdade(int idade, int idade2) {
		if (idade >= 18) {
			return true;
		}
		return false;
	}

	public boolean verificaIdade(int idade) {
		if (idade < 0 || idade > 123) {
			return false;
		}
		return true;
	}
}
