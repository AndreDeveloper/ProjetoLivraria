package boundary;

import infraestructure.CadastroLivroDAO;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import control.EvBtnSalvarLivro;
import control.LivroEvBtnAlterar;
import control.LivroEvBtnDeletar;

//import control.LivroEvBtnSalvar;
import entity.LivroEntity;

public class LivroBoundary {

	private LivroEntity livroEntity;

	private JFrame frame = new JFrame();
	private JPanel contentPane = new JPanel(new BorderLayout());
	
	private JLabel lblTitulo;
	private JLabel lblISBN;
	private JLabel lblNomeAutor;
	private JLabel lblDataPublicacao;
	private JLabel lblEditora;
	private JLabel lblCategoria;
	private JLabel lblFormato;
	private JLabel lblnumPaginas;	
	private JLabel lblSumario;
	private JLabel lblResumo;
	private JLabel lblPrecoCusto;
	private JLabel lblPrecoVenda;
	private JLabel lblMargemLucro;
	private JLabel lblQtdeEmEstoque;
	
	//private JPanel contentPane;
	JTextField txtTitulo;
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

	JButton btnVoltar;
	JButton bntPesquisarAutor;
	JButton bntPesquisarLivro;
	JButton bntDeletar;
	JButton bntAlterar;
	JButton bntSalvar;

	public LivroEntity getLivroEntity() {
		return livroEntity;
	}

	public void setLivroEntity(LivroEntity livroEntity) {
		this.livroEntity = livroEntity;
	}

	public static void main(String[] args) {
		new LivroBoundary().frame.setVisible(true);

	}

	public LivroBoundary() {

		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Cadastro de Livros");
		contentPane.setLayout(null);
		
		
		lblISBN = new JLabel("ISBN: ");
		lblISBN.setBounds(2, 10, 111, 20);
		contentPane.add(lblISBN);
		
		txtISBN = new JTextField();
		txtISBN.setBounds(111, 10, 130, 20);
		txtISBN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtISBN.setText("");
		txtISBN.setColumns(10);
		contentPane.add(txtISBN);
		

		lblTitulo = new JLabel("T�tulo: ");
		lblTitulo.setBounds(2, 40, 111, 20);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(111, 40, 337, 20);
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTitulo.setText("");
		txtTitulo.setColumns(10);
		contentPane.add(txtTitulo);
				
		
		lblNomeAutor = new JLabel("Nome do Autor: ");
		lblNomeAutor.setBounds(2, 70, 111, 20);
		contentPane.add(lblNomeAutor);
		
		txtNomeAutor = new JTextField();
		txtNomeAutor.setBounds(111, 70, 337, 20);
		txtNomeAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNomeAutor.setText("");
		contentPane.add(txtNomeAutor);
		txtNomeAutor.setColumns(10);
		
		
		lblDataPublicacao = new JLabel("Data Publica��o: ");
		lblDataPublicacao.setBounds(2, 100, 111, 20);
		contentPane.add(lblDataPublicacao);
		
		txtDataPublicacao = new JTextField();
		txtDataPublicacao.setBounds(111, 100, 337, 20);
		txtDataPublicacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDataPublicacao.setText("");
		contentPane.add(txtDataPublicacao);
		txtDataPublicacao.setColumns(10);
		
		
		lblEditora = new JLabel("Editora: ");
		lblEditora.setBounds(2, 130, 111, 20);
		contentPane.add(lblEditora);

		txtEditora = new JTextField();
		txtEditora.setBounds(111, 130, 337, 20);
		txtEditora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEditora.setText("");
		contentPane.add(txtEditora);
		txtEditora.setColumns(10);
		
		
		lblCategoria = new JLabel("Categoria: ");
		lblCategoria.setBounds(2, 160, 111, 20);
		contentPane.add(lblCategoria);
		

		txtCategoria = new JTextField();
		txtCategoria.setBounds(111, 160, 337, 20);
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCategoria.setText("");
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		
		lblFormato = new JLabel("Formato: ");
		lblFormato.setBounds(2, 190, 111, 20);
		contentPane.add(lblFormato);
		
		txtFormato = new JTextField();
		txtFormato.setBounds(111, 190, 337, 20);
		txtFormato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFormato.setText("");
		contentPane.add(txtFormato);
		txtFormato.setColumns(10);
		
		
		lblnumPaginas = new JLabel("Numero de Pags: ");
		lblnumPaginas.setBounds(2, 220, 111, 20);
		contentPane.add(lblnumPaginas);

		txtnumPaginas = new JTextField();
		txtnumPaginas.setBounds(111, 220, 337, 20);
		txtnumPaginas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtnumPaginas.setText("");
		contentPane.add(txtnumPaginas);
		txtnumPaginas.setColumns(10);
		
		
		lblSumario = new JLabel("Sumario: ");
		lblSumario.setBounds(2, 250, 111, 20);
		contentPane.add(lblSumario);

		txtSumario = new JTextField();
		txtSumario.setBounds(111, 250, 337, 20);
		txtSumario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSumario.setText("");
		contentPane.add(txtSumario);
		txtSumario.setColumns(10);
		
		
		lblResumo = new JLabel("Resumo: ");
		lblResumo.setBounds(2, 280, 111, 20);
		contentPane.add(lblResumo);

		txtResumo = new JTextField();
		txtResumo.setBounds(111, 280, 337, 20);
		txtResumo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtResumo.setText("");
		contentPane.add(txtResumo);
		txtResumo.setColumns(10);
		
		
		lblPrecoCusto = new JLabel("Preco de Custo: ");
		lblPrecoCusto.setBounds(2, 310, 111, 20);
		contentPane.add(lblPrecoCusto);
		
		txtPrecoCusto = new JTextField();
		txtPrecoCusto.setBounds(111, 310, 337, 20);
		txtPrecoCusto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrecoCusto.setText("");
		contentPane.add(txtPrecoCusto);
		txtPrecoCusto.setColumns(10);
		
		
		lblPrecoVenda = new JLabel("Preco de Venda: ");
		lblPrecoVenda.setBounds(2, 340, 111, 20);
		contentPane.add(lblPrecoVenda);
		
		txtPrecoVenda = new JTextField();
		txtPrecoVenda.setBounds(111, 340, 337, 20);
		txtPrecoVenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrecoVenda.setText("");
		contentPane.add(txtPrecoVenda);
		txtPrecoVenda.setColumns(10);

		
		lblMargemLucro = new JLabel("Margem de Lucro: ");
		lblMargemLucro.setBounds(2, 370, 111, 20);
		contentPane.add(lblMargemLucro);
		
		txtMargemLucro = new JTextField();
		txtMargemLucro.setBounds(111, 370, 337, 20);
		txtMargemLucro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMargemLucro.setText("");
		contentPane.add(txtMargemLucro);
		txtMargemLucro.setColumns(10);
		
		
		lblQtdeEmEstoque = new JLabel("Qtde em Estoque: ");
		lblQtdeEmEstoque.setBounds(2, 400, 310, 20);
		contentPane.add(lblQtdeEmEstoque);
		
		txtQtdeEmEstoque = new JTextField();
		txtQtdeEmEstoque.setBounds(111, 400, 337, 20);
		txtQtdeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtQtdeEmEstoque.setText("");
		contentPane.add(txtQtdeEmEstoque);
		txtQtdeEmEstoque.setColumns(10);
		
		//btnVoltar = new JButton("");
		//BtnVoltar.setIcon(new ImageIcon(LivroBoundary.class.getResource("/resource/________")));
		//btnVoltar.setBounds(449, 265, 43, 37);
		//contentPane.add(BtnVoltar);*/

		bntSalvar = new JButton("Salvar");
		//bntSalvar.setIcon(new ImageIcon(LivroBoundary.class.getResource("/resource/___")));
		bntSalvar.setBounds(63, 450, 125, 37);
		contentPane.add(bntSalvar);
		EvBtnSalvarLivro evtSalvar = new EvBtnSalvarLivro(txtTitulo, txtISBN, txtNomeAutor, txtDataPublicacao, txtEditora, txtCategoria, txtFormato, txtnumPaginas, txtSumario, txtResumo, txtPrecoCusto, txtPrecoVenda, txtMargemLucro, txtQtdeEmEstoque, btnVoltar, bntPesquisarAutor, bntPesquisarLivro, bntDeletar, bntAlterar, bntSalvar);
		bntSalvar.addActionListener(evtSalvar);
		
		bntAlterar = new JButton("Alterar");
		//bntAlterar.setIcon(new ImageIcon(LivroBoundary.class.getResource("/resource/_____")));
		bntAlterar.setBounds(198, 450, 125, 37);
		//contentPane.add(bntAlterar);
		
		bntDeletar = new JButton("Deletar");
		bntDeletar.setBounds(333, 450, 125, 37);
		//contentPane.add(bntDeletar);
		
		//bntPesquisarLivro = new JButton("");
		//bntPesquisarLivro.setBounds(454, 11, 37, 24);
		//bntPesquisarLivro.setIcon(new ImageIcon(LivroBoundary.class.getResource("/resource/_____")));
		//contentPane.add(bntPesquisarLivro);*/
		
		contentPane.add(bntAlterar);

		bntDeletar = new JButton("Deletar");
		bntDeletar.setBounds(333, 450, 125, 37);
		contentPane.add(bntDeletar);

		/*bntPesquisarLivro = new JButton("");
		bntPesquisarLivro.setBounds(454, 11, 37, 24);
		bntPesquisarLivro.setIcon(new ImageIcon(LivroBoundary.class.getResource("/resource/_____")));
		contentPane.add(bntPesquisarLivro);*/

		//bntPesquisarAutor = new JButton("");
		//bntPesquisarAutor.setBounds(455, 43, 37, 24);
		//bntPesquisarAutor.setIcon(new ImageIcon(LivroBoundary.class.getResource("/resource/_____")));
		//contentPane.add(bntPesquisarAutor);*/


		
		
		/*LivroEvBtnSalvar evtSalvar = new LivroEvBtnSalvar(this, txtTituloLivro, txtISBN, txtNomeAutor, txtDataPublicacao,
															txtEditora, txtCategoria, txtFormato, txtnumPaginas, txtSumario, txtResumo,
															txtPrecoCusto, txtPrecoVenda, txtMargemLucro, txtQtdeEmEstoque);
		bntSalvar.addActionListener(evtSalvar);*/
		
		
		
		LivroEvBtnAlterar evtAlterar = new LivroEvBtnAlterar(this, txtTitulo, txtISBN, txtNomeAutor, txtDataPublicacao, txtEditora,
															txtCategoria, txtFormato, txtnumPaginas, txtSumario, txtResumo, 
															txtPrecoCusto, txtPrecoVenda, txtMargemLucro, txtQtdeEmEstoque);
		bntAlterar.addActionListener(evtAlterar);		
		
		
		
		//contentPane.add(btnVoltar);

		/*
		 * Adicionar evento ao bot�o salvar
		 */

		/*LivroEvBtnSalvar evtSalvar = new LivroEvBtnSalvar(this, txtTituloLivro, txtISBN, txtNomeAutor,
				txtDataPublicacao, txtEditora, txtCategoria, txtFormato, txtnumPaginas, txtSumario, txtResumo,
				txtPrecoCusto, txtPrecoVenda, txtMargemLucro, txtQtdeEmEstoque);
		bntSalvar.addActionListener(evtSalvar);

		LivroEvBtnAlterar evtAlterar = new LivroEvBtnAlterar(this, txtTituloLivro, txtISBN, txtNomeAutor,
				txtDataPublicacao, txtEditora, txtCategoria, txtFormato, txtnumPaginas, txtSumario, txtResumo,
				txtPrecoCusto, txtPrecoVenda, txtMargemLucro, txtQtdeEmEstoque);
		bntAlterar.addActionListener(evtAlterar);

		LivroEvBtnDeletar evtDeletar = new LivroEvBtnDeletar(this);
		BtnVoltar.addActionListener(evtAlterar);

		/*
		 * Adicionar evento ao bot�o voltar
		 */
	}

	public void telaDefault() {

		txtISBN.setText("");
		txtTitulo.setText("");
		txtNomeAutor.setText("");
		txtDataPublicacao.setText("");
		txtEditora.setText("");
		txtCategoria.setText("");
		txtFormato.setText("");
		txtnumPaginas.setText("");
		txtSumario.setText("");
		txtResumo.setText("");
		txtPrecoCusto.setText("");
		txtPrecoVenda.setText("");
		txtMargemLucro.setText("");
		txtQtdeEmEstoque.setText("");

		bntAlterar.setEnabled(false);
		bntDeletar.setEnabled(false);
		//btnVoltar.setEnabled(false);
		bntSalvar.setEnabled(true);

	}
	
//	public void telaAlterar(){
//		
//		bntDeletar.setEnabled(true);		

	public void telaAlterar() {

		bntAlterar.setEnabled(true);
		bntDeletar.setEnabled(true);
		//btnVoltar.setEnabled(true);
		bntSalvar.setEnabled(true);
	}

	

	
	

}
