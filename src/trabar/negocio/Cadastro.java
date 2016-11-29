package trabar.negocio;

import java.util.List;

public interface Cadastro {
	
	public void Entrar(Cliente cliente);
	
	public void Sair(String cpf);
	
	public Cliente getCliente(String cpf);
	
	public List<Cliente> getLista();
	
	public boolean isPresente(String cpf);
}