package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import control.ClienteController;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class ConsultaClienteBoundary implements MouseListener{
	JFrame janela = new JFrame("Consulta de Clientes");
	private JTable tblCliente;
	
	private JButton btnPesquisar;
	private JFormattedTextField pesquisaCpf;
	private JTextField pesquisaNome;
	private	JPanel panelPrincipal = new JPanel(new BorderLayout());
	private int id;
	private JButton btnVisualizar;
	private	JComboBox<Object> tipoPesquisa;
	private int SelecaoTipo;
	
	public ConsultaClienteBoundary() {
		// TODO Auto-generated constructor stub
		
		

		panelPrincipal.add(Centro(), BorderLayout.CENTER);
		panelPrincipal.add(Botoes(), BorderLayout.SOUTH);
		//janela.setContentPane(panelPrincipal);
		//janela.setVisible(true);
		//janela.setSize(1000, 650);
		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

	public JComponent Centro(){
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(null);
		panelCentro.setBackground(Color.WHITE);
		
		JScrollPane SPTblConsultaClt = new JScrollPane();
		SPTblConsultaClt.setBounds(10, 97, 998, 408);
		panelCentro.add(SPTblConsultaClt);
		
		tblCliente = new JTable();
		tblCliente.setFont(new Font("Palatino Linotype", Font.PLAIN, 16));
		tblCliente.setBorder(null);
		
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "CPF", "Cidade", "E-mail"
				});
		SPTblConsultaClt.setViewportView(tblCliente);
		tblCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tblCliente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "CPF", "Cidade", "E-mail"
			}
		){
			
			 boolean[] canEdit = new boolean []{    
		             false, false, false, false, false
		         };    
		         @Override    
		         public boolean isCellEditable(int rowIndex, int columnIndex) {    
		             return canEdit [columnIndex];    
		         }  
		}
				
				
				
				);
		tblCliente.setBackground(Color.WHITE);
		
		tblCliente.getColumnModel().getColumn(0).setPreferredWidth(34);
		tblCliente.getColumnModel().getColumn(1).setPreferredWidth(352);
		tblCliente.getColumnModel().getColumn(2).setPreferredWidth(89);
		tblCliente.getColumnModel().getColumn(3).setPreferredWidth(112);
		tblCliente.getColumnModel().getColumn(4).setPreferredWidth(225);
		tblCliente.addMouseListener(this);
		 
		
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
		panelCentro.add(pesquisaCpf);
		
		pesquisaNome = new JFormattedTextField();
		pesquisaNome.setBounds(242, 64, 433, 20);
		pesquisaNome.setColumns(10);
		panelCentro.add(pesquisaNome);
		
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(673, 63, 101, 23);
		btnPesquisar.addMouseListener(this);
		
		panelCentro.add(btnPesquisar);
		
		
		tipoPesquisa = new JComboBox<Object>();
		tipoPesquisa.addItem("Nome");
		tipoPesquisa.addItem("CPF");
		tipoPesquisa.setBounds(122, 64,120,20);
		
		panelCentro.add(tipoPesquisa);
		SelecaoTipo = tipoPesquisa.getSelectedIndex();
		FocusListener focoPesquisa = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				MaskFormatter maskPesquisa;
				if (tipoPesquisa.getSelectedIndex() == 0){
					SelecaoTipo=0;
					pesquisaNome.setText("");
					
					pesquisaNome.setVisible(true);
					pesquisaCpf.setVisible(false);
				
					
				}else if (tipoPesquisa.getSelectedIndex() ==1){
					SelecaoTipo=1;
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
	

	
	ActionListener ChamaTela = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ClienteController cc = new ClienteController();
			
			
			VisualizaAtualizaClienteBoundary va = new VisualizaAtualizaClienteBoundary(cc.BuscaDadosCliente(id));
			panelPrincipal.removeAll();
			panelPrincipal.add(va.getPanel(),BorderLayout.CENTER);
			panelPrincipal.revalidate();
			panelPrincipal.repaint();
			
			
			
		}
	};

	
	
	
	
	public JComponent Botoes (){
		JPanel panelBotoes  = new JPanel(new BorderLayout());
		panelBotoes.setBackground(Color.WHITE);
		
		btnVisualizar  = new JButton ("Visualizar / Alterar");
		btnVisualizar.setBackground(Color.WHITE);
		btnVisualizar.setForeground(Color.BLUE);
		btnVisualizar.setIcon(new ImageIcon(VisualizaAtualizaClienteBoundary.class.getResource("/resource/search.png")));
		btnVisualizar.setFont(new Font("Palatino Linotype", Font.BOLD, 22));
		btnVisualizar.setBorder(null);
		btnVisualizar.setEnabled(false);
		
		panelBotoes.add(btnVisualizar, BorderLayout.LINE_END);
		
		btnVisualizar.addActionListener(ChamaTela);
		
		
		return panelBotoes;		
	}
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		if(e.getSource()== btnPesquisar){
			ClienteController control = new ClienteController(tblCliente);
			
				
				if (SelecaoTipo == 0){
					if(validaPesquisaNome()){
					control.ConsultaExistenciaNome(pesquisaNome.getText());
					}else{
						control.listaCliente();
					}
				}else if(SelecaoTipo == 1){
					if(validaPesquisaCpf()){
						
						control.listaCliente();
					}else
					{
						if(pesquisaCpf.getText().replace("-","").replace(".", "").replace(" ", "").length()<11)
							JOptionPane.showMessageDialog(null, "Os 11 digitos do CPF devem ser preenchidos");
						else
						control.ConsultaExistenciaCPF(pesquisaCpf.getText().replace(".","").replace("-", ""));
						
					}
					
				
				
			}
			

		} if(e.getSource() == tblCliente){

			int linha = tblCliente.getSelectedRow();
			id = (int)tblCliente.getValueAt(linha, 0);
			//String nome = (String) tblCliente.getValueAt(linha, 1);
			btnVisualizar.setEnabled(true);	
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
	
	public boolean validaPesquisaNome(){
		
		return pesquisaNome.getText().length()>0;
		
	}
	
	public boolean validaPesquisaCpf(){
		
		return pesquisaCpf.getText().replace("-","").replace("."," ").replace(" ","").length()==0;
		
	}
	
}

