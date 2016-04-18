package entity;

import java.util.Date;

import javax.swing.ImageIcon;


public class LivroEntity {
	
	private int id;
	private int idAutor;
	private int idCategoriaLivro;
	private int idEditora;
	private String nomeAutor;
	private String categoriaLivro;
	private String editora;

	private int isbn;
	private String tituloLivro;
	private Date dataPublicacao;
	private int formato;
	private int numeroPaginas;
	private String sumario;
	private String resumo;
	private double precoCusto;
	private double precoVenda;
	private double margemLucro;
	private int qtdeEmEstoque;
	private ImageIcon imagem;
	private String imagePath;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getIdAutor() {
		return idAutor;
	}



	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}



	public int getIdCategoriaLivro() {
		return idCategoriaLivro;
	}



	public void setIdCategoriaLivro(int idCategoriaLivro) {
		this.idCategoriaLivro = idCategoriaLivro;
	}



	public int getIdEditora() {
		return idEditora;
	}



	public void setIdEditora(int idEditora) {
		this.idEditora = idEditora;
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



	public Date getDataPublicacao() {
		return dataPublicacao;
	}



	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}



	public int getFormato() {
		return formato;
	}



	public void setFormato(int formato) {
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



	public ImageIcon getImagem() {
		return imagem;
	}



	public void setImagem(ImageIcon imagem) {
		this.imagem = imagem;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

		
