package control;

import infraestructure.PesquisaDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import entity.LivroEntity;

public class EvBtnPesquisa implements ActionListener {
	
	private PesquisaDAO pesquisaDAO;
	private List<LivroEntity> listaPesquisa = new ArrayList<LivroEntity>();
	
	public List<LivroEntity> pesquisarLivro(String tituloLivro) {
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
