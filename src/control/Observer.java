package control;

import entity.ItemCarrinhoEntity;

public interface Observer {
	
	void update(String noticia);
	void update(ItemCarrinhoEntity carrinhoEntity);
	

}
