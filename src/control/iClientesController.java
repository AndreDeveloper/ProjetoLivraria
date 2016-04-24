package control;

import entity.ClienteEntity;

public interface iClientesController {
	public void proximoId();
	public void listaCliente();
	public void ConcluirCadastro(ClienteEntity clt);
	public ClienteEntity BuscaDadosCliente (int CodCliente);

}
