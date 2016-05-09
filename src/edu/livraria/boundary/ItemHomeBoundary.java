package edu.livraria.boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.livraria.entity.Livro;

public class ItemHomeBoundary {
	private JLabel lblImagem = new JLabel();
	private JLabel lblPreco = new JLabel();
	private JButton btnAddCarrinho = new JButton();
	private JButton btnVisualizar = new JButton();
	private JPanel painelPrincipal = new JPanel(new BorderLayout());
	private Livro livro;

	public ItemHomeBoundary(Livro livro) {
		super();
		this.livro = livro;
		create();
	}
	
	
	public JPanel getPainelPrincipal() {
		return painelPrincipal;
	}


	public void setPainelPrincipal(JPanel painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}


	private void create(){
		painelPrincipal.setForeground(Color.BLACK);
		painelPrincipal.setBackground(Color.white);
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder());
		painelPrincipal.setPreferredSize(new Dimension(270, 270));
		
		btnVisualizar.setForeground(Color.white);
		btnVisualizar.setBackground(Color.BLACK);
		btnVisualizar.setBorder(BorderFactory.createEmptyBorder());
		btnVisualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVisualizar.setIcon(
				new ImageIcon(ItemHomeBoundary.class.getResource("/resource/visu.png"))
				);

		btnAddCarrinho.setForeground(Color.white);
		btnAddCarrinho.setBackground(Color.BLACK);
		btnAddCarrinho.setBorder(BorderFactory.createEmptyBorder());
		btnAddCarrinho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddCarrinho.setIcon(
				new ImageIcon(ItemHomeBoundary.class.getResource("/resource/visu.png"))
				);
		
		lblPreco.setHorizontalAlignment(JLabel.RIGHT);
		lblPreco.setVerticalAlignment(JLabel.CENTER);
		lblPreco.setForeground(Color.GREEN);
		lblPreco.setBackground(Color.WHITE);
		lblPreco.setFont(new Font("Palatino Linotype", Font.BOLD, 22));

		lblImagem.setHorizontalAlignment(JLabel.RIGHT);
		lblImagem.setVerticalAlignment(JLabel.CENTER);
		lblImagem.setForeground(Color.GREEN);
		lblImagem.setBackground(Color.WHITE);
		lblImagem.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		
		JPanel painelBotoes = new JPanel(new GridLayout(2, 1));
		JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		linha2.add(btnVisualizar);
		linha2.add(btnAddCarrinho);
		
		painelBotoes.add(lblPreco);
		painelBotoes.add(linha2);
		
		painelPrincipal.add(lblImagem, BorderLayout.CENTER);
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
	}           
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);
		
		Livro livro = new Livro();
		livro.setPrecoVenda(200);
		livro.setImagem(new ImageIcon(ItemHomeBoundary.class.getResource("/resource/adicionarCarrinho.png")));
		
		jPanel.add(new ItemHomeBoundary(livro).getPainelPrincipal());
		
		frame.setContentPane(jPanel);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
