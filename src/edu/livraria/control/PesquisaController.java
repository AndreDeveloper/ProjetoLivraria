package edu.livraria.control;

import edu.livraria.entity.Livro;
import edu.livraria.infraestructure.LivroDAO;

public class PesquisaController {
	
	public java.util.List<Livro> 
	listaLivro(String autor,
			String titulo, String editora, int categoria) {
		
			LivroDAO dao = new LivroDAO();
		    
			return dao.selectToFormPesquisa(autor, titulo, editora, categoria); 

		
	}
}
