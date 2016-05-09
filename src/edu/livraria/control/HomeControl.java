package edu.livraria.control;

import java.util.List;

import edu.livraria.entity.Livro;
import edu.livraria.infraestructure.LivroDAO;

public class HomeControl {
	public List<Livro> selectAll(){
		LivroDAO dao = new LivroDAO();
		return dao.selectAll();
	}
}
