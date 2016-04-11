package control;

import java.sql.SQLException;

import entity.LivroEntity;
import infraestructure.CadastroLivroDAO;

public class LivroControl {
	
	public LivroControl(){
		
	}
	
	public long adicionar (LivroEntity livro) throws SQLException{
		CadastroLivroDAO dao = new CadastroLivroDAO();
		
		long cod = dao.insert(livro);
		
		return cod;
	}
	
	public void alterar (LivroEntity livro){
		
	}
	

}
