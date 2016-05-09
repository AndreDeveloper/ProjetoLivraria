package edu.livraria.entity;



import javax.swing.ImageIcon;

public class ItemCarrinho {
	private ImageIcon imagem;
	private Livro livro;
	private AuxQtdade quantidade;
	private double subTotal;
	
	
	
	public ItemCarrinho() {
		super();
		this.livro = new Livro();
		this.quantidade = new AuxQtdade();
		this.livro.setTituloLivro("");
		this.livro.setPrecoVenda(0);
		this.quantidade.setQuantidade(0);
	}
	public ImageIcon getImagem() {
		return imagem;
	}
	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
		this.subTotal = livro.getPrecoVenda() * quantidade.getQuantidade();
	}
	public int getQuantidade() {
		return quantidade.getQuantidade();
	}
	public void setQuantidade(int quantidade) {
		AuxQtdade aux = new AuxQtdade();
		aux.setQuantidade(quantidade);
		this.quantidade = aux;
		this.subTotal = livro.getPrecoVenda() * quantidade;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	@Override
	public String toString() {
		return "ItemCarrinhoEntity [imagem=" + imagem + ", livro=" + livro.getTituloLivro() + 
				", quantidade=" + quantidade.getQuantidade()
				+ ", subTotal=" + subTotal + "]";
	}
	
	
}
