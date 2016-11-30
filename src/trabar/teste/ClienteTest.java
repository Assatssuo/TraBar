package trabar.teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import trabar.negocio.Cadastro;
import trabar.negocio.Cliente;
import trabar.negocio.RelatorioDados;
import trabar.persistencia.ClienteDAO;
import trabar.userinterface.CadastroController;

public class ClienteTest {
	
	private Cliente cliente;
	private CadastroController controller = new CadastroController();
	
	@Test
	public void ClienteConstrutorTeste() {
		cliente = new Cliente("Jorge","12345678910",1,Cliente.Genero.M, Cliente.StatusVIP.Gold);
		assertEquals(cliente.getNome(), "Jorge");
		assertEquals(cliente.getCpf(), "12345678910");
		assertEquals(cliente.getIdade(), 1);
		assertEquals(cliente.getGenero(), Cliente.Genero.M);
		assertEquals(cliente.getStatus(), Cliente.StatusVIP.Gold);
	}
	
	@Test(expected = IOException.class)
	public void ClienteEntradaValidacaoNomeTeste() throws IOException {
		controller.AdicionarCliente("987981231312///]","12345678910","25",Cliente.Genero.M, Cliente.StatusVIP.Gold);
	}
	
	@Test(expected = IOException.class)
	public void ClienteEntradaValidacaoCpfTeste() throws IOException {
		controller.AdicionarCliente("Jorge","asdaw2314~]´]","25",Cliente.Genero.M, Cliente.StatusVIP.Gold);
	}
	
	@Test(expected = IOException.class)
	public void ClienteEntradaValidacaoIdadeTeste() throws IOException {
		controller.AdicionarCliente("Jorge","12345678910","1",Cliente.Genero.M, Cliente.StatusVIP.Gold);
	}
	
	@Test(expected = IOException.class)
	public void ClienteSaidaJaSaiuOuNemEntrouOuNemExiste() throws IOException {
		controller.ExcluirCliente("12345678910");
	}
	
	@Test
	public void ClienteSaidaEstavaDentro() throws IOException{
		controller.AdicionarCliente("Jorge","12345458910","25",Cliente.Genero.M, Cliente.StatusVIP.Gold);
		controller.ExcluirCliente("12345458910");
	}
	
	@Test
	public void ClienteCheckEstavaNoBar() throws IOException{
		controller.AdicionarCliente("Jorge","12345458911","25",Cliente.Genero.M, Cliente.StatusVIP.Gold);
		assertEquals(true,controller.checkarCliente("12345458911"));
	}
	@Test
	public void ClienteCheckNaoEstavaNoBar() throws IOException{
		controller.AdicionarCliente("Jorge","12345458912","25",Cliente.Genero.M, Cliente.StatusVIP.Gold);
		assertEquals(false,controller.checkarCliente("12345458917"));
	}
	
	
	

}
