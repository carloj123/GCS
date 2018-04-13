package Batatinha.src.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Batatinha.src.Persistence.*;

public class TestaBar {
	
	Cliente c1;
	Cliente c2;
	Cliente c3;
	Cliente c4;
	Cliente c5;
	Cliente c6;
	Bar bar;

	@Before
	public void setUp(){
		c1 = new Cliente("juca", "123456789101", 24, 'M');
		c2 = new Cliente("joca", "123456789102", 25, 'M');
		c3 = new Cliente("jussara", "123456789103", 26, 'F');
		c4 = new Cliente("jozicreide", "123456789104", 27, 'F');
		c5 = new Cliente("janio", "123456789105", 28, 'M');
		c6 = new Cliente("jaca", "123456789106", 29, 'F');
		bar = new Bar();
		c1.setNumSocio(934);
		c2.setNumSocio(356);

		bar.add(c1.getCpf(), c1);
		bar.add(c2.getCpf(), c2);
		bar.add(c3.getCpf(), c3);
		bar.add(c4.getCpf(), c4);
		bar.add(c5.getCpf(), c5);
		bar.add(c6.getCpf(), c6);
	}
	
	@Test
	public void clienteSemSaida() {

		c5.setNumSocio(880);

		int retorno = bar.pessoasNoBar().size();

		assertEquals(6, retorno);

	}

	@Test
	public void clienteComSaida() {
		c5.setNumSocio(880);

		bar.saiuDoBar(c1.getCpf());
		bar.saiuDoBar(c4.getCpf());

		int retorno = bar.pessoasNoBar().size();

		assertEquals(4, retorno);

	}

	@Test
	public void porcentagemSociosSemSaida() {
		c5.setNumSocio(880);

		double retorno = bar.porcentagemSociosNoBar();

		double esperado = (3 * 100) / 6;

		assertEquals(esperado, retorno);

	}

	@Test
	public void porcentagemSociosComSaida() {
		
		c5.setNumSocio(880);

		bar.saiuDoBar(c1.getCpf());

		double retorno = bar.porcentagemSociosNoBar();

		double esperado = (2 * 100) / 5;

		assertEquals(esperado, retorno);

	}

	@Test
	public void porcentagemNaoSociosSemSaida() {

		double retorno = bar.porcentagemNSociosNoBar();

		double esperado = (4 * 100) / 6;

		assertEquals(esperado, retorno);

	}

	@Test
	public void porcentagemNaoSociosComSaida() {

		bar.saiuDoBar(c3.getCpf());

		double retorno = bar.porcentagemNSociosNoBar();

		double esperado = (3 * 100) / 6;

		assertEquals(esperado, retorno);

	}

	@Test
	public void quantidadeNaoSociosSemSaida() {

		double retorno = bar.quantidadeNSociosBar();

		double esperado = 4;

		assertEquals(esperado, retorno);

	}

	@Test
	public void quantidadeNaoSociosComSaida() {

		bar.saiuDoBar(c3.getCpf());
		bar.saiuDoBar(c4.getCpf());

		double retorno = bar.quantidadeNSociosBar();

		double esperado = 2;

		assertEquals(esperado, retorno);

	}

	@Test
	public void porcentagemMasculinoSemSaida() {

		double retorno = bar.percentualMascBar();

		double esperado = (3*100)/6;

		assertEquals(esperado, retorno);

	}

	@Test
	public void porcentagemMasculinoComSaida() {

		bar.saiuDoBar(c1.getCpf());

		double retorno = bar.percentualMascBar();

		double esperado = (2*100)/5;

		assertEquals(esperado, retorno);

	}

	@Test
	public void porcentagemFemininoSemSaida() {

		double retorno = bar.percentualFemBar();

		double esperado = (3*100)/6;

		assertEquals(esperado, retorno);

	}

	@Test
	public void porcentagemFemininoComSaida() {

		bar.saiuDoBar(c1.getCpf());
		bar.saiuDoBar(c3.getCpf());
		bar.saiuDoBar(c4.getCpf());

		double retorno = bar.percentualFemBar();

		double esperado = (1*100)/3;

		assertEquals(esperado, retorno);

	}

	@Test
	public void totalDePessoasSemSaida() {
		
		int retorno = bar.quantidadePessoasDia();
		
		int esperado = 6;

		assertEquals(esperado, retorno);

	}
	
	@Test
	public void totalDePessoasComSaida() {
		
		bar.saiuDoBar(c1.getCpf());
		bar.saiuDoBar(c2.getCpf());
		bar.saiuDoBar(c3.getCpf());
		
		int retorno = bar.quantidadePessoasDia();
		
		int esperado = 6;

		assertEquals(esperado, retorno);

	}

}
