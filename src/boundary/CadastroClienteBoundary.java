package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PageAttributes;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import control.EvBtnClienteConcluirCad;
import control.evComboboxCidade;
import control.evComboboxUF;
import entity.CidadeEntity;
import entity.EnderecoEntity;
import entity.UfEntity;


public class CadastroClienteBoundary {
	JLabel lblNome, lblCPF, lblRg, lblCep, lblLogradouro, lblNumero, lblComplemento, lblBairro, lblUf, lblCidade, lblEmail, lblTelefone, lblCelular;
	JTextField nome;
	JTextField cpf;
	JTextField rg;
	JTextField cep;
	JTextField logradouro;
	JTextField numero;
	JTextField complemento;
	JTextField bairro;
	JComboBox <UfEntity>cbUf;
	JComboBox <CidadeEntity>cbCidade;
	JTextField email;
	JTextField telefone;
	JTextField celular;
	String ufSelecionado;
	
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
		JPanel panelCentro = new JPanel(new GridLayout(14,1,10,10));
		
		panelCentro.setBackground(Color.WHITE);
		
		
		lblNome = new JLabel("*Nome Completo: ");
		panelCentro.add(lblNome);
		nome = new JTextField(30);
		panelCentro.add(nome);
		
		lblCPF = new JLabel("*CPF: ");
		panelCentro.add(lblCPF);
		cpf = new JTextField(10);
		panelCentro.add(cpf);
		
		lblRg = new JLabel("*RG: ");
		panelCentro.add(lblRg);
		rg = new JTextField(10);
		panelCentro.add(rg);
		
		lblCep = new JLabel("*CEP: ");
		panelCentro.add(lblCep);
		cep = new JTextField(10);
		panelCentro.add(cep);
		
		
		
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
		cbUf = new JComboBox<UfEntity>();
		
		evComboboxUF comboUf = new evComboboxUF(cbUf);
		
		comboUf.listaUF();
		cbUf.setSelectedIndex(25);
		panelCentro.add(cbUf);
		
		
		lblCidade = new JLabel("*Cidade: ");
		panelCentro.add(lblCidade);
		cbCidade = new JComboBox<CidadeEntity>();
		
		final evComboboxCidade comboCidade= new evComboboxCidade (cbCidade);

		comboCidade.listaCidade(cbUf.getSelectedIndex()+1);
		
		cbCidade.setSelectedIndex(564);
		
		ActionListener comboboxUfcidade = new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//String ufSelecionado = ;
				int ufSelecionado = cbUf.getSelectedIndex()+1;
				comboCidade.listaCidade(ufSelecionado);
				
				
			}
		};
		cbUf.addActionListener(comboboxUfcidade);
		
		ActionListener comboCity = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(cbCidade.getSelectedIndex()+1);
				
			}
		};
		
		cbCidade.addActionListener(comboCity);
		
		
		panelCentro.add(cbCidade);
		
		
		
		
		
		JLabel lblSexo = new JLabel("*Sexo");
		panelCentro.add(lblSexo);
		JComboBox cbSexo = new JComboBox();
		Vector Sexo = new Vector();
		Sexo.add("");
		Sexo.add("Masculino");
		Sexo.add("Feminino");
		Sexo.add("Não informado");
		for (int i=0;i<Sexo.size();i++){
			cbSexo.addItem(Sexo.get(i));
			
		}
		
		
		
		
		panelCentro.add(cbSexo);
		
		lblEmail = new JLabel("*Email: ");
		panelCentro.add(lblEmail);
		email = new JTextField(30);
		panelCentro.add(email);
		
		
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
//	
//	EvBtnClienteConcluirCad btnCadController = 
//			new EvBtnClienteConcluirCad(nome, cpf, rg, cep,
//					logradouro, numero, complemento,
//					bairro, cbUf, cidade, email, 
//					telefone, celular, btnCadastrar);
//					
//					
//	btnCadastrar.addActionListener(btnCadController);
//	
		
		return PanelSul;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new CadastroClienteBoundary();
	}
	

}
