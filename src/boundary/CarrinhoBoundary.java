package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicInternalFrameUI.InternalFramePropertyChangeListener;

import control.EvBtnRmItemCarrinho;
import control.testeEv;
import entity.LivroEntity;
import entity.AuxQtdadeEntity;
import entity.ItemCarrinhoEntity;

public class CarrinhoBoundary {
	private JPanel tela = new JPanel();
	private JPanel painelPrincipal = new JPanel();
	private JPanel painelProdutos = new JPanel();
	private GridLayout gridLayout = new GridLayout(1, 1, 10, 10);
	private JScrollPane bar = new JScrollPane();
	private JLabel valorTotal = new JLabel("TOTAL: R$");
	private java.util.List<ItemCarrinhoEntity> itensList =
			new ArrayList<ItemCarrinhoEntity>();
	
	
	public JPanel getTela() {
		return tela;
	}

	public void setTela(JPanel tela) {
		this.tela = tela;
	}

	public CarrinhoBoundary(){
		BorderLayout borderLayout = new BorderLayout();
		painelPrincipal.setLayout(borderLayout);
		painelProdutos.setLayout(gridLayout);
		painelPrincipal.add(painelProdutos, BorderLayout.CENTER);		
		//
		tela.add(painelPrincipal);
		//
		JLabel carrinho = new JLabel("");
		carrinho.setIcon(new ImageIcon(CarrinhoBoundary.class.getResource("/resource/carrinho.png")));
		
		//
		JButton btnPedido = new JButton("Fechar pedido");
		btnPedido.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
		JPanel painelBotao = new JPanel();
		painelBotao.setLayout(new BorderLayout());
		painelBotao.add(valorTotal , BorderLayout.CENTER);
		painelBotao.add(btnPedido , BorderLayout.EAST);
		painelPrincipal.add(painelBotao, BorderLayout.SOUTH);
		
		JLabel lb1 = new JLabel("");
		JLabel lb2 = new JLabel("Item");
		JLabel lb3 = new JLabel("Preço");
		JLabel lb4 = new JLabel("Quantidade");
		JLabel lb5 = new JLabel("Subtotal");
		JLabel lb6 = new JLabel("");
		lb1.setHorizontalAlignment(JLabel.CENTER);
		lb2.setHorizontalAlignment(JLabel.CENTER);
		lb3.setHorizontalAlignment(JLabel.CENTER);
		lb4.setHorizontalAlignment(JLabel.CENTER);
		lb5.setHorizontalAlignment(JLabel.CENTER);
		lb1.setVerticalAlignment(JLabel.CENTER);
		lb2.setVerticalAlignment(JLabel.CENTER);
		lb3.setVerticalAlignment(JLabel.CENTER);
		lb4.setVerticalAlignment(JLabel.CENTER);
		lb5.setVerticalAlignment(JLabel.CENTER);
		lb1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lb5.setFont(new Font("Tahoma", Font.BOLD, 18));
		JPanel painelIndice = new JPanel();
		painelIndice.setLayout(new GridLayout(1, 7, 10, 10));
		painelIndice.add(carrinho);
		painelIndice.add(lb2);
		painelIndice.add(lb3);
		painelIndice.add(lb4);
		painelIndice.add(lb5);
		painelIndice.add(lb6);
		painelPrincipal.add(painelIndice, BorderLayout.NORTH);
		
		
		btnPedido.setForeground(Color.BLACK);
		btnPedido.setBackground(Color.WHITE);
		btnPedido.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPedido.setBorder(BorderFactory.createEmptyBorder());
		btnPedido.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		valorTotal.setForeground(Color.BLUE);
		valorTotal.setBackground(Color.WHITE);
		valorTotal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		valorTotal.setBorder(BorderFactory.createEmptyBorder());
		valorTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		tela.setForeground(Color.WHITE);
		tela.setBackground(Color.WHITE);
		
		painelPrincipal.setForeground(Color.WHITE);
		painelPrincipal.setBackground(Color.WHITE);
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder());
		
		painelProdutos.setForeground(Color.WHITE);
		painelProdutos.setBackground(Color.WHITE);
		painelProdutos.setBorder(BorderFactory.createEmptyBorder());
		
		painelIndice.setForeground(Color.WHITE);
		painelIndice.setBackground(Color.WHITE);
		painelIndice.setBorder(BorderFactory.createEmptyBorder());
		
		painelBotao.setForeground(Color.WHITE);
		painelBotao.setBackground(Color.WHITE);
		painelBotao.setBorder(BorderFactory.createEmptyBorder());
		
		painelPrincipal.add(bar, BorderLayout.CENTER);
		bar.setViewportView(painelProdutos);

		testeEv evteste = new testeEv(itensList, btnPedido);
		btnPedido.addActionListener(evteste);
		
	}
	
	public void adicionaItem(ItemCarrinhoEntity itemEntity){
		double total = 0;
		gridLayout.setRows(gridLayout.getRows() + 1);
		ItemCarrinhoBoundary item =
				new ItemCarrinhoBoundary(itemEntity, this.itensList, valorTotal);
		itensList.add(itemEntity);
		painelProdutos.add(item);
		
		EvBtnRmItemCarrinho evBtnRM =
				new EvBtnRmItemCarrinho(tela, item, painelProdutos, 
						itensList, itemEntity, bar, valorTotal);
		JButton btnTemp = item.getBtnRemover();
		btnTemp.addActionListener(evBtnRM);
	
		for (ItemCarrinhoEntity a : itensList){
			total += a.getSubTotal();
		}
		
		
		valorTotal.setText("Total: R$ " + total);
		bar.repaint();
		tela.repaint();
		//tela.setVisible(false);
		//tela.setVisible(true);
		
	}
	
	
}
