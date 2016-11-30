package trabar.persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import trabar.negocio.Cadastro;
import trabar.negocio.Cliente;
import trabar.negocio.Entrada;
import trabar.negocio.Saida;

public class ClienteDAO implements Cadastro {
	private static Map<String,Cliente> clientes;
	private static List<Entrada> presentes;
	private static List<Saida> ausentes;
	
	public ClienteDAO(){
		clientes = new LinkedHashMap<String,Cliente>();
		presentes = new ArrayList();
		ausentes = new ArrayList();
	}
	
	public void entrar(Cliente cliente) {
		clientes.put(cliente.getCpf(), cliente);
		Entrada entrada = new Entrada(cliente.getCpf()); 
		presentes.add(entrada);
		
		try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File ("entradas.csv"), true))){
			pw.print(cliente.getCpf());
			pw.print(";");
			pw.print(cliente.getNome());
			pw.print(";");
			pw.print(cliente.getIdade());
			pw.print(";");			
			pw.print(cliente.getGenero());
			pw.print(";");
			pw.print(cliente.getStatus());
			pw.print(";");
			pw.print(entrada.getHorario());
			pw.println(";");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void sair(String cpf) {
		Entrada aux = null;
		for(Entrada entrada : presentes){
			if(entrada.getCpf().equals(cpf)){
				aux = entrada;
			}else{
				//throw exception
			}
		}
		presentes.remove(aux);
		Saida saida =  new Saida(cpf);
		ausentes.add(saida);
		Cliente cliente = clientes.get(cpf);
		try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File ("saida.csv"), true))){
			pw.print(cliente.getCpf());
			pw.print(";");
			pw.print(cliente.getNome());
			pw.print(";");
			pw.print(cliente.getIdade());
			pw.print(";");
			pw.print(cliente.getGenero());
			pw.print(";");
			pw.print(cliente.getStatus());
			pw.print(";");
			pw.print(saida.getHorario());
			pw.println(";");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Cliente getCliente(String cpf) {
		for(Entrada entrada : presentes){
			return clientes.get(entrada.getCpf());
		}
		return null;
	}
	
	public List<Cliente> getLista() {
		List<Cliente> resultado = new ArrayList();
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
	public List<Entrada> getPresentes(){
		return presentes;
	}
	
	public List<Saida> getAusentes() {
		return ausentes;
	}
}
