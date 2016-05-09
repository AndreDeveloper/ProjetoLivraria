package edu.livraria.entity;

public enum Categoria {
	FICCAO(0), ROMANCE(1), AVENTURA(2);
	
	private int dado;
	
	Categoria(int categoria){
		this.dado = categoria;
	}
	
	public int getCategoria(){
		return this.dado;
	}
	
	public String obterCategoriaPorExtenso(){
		switch (this.dado) {
		case 2: return "Aventura!";
		case 1: return "Romance!";
		}
		return null;
	}
}
