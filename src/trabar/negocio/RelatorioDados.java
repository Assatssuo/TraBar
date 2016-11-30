package trabar.negocio;

import java.util.List;

import trabar.persistencia.ClienteDAO;

public class RelatorioDados {
	private int quantidade;
	private double porcentagemF;
	private double porcentagemM;
	private double none;
	private double silver;
	private double gold;
	private double platinum;
	
	public RelatorioDados(Cadastro cadastro){
		List<Cliente> clientes = cadastro.getLista();
		double auxF = 0;
		double auxM = 0;
		double auxN = 0;
		double auxS = 0;
		double auxG = 0;
		double auxP = 0;
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
		
		if(!clientes.isEmpty()){
			quantidade = clientes.size();
			porcentagemF = (auxF/quantidade)*100;
			porcentagemM = (auxM/quantidade)*100;
			none = (auxN/quantidade)*100;
			silver = (auxS/quantidade)*100;
			gold = (auxG/quantidade)*100;
			platinum = (auxP/quantidade)*100;
		}else{
			quantidade = 0;
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
	public double getNone() {
		return none;
	}
	public double getSilver() {
		return silver;
	}
	public double getGold() {
		return gold;
	}
	public double getPlatinum() {
		return platinum;
	}
}
