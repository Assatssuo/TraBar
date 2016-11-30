package trabar.teste;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import trabar.negocio.Cliente;
import trabar.negocio.RelatorioDados;
import trabar.userinterface.CadastroController;

public class RelatorioTeste {
	private CadastroController controller = new CadastroController();
	
	@Test
	public void RelatorioPopuladoUmTeste() throws IOException{
		controller.AdicionarCliente("Jorge","12345678910","25",Cliente.Genero.M, Cliente.StatusVIP.Gold);
		RelatorioDados relatorio = controller.CalculaRelatorio();
		assertEquals(1, relatorio.getQuantidade());
		assertEquals(0, (int)relatorio.getPorcentagemF());
		assertEquals(100, (int)relatorio.getPorcentagemM());
		assertEquals(0, (int)relatorio.getNone());
		assertEquals(0, (int)relatorio.getSilver());
		assertEquals(100, (int)relatorio.getGold());
		assertEquals(0, (int)relatorio.getPlatinum());
	}
	@Test
	public void RelatorioPopuladoDoisTeste() throws IOException{
		controller.AdicionarCliente("Amanda","12345678911","21",Cliente.Genero.F, Cliente.StatusVIP.Platinum);
		RelatorioDados relatorio = controller.CalculaRelatorio();
		assertEquals(2, relatorio.getQuantidade());
		assertEquals(50, (int)relatorio.getPorcentagemF());
		assertEquals(50, (int)relatorio.getPorcentagemM());
		assertEquals(0, (int)relatorio.getNone());
		assertEquals(0, (int)relatorio.getSilver());
		assertEquals(50, (int)relatorio.getGold());
		assertEquals(50, (int)relatorio.getPlatinum());
	}
	
	@Test
	public void RelatorioPopuladoQTeste() throws IOException{
		controller.AdicionarCliente("Julia","12345678912","22",Cliente.Genero.M, Cliente.StatusVIP.Silver);
		controller.AdicionarCliente("Robson","12345678913","21",Cliente.Genero.F, Cliente.StatusVIP.None);
		RelatorioDados relatorio = controller.CalculaRelatorio();
		assertEquals(4, relatorio.getQuantidade());
		assertEquals(50, (int)relatorio.getPorcentagemF());
		assertEquals(50, (int)relatorio.getPorcentagemM());
		assertEquals(25, (int)relatorio.getNone());
		assertEquals(25, (int)relatorio.getSilver());
		assertEquals(25, (int)relatorio.getGold());
		assertEquals(25, (int)relatorio.getPlatinum());
	}
	
	@Test
	public void RelatorioVazioTeste(){
		RelatorioDados relatorio = controller.CalculaRelatorio();
		assertEquals(0, relatorio.getQuantidade()); //bug? má arquitetura? não sei, desisto
		assertEquals(0, (int)relatorio.getPorcentagemF());
		assertEquals(0, (int)relatorio.getPorcentagemM());
		assertEquals(0, (int)relatorio.getNone());
		assertEquals(0, (int)relatorio.getSilver());
		assertEquals(0, (int)relatorio.getGold());
		assertEquals(0, (int)relatorio.getPlatinum());
	}

}
