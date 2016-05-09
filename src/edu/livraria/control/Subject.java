package edu.livraria.control;

import edu.livraria.entity.ItemCarrinho;

public interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notificar(String noticia);
	void notificar( ItemCarrinho carrinhoEntity);
}
