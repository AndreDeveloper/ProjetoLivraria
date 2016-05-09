package edu.livraria.boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.livraria.entity.ItemCarrinho;

public class AuxQtdadeCarrinhoBoundary implements ActionListener, KeyListener{
	private JDialog tela = new JDialog();
	private JButton btnMais = new JButton("+");
	private JButton btnMenos = new JButton("-");
	private JButton btnOk = new JButton("OK");
	private JButton btnCancelar = new JButton("Cancelar");
	private JTextField txtValor = new JTextField(3);
	private JTextArea texto = new JTextArea(
			"Deseja realmente incluir esse item ao carrinho?\n"
			+ "se sim, escolha a quantidade e clique em 'ok'"
			);
	private ItemCarrinho carrinhoEntity;
	
	public AuxQtdadeCarrinhoBoundary(ItemCarrinho carrinhoEntity) {
		super();
		this.carrinhoEntity = carrinhoEntity;
	    acao();
	}

	public void acao() {
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(80);
		flowLayout.setAlignment(FlowLayout.CENTER);

		FlowLayout flowLayout1 = new FlowLayout();
		flowLayout1.setHgap(50);
		flowLayout1.setAlignment(FlowLayout.CENTER);
		
		JPanel painelPrincipal = new JPanel(new BorderLayout());
		painelPrincipal.setBackground(Color.white);
		painelPrincipal.setForeground(Color.blue);
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel painelSul = new JPanel(flowLayout);
		painelSul.setBackground(Color.white);
		painelSul.setForeground(Color.blue);
		painelSul.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel painelCentro = new JPanel(flowLayout1);
		painelCentro.setBackground(Color.white);
		painelCentro.setForeground(Color.blue);
		painelCentro.setBorder(BorderFactory.createEmptyBorder());
		
		painelCentro.add(btnMenos);
		painelCentro.add(txtValor);
		painelCentro.add(btnMais);
		
		painelSul.add(btnCancelar);
		painelSul.add(btnOk);
		
		painelPrincipal.add(texto, BorderLayout.NORTH);
		painelPrincipal.add(painelCentro, BorderLayout.CENTER);
		painelPrincipal.add(painelSul, BorderLayout.SOUTH);
		
		texto.setFont(new Font("Palatino Linotype", Font.PLAIN, 16));
		texto.setBackground(Color.white);
		texto.setForeground(Color.blue);
		texto.setBorder(BorderFactory.createEmptyBorder());
		texto.setEditable(false);

		txtValor.setFont(new Font("Palatino Linotype", Font.BOLD, 28));
		txtValor.setBackground(Color.white);
		txtValor.setForeground(Color.blue);
		txtValor.setBorder(BorderFactory.createEmptyBorder());
		txtValor.setText("1");
		txtValor.setHorizontalAlignment(JTextField.CENTER);
		txtValor.addKeyListener(this);
		
		

		btnMais.setFont(new Font("Palatino Linotype", Font.BOLD, 60));
		btnMais.setBackground(Color.white);
		btnMais.setForeground(Color.GREEN);
		btnMais.setBorder(BorderFactory.createEmptyBorder());
		btnMais.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMais.addActionListener(this);
		
		btnMenos.setFont(new Font("Palatino Linotype", Font.BOLD, 60));
		btnMenos.setBackground(Color.white);
		btnMenos.setForeground(Color.RED);
		btnMenos.setBorder(BorderFactory.createEmptyBorder());
		btnMenos.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMenos.addActionListener(this);
		
		btnOk.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		btnOk.setBackground(Color.white);
		btnOk.setForeground(Color.BLACK);
		btnOk.setBorder(BorderFactory.createEmptyBorder());
		btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnOk.addActionListener(this);
		
		btnCancelar.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		btnCancelar.setBackground(Color.white);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBorder(BorderFactory.createEmptyBorder());
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(this);
		
		tela.setModal(true);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setContentPane(painelPrincipal);
		tela.setSize(335, 200);
		tela.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
	}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnMais){
				int valor = Integer.parseInt(txtValor.getText()) + 1;
				txtValor.setText("" + valor);
			}else if (arg0.getSource() == btnMenos){
				if(Integer.parseInt(txtValor.getText()) > 1){ 
				int valor = Integer.parseInt(txtValor.getText()) - 1;
				txtValor.setText("" + valor);
				}
			}else if (arg0.getSource() == btnOk){
				carrinhoEntity.setQuantidade(
						Integer.parseInt(txtValor.getText())
						);
				tela.dispose();
			}else if (arg0.getSource() == btnCancelar){
				tela.dispose();
			}
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
			// TODO Auto-generated method stub
			String caracteres="0987654321";
			if(!caracteres.contains(arg0.getKeyChar()+"")){
				arg0.consume();
			}
		}
	
}
