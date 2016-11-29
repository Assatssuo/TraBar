package trabar.negocio;



public class Cliente {
	
	private String nome;
	private String cpf;
	private int idade;
	
	// F or M
	private char genero;
	
	//N = None, S = Silver, G = Gold, P = Platinum 
	private char statusVIP;
	
	public Cliente(String nome, String cpf, int idade, char genero, char status){
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.genero = genero;
		this.statusVIP = status;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public char getGenero(){
		return genero;
	}
	
	public char getStatus(){
		return statusVIP;
	}
	
	
}

	
