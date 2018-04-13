package Batatinha.src.Persistence;

public class Cliente {
	private String nome;
	private String cpf;
	private int idade;
	private char genero;
	private int numSocio;

	public Cliente(String nome, String cpf, int idade, char genero) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.genero = genero;
		this.numSocio = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getNumSocio() {
		return numSocio;
	}

	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}

	@Override
	public String toString() {
		return "Cliente \n\n nome=" + nome + "\n cpf=" + cpf + "\n idade=" + idade + "\n genero=" + genero + "\n numSocio="
				+ numSocio;
	}
	
	
	
	
}
