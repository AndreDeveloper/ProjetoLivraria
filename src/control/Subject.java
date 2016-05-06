package control;

import entity.ItemCarrinhoEntity;

public interface Subject {
	void addObserver(Observer o);
	void removeObserver(Observer o);
	void notificar(String noticia);
	void notificar( ItemCarrinhoEntity carrinhoEntity);
}
