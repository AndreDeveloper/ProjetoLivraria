package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ClientInfoStatus;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import control.ClienteController;

import entity.ClienteEntity;
import entity.EnderecoEntity;

public class VisualizaAtualizaClienteBoundary implements ActionListener {

	private JLabel lblCodCliente;
	private JTextField nome;
	private JFormattedTextField cpf;
	private JFormattedTextField rg;
	private JFormattedTextField cep;
	private JTextField complemento;
	private JTextField logradouro;
	private JTextField bairro;
	private JTextField uf;
	private JTextField cidade;
	private JTextField email;
	private JFormattedTextField telefone;
	private JFormattedTextField celular;
	private JTextField numero;
	private JPasswordField senha;
	private JTextField sexo;
	private JPanel panel = new JPanel(new BorderLayout());
	private JButton btnAlterarDados;
	private JButton btnAtualizar;
	private JButton btnVoltar;
	private ConsultaClienteBoundary consultaCliente;
	private JDialog dialogVA = new JDialog();
	private JButton btnConsultaCliente;
	private JLabel exibeDataCadastro;
	private int id;

	public JPanel getPanel() {

		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public VisualizaAtualizaClienteBoundary() {

		panel.add(Norte(), BorderLayout.NORTH);
		panel.add(Centro(), BorderLayout.CENTER);
		panel.add(Botoes(), BorderLayout.SOUTH);

		padraoVisualizaAtualiza();

	}

	

	public void popula(ClienteEntity clt) {

		lblCodCliente.setText("" + clt.getCodCliente());
		nome.setText(clt.getNome());
		cpf.setText(clt.getCpf());
		rg.setText(clt.getRg());
		cep.setText(clt.getCep());
		logradouro.setText(clt.getLogradouro());
		numero.setText("" + clt.getNumero());
		complemento.setText(clt.getComplemento());
		bairro.setText(clt.getBairro());
		uf.setText(clt.getUf());
		cidade.setText(clt.getCidade());
		sexo.setText(clt.getSexo());
		email.setText(clt.getEmail());
		senha.setText(clt.getSenha());
		telefone.setText(clt.getTelefone());
		celular.setText(clt.getCelular());
		exibeDataCadastro.setText(clt.getDtCadastro());

	}

	public JComponent Norte() {
		JPanel panelNorte = new JPanel(new BorderLayout());
		panelNorte.setBackground(Color.WHITE);
		JLabel lblTitulo = new JLabel("Atualização Cadastral");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JLabel obrigatorio = new JLabel("Os campos com * são obrigatórios");
		obrigatorio.setForeground(Color.red);
		obrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));

		panelNorte.add(obrigatorio, BorderLayout.SOUTH);

		panelNorte.add(lblTitulo, BorderLayout.WEST);

		btnConsultaCliente = new JButton("Consultar Cliente");
		btnConsultaCliente
				.setIcon(new ImageIcon(VisualizaAtualizaClienteBoundary.class.getResource("/resource/search.png")));
		btnConsultaCliente.setBackground(Color.WHITE);
		btnConsultaCliente.setForeground(Color.BLUE);
		btnConsultaCliente.setBorder(null);
		btnConsultaCliente.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnConsultaCliente.addActionListener(this);
		panelNorte.add(btnConsultaCliente, BorderLayout.EAST);

		return panelNorte;

	}

	public JComponent Centro() {

		JPanel panelCentro = new JPanel(new GridLayout(17, 2, 10, 10));
		
		panelCentro.setBackground(Color.WHITE);
		panelCentro.add(new JLabel ("Data de Cadastro: "));
		exibeDataCadastro = new JLabel("");
		panelCentro.add(exibeDataCadastro);
		
		panelCentro.add(new JLabel("Código Cliente: "));
		lblCodCliente = new JLabel("");
		panelCentro.add(lblCodCliente);

		panelCentro.add(new JLabel("*Nome Completo: "));
		nome = new JTextField();
		panelCentro.add(nome);

		panelCentro.add(new JLabel("*CPF: "));
		cpf = new JFormattedTextField();
		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.install(cpf);
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		cpf.setPreferredSize(new Dimension(5, 2));

		panelCentro.add(cpf);

		panelCentro.add(new JLabel("*RG: "));
		rg = new JFormattedTextField();
		try {
			MaskFormatter maskRg = new MaskFormatter("##.###.###-#");
			maskRg.install(rg);
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		panelCentro.add(rg);

		panelCentro.add(new JLabel("*CEP: "));
		cep = new JFormattedTextField();
		try {
			MaskFormatter maskCep = new MaskFormatter("#####-###");
			maskCep.install(cep);

		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		panelCentro.add(cep);

		FocusListener focoCep = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (validaCEP() == true) {
					ValidaCepRetorno();
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		};
		cep.addFocusListener(focoCep);

		panelCentro.add(new JLabel("*Logradouro: "));
		logradouro = new JTextField(30);
		logradouro.setEditable(false);
		panelCentro.add(logradouro);

		panelCentro.add(new JLabel("*Número: "));
		numero = new JTextField(30);
		panelCentro.add(numero);

		panelCentro.add(new JLabel("Complemento: "));
		complemento = new JTextField(30);
		panelCentro.add(complemento);

		panelCentro.add(new JLabel("*Bairro: "));
		bairro = new JTextField(30);
		bairro.setEditable(false);
		panelCentro.add(bairro);

		panelCentro.add(new JLabel("*UF"));
		uf = new JTextField(2);
		uf.setEditable(false);
		panelCentro.add(uf);

		panelCentro.add(new JLabel("*Cidade: "));
		cidade = new JTextField(30);
		cidade.setEditable(false);
		panelCentro.add(cidade);

		panelCentro.add(new JLabel("*E-mail (Será usado para Login): "));
		email = new JTextField(30);
		panelCentro.add(email);

		panelCentro.add(new JLabel("*Sexo"));
		sexo = new JTextField();
		panelCentro.add(sexo);

		panelCentro.add(new JLabel("*Senha: "));
		senha = new JPasswordField();
		panelCentro.add(senha);

		panelCentro.add(new JLabel("*Telefone: "));
		telefone = new JFormattedTextField();
		MaskFormatter maskTel;
		try {
			maskTel = new MaskFormatter("(##) ####-####");
			maskTel.install(telefone);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		panelCentro.add(telefone);

		panelCentro.add(new JLabel("*Celular: "));
		celular = new JFormattedTextField();
		try {
			MaskFormatter maskCel = new MaskFormatter("(##) #####-####");
			maskCel.install(celular);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		panelCentro.add(celular);

		return panelCentro;
	}

	public JComponent Botoes() {
		JPanel PanelSul = new JPanel();
		PanelSul.setBackground(Color.WHITE);
		PanelSul.setLayout(new BorderLayout());

		btnAtualizar = new JButton("Atualizar");
		PanelSul.add(btnAtualizar, BorderLayout.EAST);
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setForeground(Color.BLUE);
		btnAtualizar.setIcon(new ImageIcon(VisualizaAtualizaClienteBoundary.class.getResource("/resource/update.png")));
		btnAtualizar.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		btnAtualizar.setBorder(null);
		btnAtualizar.setEnabled(false);
		btnAtualizar.addActionListener(this);

		btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setBackground(Color.WHITE);
		btnAlterarDados.setForeground(Color.BLUE);
		btnAlterarDados.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		btnAlterarDados.setBorder(null);
		btnAlterarDados
				.setIcon(new ImageIcon(VisualizaAtualizaClienteBoundary.class.getResource("/resource/edit.png")));
		btnAlterarDados.setEnabled(false);
		PanelSul.add(btnAlterarDados, BorderLayout.CENTER);
		btnAlterarDados.addActionListener(this);

		return PanelSul;
	}

	public void AlterarDados() {
		nome.setEditable(true);

		cep.setEditable(true);
		numero.setEditable(true);
		complemento.setEditable(true);
		email.setEditable(true);
		senha.setEditable(true);
		telefone.setEditable(true);
		celular.setEditable(true);

	}

	public void ValidaCepRetorno() {
		ClienteController buscacep = new ClienteController();
		List<EnderecoEntity> end = new ArrayList<EnderecoEntity>();
		end = buscacep.buscaPorCep(cep.getText().replace("-", ""));

		if (end == null) {

			logradouro.setEditable(true);
			bairro.setEditable(true);
			cidade.setEditable(true);
			uf.setEditable(true);
			logradouro.setText("");
			bairro.setText("");
			cidade.setText("");
			uf.setText("");

		} else {

			for (EnderecoEntity endereco : end) {

				bairro.setText(endereco.getBairro());

				uf.setText(endereco.getUf());

				cidade.setText(endereco.getCidade());
				logradouro.setText(endereco.getLogradouro());
			}
		}
	}

	@SuppressWarnings("deprecation")
	public ClienteEntity EventoAtualizaCadastro() {

		ClienteEntity clt = new ClienteEntity();
		clt.setCodCliente(Integer.parseInt(lblCodCliente.getText()));
		clt.setNome(nome.getText());

		clt.setCpf(cpf.getText());
		clt.setSexo(sexo.getText());
		clt.setRg(rg.getText().replace("-", "").replace(".", ""));
		clt.setCep(cep.getText().replace("-", ""));
		clt.setLogradouro(logradouro.getText());
		clt.setNumero(numero.getText());
		clt.setComplemento(complemento.getText());
		clt.setBairro(bairro.getText());
		clt.setUf(uf.getText());
		clt.setCidade(cidade.getText());
		clt.setEmail(email.getText());
		clt.setTelefone(telefone.getText());
		clt.setCelular(celular.getText());
		clt.setSenha(senha.getText());

		return clt;

	}

	public void padraoVisualizaAtualiza() {
		lblCodCliente.setText("");
		exibeDataCadastro.setText("");
		nome.setEditable(false);
		nome.setText("");
		cpf.setEditable(false);
		cpf.setText("");
		rg.setEditable(false);
		rg.setText("");
		cep.setEditable(false);
		cep.setText("");
		logradouro.setEditable(false);
		logradouro.setText("");
		numero.setEditable(false);
		numero.setText("");
		complemento.setEditable(false);
		complemento.setText("");
		bairro.setEditable(false);
		bairro.setText("");
		uf.setEditable(false);
		uf.setText("");
		cidade.setEditable(false);
		cidade.setText("");
		sexo.setEditable(false);
		sexo.setText("");
		email.setEditable(false);
		email.setText("");
		senha.setEditable(false);
		senha.setText("");
		telefone.setEditable(false);
		telefone.setText("");
		celular.setEditable(false);
		celular.setText("");
		btnAtualizar.setEnabled(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnConsultaCliente) {

			consultaCliente = new ConsultaClienteBoundary();
			popula(consultaCliente.getDadosCliente());
			;
			btnAlterarDados.setEnabled(true);
		} else

		if (e.getSource() == btnAlterarDados) {

			AlterarDados();
			btnAlterarDados.setEnabled(false);
			btnAtualizar.setEnabled(true);

		} else if (e.getSource() == btnAtualizar) {

			if (ValidaCampos()) {
				ClienteController cc = new ClienteController();

				cc.AtualizaCliente(EventoAtualizaCadastro());
				padraoVisualizaAtualiza();
			}

		}

	}

	public boolean validaCEP() {
		if (cep.getText().replace("-", "").replace(" ", "").length() <= 0) {
			JOptionPane.showMessageDialog(null, "O CEP deve ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			cep.requestFocus();
			return false;
		} else {

			return true;
		}

	}

	public boolean ValidaCampos() {

		if (nome.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Nome completo deve ser informado", "Atençao",
					JOptionPane.WARNING_MESSAGE);
			nome.requestFocus();
			return false;
		} else if (cpf.getText().replace(" ", "").length() <= 3) {

			cpf.requestFocus();
			JOptionPane.showMessageDialog(null, "O CPF deve ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (rg.getText().replace("-", "").replace(".", "").replace(" ", "").length() <= 0) {
			rg.requestFocus();
			JOptionPane.showMessageDialog(null, "O RG deve ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (logradouro.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Logradouro deve ser informado", "Atençao",
					JOptionPane.WARNING_MESSAGE);
			logradouro.requestFocus();
			return false;
		} else if (numero.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Numero deve ser informado, caso ao contrario informe S/N", "Atençao",
					JOptionPane.WARNING_MESSAGE);
			numero.requestFocus();
			return false;
		} else if (bairro.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O Bairro ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			bairro.requestFocus();
			return false;
		} else if (uf.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "A UF deve ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			uf.requestFocus();
			return false;
		} else if (cidade.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "A Cidade deve ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			cidade.requestFocus();
			return false;
		} else if (!email.getText().contains("@")) {

			JOptionPane.showMessageDialog(null, "Digite um e-mail valido", "Atençao", JOptionPane.WARNING_MESSAGE);

			return false;
		} else if (email.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "O E-mail deve ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			email.requestFocus();
			return false;
		} else if (senha.getText().length() <= 0) {
			JOptionPane.showMessageDialog(null, "A senha deve ser informado", "Atençao", JOptionPane.WARNING_MESSAGE);
			senha.requestFocus();
			return false;
		} else if (telefone.getText().replace("-", "").replace("(", "").replace(")", "").replace(" ", "").length() <= 0
				|| telefone.getText().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")
						.length() < 10) {
			JOptionPane.showMessageDialog(null, "O Telefone deve ser informado com DDD e os 8 Digitos", "Atençao",
					JOptionPane.WARNING_MESSAGE);
			telefone.requestFocus();
			return false;
		} else if (celular.getText().replace("-", "").replace("(", "").replace(")", "").replace(" ", "").length() <= 0
				|| celular.getText().replace("-", "").replace("(", "").replace(")", "").replace(" ", "")
						.length() < 11) {
			JOptionPane.showMessageDialog(null, "O Celular deve ser informado com DDD e os 9 Digitos", "Atençao",
					JOptionPane.WARNING_MESSAGE);
			celular.requestFocus();
			return false;
		} else {
			return true;
		}

	}

}