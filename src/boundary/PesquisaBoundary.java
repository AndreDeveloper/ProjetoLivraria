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
import infraestructure.CategoriaDAO;

public class PesquisaBoundary implements ActionListener{
     private JPanel tela = new JPanel();
     private JPanel painelPrincipal = new JPanel();
     private JPanel painelResultado = new JPanel();
     private JButton btnPesquisar = new JButton("Pesquisar");
     private JButton btnAutor = new JButton();
     private JButton btnEditora = new JButton();
     private JComboBox<String> listaCategorias =
    		 new JComboBox<String>();
     private JTextField txtTitulo = new JTextField(15);
     private JTextField txtAutor = new JTextField(15);
     private JTextField txtEditora = new JTextField(15);
     private PesquisaController controller = new PesquisaController();
     private CarrinhoBoundary carrinhoBoundary;
     private JPanel painelIndice = new JPanel();
     private TelaPrincipalBoundary telaPrincipal;
     
     
     
     public PesquisaBoundary(CarrinhoBoundary carrinhoBoundary,
    		 TelaPrincipalBoundary telaPrincipal) {
		super();
		this.carrinhoBoundary = carrinhoBoundary;
		this.telaPrincipal = telaPrincipal;
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
    	// 
    	 
    	DefaultComboBoxModel<String> combomodel = 
    			new DefaultComboBoxModel<String>();
    	for(String s: new CategoriaDAO().selectAll()){
    		combomodel.addElement(s);
    	}
    	listaCategorias.setModel(combomodel);
    	listaCategorias.setToolTipText("Escolha uma categoria");    	
    	listaCategorias.setForeground(Color.BLACK);
    	listaCategorias.setBackground(Color.WHITE);
    	listaCategorias.setFont(new Font("Tahoma", Font.BOLD, 14));
    	listaCategorias.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	listaCategorias.setBorder(BorderFactory.createEmptyBorder());
    	
		JPanel painelCriterios = new JPanel();
		painelCriterios.setLayout(new GridLayout(5, 1, 10, 10));
		JLabel lbTitulo = new JLabel("  Titulo");
		JLabel lbAutor = new JLabel("  Autor");
		JLabel lbEditora = new JLabel("Editora");
		
		btnAutor.setHorizontalAlignment(JLabel.RIGHT);
    	btnAutor.setForeground(Color.BLACK);
    	btnAutor.setBackground(Color.WHITE);
    	btnAutor.setFont(new Font("Tahoma", Font.BOLD, 22));
    	btnAutor.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	btnAutor.setBorder(BorderFactory.createEmptyBorder());
    	btnAutor.setHorizontalAlignment(JButton.CENTER);
    	btnAutor.addActionListener(this);
    	btnAutor.setIcon(
    					new ImageIcon(LivroBoundary.class.getResource("/resource/lupa.png"))
    					);
    	
    	btnEditora.setForeground(Color.BLACK);
    	btnEditora.setBackground(Color.WHITE);
    	btnEditora.setFont(new Font("Tahoma", Font.BOLD, 22));
    	btnEditora.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	btnEditora.setBorder(BorderFactory.createEmptyBorder());
    	btnEditora.setHorizontalAlignment(JButton.CENTER);
    	btnEditora.setToolTipText("clique para Realizar a pesquisa");
    	btnEditora.addActionListener(this);
    	btnEditora.setIcon(
    					new ImageIcon(LivroBoundary.class.getResource("/resource/lupa.png"))
    					);
    	
		JPanel painel1 = new JPanel();
		painel1.setLayout(new FlowLayout());
		painel1.add(lbTitulo);
		painel1.add(txtTitulo);
		
		JPanel painel2 = new JPanel();
		painel2.setLayout(new FlowLayout());
		painel2.add(lbAutor);
		JPanel painelAuxAutor = new JPanel(new FlowLayout());
		painelAuxAutor.setBackground(Color.white);
		painelAuxAutor.setBorder(BorderFactory.createEmptyBorder());
		painelAuxAutor.add(txtAutor);
		painelAuxAutor.add(btnAutor);
		painel2.add(painelAuxAutor);
		
		JPanel painel3 = new JPanel();
		painel3.setLayout(new FlowLayout());
		painel3.add(lbEditora);
		JPanel painelAuxEditora = new JPanel();
		painelAuxEditora.setBackground(Color.white);
		painelAuxEditora.setBorder(BorderFactory.createEmptyBorder());
		painelAuxEditora.add(txtEditora);
		painelAuxEditora.add(btnEditora);
		painel3.add(painelAuxEditora);
		
		painelCriterios.add(painel1);
		painelCriterios.add(painel2);
		painelCriterios.add(painel3);
		painelCriterios.add(listaCategorias);
		painelCriterios.add(btnPesquisar);
		
	
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

    	JLabel lblDescricao = new JLabel("Procure um livro...");
    	
    	lblDescricao.setHorizontalAlignment(JLabel.RIGHT);
    	lblDescricao.setForeground(Color.BLACK);
    	lblDescricao.setBackground(Color.WHITE);
    	lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 22));
    	lblDescricao.setBorder(BorderFactory.createEmptyBorder());
    	lblDescricao.setHorizontalAlignment(JButton.CENTER);

    	
    	JPanel painelCompCri = new JPanel();
    	painelCompCri.setLayout(new BorderLayout());
    	painelCompCri.add(painelCriterios, BorderLayout.NORTH);
    	
    	
		JPanel painelLeste = new JPanel();
		painelLeste.setLayout(new BorderLayout());
	//	painelLeste.add(scrollPane, BorderLayout.WEST);
		painelLeste.add(painelCompCri, BorderLayout.CENTER);
		painelLeste.setBorder(new LineBorder(Color.BLACK));
		painelLeste.add(lblDescricao, BorderLayout.NORTH);
		
		painelPrincipal.add(painelLeste, BorderLayout.WEST);
		
		painelResultado.setLayout(new BorderLayout());
		
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
		 painelResultado.add(painelIndice, BorderLayout.NORTH);
		 JScrollPane spane = new JScrollPane();
		 JPanel painel = new JPanel();
		 this.formataPainel(painel);
		 GridLayout grid = new GridLayout(1, 1, 10,10);
		 painel.setLayout(grid);
		 spane.setViewportView(painel);
		 for(LivroEntity l: listaLivro){
			 ItemPesquisaBoundary item = new
					 ItemPesquisaBoundary(l, carrinhoBoundary, telaPrincipal);
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
		 String autor = txtAutor.getText().replaceFirst("([0-9]+)\\s\\-\\s", "").trim();
		 String editora = txtEditora.getText().replaceFirst("([0-9]+)\\s\\-\\s", "").trim();
		 livro.setTituloLivro(txtTitulo.getText());
		 livro.setNomeAutor(autor);
		 livro.setCategoriaLivro(listaCategorias.getSelectedItem().toString());
		 livro.setEditora(editora);
		 if(listaCategorias.getSelectedIndex() != 0){
		 livro.setIdCategoriaLivro(listaCategorias.getSelectedIndex() + 1);
		 }else{
			 livro.setIdCategoriaLivro(0);
		 }
		 return livro;
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnPesquisar){
			mostraPesquisa(controller.listaLivro(formToLivro().getNomeAutor(),
					formToLivro().getTituloLivro(),
					formToLivro().getEditora(),
					formToLivro().getIdCategoriaLivro()));
		}else if (e.getSource() == btnAutor){
			new AuxiliarPesquisa(txtAutor, "Autor");
		}else if (e.getSource() == btnEditora){
			new AuxiliarPesquisa(txtEditora, "Editora");
		}
	}
	 
}
