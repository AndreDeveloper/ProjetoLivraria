package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.JTextField;

import entity.ClienteEntity;
import infraestructure.ClienteDAO;

public class ClienteController implements iClientesController {
	private JTextField CodCliente;
	
	
	
public void ConcluirCadastro(ClienteEntity clt){
		
	
	try{	
			ClienteDAO cltDao = new ClienteDAO();
			cltDao.insereCliente(clt);
			JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}


	

	@Override
	public void proximoId() {

		try {
			ClienteDAO cltDao = new ClienteDAO();
			CodCliente.setText(String.valueOf(cltDao.proximoId()));
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void listaCliente() {
		String r = null;
		try {
			ClienteDAO cltDao = new ClienteDAO();

			List<ClienteEntity> listaCliente = cltDao.ConsultaCliente();
			if (listaCliente != null) {
				for (ClienteEntity clt : listaCliente) {

					r = r + " " + clt;
					System.out.println(r);
				}
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

}
