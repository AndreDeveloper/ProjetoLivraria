package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.ClienteEntity;
import entity.EnderecoEntity;
import infraestructure.ClienteDAO;
import infraestructure.LocalidadeDAO;

public class ClienteController implements iClientesController {

	private JTable tblCliente;

	public ClienteController() {

	}

	public ClienteController(JTable tblCliente) {

		this.tblCliente = tblCliente;
	}

	public boolean ConcluirCadastro(ClienteEntity clt) {

		boolean validacao = true;

		try {
			ClienteDAO cltDao = new ClienteDAO();
			cltDao.insereCliente(clt);
			JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e1) {

			validacao = false;
			JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

		}

		return validacao;

	}

	public void AtualizaCliente(ClienteEntity clt) {

		try {
			ClienteDAO cltDao = new ClienteDAO();
			cltDao.AtualizaCliente(clt);

			JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Override
	public void listaCliente() {
		if (tblCliente != null) {
			DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
			if (modelo.getRowCount() > 0) {
				modelo.setRowCount(0);

			}
		}

		try {
			ClienteDAO cltDao = new ClienteDAO();

			List<ClienteEntity> listaCliente = cltDao.ConsultaCliente();

			DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
			if (listaCliente != null) {
				preencheTable(listaCliente);

			}

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		tblCliente.revalidate();
	}

	@Override
	public ClienteEntity BuscaDadosCliente(int CodCliente) {
		ClienteEntity clt = new ClienteEntity();
		try {
			ClienteDAO cltDao = new ClienteDAO();
			List<ClienteEntity> ClienteSelecionado = new ArrayList<ClienteEntity>();
			ClienteSelecionado = cltDao.ConsultaCliente(CodCliente);
			for (ClienteEntity cliente : ClienteSelecionado) {
				clt.getCodCliente();
				clt.getNome();
				clt.getCpf();
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
				clt.getDtCadastro();

				clt = cliente;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clt;
	}

	public void ConsultaExistenciaCPF(String cpf) {
		if (tblCliente != null) {
			DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
			if (modelo.getRowCount() > 0) {
				modelo.setRowCount(0);
			}
		}

		try {
			ClienteDAO cltDao = new ClienteDAO();

			List<ClienteEntity> listaCliente = cltDao.ConsultaClientePorCPF(cpf);

			if (listaCliente != null) {
				preencheTable(listaCliente);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void preencheTable(List<ClienteEntity> listaCliente) {
		DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
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

	public void ConsultaExistenciaNome(String nome) {

		DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
		if (tblCliente != null) {

			if (modelo.getRowCount() > 0) {
				modelo.setRowCount(0);
			}
		}

		try {
			ClienteDAO cltDao = new ClienteDAO();

			List<ClienteEntity> listaCliente = cltDao.ConsultaClientePorNome(nome);

			if (listaCliente != null) {
				preencheTable(listaCliente);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	public List<EnderecoEntity> buscaPorCep(String cep) {

		List<EnderecoEntity> list = new ArrayList<EnderecoEntity>();

		try {
			LocalidadeDAO buscaEnd = new LocalidadeDAO();
			list = buscaEnd.ConsultaEndereco(cep);
			// Identifica se o cep foi encontrado. se não foi encontrado ele
			// retorna null na list para o digitar os clientes
			// se nao ele autocompleta.
			for (EnderecoEntity endereco : list) {

				if ((endereco.getUf() == null && endereco.getBairro() == null)
						&& (endereco.getCidade() == null && endereco.getLogradouro() == null)) {

					list = null;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
