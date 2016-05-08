package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import control.Observer;
import entity.ItemCarrinhoEntity;


public class TelaPrincipalBoundary implements ActionListener, Observer {
	private JFrame tela = new JFrame("Livraria Digital");
	private JPanel painelPrincipal = new JPanel();
	private BorderLayout borderLayout = new BorderLayout();
	private JPanel painelMenu = new JPanel(new GridLayout(1, 3, 3, 3));
	private JButton btnHome = new JButton("Home");
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnCrudLivro = new JButton("Getão de livros");
	private JButton btnEntrar = new JButton("Entrar");
	private JButton btnConsultar = new JButton("Consultar");
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnCarrinho = new JButton("");
	private JButton btnAdmin = new JButton ("Admin");
	private JButton btnLogout = new JButton ("Logout");
	
	private CadastroClienteBoundary formCadastroCliente = new CadastroClienteBoundary();
	private CarrinhoBoundary formCarrinho = new CarrinhoBoundary();
	private LivroBoundary formLivro = new LivroBoundary();
	private PesquisaBoundary formPesquisa = new PesquisaBoundary(formCarrinho, this);
	//private ConsultaClienteBoundary consultaCliente = new ConsultaClienteBoundary();
	private VisualizaAtualizaClienteBoundary VA = new VisualizaAtualizaClienteBoundary();
	
	
	public TelaPrincipalBoundary() {
		// adicionando os observers
		formCarrinho.addObserver(this);
		
		//
		painelPrincipal.setLayout(borderLayout);
		painelPrincipal.setForeground(Color.WHITE);
		painelPrincipal.setBackground(Color.WHITE);
		painelMenu.setBackground(Color.black);
		// criando e configurando componentes da coluna 1 do menu
		FlowLayout layoutColuna1 = new FlowLayout();
		layoutColuna1.setAlignment(FlowLayout.LEFT);
		JPanel coluna1 = new JPanel(layoutColuna1);
		coluna1.setForeground(Color.blue);
		coluna1.setBackground(Color.white);
		JLabel iconeLivro = new JLabel("");
		JLabel livraria = new JLabel("Livraria \nDigital");
		iconeLivro.setIcon(
				new ImageIcon(TelaPrincipalBoundary.class.getResource("/resource/livros.png"))
				);
		livraria.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		livraria.setForeground(Color.BLUE);
		livraria.setBackground(Color.WHITE);
		livraria.setHorizontalAlignment(JLabel.CENTER);
		livraria.setVerticalAlignment(JLabel.CENTER);
		coluna1.add(iconeLivro);
		coluna1.add(livraria);

		
		JLabel barra = new JLabel("    |    ");
		barra.setHorizontalAlignment(JLabel.CENTER);
		barra.setForeground(Color.GRAY);
		barra.setFont(new Font("Papyrus", Font.BOLD, 30));
		coluna1.add(barra);
		
		btnAdmin.setForeground(Color.BLACK);
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAdmin.setBorder(BorderFactory.createEmptyBorder());
		btnAdmin.setToolTipText("Entrar em modo administrador");
		btnAdmin.setFont(new Font("Papyrus", Font.BOLD, 18));
		btnAdmin.addActionListener(this);
		
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setBorder(BorderFactory.createEmptyBorder());
		btnLogout.setToolTipText("Entrar em modo administrador");
		btnLogout.setFont(new Font("Papyrus", Font.BOLD, 18));
		btnLogout.addActionListener(this);
		btnLogout.setVisible(false);
		
		coluna1.add(btnAdmin);
		coluna1.add(btnLogout);
		
		// criando a coluna 2 do menu
		FlowLayout layoutColuna2 = new FlowLayout();
		layoutColuna2.setAlignment(FlowLayout.CENTER);
		layoutColuna2.setHgap(20);
		layoutColuna2.setVgap(20);
		JPanel coluna2 = new JPanel(layoutColuna2);
		coluna2.setBackground(Color.WHITE);
		
		btnHome.setHorizontalAlignment(JLabel.CENTER);
		btnHome.setForeground(Color.BLUE);
		btnHome.setBackground(Color.WHITE);
		btnHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHome.setBorder(BorderFactory.createEmptyBorder());
		btnHome.setToolTipText("ir para tela principal");
		btnHome.setFont(new Font("Papyrus", Font.BOLD, 18));
		
		btnPesquisar.setHorizontalAlignment(JLabel.CENTER);
		btnPesquisar.setForeground(Color.BLUE);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorder(BorderFactory.createEmptyBorder());
		btnPesquisar.setToolTipText("ir para tela principal");
		btnPesquisar.setFont(new Font("Papyrus", Font.BOLD, 18));
		
		btnCrudLivro.setHorizontalAlignment(JLabel.CENTER);
		btnCrudLivro.setForeground(Color.BLUE);
		btnCrudLivro.setBackground(Color.WHITE);
		btnCrudLivro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCrudLivro.setBorder(BorderFactory.createEmptyBorder());
		btnCrudLivro.setToolTipText("ir para tela principal");
		btnCrudLivro.setFont(new Font("Papyrus", Font.BOLD, 18));
		btnCrudLivro.setVisible(false);

		
		coluna2.add(btnHome);
		coluna2.add(btnPesquisar);
		
		coluna2.add(btnCrudLivro);
		
		// criando coluna 3 do menu
		JPanel coluna3 = new JPanel(new GridLayout(1,2));
		coluna3.setBackground(Color.white);
		JPanel painelCadastrar = new JPanel(new GridLayout(2, 1));
		painelCadastrar.setBackground(Color.white);
		JPanel painelBotoes = new JPanel(new GridLayout(1, 2));
		painelBotoes.setBackground(Color.white);
		
		btnEntrar.setForeground(Color.BLUE);
		btnEntrar.setBackground(Color.WHITE);
		btnEntrar.setHorizontalAlignment(JButton.CENTER);
		btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnEntrar.setBorder(BorderFactory.createEmptyBorder());
		btnEntrar.setToolTipText("faça seu login");
		
		btnConsultar.setForeground(Color.BLUE);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConsultar.setBorder(BorderFactory.createEmptyBorder());
		btnConsultar.setToolTipText("Consulte os clientes cadastrados");
		btnConsultar.setVisible(false);
		
		
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCadastrar.setBorder(BorderFactory.createEmptyBorder());
		btnCadastrar.setToolTipText("Faça seu cadastro");
		
		JLabel iconeUser = new JLabel();
		iconeUser.setIcon(
				new ImageIcon(TelaPrincipalBoundary.class.getResource("/resource/login.png"))
				);
		iconeUser.setVerticalAlignment(JLabel.CENTER);
		iconeUser.setHorizontalAlignment(JLabel.CENTER);
		
		painelBotoes.add(btnEntrar);
		painelBotoes.add(btnConsultar);
		painelBotoes.add(btnCadastrar);
		
		
		painelCadastrar.add(iconeUser);
		painelCadastrar.add(painelBotoes);
		
		btnCarrinho.setForeground(Color.GREEN);
		btnCarrinho.setBackground(Color.WHITE);
		btnCarrinho.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCarrinho.setBorder(BorderFactory.createEmptyBorder());
		btnCarrinho.setToolTipText("Ir para carrinho de compras");
		btnCarrinho.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnCarrinho.setVerticalTextPosition(SwingConstants.TOP);
		btnCarrinho.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCarrinho.setIcon(
				new ImageIcon(TelaPrincipalBoundary.class.getResource("/resource/carrinho.png"))
				);
		
		coluna3.add(painelCadastrar);
		coluna3.add(btnCarrinho);
		// adicionando evento aos botoes
		btnCadastrar.addActionListener(this);
		btnCarrinho.addActionListener(this);
		btnCrudLivro.addActionListener(this);
		btnEntrar.addActionListener(this);
		btnHome.addActionListener(this);
		btnPesquisar.addActionListener(this);
		btnConsultar.addActionListener(this);
		// criando de fato a tela principal
		painelMenu.add(coluna1);
		painelMenu.add(coluna2);
		painelMenu.add(coluna3);
		painelPrincipal.add(painelMenu, BorderLayout.NORTH);
		
		painelPrincipal.setForeground(Color.BLUE);
		painelPrincipal.setBackground(Color.WHITE);
		
		tela.setForeground(Color.blue);
		tela.setBackground(Color.WHITE);
		tela.setContentPane(painelPrincipal);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tela.setSize(1100, 700);
		tela.setVisible(true);
	}
	
	public void selectTela(JPanel jpanel){
		painelPrincipal.removeAll();
		painelPrincipal.add(painelMenu, BorderLayout.NORTH);
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setViewportView(jpanel);
		jpanel.setBackground(Color.WHITE);
		painelPrincipal.add(scrollpane, BorderLayout.CENTER);
		
		tela.repaint();
		tela.invalidate();
		tela.revalidate();
		scrollpane.invalidate();
		scrollpane.revalidate();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCrudLivro){
			selectTela(formLivro.getTela());
		}else if(e.getSource() == btnPesquisar){
			selectTela(formPesquisa.getTela());
		}else if(e.getSource() == btnHome){
			
		}else if(e.getSource() == btnCarrinho){
			selectTela(formCarrinho.getTela());
		}else if(e.getSource() == btnCadastrar){
			selectTela(formCadastroCliente.getPanel());
		}else if(e.getSource() == btnEntrar){
			
		}else if (e.getSource() == btnConsultar){
			selectTela(VA.getPanel());
		}else if (e.getSource() == btnAdmin){
			AtivaModoADM();
		}else if (e.getSource() == btnLogout){
			FazLogout();
		}
	}
	public static void main(String[] args) {
		new TelaPrincipalBoundary();
	}

	@Override
	public void update(String noticia) {
		btnCarrinho.setText(noticia);
		if(btnCarrinho.getText().equals("0")){
			btnCarrinho.setText("");	
		}
	}

	@Override
	public void update(ItemCarrinhoEntity carrinhoEntity) {
		// TODO Auto-generated method stub
		formCarrinho.adicionaItem(carrinhoEntity);
	}
	public void AtivaModoADM(){
		btnConsultar.setVisible(true);
		btnHome.setVisible(false);
		btnCrudLivro.setVisible(true);
		btnEntrar.setVisible(false);
		btnPesquisar.setVisible(false);
		btnAdmin.setVisible(false);
		btnLogout.setVisible(true);
		
		
		
	}
	public void FazLogout(){
		
		btnConsultar.setVisible(false);
		btnHome.setVisible(true);
		btnCrudLivro.setVisible(false);
		btnEntrar.setVisible(true);
		btnPesquisar.setVisible(true);
		btnAdmin.setVisible(true);
		btnLogout.setVisible(false);
		
	}
	
}
