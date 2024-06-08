package Java.controller.model.clientes;

import Java.controller.services.ServiceClientes;

import java.util.ArrayList;

public interface ICliente {
	void cadastrarCliente(String nome, String endereço);
	void atualizarCliente(ArrayList<ServiceClientes> lista, int id, String itemNome, String itemEnd);

	static void criarCliente() {

	}


}
