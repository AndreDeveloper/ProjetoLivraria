package edu.livraria.boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;

import edu.livraria.control.AuxiliarPesquisaController;
import edu.livraria.entity.Livro;

public class AuxiliarPesquisa implements MouseListener, KeyListener{
	private JLabel lblParam = new JLabel();
	private JTextField txtParam = new JTextField();
	private JTable tabela = new JTable();
	private JPanel painelPrincipal = new JPanel(new BorderLayout());
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel painelParam = new JPanel(new GridLayout(1, 1, 20, 20));
	private JDialog tela = new JDialog();
	private AuxiliarPesquisaController controller = new AuxiliarPesquisaController();
	private JTextField txtCampo;
	private String param;
	
	
	public AuxiliarPesquisa(JTextField txtCampo, String param) {
		super();
		this.txtCampo = txtCampo;
		this.param = param;
		
		montaTelaAutor();
	}



	public AuxiliarPesquisa() {
		super();
		montaTelaAutor();
	}



	public void montaTelaAutor(){
		tela.setModal(true);
		tela.toFront();
		lblParam.setText(param);
		painelParam.add(lblParam);
		painelParam.add(txtParam);
		
		tela.setForeground(Color.BLACK);
	   	tela.setBackground(Color.WHITE);
	   	tela.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		painelParam.setForeground(Color.BLACK);
	   	painelParam.setBackground(Color.WHITE);
	   	painelParam.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	painelParam.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		painelPrincipal.setForeground(Color.BLACK);
	   	painelPrincipal.setBackground(Color.WHITE);
	   	painelPrincipal.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	painelPrincipal.setBorder(BorderFactory.createEmptyBorder());	   	
	   	
		scrollPane.setForeground(Color.BLACK);
	   	scrollPane.setBackground(Color.WHITE);
	   	scrollPane.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	scrollPane.setBorder(BorderFactory.createEmptyBorder());
	   	
		txtParam.setToolTipText("digite aqui para pesquisar um autor");    	
	   	txtParam.setForeground(Color.BLACK);
	   	txtParam.setBackground(Color.WHITE);
	   	txtParam.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	txtParam.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	txtParam.addKeyListener(this);
	   	    	
	   	lblParam.setForeground(Color.BLACK);
	   	lblParam.setBackground(Color.WHITE);
	   	lblParam.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	lblParam.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	lblParam.setBorder(BorderFactory.createEmptyBorder());
	   	lblParam.setHorizontalAlignment(JLabel.RIGHT);
		
	   	tabela.setForeground(Color.BLACK);
	   	tabela.setBackground(Color.WHITE);
	   	tabela.setFont(new Font("Tahoma", Font.BOLD, 14));
	   	tabela.setCursor(new Cursor(Cursor.HAND_CURSOR));
	   	tabela.setBorder(BorderFactory.createEmptyBorder());
	   	tabela.setGridColor(Color.white);
	   	
	   	scrollPane.setViewportView(tabela);
		
		painelPrincipal.add(painelParam, BorderLayout.NORTH);
		painelPrincipal.add(scrollPane, BorderLayout.CENTER);
		
		tabela.addMouseListener(this);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableModel modelotabela = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "Nome"
				}
			);
		tabela.setModel(modelotabela);
		
		controller.preencheTabela(tabela, param);
		
		tela.setContentPane(painelPrincipal);
		tela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tela.setSize(800, 400);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Pesquisa rapida");
		tela.setResizable(false);
		tela.setVisible(true);
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int linha = tabela.getSelectedRow();
		long id =  (Long) tabela.getValueAt(linha, 0);
		String nome = (String) tabela.getValueAt(linha, 1);
		txtCampo.setText(id + " - " + nome);
		tela.dispose();
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		controller.preencheTabela(tabela, param,txtParam.getText());
		
	}
}
