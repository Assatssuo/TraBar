package trabar.userinterface;

import trabar.negocio.Cliente;
import trabar.negocio.VerificadorCliente;

public class CadastroController {
	
	public static void AdicionarCliente(String Nome, String cpf, String idade){
		if(VerificadorCliente.VerificarDados(nome,cpf,idade)){
			
		}else{
			//throw exception
		}
	}

}
