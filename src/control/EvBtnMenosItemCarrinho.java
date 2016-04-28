package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import entity.LivroEntity;
import entity.AuxQtdadeEntity;
import entity.ItemCarrinhoEntity;

public class EvBtnMenosItemCarrinho implements ActionListener{
	private ItemCarrinhoEntity itemEntity;
	java.util.List<ItemCarrinhoEntity> itensList;
	private JButton btn;
	private JLabel labelQdade;
	private JLabel lbSubTotal;
	private JLabel valorTotal;

	
	public EvBtnMenosItemCarrinho(ItemCarrinhoEntity itemEntity, List<ItemCarrinhoEntity> itensList, JButton btn,
			JLabel labelQdade, JLabel lbSubTotal, JLabel valorTotal) {
		super();
		this.itemEntity = itemEntity;
		this.itensList = itensList;
		this.btn = btn;
		this.labelQdade = labelQdade;
		this.lbSubTotal = lbSubTotal;
		this.valorTotal = valorTotal;
	}

	public void acao(){
		if(this.itemEntity.getQuantidade() >1){
			double total = 0;
			this.itemEntity.setQuantidade(
					this.itemEntity.getQuantidade() - 1);
			this.itemEntity.setSubTotal(
					this.itemEntity.getQuantidade() *
					this.itemEntity.getLivro().getPrecoVenda());
			lbSubTotal.setText("R$ " + this.itemEntity.getSubTotal());
			labelQdade.setText("" + this.itemEntity.getQuantidade());
		
			for (ItemCarrinhoEntity a : itensList){
				total += a.getSubTotal();
			}
			
			
			valorTotal.setText("Total: R$ " + total);		
		
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.acao();
	}
	
	
}
