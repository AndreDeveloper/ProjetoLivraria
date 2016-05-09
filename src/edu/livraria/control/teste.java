package edu.livraria.control;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.livraria.boundary.ItemHomeBoundary;
import edu.livraria.entity.Livro;

public class teste {

	
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			
			JPanel jPanel = new JPanel();
			jPanel.setLayout(new FlowLayout());
			
			Livro livro = new Livro();
			livro.setPrecoVenda(200);
			livro.setImagem(new ImageIcon(ItemHomeBoundary.class.getResource("/resource/livro.png")));
			
			jPanel.add(new ItemHomeBoundary(livro).getPainelPrincipal());
			
			frame.setContentPane(jPanel);
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}

	

}
