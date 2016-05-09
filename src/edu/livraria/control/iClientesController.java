package edu.livraria.control;

import edu.livraria.entity.Cliente;

public interface iClientesController {
	
	public void listaCliente();

	public boolean ConcluirCadastro(Cliente clt);

	public Cliente BuscaDadosCliente(int CodCliente);

}
