package edu.livraria.control;

import edu.livraria.entity.ItemCarrinho;

public interface Observer {
	
	void update(String noticia);
	void update(ItemCarrinho carrinhoEntity);
	

}
