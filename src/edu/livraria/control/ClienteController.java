package edu.livraria.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.livraria.entity.Cliente;
import edu.livraria.entity.Endereco;
import edu.livraria.infraestructure.ClienteDAO;
import edu.livraria.infraestructure.LocalidadeDAO;

public class ClienteController implements iClientesController {

	private JTable tblCliente;

	public ClienteController() {

	}

	public ClienteController(JTable tblCliente) {

		this.tblCliente = tblCliente;
	}

	public boolean ConcluirCadastro(Cliente clt) {

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

	public void AtualizaCliente(Cliente clt) {

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

			List<Cliente> listaCliente = cltDao.ConsultaCliente();

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
	public Cliente BuscaDadosCliente(int CodCliente) {
		Cliente clt = new Cliente();
		try {
			ClienteDAO cltDao = new ClienteDAO();
			List<Cliente> ClienteSelecionado = new ArrayList<Cliente>();
			ClienteSelecionado = cltDao.ConsultaCliente(CodCliente);
			for (Cliente cliente : ClienteSelecionado) {
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

			List<Cliente> listaCliente = cltDao.ConsultaClientePorCPF(cpf);

			if (listaCliente != null) {
				preencheTable(listaCliente);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void preencheTable(List<Cliente> listaCliente) {
		DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
		for (Cliente c : listaCliente) {

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

			List<Cliente> listaCliente = cltDao.ConsultaClientePorNome(nome);

			if (listaCliente != null) {
				preencheTable(listaCliente);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	public List<Endereco> buscaPorCep(String cep) {

		List<Endereco> list = new ArrayList<Endereco>();

		try {
			LocalidadeDAO buscaEnd = new LocalidadeDAO();
			list = buscaEnd.ConsultaEndereco(cep);
			// Identifica se o cep foi encontrado. se não foi encontrado ele
			// retorna null na list para o digitar os clientes
			// se nao ele autocompleta.
			for (Endereco endereco : list) {

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
