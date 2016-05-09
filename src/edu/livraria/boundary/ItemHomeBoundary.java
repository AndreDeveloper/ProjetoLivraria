package edu.livraria.boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.livraria.control.Observer;
import edu.livraria.control.Subject;
import edu.livraria.entity.ItemCarrinho;
import edu.livraria.entity.Livro;

public class ItemHomeBoundary implements ActionListener, Subject{
	private JLabel lblImagem = new JLabel();
	private JLabel lblPreco = new JLabel();
	private JButton btnAddCarrinho = new JButton();
	private JButton btnVisualizar = new JButton();
	private JPanel painelPrincipal = new JPanel(new BorderLayout());
	private Livro livro;
	private List<Observer> listaObserver = new ArrayList<Observer>();

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
		painelPrincipal.setPreferredSize(new Dimension(200, 310));
		
		btnVisualizar.setForeground(Color.white);
		btnVisualizar.setBackground(Color.BLACK);
		btnVisualizar.setBorder(BorderFactory.createEmptyBorder());
		btnVisualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVisualizar.setIcon(
				new ImageIcon(ItemHomeBoundary.class.getResource("/resource/visu.png"))
				);
		btnVisualizar.addActionListener(this);
		
		btnAddCarrinho.setForeground(Color.white);
		btnAddCarrinho.setBackground(Color.BLACK);
		btnAddCarrinho.setBorder(BorderFactory.createEmptyBorder());
		btnAddCarrinho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddCarrinho.setIcon(
				new ImageIcon(ItemHomeBoundary.class.getResource("/resource/adicionarCarrinho.png"))
				);
		btnAddCarrinho.addActionListener(this);
		
		lblPreco.setHorizontalAlignment(JLabel.CENTER);
		lblPreco.setVerticalAlignment(JLabel.CENTER);
		lblPreco.setForeground(Color.GREEN);
		lblPreco.setBackground(Color.WHITE);
		lblPreco.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		lblPreco.setText("R$ " + livro.getPrecoVenda());
		
		lblImagem.setHorizontalAlignment(JLabel.CENTER);
		lblImagem.setVerticalAlignment(JLabel.CENTER);
		lblImagem.setForeground(Color.GREEN);
		lblImagem.setBackground(Color.WHITE);
		lblImagem.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		lblImagem.setIcon(this.livro.getImagem());
		
		JPanel painelBotoes = new JPanel(new GridLayout(2, 1,0,0));
		JPanel linha2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
		
		painelBotoes.setForeground(Color.BLACK);
		painelBotoes.setBackground(Color.white);
		painelBotoes.setBorder(BorderFactory.createEmptyBorder());
		
		linha2.setForeground(Color.BLACK);
		linha2.setBackground(Color.white);
		linha2.setBorder(BorderFactory.createEmptyBorder());
		
		linha2.add(btnVisualizar);
		linha2.add(btnAddCarrinho);
		
		painelBotoes.add(lblPreco);
		painelBotoes.add(linha2);
		
		painelPrincipal.add(lblImagem, BorderLayout.CENTER);
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btnAddCarrinho){
			ItemCarrinho carrinhoEntity = new ItemCarrinho();
			new AuxQtdadeCarrinhoBoundary(carrinhoEntity);
			if (carrinhoEntity.getQuantidade() != 0){
				carrinhoEntity.setLivro(livro);
				carrinhoEntity.setImagem(livro.getImagem());
				notificar(carrinhoEntity);
			}
		
		}else if (arg0.getSource() == btnVisualizar){
			notificar(livro);
		}
		
	}


	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		listaObserver.add(o);
	}


	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		listaObserver.remove(o);
	}


	@Override
	public void notificar(String noticia) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void notificar(ItemCarrinho carrinhoEntity) {
		// TODO Auto-generated method stub
		for(Observer o: listaObserver){
			o.update(carrinhoEntity);
		}
	}


	@Override
	public void notificar(Livro livro) {
		for(Observer o: listaObserver){
			o.update(livro);
		}
		
	}           
	
}
