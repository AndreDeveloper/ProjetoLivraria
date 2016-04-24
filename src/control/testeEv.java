package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import entity.ItemCarrinhoEntity;

public class testeEv implements ActionListener{
	private java.util.List<ItemCarrinhoEntity> itensList;
	private JButton btn;
	public testeEv(List<ItemCarrinhoEntity> itensList, JButton btn) {
		super();
		this.itensList = itensList;
		this.btn = btn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(ItemCarrinhoEntity c : itensList){
			System.out.println(c.toString());
		}
	}
	
	
}
