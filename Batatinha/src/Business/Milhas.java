package Batatinha.src.Business;

import Batatinha.src.Persistence.*;

import java.util.HashMap;
import java.util.Random;

import Batatinha.src.Persistence.Cliente;


public class Milhas {

	HashMap<Cliente, Integer> milhasPorCliente;

	public Milhas() {

		this.milhasPorCliente = new HashMap<>();

	}

	public void addMilha(Cliente c) {
		Random r = new Random();

		int num = r.nextInt(10);

		if (num < 5) {
			if (milhasPorCliente.containsKey(c)) {
				milhasPorCliente.put(c, (milhasPorCliente.get(c) + 100));
			} else {
				milhasPorCliente.put(c, 100);
			}
		}
	}

	public boolean usaMilhas(Cliente c, int milhas) {

		if (milhasPorCliente.containsKey(c)) {
			milhasPorCliente.put(c, (milhasPorCliente.get(c) - milhas));
			return true;
		} else {
			return false;
		}

	}

	public boolean apagarSocio(Cliente c) {
		if (milhasPorCliente.containsKey(c)) {
			milhasPorCliente.remove(c);
			return true;
		} else {
			return false;
		}
	}

}
