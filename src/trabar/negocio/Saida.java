package trabar.negocio;

import java.util.Date;

public class Saida {
	private String cpf;
	private Date horario;
	
	public Saida(String cpf){
		this.cpf = cpf;
		this.horario = new Date();
	}

	public String getCpf() {
		return cpf;
	}

	public Date getHorario() {
		return horario;
	}
	
	
	
}
