package trabar.negocio;

import java.util.List;

public interface Cadastro {
	
	public void entrar(Cliente cliente);
	
	public void sair(String cpf);
	
	public Cliente getCliente(String cpf);
	
	public List<Cliente> getLista();
	
	public boolean isPresente(String cpf);
}