package trabar.negocio;

import java.util.List;

import trabar.persistencia.ClienteDAO;

public class RelatorioDados {
	private int quantidade;
	private double porcentagemF;
	private double porcentagemM;
	private int none;
	private int silver;
	private int gold;
	private int platinum;
	
	public RelatorioDados(){
		Cadastro dados = new ClienteDAO();
		List<Cliente> clientes = dados.getLista();
		int auxF = 0;
		int auxM = 0;
		int auxN = 0;
		int auxS = 0;
		int auxG = 0;
		int auxP = 0;
		for(Cliente cliente : clientes){
			if(cliente.getGenero().toString().equals("F"))
				auxF +=1;
			else
				auxM +=1;
			switch (cliente.getStatus().toString()){
				case "None":
					auxN+=1;
					break;
				case "Silver":
					auxS+=1;
					break;
				case "Gold":
					auxG+=1;
					break;
				case "Platinum":
					auxP+=1;
					break;
			}
		}
		
		quantidade = clientes.size();
		if(quantidade != 0){
			porcentagemF = (auxF/quantidade)*100;
			porcentagemM = (auxM/quantidade)*100;
			none = (auxN/quantidade)*100;
			silver = (auxS/quantidade)*100;
			gold = (auxG/quantidade)*100;
			platinum = (auxP/quantidade)*100;
		}else{
			porcentagemF = 0;
			porcentagemM = 0;
			none = 0;
			silver = 0;
			gold = 0;
			platinum = 0;
		}		
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public double getPorcentagemF() {
		return porcentagemF;
	}
	public double getPorcentagemM() {
		return porcentagemM;
	}
	public int getNone() {
		return none;
	}
	public int getSilver() {
		return silver;
	}
	public int getGold() {
		return gold;
	}
	public int getPlatinum() {
		return platinum;
	}
}
