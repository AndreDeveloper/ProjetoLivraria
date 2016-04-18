package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import control.EvBtnMaisItemCarrinho;
import control.EvBtnMenosItemCarrinho;
import entity.AuxQtdadeEntity;
import entity.ItemCarrinhoEntity;
import entity.LivroEntity;

public class ItemCarrinhoBoundary extends JPanel{
	private static final long serialVersionUID = 1L;
	private ItemCarrinhoEntity itemEntity;
	private java.util.List<ItemCarrinhoEntity> itensList;
	private LivroEntity livro;
	private AuxQtdadeEntity quantidade;
	private double subTotal;
	JButton btnRemover = new JButton("");
	private JLabel valorTotal;
	
	public ItemCarrinhoBoundary(ItemCarrinhoEntity itemEntity,
			java.util.List<ItemCarrinhoEntity> itensList,
			JLabel valorTotal) {
		super();
		AuxQtdadeEntity aux = new AuxQtdadeEntity();
		aux.setQuantidade(itemEntity.getQuantidade());
		this.itemEntity = itemEntity;
		this.itensList = itensList;
		this.livro = itemEntity.getLivro();
		this.quantidade = aux;
		this.subTotal = itemEntity.getSubTotal();
		this.valorTotal = valorTotal;
		this.create();	
	}

	
	public ItemCarrinhoEntity getItemEntity() {
		return itemEntity;
	}


	public void setItemEntity(ItemCarrinhoEntity itemEntity) {
		this.itemEntity = itemEntity;
	}


	public JButton getBtnRemover(){
		return btnRemover;
	}
	
	public void create(){
		GridLayout gridLayout = new GridLayout(1, 6, 5, 5);
		this.setLayout(gridLayout);
		JLabel imagem = new JLabel("");
		imagem.setIcon(livro.getImagem());
		JTextArea nomeLivro = new JTextArea(livro.getTituloLivro());
		nomeLivro.setLineWrap(true);
		nomeLivro.setEditable(false);
		//JLabel nomeLivro = new JLabel(livro.getNome());
		JLabel preco = new JLabel("R$ " + livro.getPrecoVenda());
		JLabel lbSubTotal = new JLabel("R$ " + this.subTotal);
		JPanel painelQtdade = new JPanel();
		nomeLivro.setToolTipText(nomeLivro.getText());
		
		
		imagem.setHorizontalAlignment(JLabel.CENTER);
		preco.setHorizontalAlignment(JLabel.CENTER);
		lbSubTotal.setHorizontalAlignment(JLabel.CENTER);
		imagem.setVerticalAlignment(JLabel.CENTER);
		//nomeLivro.setVerticalAlignment(JLabel.CENTER);
		preco.setVerticalAlignment(JLabel.CENTER);
		lbSubTotal.setVerticalAlignment(JLabel.CENTER);
		
		painelQtdade.setLayout(new BorderLayout());
		JButton btnMais = new JButton("+");
		JButton btnMenos = new JButton("-");
		JLabel labelQdade = new JLabel("" + this.quantidade.getQuantidade());
		labelQdade.setHorizontalAlignment(JLabel.CENTER);
		labelQdade.setVerticalAlignment(JLabel.CENTER);
		
		painelQtdade.add(labelQdade, BorderLayout.CENTER);
		painelQtdade.add(btnMenos, BorderLayout.WEST);
		painelQtdade.add(btnMais, BorderLayout.EAST);
		
		nomeLivro.setPreferredSize(new Dimension(10, 30));

		
		//
	//	Dimension d = new Dimension(50, 50);
	//	btnRemover.setPreferredSize(d);
	//	JPanel painelbtn = new JPanel();
	//	painelbtn.add(btnRemover);
		
		btnRemover.setForeground(Color.RED);
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRemover.setBorder(BorderFactory.createEmptyBorder());
		btnRemover.setIcon(new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/trash.png")));
		
		
		btnMais.setForeground(Color.GREEN);
		btnMais.setBackground(Color.WHITE);
		btnMais.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMais.setBorder(BorderFactory.createEmptyBorder());
		
		btnMenos.setForeground(Color.BLUE);
		btnMenos.setBackground(Color.WHITE);
		btnMenos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMenos.setBorder(BorderFactory.createEmptyBorder());
		
		this.setForeground(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createEmptyBorder());
		
		painelQtdade.setForeground(Color.WHITE);
		painelQtdade.setBackground(Color.WHITE);
		painelQtdade.setBorder(BorderFactory.createEmptyBorder());
		
		//painelbtn.setForeground(Color.WHITE);
		//painelbtn.setBackground(Color.WHITE);
		//painelbtn.setBorder(BorderFactory.createEmptyBorder());
		
		btnMais.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnMenos.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnRemover.setToolTipText("Remover item");
		btnMais.setToolTipText("Adicionar");
		btnMenos.setToolTipText("Remover");
		
		//		
		this.add(imagem);
		this.add(nomeLivro);
		this.add(preco);
		this.add(painelQtdade);
		this.add(lbSubTotal);
		//this.add(painelbtn);
		this.add(btnRemover);
		
		
		
		this.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		EvBtnMaisItemCarrinho evBtnMais =
				new EvBtnMaisItemCarrinho(itemEntity, itensList, btnMais,
						labelQdade, lbSubTotal, valorTotal);
		btnMais.addActionListener(evBtnMais);
        
		EvBtnMenosItemCarrinho evBtnMenos =
				new EvBtnMenosItemCarrinho(itemEntity, itensList, btnMenos,
						labelQdade, lbSubTotal, valorTotal);
		btnMenos.addActionListener(evBtnMenos);
	}
	
	
}