package edu.livraria.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.livraria.entity.Livro;
import edu.livraria.infraestructure.PesquisaDAO;

public class PesquisaControl implements TableModel {

	private PesquisaDAO pesquisaDAO;
	private List<Livro> listaPesquisa = new ArrayList<Livro>();

	public PesquisaControl() {

		try {
			pesquisaDAO = new PesquisaDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Livro> pesquisarLivro(String tituloLivro, String NomeAutor, Double PrecoVenda ) {
		try {
			listaPesquisa = pesquisaDAO.perquisarLivro(tituloLivro, NomeAutor, PrecoVenda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPesquisa;

	}

	@Override
	public void addTableModelListener(TableModelListener arg0) {

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: 
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Double.class;
		default:
			return null;
		}
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public String getColumnName(int col) {
		switch(col){
		case 0: 
			return "Titutlo";
		case 1:
			return "Nome do Autor";
		case 2:
			return "Preço de Venda";
		default: 
			return "";
		}
	}

	@Override
	public int getRowCount() {
		return listaPesquisa.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Livro l = listaPesquisa.get(row); 
		switch(col){
		case 0: 
			return l.getTituloLivro();
		case 1:
			return l.getNomeAutor();
		case 2:
			return l.getPrecoVenda();
		case 3:
		default: 
			return "";
		}
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {

	}
	
	
	public List<Livro> getListaDisc() {
		return listaPesquisa;
	}

	public void setLista(List<Livro> listadisc) {
		this.listaPesquisa = listaPesquisa;
	}


}

