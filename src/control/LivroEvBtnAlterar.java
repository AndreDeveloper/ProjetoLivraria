package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entity.LivroEntity;
import boundary.LivroBoundary;
import infraestructure.CadastroLivroDAO;

public class LivroEvBtnAlterar implements ActionListener {

	private LivroBoundary TelaLivro;
	private JTextField txtTituloLivro;
	private JTextField txtISBN;
	private JTextField txtNomeAutor;
	private JTextField txtDataPublicacao;
	private JTextField txtEditora;
	private JTextField txtCategoria;
	private JTextField txtFormato;
	private JTextField txtnumPaginas;
	private JTextField txtSumario;
	private JTextField txtResumo;
	private JTextField txtPrecoCusto;
	private JTextField txtPrecoVenda;
	private JTextField txtMargemLucro;
	private JTextField txtQtdeEmEstoque;

	public LivroEvBtnAlterar(LivroBoundary telaLivro, JTextField txtTituloLivro, JTextField txtISBN,
			JTextField txtNomeAutor, JTextField txtDataPublicacao, JTextField txtEditora, JTextField txtCategoria,
			JTextField txtFormato, JTextField txtnumPaginas, JTextField txtSumario, JTextField txtResumo,
			JTextField txtPrecoCusto, JTextField txtPrecoVenda, JTextField txtMargemLucro,
			JTextField txtQtdeEmEstoque) {
		super();
		this.TelaLivro = telaLivro;
		this.txtTituloLivro = txtTituloLivro;
		this.txtISBN = txtISBN;
		this.txtNomeAutor = txtNomeAutor;
		this.txtDataPublicacao = txtDataPublicacao;
		this.txtEditora = txtEditora;
		this.txtCategoria = txtCategoria;
		this.txtFormato = txtFormato;
		this.txtnumPaginas = txtnumPaginas;
		this.txtSumario = txtSumario;
		this.txtResumo = txtResumo;
		this.txtPrecoCusto = txtPrecoCusto;
		this.txtPrecoVenda = txtPrecoVenda;
		this.txtMargemLucro = txtMargemLucro;
		this.txtQtdeEmEstoque = txtQtdeEmEstoque;
	}

	public void acao() {
		LivroEntity livro = this.TelaLivro.getLivroEntity();
		CadastroLivroDAO livroDao = new CadastroLivroDAO();

		livro.setTituloLivro(txtTituloLivro.getText());
		// livro.setNomeAutor(comboAutor.getSelectedItem().toString());
		// livro.setCategoriaLivro(comboCategoriaLivro.getSelectedItem().toString());
		// livro.setEditora(comboEditora.getSelectedItem().toString());
		// livro.setDataPublicacao(dataPublicacao.getDate());
		// livro.setFormato(comboFormato.getSelectedItem().toString());
		// livro.setNumeroPaginas(txtnumPaginas.getRows());
		livro.setSumario(txtSumario.getText());
		livro.setResumo(txtResumo.getText());
		// livro.setPrecoCusto(txtPrecoCusto.getText());
		// livro.setPrecoVenda(txtPrecoVenda.getText());
		// livro.setMargemLucro(txtMargemLucro.getText());
		// livro.setQtdeEmEstoque(txtQtdeEmEstoque.getText());
		livro.setTituloLivro(txtISBN.getText());
		livro.setTituloLivro(txtNomeAutor.getText());
		livro.setTituloLivro(txtDataPublicacao.getText());
		livro.setTituloLivro(txtEditora.getText());
		livro.setTituloLivro(txtCategoria.getText());
		livro.setTituloLivro(txtFormato.getText());
		livro.setTituloLivro(txtnumPaginas.getText());
		livro.setTituloLivro(txtSumario.getText());
		livro.setTituloLivro(txtResumo.getText());
		livro.setTituloLivro(txtPrecoCusto.getText());
		livro.setTituloLivro(txtPrecoVenda.getText());
		livro.setTituloLivro(txtMargemLucro.getText());
		livro.setTituloLivro(txtQtdeEmEstoque.getText());

		try {
			if (livroDao.update(livro) > 0) {
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar o livro.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (validaCampos())
			acao();
	}
	public boolean validaCampos() {
		if (txtISBN.getText().length() <= 0 || txtNomeAutor.getText().length() <= 0
				|| txtDataPublicacao.getText().length() <= 0 || txtEditora.getText().length() <= 0
				|| txtCategoria.getText().length() <= 0 || txtFormato.getText().length() <= 0
				|| txtnumPaginas.getText().length() <= 0 || txtSumario.getText().length() <= 0
				|| txtResumo.getText().length() <= 0 || txtPrecoCusto.getText().length() <= 0
				|| txtPrecoVenda.getText().length() <= 0 || txtMargemLucro.getText().length() <= 0
				|| txtQtdeEmEstoque.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Preencher todos os campos");
			return false;
		}
		return true;
	}

}
