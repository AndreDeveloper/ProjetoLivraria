package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.ClienteEntity;
import infraestructure.ClienteDAO;

public class ClienteController implements iClientesController {
	//private int CodCliente;
	private JTable tblCliente;
	
	
	public ClienteController ()
	{
		
	}
	
public ClienteController(JTable tblCliente) {
		
		this.tblCliente = tblCliente;
	}

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

public void AtualizaCliente(ClienteEntity clt) {
	
	
	try {
		ClienteDAO cltDao = new ClienteDAO();
		cltDao.AtualizaCliente(clt);
		
		JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso","Sucesso", JOptionPane.INFORMATION_MESSAGE);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



	@Override
	public void proximoId() {

		try {
			ClienteDAO cltDao = new ClienteDAO();
			//CodCliente.setText(String.valueOf(cltDao.proximoId()));
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	
	
	
	
	
	
	
	
	@Override
	public void listaCliente() {
		if (tblCliente!=null) {
			DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
			if(modelo.getRowCount()>0){
				modelo.setRowCount(0);
			}
		}
		
		
		
		try {
			ClienteDAO cltDao = new ClienteDAO();

			List<ClienteEntity> listaCliente = cltDao.ConsultaCliente();
			
			DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
			if (listaCliente != null) {
				for (ClienteEntity c : listaCliente) {
					

					Object[] linha = new Object[5];
					linha[0] = c.getCodCliente();
					linha[1] = c.getNome();
					linha[2] = c.getCpf();
					linha[3] = c.getCidade();
					linha[4] = c.getEmail();
					modelo.addRow(linha);					
				}
		
			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public ClienteEntity BuscaDadosCliente(int CodCliente) {
		ClienteEntity clt = new ClienteEntity() ;
		try {
			ClienteDAO cltDao = new ClienteDAO();
			List<ClienteEntity> ClienteSelecionado = new ArrayList<ClienteEntity>();
			ClienteSelecionado= cltDao.ConsultaCliente(CodCliente);
			for(ClienteEntity cliente : ClienteSelecionado){
				clt.getCodCliente();
				clt.getNome();
				clt.getCpf() ;
				clt.getRg();
				clt.getSexo();
				clt.getLogradouro();
				clt.getNumero();
				clt.getComplemento();
				clt.getBairro();
				clt.getCidade();
				clt.getUf();
				clt.getCep();
				clt.getEmail();
				clt.getTelefone();
				clt.getCelular();
				clt.getSenha();
				
				clt = cliente;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return clt;
	}


	



	
}
