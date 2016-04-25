package boundary;

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

import entity.ItemCarrinhoEntity;
import entity.LivroEntity;

public class ItemPesquisaBoundary extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private LivroEntity livro;
	private CarrinhoBoundary carrinhoBoundary;
	private JButton btnImagem = new JButton("");
	private JButton btnAddCarrinho = new JButton("");
	private TelaPrincipalBoundary telaPrincipalBoundary;
	
	public ItemPesquisaBoundary(LivroEntity livro,
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
		JLabel lbAutor = new JLabel(livro.getNomeAutor());
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
		
		btnAddCarrinho.setIcon(
				new ImageIcon(ItemCarrinhoBoundary.class.getResource("/resource/adicionarCarrinho.png")));
		btnAddCarrinho.setForeground(Color.RED);
		btnAddCarrinho.setBackground(Color.WHITE);
		btnAddCarrinho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddCarrinho.setBorder(BorderFactory.createEmptyBorder());
		btnAddCarrinho.setToolTipText("Adicionar item ao carrinho de compras");
		btnAddCarrinho.addActionListener(this);
		
		
		lbAutor.setHorizontalAlignment(JLabel.CENTER);
		lbAutor.setVerticalAlignment(JLabel.CENTER);
		lbAutor.setForeground(Color.BLUE);
		lbAutor.setBackground(Color.WHITE);
		lbAutor.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		
		lbTitulo.setForeground(Color.BLUE);
		lbTitulo.setBackground(Color.WHITE);
		lbTitulo.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		
		lbPreco.setHorizontalAlignment(JLabel.CENTER);
		lbPreco.setVerticalAlignment(JLabel.CENTER);
		lbPreco.setForeground(Color.BLUE);
		lbPreco.setBackground(Color.WHITE);
		lbPreco.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		
		this.setLayout(gridlayout);
		this.add(btnImagem);
		this.add(jScrollPane);
		this.add(lbAutor);
		this.add(lbPreco);
		this.add(btnAddCarrinho);
		
		this.setForeground(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == btnAddCarrinho){
			ItemCarrinhoEntity carrinhoEntity = new ItemCarrinhoEntity();
			new AuxQtdadeCarrinhoBoundary(carrinhoEntity);
			if (carrinhoEntity.getQuantidade() != 0){
				carrinhoEntity.setLivro(livro);
				carrinhoEntity.setImagem(livro.getImagem());
				carrinhoBoundary.adicionaItem(carrinhoEntity);
			}
			
		}else if(arg0.getSource() == btnImagem){
			InfoLivroBoundary resultado = new InfoLivroBoundary(livro);
			telaPrincipalBoundary.selectTela(resultado.getPainelPrincipal());
			
		}
	}
	
	
	
	
}
