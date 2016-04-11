package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import entity.LivroEntity;
import sun.net.www.content.image.jpeg;

public class PesquisaBoundary {
     private JFrame tela = new JFrame("Pesquisa de livros");
     private JPanel painelPrincipal = new JPanel();
     private JList listaCategorias;
     private JPanel painelResultado = new JPanel();
     
     
     public PesquisaBoundary() {
		this.create();
	}

	public void create(){
    	 painelPrincipal.setLayout(new BorderLayout());
    	 /*JScrollPane scrollPane = new JScrollPane();
    	 listaCategorias = new JList();
			scrollPane.setViewportView(listaCategorias);
			listaCategorias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listaCategorias.setModel(new AbstractListModel() {
				String[] values = new String[] {"<<TODOS>>","Categoria",
						"Administra\u00E7\u00E3o", "Agropecu\u00E1ria", 
						"Artes", "Audiolivro", "Autoajuda", 
						"Ci\u00EAncias Biol\u00F3gicas", 
						"Ci\u00EAncias Exatas", 
						"Ci\u00EAncias Humanas e Sociais", "Contabilidade",
						"Cursos e Idiomas", "Dicion\u00E1rios e Manuais Convers.", 
						"Did\u00E1ticos", "Direito", 
						"Economia", "Engenharia e Tecnologia", "Esoterismo", 
						"Esportes e Lazer", "Gastronomia", "Geografia e Historia", 
						"Inform\u00E1tica", "Lingu\u00EDstica", 
						"Literatura Estrangeira", "Literatura Infantojuvenil", 
						"Literatura Nacional", "Livros", "Medicina", "Religi\u00E3o", 
						"Turismo"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});*/
    	 String[] values = new String[] {"<<Escolha a Categoria>>",
					"Administra\u00E7\u00E3o", "Agropecu\u00E1ria", 
					"Artes", "Audiolivro", "Autoajuda", 
					"Ci\u00EAncias Biol\u00F3gicas", 
					"Ci\u00EAncias Exatas", 
					"Ci\u00EAncias Humanas e Sociais", "Contabilidade",
					"Cursos e Idiomas", "Dicion\u00E1rios e Manuais Convers.", 
					"Did\u00E1ticos", "Direito", 
					"Economia", "Engenharia e Tecnologia", "Esoterismo", 
					"Esportes e Lazer", "Gastronomia", "Geografia e Historia", 
					"Inform\u00E1tica", "Lingu\u00EDstica", 
					"Literatura Estrangeira", "Literatura Infantojuvenil", 
					"Literatura Nacional", "Livros", "Medicina", "Religi\u00E3o", 
					"Turismo"}; 
		JComboBox<String> listaCategorias =
				new JComboBox<String>();
    	DefaultComboBoxModel<String> combomodel = 
    			new DefaultComboBoxModel<String>(values);
    	listaCategorias.setModel(combomodel);
    	listaCategorias.setToolTipText("Escolha uma categoria");    	
    	listaCategorias.setForeground(Color.BLACK);
    	listaCategorias.setBackground(Color.WHITE);
    	listaCategorias.setFont(new Font("Tahoma", Font.BOLD, 14));
    	listaCategorias.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	listaCategorias.setBorder(BorderFactory.createEmptyBorder());
    	
		JPanel painelCriterios = new JPanel();
		painelCriterios.setLayout(new GridLayout(4, 1, 10, 10));
		JLabel lbTitulo = new JLabel("  Titulo");
		JLabel lbAutor = new JLabel("  Autor");
		JLabel lbEditora = new JLabel("Editora");
		JTextField txtTitulo = new JTextField(15);
		JTextField txtAutor = new JTextField(15);
		JTextField txtEditora = new JTextField(15);
		
		JPanel painel1 = new JPanel();
		painel1.setLayout(new FlowLayout());
		painel1.add(lbTitulo);
		painel1.add(txtTitulo);
		
		JPanel painel2 = new JPanel();
		painel2.setLayout(new FlowLayout());
		painel2.add(lbAutor);
		painel2.add(txtAutor);
		
		JPanel painel3 = new JPanel();
		painel3.setLayout(new FlowLayout());
		painel3.add(lbEditora);
		painel3.add(txtEditora);
		
		painelCriterios.add(painel1);
		painelCriterios.add(painel2);
		painelCriterios.add(painel3);
		painelCriterios.add(listaCategorias);
		
	
    	lbTitulo.setHorizontalAlignment(JLabel.RIGHT);
    	lbAutor.setHorizontalAlignment(JLabel.RIGHT);
    	lbEditora.setHorizontalAlignment(JLabel.RIGHT);
    	
    	JButton btnPesquisar = new JButton("Pesquisar");
    	btnPesquisar.setIcon(
				new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/lupa.png"))
				);
    	btnPesquisar.setHorizontalAlignment(JLabel.RIGHT);
    	btnPesquisar.setForeground(Color.BLACK);
    	btnPesquisar.setBackground(Color.WHITE);
    	btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 22));
    	btnPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	btnPesquisar.setBorder(BorderFactory.createEmptyBorder());
    	btnPesquisar.setHorizontalAlignment(JButton.CENTER);
    	btnPesquisar.setToolTipText("clique para Realizar a pesquisa");
    	
    	JPanel painelCompCri = new JPanel();
    	painelCompCri.setLayout(new BorderLayout());
    	painelCompCri.add(painelCriterios, BorderLayout.NORTH);
    	
    	
		JPanel painelLeste = new JPanel();
		painelLeste.setLayout(new BorderLayout());
	//	painelLeste.add(scrollPane, BorderLayout.WEST);
		painelLeste.add(painelCompCri, BorderLayout.CENTER);
		painelLeste.setBorder(new LineBorder(Color.BLACK));
		painelLeste.add(btnPesquisar, BorderLayout.SOUTH);
		
		painelPrincipal.add(painelLeste, BorderLayout.WEST);
     
		JPanel painelNorte = new JPanel();
		painelNorte.setLayout(new GridLayout(1, 3,10,10));
		
		JLabel iconeLivro = new JLabel();
		iconeLivro.setIcon(
				new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/livros.png"))
				);
		JButton btnCarrinho = new JButton();
		btnCarrinho.setIcon(
				new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/carrinho.png"))
				);
		btnCarrinho.setHorizontalAlignment(JLabel.RIGHT);
		btnCarrinho.setForeground(Color.BLUE);
		btnCarrinho.setBackground(Color.WHITE);
		btnCarrinho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCarrinho.setBorder(BorderFactory.createEmptyBorder());
		btnCarrinho.setToolTipText("clique para visualisar o carrinho");
		
		JLabel iconeUser = new JLabel();
		iconeUser.setIcon(
				new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/login.png"))
				);
		iconeUser.setVerticalAlignment(JLabel.CENTER);
		iconeUser.setHorizontalAlignment(JLabel.CENTER);
		JPanel painelCadastrar = new JPanel();
		painelCadastrar.setLayout(new GridLayout(2, 1));
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new GridLayout(1, 2));
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.BLUE);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEntrar.setBorder(BorderFactory.createEmptyBorder());
		btnEntrar.setToolTipText("faça seu login");
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrar.setBorder(BorderFactory.createEmptyBorder());
		btnCadastrar.setToolTipText("Faça seu cadastro");
		
		painelBotoes.add(btnEntrar);
		painelBotoes.add(btnCadastrar);
		
		painelCadastrar.add(iconeUser);
		painelCadastrar.add(painelBotoes);
		
		painelNorte.add(iconeLivro);
		painelNorte.add(painelCadastrar);
		painelNorte.add(btnCarrinho);
		
		painelPrincipal.add(painelNorte, BorderLayout.NORTH);
		
		painelResultado.setLayout(new BorderLayout());
		
		JPanel painelIndice = new JPanel();
		painelIndice.setLayout(new GridLayout(1, 5, 5, 5));
		
		JLabel lb1 = new JLabel("");
		JLabel lb2 = new JLabel("Nome do livro");
		lb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb2.setHorizontalAlignment(JLabel.CENTER);
		JLabel lb3 = new JLabel("Autor");
		lb3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb3.setHorizontalAlignment(JLabel.CENTER);
		JLabel lb4 = new JLabel("Preço");
		lb4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb4.setHorizontalAlignment(JLabel.CENTER);
		JLabel lb5 = new JLabel("");
		
		painelIndice.add(lb1);
		painelIndice.add(lb2);
		painelIndice.add(lb3);
		painelIndice.add(lb4);
		painelIndice.add(lb5);
		
		this.formataPainel(painel1);
		this.formataPainel(painel2);
		this.formataPainel(painel3);
		this.formataPainel(painelBotoes);
		this.formataPainel(painelCadastrar);
		this.formataPainel(painelCompCri);
		this.formataPainel(painelCriterios);
		this.formataPainel(painelIndice);
		this.formataPainel(painelLeste);
		this.formataPainel(painelNorte);
		this.formataPainel(painelPrincipal);
		this.formataPainel(painelResultado);

		painelLeste.setBorder(new LineBorder(Color.BLACK));
		painelNorte.setBorder(new LineBorder(Color.BLACK));
		painelCompCri.setBorder(new LineBorder(Color.BLACK));
		
		
		painelResultado.add(painelIndice, BorderLayout.NORTH);
		painelPrincipal.add(painelResultado, BorderLayout.CENTER);
		tela.setContentPane(painelPrincipal);
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tela.setVisible(true);
     }
     
	
	 public void mostraPesquisa(java.util.List<LivroEntity> listaLivro){
		 JScrollPane spane = new JScrollPane();
		 JPanel painel = new JPanel();
		 GridLayout grid = new GridLayout(1, 1, 10,10);
		 painel.setLayout(grid);
		 spane.setViewportView(painel);
		 for(LivroEntity l: listaLivro){
			 ItemPesquisaBoundary item = new
					 ItemPesquisaBoundary(l);
			 painel.add(item);
			 grid.setRows(grid.getRows() + 1);
		 }
		 
		 painelResultado.add(spane, BorderLayout.CENTER);
		 
		 spane.repaint();
		 spane.invalidate();
		 spane.revalidate();
		 tela.repaint();
		 tela.invalidate();
		 tela.revalidate();
	 }
     
	 public void formataPainel(JPanel painel){
		painel.setForeground(Color.WHITE);
		painel.setBackground(Color.WHITE);
		painel.setBorder(BorderFactory.createEmptyBorder());
	 }
	 
	 public static void main(String[] args) {
			new PesquisaBoundary().tela.setVisible(true);

		}
	 
}
