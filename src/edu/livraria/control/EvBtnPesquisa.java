package edu.livraria.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.livraria.entity.Livro;
import edu.livraria.infraestructure.PesquisaDAO;

public class EvBtnPesquisa implements ActionListener {
	
	private PesquisaDAO pesquisaDAO;
	private List<Livro> listaPesquisa = new ArrayList<Livro>();
	
	public List<Livro> pesquisarLivro(String tituloLivro) {
		try {
			listaPesquisa = pesquisaDAO.perquisarLivro(tituloLivro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPesquisa;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		pesquisarLivro("abc");
	}

}
