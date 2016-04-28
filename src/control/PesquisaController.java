package control;

import entity.LivroEntity;
import infraestructure.LivroDAO;

public class PesquisaController {
	
	public java.util.List<LivroEntity> 
	listaLivro(String autor,
			String titulo, String editora, int categoria) {
		
			LivroDAO dao = new LivroDAO();
		    
			return dao.selectToFormPesquisa(autor, titulo, editora, categoria); 

		
	}
}
