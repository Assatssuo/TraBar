package trabar.persistencia;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import trabar.negocio.Cadastro;
import trabar.negocio.Cliente;
import trabar.negocio.Entrada;
import trabar.negocio.Saida;

public class ClienteDAO implements Cadastro {
	private Map<String,Cliente> clientes = new LinkedHashMap<String,Cliente>();
	private List<Entrada> presentes;
	private List<Saida> ausentes;
	
	public void Entrar(Cliente cliente) {
		clientes.put(cliente.getCpf(), cliente);
		presentes.add(new Entrada(cliente.getCpf()));
	}
	public void Sair(String cpf) {
		for(Entrada entrada : presentes){
			if(entrada.getCpf().equals(cpf)){
				presentes.remove(entrada);
			}else{
				//throw exception
			}
		}
		ausentes.add(new Saida(cpf));
	}
	public Cliente getCliente(String cpf) {
		for(Entrada entrada : presentes){
			return clientes.get(entrada.getCpf());
		}
		return null;
	}
	
	public List<Cliente> getLista() {
		List<Cliente> resultado = null;
		for(Entrada entrada : presentes){
			resultado.add(clientes.get(entrada.getCpf()));
		}
		return resultado;
	}
	
	public boolean isPresente(String cpf) {
		boolean resultado = false;
		for(Entrada entrada : presentes){
			if(entrada.getCpf().equals(cpf))
				resultado = true;
		}
		return resultado;	
	}
}
