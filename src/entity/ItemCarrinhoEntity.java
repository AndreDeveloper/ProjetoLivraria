package entity;



import javax.swing.ImageIcon;

public class ItemCarrinhoEntity {
	private ImageIcon imagem;
	private LivroEntity livro;
	private AuxQtdadeEntity quantidade;
	private double subTotal;
	
	
	
	public ItemCarrinhoEntity() {
		super();
		this.livro = new LivroEntity();
		this.quantidade = new AuxQtdadeEntity();
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
	public LivroEntity getLivro() {
		return livro;
	}
	public void setLivro(LivroEntity livro) {
		this.livro = livro;
		this.subTotal = livro.getPrecoVenda() * quantidade.getQuantidade();
	}
	public int getQuantidade() {
		return quantidade.getQuantidade();
	}
	public void setQuantidade(int quantidade) {
		AuxQtdadeEntity aux = new AuxQtdadeEntity();
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
