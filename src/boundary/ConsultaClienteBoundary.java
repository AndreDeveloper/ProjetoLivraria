package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import control.ClienteController;
import entity.ClienteEntity;

public class ConsultaClienteBoundary implements ActionListener, MouseListener {
	JFrame janela = new JFrame("Consulta de Clientes");
	private JTable tblCliente;

	private JButton btnPesquisar;
	private JFormattedTextField pesquisaCpf;
	private JTextField pesquisaNome;
	private JPanel panelPrincipal = new JPanel(new BorderLayout());
	private int id;

	private JComboBox<Object> tipoPesquisa;
	private int SelecaoTipo;
	private JDialog consultaCltDialog = new JDialog();

	public ConsultaClienteBoundary() {

		panelPrincipal.add(Centro(), BorderLayout.CENTER);

		consultaCltDialog.setModal(true);
		consultaCltDialog.setLocationRelativeTo(null);
		consultaCltDialog.setResizable(false);
		consultaCltDialog.setContentPane(panelPrincipal);
		consultaCltDialog.setSize(1020, 600);
		consultaCltDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		consultaCltDialog.setLocationRelativeTo(null);
		consultaCltDialog.setVisible(true);

	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JComponent Centro() {
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(null);
		panelCentro.setBackground(Color.WHITE);

		JScrollPane SPTblConsultaClt = new JScrollPane();
		SPTblConsultaClt.setBounds(10, 97, 998, 408);
		panelCentro.add(SPTblConsultaClt);

		tblCliente = new JTable();
		tblCliente.setFont(new Font("Palatino Linotype", Font.PLAIN, 16));
		tblCliente.setBorder(null);

		@SuppressWarnings("unused")
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "CPF", "Cidade", "E-mail" });
		SPTblConsultaClt.setViewportView(tblCliente);
		tblCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tblCliente.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "CPF", "Cidade", "E-mail" }) {

					/**
					* 
					*/
					private static final long serialVersionUID = 1L;
					boolean[] canEdit = new boolean[] { false, false, false, false, false };

					@Override
					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				}

		);
		tblCliente.setBackground(Color.WHITE);

		tblCliente.getColumnModel().getColumn(0).setPreferredWidth(34);
		tblCliente.getColumnModel().getColumn(1).setPreferredWidth(352);
		tblCliente.getColumnModel().getColumn(2).setPreferredWidth(89);
		tblCliente.getColumnModel().getColumn(3).setPreferredWidth(112);
		tblCliente.getColumnModel().getColumn(4).setPreferredWidth(225);
		tblCliente.revalidate();
		tblCliente.addMouseListener(this);
		JLabel lblMsg = new JLabel("Selecione um cliente na lista para Visualizar ou Atualizar os dados");
		lblMsg.setBounds(442, 650, 433, 20);
		panelCentro.add(lblMsg);

		JLabel lblConsultaDeClientes = new JLabel("Consulta de Clientes");
		lblConsultaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblConsultaDeClientes.setBounds(242, 11, 257, 30);
		panelCentro.add(lblConsultaDeClientes);
		ClienteController control = new ClienteController();
		control = new ClienteController(tblCliente);
		control.listaCliente();

		pesquisaCpf = new JFormattedTextField();
		pesquisaCpf.setBounds(242, 64, 433, 20);
		pesquisaCpf.setVisible(false);
		pesquisaCpf.setColumns(10);
		pesquisaCpf.addActionListener(this);
		panelCentro.add(pesquisaCpf);

		pesquisaNome = new JFormattedTextField();
		pesquisaNome.setBounds(242, 64, 433, 20);
		pesquisaNome.setColumns(10);
		pesquisaNome.addActionListener(this);
		panelCentro.add(pesquisaNome);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(680, 63, 101, 23);
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setForeground(Color.black);
		btnPesquisar.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		btnPesquisar.setBorder(null);

		btnPesquisar.addActionListener(this);

		panelCentro.add(btnPesquisar);

		tipoPesquisa = new JComboBox<Object>();
		tipoPesquisa.addItem("Nome");
		tipoPesquisa.addItem("CPF");
		tipoPesquisa.setBounds(122, 64, 120, 20);

		panelCentro.add(tipoPesquisa);
		SelecaoTipo = tipoPesquisa.getSelectedIndex();
		FocusListener focoPesquisa = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				MaskFormatter maskPesquisa;
				if (tipoPesquisa.getSelectedIndex() == 0) {
					SelecaoTipo = 0;
					pesquisaNome.setText("");

					pesquisaNome.setVisible(true);
					pesquisaCpf.setVisible(false);

				} else if (tipoPesquisa.getSelectedIndex() == 1) {
					SelecaoTipo = 1;
					pesquisaNome.setVisible(false);
					pesquisaCpf.setVisible(true);
					try {
						maskPesquisa = new MaskFormatter("###.###.###-##");
						maskPesquisa.install(pesquisaCpf);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		};
		tipoPesquisa.addFocusListener(focoPesquisa);
		
		

		return panelCentro;
	}

	ActionListener acaoEnter = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			

		}
	};

	public ClienteEntity getDadosCliente() {
		ClienteController control = new ClienteController();
		ClienteEntity clt = new ClienteEntity();
		clt = control.BuscaDadosCliente(id);

		return clt;
	}



	public boolean validaPesquisaNome() {

		return pesquisaNome.getText().length() > 0;

	}

	public boolean validaPesquisaCpf() {

		return pesquisaCpf.getText().replace("-", "").replace(".", " ").replace(" ", "").length() == 0;

	}

	public void Consulta() {

		ClienteController control = new ClienteController(tblCliente);

		if (SelecaoTipo == 0) {
			if (validaPesquisaNome()) {
				control.ConsultaExistenciaNome(pesquisaNome.getText());
			} else {
				control.listaCliente();
			}
		} else if (SelecaoTipo == 1) {
			if (validaPesquisaCpf()) {

				control.listaCliente();
			} else {
				if (pesquisaCpf.getText().replace("-", "").replace(".", "").replace(" ", "").length() < 11)
					JOptionPane.showMessageDialog(null, "Os 11 digitos do CPF devem ser preenchidos");
				else
					control.ConsultaExistenciaCPF(pesquisaCpf.getText().replace(".", "").replace("-", ""));

			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pesquisaNome || e.getSource() == pesquisaCpf) {
			Consulta();
		}else 
		if (e.getSource() == btnPesquisar || e.getSource() == pesquisaNome || e.getSource() == pesquisaCpf) {
			Consulta();
		}

		

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCliente) {

			int linha = tblCliente.getSelectedRow();
			id = (int) tblCliente.getValueAt(linha, 0);

			consultaCltDialog.dispose();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
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

}
