package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entity.LivroEntity;
import infraestructure.CadastroLivroDAO;

public class EvBtnSalvarLivro implements ActionListener{
	JTextField txtTituloLivro;
	JTextField txtISBN;
	JTextField txtNomeAutor;
	JTextField txtDataPublicacao;
	JTextField txtEditora;
	JTextField txtCategoria;
	JTextField txtFormato;
	JTextField txtnumPaginas;
	JTextField txtSumario;
	JTextField txtResumo;
	JTextField txtPrecoCusto;
	JTextField txtPrecoVenda;
	JTextField txtMargemLucro;
	JTextField txtQtdeEmEstoque;

	JButton BtnVoltar;
	JButton bntPesquisarAutor;
	JButton bntPesquisarLivro;
	JButton bntDeletar;
	JButton bntAlterar;
	JButton bntSalvar;
	LivroEntity livroEntity;
	CadastroLivroDAO livroDAO;


	
	
	
	public EvBtnSalvarLivro(JTextField txtTituloLivro, JTextField txtISBN, JTextField txtNomeAutor,
			JTextField txtDataPublicacao, JTextField txtEditora, JTextField txtCategoria, JTextField txtFormato,
			JTextField txtnumPaginas, JTextField txtSumario, JTextField txtResumo, JTextField txtPrecoCusto,
			JTextField txtPrecoVenda, JTextField txtMargemLucro, JTextField txtQtdeEmEstoque, JButton btnVoltar,
			JButton bntPesquisarAutor, JButton bntPesquisarLivro, JButton bntDeletar, JButton bntAlterar,
			JButton bntSalvar) {
		super();
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
		this.BtnVoltar = btnVoltar;
		this.bntPesquisarAutor = bntPesquisarAutor;
		this.bntPesquisarLivro = bntPesquisarLivro;
		this.bntDeletar = bntDeletar;
		this.bntAlterar = bntAlterar;
		this.bntSalvar = bntSalvar;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(validaCampos())
			salvar();
			
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
	
	
	
	public void salvar(){
		
		livroEntity = new LivroEntity();
		
		
		

	//	livroEntity.setTituloLivro(txtTituloLivro.getText()); 
		
		//livroEntity.setIsbn(Integer.parseInt(txtISBN.getText()));
		livroEntity.setNomeAutor(txtNomeAutor.getText());
		livroEntity.setDataPublicacao(txtDataPublicacao.getText());
		livroEntity.setEditora(txtEditora.getText());
		livroEntity.setCategoriaLivro(txtCategoria.getText());
		livroEntity.setFormato(txtFormato.getText());
		livroEntity.setNumeroPaginas(Integer.parseInt(txtnumPaginas.getText()));
		livroEntity.setSumario(txtSumario.getText());
		livroEntity.setResumo(txtResumo.getText());
		livroEntity.setPrecoCusto(Double.parseDouble(txtPrecoCusto.getText()));
		livroEntity.setPrecoVenda(Double.parseDouble(txtPrecoVenda.getText()));
		livroEntity.setMargemLucro(Double.parseDouble(txtMargemLucro.getText()));
		livroEntity.setQtdeEmEstoque(Integer.parseInt(txtQtdeEmEstoque.getText()));
		
		try {
			 livroDAO = new CadastroLivroDAO();
			if (livroDAO.insert(livroEntity) >= 0){
				JOptionPane.showMessageDialog(null, "Cadastro do Livro Efetuado Com Sucesso");
				
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
		
	}

	
}
