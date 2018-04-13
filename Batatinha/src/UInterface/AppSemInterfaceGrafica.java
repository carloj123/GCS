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

			System.out.println(
					"Digite a opção do que desejar fazer\n" + "1 - Cadastrar Cliente\n" + "2 - Remover Cliente do Bar\n"
							+ "3 - Mostrar Todos Clientes do Bar\n" + "4 - Mostra um Cliente de Determinado CPF\n"
							+ "5 - Quantas Pessoas Estão no Bar\n" + "6 - Distribuição de Genero no Bar|n"
							+ "7 - Quantidade de Socios e Nao Socios no Bar|n" + "Digite '0' para Sair");
			int opcao = in.nextInt();

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

				Cliente c = new Cliente(nome, cpf, idade, genero.charAt(0));
				if (ehSocio.equalsIgnoreCase("sim"))
					c.setNumSocio(countSocio);
				countSocio++;
				bar.add(cpf, c);
				System.out.println("\n\n\n");
				break;
			}

			case 2: {
				System.out.println("Informe o CPF do cliente");
				String cpf = in.next();
				bar.saiuDoBar(cpf);
				System.out.println("\n\n\n");
				break;
			}

			case 3:
				bar.pessoasNoBar().forEach(c -> System.out.println(c));
				System.out.println("\n\n\n");

			case 4: {
				System.out.println("Informe o CPF do cliente procurado");
				String cpf = in.next();

				System.out.println(bar.pessoaNoBar(cpf).getNome());
				System.out.println("\n\n\n");
				break;
			}

			case 5:
				System.out.println("Quantidade de pessoas: " + bar.quantidadeNSociosBar() + bar.quantidadeSociosBar());
				System.out.println("\n\n\n");
				break;

			case 6:
				System.out.println("Porcentagem Feminina: " + bar.percentualFemBar() + "\nPorcentagem Masculina: "
						+ bar.percentualMascBar());
				System.out.println("\n\n\n");
				break;

			case 7:
				System.out.println("Quantidade de Socios: " + bar.quantidadeSociosBar() + "\nQuantidade de Nao Socios: "
						+ bar.quantidadeNSociosBar());
				System.out.println("\n\n\n");
				break;
			}
		}

		System.out.println("Os clientes do dia estão salvos no arquivo -> 'Users/User/Desktop/Lista_Clientes.txt'");
		bar.escreveArquivo();
	}
}
