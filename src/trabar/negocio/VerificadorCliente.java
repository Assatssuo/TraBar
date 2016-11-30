package trabar.negocio;

import trabar.persistencia.ClienteDAO;

public class VerificadorCliente {

	public static boolean verificaDados(String nome, String cpf, String idade, Cadastro cadastro){		
		return (isNomeValid(nome)&&isCpfValid(cpf,cadastro)&&isIdadeValid(idade));
	}	
	
	public static boolean isNomeValid(String nome){
		return nome.matches("[a-zA-Z]+\\.?");
	}
	
	public static boolean isCpfValid(String cpf, Cadastro cadastro){
		String regex = "\\d+";
		if(cpf.matches(regex)&&cpf.length()==11&&!verificaCpfPresentes(cpf,cadastro))
			return true;
		return false;
	}
	public static boolean isIdadeValid(String idade){
		int valor;
		try{
		    valor = Integer.valueOf(idade);
		}catch(NumberFormatException e) {
		    return false;
		}		
		if(valor>=18 && valor<=125)
			return true;
		return false;
	}
	
	public static boolean verificaCpfPresentes(String cpf, Cadastro cadastro){
		for(Entrada cliente : cadastro.getPresentes()){
			if(cliente.getCpf().equals(cpf)){
				return true;
			}
		}
		return false;
	}
}
