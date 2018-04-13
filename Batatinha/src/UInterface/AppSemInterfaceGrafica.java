package Batatinha.src.UInterface;

import java.io.IOException;
import java.util.Scanner;

import Batatinha.src.Persistence.Bar;
import Batatinha.src.Persistence.Cliente;

public class AppSemInterfaceGrafica {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Bar bar = new Bar();
		int countSocio = 0;
		while (true) {

			System.out.println("Digite a op��o do que desejar fazer\n" + "1 - Cadastrar Cliente\					+ "2 - Remover Cliente do Bar\n" + "3 - Mostrar Todos Clientes do Bar\n"
					+ "4 - Mostra um Cliente de Determinado CPF\n" + "5 - Quantas Pessoas Est�o no Bar\n"					+ "6 - Distribui��o de Genero no Bar\n" + "7 - Quantidade de Socios e Nao Socios no Bar\					+ "8 - CPF das Pessoas no Bar\n" + "9 - Idade das Pessoas no Bar\n" + "Digite '0' para Sair");
			int opcao = in.nextInt();

			if (opcao > 9 || opcao < 0) {
				System.out.println("Informe uma opcao valida");
				opcao = in.nextInt();
			}

			if (opcao == 0) {
				break;
			}

			switch (opcao) {

			case 1: {
				System.out.println("Informe o nome do cliente");
				String nome = in.nextLine();
				nome = in.nextLine();
				System.out.println("Informe o CPF do cliente");
				String cpf = in.next();
				System.out.println("Informe a idade do cliente");
				int idade = in.nextInt();
				System.out.println("Informe o genero do cliente");
				String genero = in.next();
				System.out.println("Informe se o cliente eh socio(sim ou nao)");
				String ehSocio = in.next();

				if (!bar.verificaCPF(cpf)) {
					do {
						System.out.println("Insira um CPF valido");
						cpf = in.next();
					} while (!bar.verificaCPF(cpf));
				}
				if(!bar.verificaIdade(idade)){
					do{
						System.out.println("Idade Inv�lida");						idade = in.nextInt();
					}while(!bar.verificaIdade(idade));
				}
				if(!bar.verificaIdade(idade, idade)){
					System.out.println("Usuario nao tem idade suficiente");
					break;
				}

				Cliente c = new Cliente(nome, cpf, idade, genero.charAt(0));
				System.out.println();
				if (!(ehSocio.equalsIgnoreCase("sim")) && !(ehSocio.equalsIgnoreCase("nao"))) {
					System.out.println("Digite 'sim' ou 'nao' ");
					ehSocio = in.next();
				} else if (ehSocio.equalsIgnoreCase("sim")) {
					c.setNumSocio(countSocio);
					countSocio++;
				}
				bar.add(cpf, c);
				System.out.println("\n\n\n\n\n\n");
				break;

			}

			case 2: {
				System.out.println("Informe o CPF ou Nome do cliente");
				String cpfNome = in.next();

				try {
					Integer.parseInt(cpfNome);
					bar.saiuDoBar(cpfNome);
				} catch (Exception e) {
					bar.saiuDoBarNome(cpfNome);
				}

				System.out.println("\n\n\n\n\n\n");
				break;
			}

			case 3:
				bar.pessoasNoBar().forEach(c -> System.out.println(c));
				System.out.println("\n\n\n\n\n\n");

			case 4: {
				System.out.println("Informe o CPF do cliente procurado");
				String cpf = in.next();

				System.out.println(bar.pessoaNoBar(cpf).getNome());
				System.out.println("\n\n\n\n\n\n");
				break;
			}

			case 5:
				int batata = bar.quantidadeNSociosBar() + bar.quantidadeSociosBar();
				System.out.println("Quantidade de pessoas: " + batata);
				System.out.println("\n\n\n\n\n\n");
				break;

			case 6:
				System.out.println("Porcentagem Feminina: " + bar.percentualFemBar() + "\nPorcentagem Masculina: "
						+ bar.percentualMascBar());
				System.out.println("\n\n\n\n\n\n");
				break;

			case 7:
				System.out.println("Quantidade de Socios: " + bar.quantidadeSociosBar() + "\nQuantidade de Nao Socios: "
						+ bar.quantidadeNSociosBar());
				System.out.println("\n\n\n\n\n\n");
				break;

			case 8:
				bar.pessoasNoBar(0).forEach(c -> System.out.println(c.getCpf()));
				break;

			case 9:
				bar.pessoasNoBar(0).forEach(c -> System.out.println(c.getIdade()));
				break;
			}
		}

		System.out.println("Os clientes do dia est�o salvos no arquivo -> 'Users/User/Desktop/Lista_Clientes.txt'");		bar.escreveArquivo();
	}
}
