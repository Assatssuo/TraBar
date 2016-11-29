package trabar.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import trabar.negocio.Cliente;

public class ClienteTest {

	@Test
	public void test() {
		Cliente cliente = new Cliente("Jorge","12345678910",1,Cliente.Genero.M, Cliente.StatusVIP.Platinum);
		assertEquals(cliente.getNome(), "Jorge");
		assertEquals(cliente.getCpf(), "12345678910");
		assertEquals(cliente.getNome(), 1);
		assertEquals(cliente.getNome(), Cliente.Genero.M);
		assertEquals(cliente.getNome(), Cliente.StatusVIP.Platinum);
	}

}
