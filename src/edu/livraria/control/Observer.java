package edu.livraria.control;

import edu.livraria.entity.ItemCarrinho;
import edu.livraria.entity.Livro;

public interface Observer {
	
	void update(String noticia);
	void update(ItemCarrinho carrinhoEntity);
	void update(Livro livro);
	

}
