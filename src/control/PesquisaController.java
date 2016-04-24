package control;

import entity.LivroEntity;
import infraestructure.LivroDAO;

public class PesquisaController {
	
	public java.util.List<LivroEntity> 
	listaLivro(int autor,
			String titulo, int editora, int categoria) {
		
			LivroDAO dao = new LivroDAO();
		    
			return dao.selectToFormPesquisa(autor, titulo, editora, categoria); 

		
	}
}
