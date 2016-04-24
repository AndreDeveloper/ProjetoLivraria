package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import boundary.CarrinhoBoundary;
import boundary.ItemCarrinhoBoundary;
import entity.ItemCarrinhoEntity;

public class EvBtnRmItemCarrinho implements ActionListener{
    private JPanel tela;
	private ItemCarrinhoBoundary item;
	private JPanel painel;
	private java.util.List<ItemCarrinhoEntity> itensList =
			new ArrayList<ItemCarrinhoEntity>();
	private ItemCarrinhoEntity itemEntity;
	private JScrollPane bar;
	private JLabel valorTotal;
	private CarrinhoBoundary carrinhoBoundary;
	
	public EvBtnRmItemCarrinho(CarrinhoBoundary carrinhoBoundary, JPanel tela,
			ItemCarrinhoBoundary item, JPanel painel,
			List<ItemCarrinhoEntity> itensList,
			ItemCarrinhoEntity itemEntity,
			JScrollPane bar, JLabel valorTotal) {
		super();
		this.carrinhoBoundary = carrinhoBoundary;
		this.tela = tela;
		this.item = item;
		this.painel = painel;
		this.itensList = itensList;
		this.itemEntity = itemEntity;
		this.bar = bar;
		this.valorTotal = valorTotal;
	}

	public void acao(){
		double total = 0;
		painel.remove(item);
		itensList.remove(itemEntity);
		bar.invalidate();
		bar.revalidate();
		tela.repaint();
		painel.repaint();

		for (ItemCarrinhoEntity a : itensList){
			total += a.getSubTotal();
		}
		
		
		valorTotal.setText("Total: R$ " + total);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.acao();
		carrinhoBoundary.notificar("" + carrinhoBoundary.getQuantidade());
	}
	
	
}
