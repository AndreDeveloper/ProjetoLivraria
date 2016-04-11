package entity;

import java.util.Date;

import javax.swing.ImageIcon;

public class LivroEntity {
	
	private int id;

	private int isbn;
	private String tituloLivro;
	private String nomeAutor;
	private String categoriaLivro;
	private String editora;
	private String dataPublicacao;
	private String formato;
	private int numeroPaginas;
	private String sumario;
	private String resumo;
	private double precoCusto;
	private double precoVenda;
	private double margemLucro;
	private int qtdeEmEstoque;
	private ImageIcon imagem;

	public ImageIcon getImagem() {
		return imagem;
	}

	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}
	
	

	
	/*
	 * public LivroEntity(int isbn, String tituloLivro, String nomeAutor,
	 * ======= >>>>>>> branch 'master' of
	 * https://github.com/AndreDeveloper/ProjetoLivraria.git <<<<<<< HEAD
	 * >>>>>>> pesquisa item ======= >>>>>>>
	 * 8231669bb9a2e0e7e8783c627dd1c7a664cc8294 public LivroEntity(){
	 * 
	 * }
	 * 
	 * public LivroEntity(int isbn, String tituloLivro, String nomeAutor,
	 * <<<<<<< HEAD ======= /*public LivroEntity(int isbn, String tituloLivro,
	 * String nomeAutor, >>>>>>> Cadastro do Livro: CRUD e tela concluídos.
	 * Necessita de pequenos ======= >>>>>>>
	 * 8b327b74bb9912c0db4853d0dd43d3b1ef98c223 >>>>>>>
	 * 8231669bb9a2e0e7e8783c627dd1c7a664cc8294 String categoriaLivro, String
	 * editora, String dataPublicacao, String formato, int numeroPaginas, String
	 * sumario, String resumo, double precoCusto, double precoVenda, double
	 * margemLucro, int qtdeEmEstoque) { super(); this.isbn = isbn;
	 * this.tituloLivro = tituloLivro; this.nomeAutor = nomeAutor;
	 * this.categoriaLivro = categoriaLivro; this.editora = editora;
	 * this.dataPublicacao = dataPublicacao; this.formato = formato;
	 * this.numeroPaginas = numeroPaginas; this.sumario = sumario; this.resumo =
	 * resumo; this.precoCusto = precoCusto; this.precoVenda = precoVenda;
	 * this.margemLucro = margemLucro; this.qtdeEmEstoque = qtdeEmEstoque; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getCategoriaLivro() {
		return categoriaLivro;
	}

	public void setCategoriaLivro(String categoriaLivro) {
		this.categoriaLivro = categoriaLivro;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}

	public int getQtdeEmEstoque() {
		return qtdeEmEstoque;
	}

	public void setQtdeEmEstoque(int qtdeEmEstoque) {
		this.qtdeEmEstoque = qtdeEmEstoque;
	}

	@Override
	public String toString() {
		return "isbn= " + isbn + 
				"\nTitulo do Livro: " + tituloLivro + ""
				+ "\nNome do Autor: " + nomeAutor
				+ "\nCategoria: " + categoriaLivro 
				+ "\nEditora:" + editora 
				+ "\nData da Publicacao: " + dataPublicacao
				+ "\nFormato: " + formato 
				+ "\nNumero de Paginas: " + numeroPaginas 
				+ "\nSumario: " + sumario 
				+ "\nResumo: " + resumo; 
		
	}
}
	
	
//	
//		return "isbn= " + isbn + "\nTitulo do Livro: " + tituloLivro + "" + "\nNome do Autor: " + nomeAutor
//				+ "\nCategoria: " + categoriaLivro + "\nEditora:" + editora + "\nData da Publicacao: " + dataPublicacao
//				+ "\nFormato: " + formato + "\nNumero de Paginas: " + numeroPaginas + "\nSumario: " + sumario
//				+ "\nResumo: " + resumo;
		
