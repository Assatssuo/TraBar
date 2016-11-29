package trabar.negocio;



public class Cliente {
	
	private String nome;
	private String cpf;
	private int idade;
	
	// F or M
	private Genero genero;
	public enum Genero{
		F,M;
	}
	
	private StatusVIP statusVIP;
	public enum StatusVIP{
		None, Silver, Gold, Platinum;
		
	}
	
	public Cliente(String nome, String cpf, int idade, Genero genero, StatusVIP status){
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.genero = genero;
		this.statusVIP = status;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getIdade(){
		return idade;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public Genero getGenero(){
		return genero;
	}
	
	public StatusVIP getStatus(){
		return statusVIP;
	}
	
	
}

	
