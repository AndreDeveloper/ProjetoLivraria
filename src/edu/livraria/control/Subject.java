package edu.livraria.control;

import edu.livraria.entity.ItemCarrinho;
import edu.livraria.entity.Livro;

public interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notificar(String noticia);
	void notificar( ItemCarrinho carrinhoEntity);
	void notificar( Livro livro);
}
