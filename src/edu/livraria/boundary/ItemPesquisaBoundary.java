package edu.livraria.boundary;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import edu.livraria.entity.ItemCarrinho;
import edu.livraria.entity.Livro;

public class ItemPesquisaBoundary extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Livro livro;
	private CarrinhoBoundary carrinhoBoundary;
	private JButton btnImagem = new JButton("");
	private JButton btnAddCarrinho = new JButton("");
	private TelaPrincipalBoundary telaPrincipalBoundary;
	private JButton btnVisualizar = new JButton();
	
	public ItemPesquisaBoundary(Livro livro,
			CarrinhoBoundary carrinhoBoundary,
			TelaPrincipalBoundary telaPrincipalBoundary) {
		super();
		this.livro = livro;
		this.carrinhoBoundary = carrinhoBoundary;
		this.telaPrincipalBoundary = telaPrincipalBoundary;
		this.criarTela();
	}

	private void criarTela(){
		GridLayout gridlayout = new GridLayout(1, 5, 5, 5);
		JTextArea lbAutor = new JTextArea(livro.getNomeAutor());
		JTextArea lbTitulo = new  JTextArea(livro.getTituloLivro());
		JLabel lbPreco = new JLabel("R$ " + livro.getPrecoVenda());
		
		lbTitulo.setEditable(false);
		lbTitulo.setLineWrap(true);
		lbTitulo.setToolTipText(lbTitulo.getText());
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(lbTitulo);
		Dimension d = new Dimension(100, 40);
		jScrollPane.setSize(d);
		jScrollPane.setPreferredSize(d);
		jScrollPane.setForeground(Color.RED);
		jScrollPane.setBackground(Color.WHITE);
		jScrollPane.setBorder(BorderFactory.createEmptyBorder());
	
		btnImagem.setIcon(livro.getImagem());
		btnImagem.setForeground(Color.RED);
		btnImagem.setBackground(Color.WHITE);
		btnImagem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnImagem.setBorder(BorderFactory.createEmptyBorder());
		btnImagem.setToolTipText("Clique na imagem para visualizar mais detalhes sobre o livro");
		btnImagem.addActionListener(this);
		
		btnVisualizar.setIcon(livro.getImagem());
		btnVisualizar.setForeground(Color.RED);
		btnVisualizar.setBackground(Color.WHITE);
		btnVisualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVisualizar.setBorder(BorderFactory.createEmptyBorder());
		btnVisualizar.setToolTipText("Clique na imagem para visualizar mais detalhes sobre o livro");
		btnVisualizar.addActionListener(this);
        btnVisualizar.setIcon(
				new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/visu.png")));
		
		btnAddCarrinho.setIcon(
				new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/adicionarCarrinho.png")));
		btnAddCarrinho.setForeground(Color.RED);
		btnAddCarrinho.setBackground(Color.WHITE);
		btnAddCarrinho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddCarrinho.setBorder(BorderFactory.createEmptyBorder());
		btnAddCarrinho.setToolTipText("Adicionar item ao carrinho de compras");
		btnAddCarrinho.addActionListener(this);
		
		
		//lbAutor.setHorizontalAlignment(JLabel.CENTER);
		//lbAutor.setVerticalAlignment(JLabel.CENTER);
		lbAutor.setForeground(Color.BLUE);
		lbAutor.setBackground(Color.WHITE);
		lbAutor.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lbAutor.setLineWrap(true);
		
		lbTitulo.setForeground(Color.BLUE);
		lbTitulo.setBackground(Color.WHITE);
		lbTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		
		lbPreco.setHorizontalAlignment(JLabel.CENTER);
		lbPreco.setVerticalAlignment(JLabel.CENTER);
		lbPreco.setForeground(Color.BLUE);
		lbPreco.setBackground(Color.WHITE);
		lbPreco.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		
		JPanel painel1 = new JPanel(new GridLayout(2, 1));
		painel1.setForeground(Color.BLUE);
		painel1.setBackground(Color.WHITE);
		painel1.setBorder(BorderFactory.createEmptyBorder());
		
		painel1.add(btnAddCarrinho);
		painel1.add(btnVisualizar);
		
		this.setLayout(gridlayout);
		this.add(btnImagem);
		this.add(jScrollPane);
		this.add(lbAutor);
		this.add(lbPreco);
		this.add(painel1);
		
		this.setForeground(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == btnAddCarrinho){
			ItemCarrinho carrinhoEntity = new ItemCarrinho();
			new AuxQtdadeCarrinhoBoundary(carrinhoEntity);
			if (carrinhoEntity.getQuantidade() != 0){
				carrinhoEntity.setLivro(livro);
				carrinhoEntity.setImagem(livro.getImagem());
				carrinhoBoundary.adicionaItem(carrinhoEntity);
			}
			
		}else if(arg0.getSource() == btnImagem){
			InfoLivroBoundary resultado = new InfoLivroBoundary(livro);
			resultado.addObserver(telaPrincipalBoundary);
			telaPrincipalBoundary.selectTela(resultado.getPainelPrincipal());
			
		}else if(arg0.getSource() == btnVisualizar){
			InfoLivroBoundary resultado = new InfoLivroBoundary(livro);
			resultado.addObserver(telaPrincipalBoundary);
			telaPrincipalBoundary.selectTela(resultado.getPainelPrincipal());
			
		}
	}
	
	
	
	
}
