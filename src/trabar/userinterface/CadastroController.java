package trabar.userinterface;

import java.io.IOException;

import trabar.negocio.Cadastro;
import trabar.negocio.Cliente;
import trabar.negocio.Cliente.Genero;
import trabar.negocio.Cliente.StatusVIP;
import trabar.negocio.RelatorioDados;
import trabar.negocio.VerificadorCliente;
import trabar.persistencia.ClienteDAO;

public class CadastroController {
	
	private static Cadastro cadastro = new ClienteDAO();
	
	public static void AdicionarCliente(String nome, String cpf, String idade, Genero genero, StatusVIP statusVIP) throws IOException{
		if(VerificadorCliente.verificaDados(nome,cpf,idade,cadastro)){
			cadastro.entrar(new Cliente(nome,cpf,Integer.parseInt(idade),genero,statusVIP));
		}else{
			throw new IOException("Dados inválidos.");
		}
	}
	
	public static void ExcluirCliente(String cpf) throws IOException{
		if(VerificadorCliente.verificaCpfPresentes(cpf,cadastro))
			cadastro.sair(cpf);
		else{
			throw new IOException("O cliente, de cpf "+cpf+", não está no bar.");
		}
	}

	public static RelatorioDados CalculaRelatorio() {
		RelatorioDados relatorio = new RelatorioDados(cadastro);
		return relatorio;
	}

	public static boolean checkarCliente(String cpf) {
		return VerificadorCliente.verificaCpfPresentes(cpf, cadastro);
	}

}
