package edu.livraria.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import edu.livraria.entity.ItemCarrinho;

public class testeEv implements ActionListener{
	private java.util.List<ItemCarrinho> itensList;
	private JButton btn;
	public testeEv(List<ItemCarrinho> itensList, JButton btn) {
		super();
		this.itensList = itensList;
		this.btn = btn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(ItemCarrinho c : itensList){
			System.out.println(c.toString());
		}
	}
	
	
}
