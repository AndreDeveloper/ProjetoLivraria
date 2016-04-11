package boundary;

import infraestructure.PesquisaDAO;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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

import entity.LivroEntity;

public class ExibirInfosLivroBoundary {

	private LivroEntity livroEntity;
	
	private List<LivroEntity> listaPesquisa = new ArrayList<LivroEntity>();

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
	private JTextField txtTitulo;
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
	
	JButton btn;


	public LivroEntity getLivroEntity() {
		return livroEntity;
	}

	public void setLivroEntity(LivroEntity livroEntity) {
		this.livroEntity = livroEntity;
	}

	public static void main(String[] args) {
		new ExibirInfosLivroBoundary().frame.setVisible(true);

	}

	public ExibirInfosLivroBoundary() {
		
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Detalhes do Livro");
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
		

		lblTitulo = new JLabel("Título: ");
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
		
		
		lblDataPublicacao = new JLabel("Data Publicação: ");
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
		
		btn = new JButton("Pesquisar");
		btn.setBounds(150, 450, 150, 37);
		contentPane.add(btn);
		btn.addActionListener(new EvBtnPesquisa());
		

	}
	

public class EvBtnPesquisa implements ActionListener {
	
	private PesquisaDAO pesquisaDAO;
	
	
	public List<LivroEntity> pesquisarLivro(String tituloLivro) {
		try {
			listaPesquisa = pesquisaDAO.perquisarLivro(tituloLivro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaPesquisa;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		pesquisarLivro("abc");
		
		txtTitulo.setText(listaPesquisa.get(0).getTituloLivro());
		txtNomeAutor.setText(listaPesquisa.get(0).getNomeAutor());
	}

}


}
