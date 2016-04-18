package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import control.PesquisaController;
import entity.LivroEntity;

public class PesquisaBoundary implements ActionListener{
     private JPanel tela = new JPanel();
     private JPanel painelPrincipal = new JPanel();
     private JPanel painelResultado = new JPanel();
     private JButton btnPesquisar = new JButton("Pesquisar");
     private JComboBox<String> listaCategorias =
    		 new JComboBox<String>();
     private JTextField txtTitulo = new JTextField(15);
     private JTextField txtAutor = new JTextField(15);
     private JTextField txtEditora = new JTextField(15);
     private PesquisaController controller = new PesquisaController();
     private CarrinhoBoundary carrinhoBoundary;
     
     
     
     public PesquisaBoundary(CarrinhoBoundary carrinhoBoundary) {
		super();
		this.carrinhoBoundary = carrinhoBoundary;
		this.create();
	}



     
     
	public JPanel getTela() {
		return tela;
	}



	public void setTela(JPanel tela) {
		this.tela = tela;
	}



	public void create(){
    	 painelPrincipal.setLayout(new BorderLayout());
         painelPrincipal.setForeground(Color.WHITE);
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
		painelLeste.add(btnPesquisar, BorderLayout.NORTH);
		
		painelPrincipal.add(painelLeste, BorderLayout.WEST);
		
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
		
		btnPesquisar.addActionListener(this);
		
		painelIndice.add(lb1);
		painelIndice.add(lb2);
		painelIndice.add(lb3);
		painelIndice.add(lb4);
		painelIndice.add(lb5);
		
		this.formataPainel(painel1);
		this.formataPainel(painel2);
		this.formataPainel(painel3);
		this.formataPainel(painelCompCri);
		this.formataPainel(painelCriterios);
		this.formataPainel(painelIndice);
		this.formataPainel(painelLeste);
		this.formataPainel(painelPrincipal);
		this.formataPainel(painelResultado);

		painelLeste.setBorder(new LineBorder(Color.BLACK));
		painelCompCri.setBorder(new LineBorder(Color.BLACK));
		
		
		painelResultado.add(painelIndice, BorderLayout.NORTH);
		painelPrincipal.add(painelResultado, BorderLayout.CENTER);
		tela.add(painelPrincipal);
     }
     
	
	 public void mostraPesquisa(java.util.List<LivroEntity> listaLivro){
		 System.out.println(listaLivro.size());
		 painelResultado.removeAll();
		 JScrollPane spane = new JScrollPane();
		 JPanel painel = new JPanel();
		 this.formataPainel(painel);
		 GridLayout grid = new GridLayout(1, 1, 10,10);
		 painel.setLayout(grid);
		 spane.setViewportView(painel);
		 for(LivroEntity l: listaLivro){
			 ItemPesquisaBoundary item = new
					 ItemPesquisaBoundary(l, carrinhoBoundary);
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

	 public LivroEntity formToLivro(){
		 LivroEntity livro = new LivroEntity();
		 livro.setTituloLivro(txtTitulo.getText());
		 livro.setNomeAutor(txtAutor.getText());
		 livro.setCategoriaLivro(listaCategorias.getSelectedItem().toString());
		 livro.setEditora(txtEditora.getText());
		 return livro;
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnPesquisar){
			mostraPesquisa(controller.listaLivro(0, formToLivro().getNomeAutor(), 0, 0));
		}
	}
	 
}
