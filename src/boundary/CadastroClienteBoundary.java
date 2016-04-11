package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PageAttributes;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.mysql.fabric.xmlrpc.base.Array;
import com.sun.corba.se.spi.orbutil.fsm.Action;

import control.EvBtnClienteConcluirCad;

import control.evBuscaCEP;

import entity.EnderecoEntity;



public class CadastroClienteBoundary {
	JLabel lblNome, lblCPF, lblRg, lblCep, lblLogradouro, lblNumero, lblComplemento, lblBairro, lblUf, lblCidade, lblEmail, lblTelefone, lblCelular;
	JTextField nome;
	JTextField cpf;
	JTextField rg;
	JTextField cep;
	JTextField complemento;
	JTextField logradouro;
	JTextField bairro;
	JTextField uf;
	JTextField cidade;
	JTextField email;
	JTextField telefone;
	JTextField celular;
	JTextField numero;
	JPasswordField senha;
	JComboBox cbSexo;
	String sexo;
	
	
	
	public CadastroClienteBoundary() {
		// TODO Auto-generated constructor stub
	JFrame janela = new JFrame("Cadastro de Cliente");
	JPanel panel = new JPanel(new BorderLayout());
	
		
	panel.add(Norte(), BorderLayout.NORTH);
	panel.add(Centro(),BorderLayout.CENTER);
	panel.add(Sul(),BorderLayout.SOUTH);
	//panel.add(Esquerdo(), BorderLayout.WEST);
	
	
	
	janela.setContentPane(panel);
	
	
	
	janela.setVisible(true);
	janela.setSize(1000, 600);
	janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
	public JComponent Norte (){
		JPanel panelNorte = new JPanel(new BorderLayout());
		panelNorte.setBackground(Color.WHITE);
		JLabel lblTitulo = new JLabel("Identificação - Faça seu cadastro");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JLabel lblLogin = new JLabel("Já tem cadastro? Faça o login");
		
		panelNorte.add(lblLogin,BorderLayout.EAST);
		panelNorte.add(lblTitulo,BorderLayout.CENTER);
		
		
		return panelNorte;
	
	}
	public JComponent Centro(){
		JPanel panelCentro = new JPanel(new GridLayout(15,1,10,10));
		
		
		
		panelCentro.setBackground(Color.WHITE);
		
		
		lblNome = new JLabel("*Nome Completo: ");
		panelCentro.add(lblNome);
		nome = new JTextField(30);
		
		panelCentro.add(nome);
		
		lblCPF = new JLabel("*CPF: ");
		panelCentro.add(lblCPF);
		
		cpf = new JTextField();
		cpf.setPreferredSize(new Dimension(5,2));
//		cpf.setMinimumSize(new Dimension(1,2));
		panelCentro.add(cpf);
		
		lblRg = new JLabel("*RG: ");
		panelCentro.add(lblRg);
		rg = new JTextField(10);
		panelCentro.add(rg);
		
		lblCep = new JLabel("*CEP: ");
		panelCentro.add(lblCep);
		cep = new JTextField(10);
		panelCentro.add(cep);
		
		evBuscaCEP buscacep = new evBuscaCEP();
		
		FocusListener focoCep = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
				
				List<EnderecoEntity> end = new ArrayList<EnderecoEntity>();
				end = buscacep.buscaPorCep(cep.getText());
				for(EnderecoEntity endereco: end){
					
					
					bairro.setText(endereco.getBairro());

					
					uf.setText(endereco.getUf());
					
					cidade.setText(endereco.getCidade());
					logradouro.setText(endereco.getLogradouro());
					
				}
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		};
		cep.addFocusListener(focoCep);
		
		
		
		
		
		
		
		lblLogradouro = new JLabel("*Logradouro: ");
		panelCentro.add(lblLogradouro);
		logradouro = new JTextField(30);
		panelCentro.add(logradouro);
		
		lblNumero = new JLabel("*Número: ");
		panelCentro.add(lblNumero);
		numero = new JTextField(30);
		panelCentro.add(numero);
	
		lblComplemento = new JLabel("*Complemento: ");
		panelCentro.add(lblComplemento);
		complemento = new JTextField(30);
		panelCentro.add(complemento);
		

		lblBairro = new JLabel("*Bairro: ");
		panelCentro.add(lblBairro);
		bairro = new JTextField(30);
		
		panelCentro.add(bairro);
		
		lblUf = new JLabel("*UF");
		panelCentro.add(lblUf);
		uf = new JTextField(2);
		panelCentro.add(uf);
		
		lblCidade = new JLabel("*Cidade: ");
		panelCentro.add(lblCidade);
		cidade = new JTextField(30);
		panelCentro.add(cidade);
		
		
<<<<<<< HEAD
		final evComboboxCidade comboCidade= new evComboboxCidade (cbCidade);

		comboCidade.listaCidade(cbUf.getSelectedIndex()+1);
=======
>>>>>>> cc137189a0891539ccf2819a18b7dd17ec7f6a29
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblSexo = new JLabel("*Sexo");
		panelCentro.add(lblSexo);
		cbSexo = new JComboBox();
		Vector Sexo = new Vector();
		Sexo.add("");
		Sexo.add("Masculino");
		Sexo.add("Feminino");
		Sexo.add("Não informado");
		for (int i=0;i<Sexo.size();i++){
			cbSexo.addItem(Sexo.get(i));
			
		}
			
		panelCentro.add(cbSexo);
		
		ActionListener recebeSexo = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				sexo =(String) cbSexo.getSelectedItem();
				
				
			}
		};
		cbSexo.addActionListener(recebeSexo);
		
		
		lblEmail = new JLabel("*Email: ");
		panelCentro.add(lblEmail);
		email = new JTextField(30);
		panelCentro.add(email);
		

		JLabel lblSenha = new JLabel("Senha: ");
		panelCentro.add(lblSenha);
		senha = new JPasswordField();
		panelCentro.add(senha);
		
		lblTelefone = new JLabel("*Telefone: ");
		panelCentro.add(lblTelefone);
		telefone = new JTextField(10);
		panelCentro.add(telefone);
		
		JLabel lblCelular = new JLabel("*Celular: ");
		panelCentro.add(lblCelular);
		celular = new JTextField(10);
		panelCentro.add(celular);
		
	

		

		
		
		return panelCentro;
	}
	
	public JComponent Esquerdo(){
		
		JPanel panelEsquerdo = new JPanel(new FlowLayout());
		panelEsquerdo.setBackground(Color.WHITE);
		JLabel myAcc = new JLabel("Minha Conta");
		
		panelEsquerdo.add(myAcc);
		
		
		
		
		return panelEsquerdo; 
	}
	
	public JComponent Sul (){
		JPanel PanelSul = new JPanel();
		PanelSul.setBackground(Color.WHITE);
		PanelSul.setLayout(new BorderLayout());
		
		JButton btnCadastrar = new JButton("Concluir Cadastro");
		PanelSul.add(btnCadastrar, BorderLayout.EAST);
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.setForeground(Color.WHITE);

	EvBtnClienteConcluirCad btnCadController = 
			new EvBtnClienteConcluirCad(nome, cpf, rg, cep, complemento, logradouro, bairro, uf, cidade, email, telefone, celular, numero, senha, btnCadastrar, cbSexo, sexo);
					
					
	btnCadastrar.addActionListener(btnCadController);
	
		
		return PanelSul;
	}
	
	
	
	
	
	
	
	
	//public static void main(String[] args) {
		
		//new CadastroClienteBoundary();
	//}
	

}
