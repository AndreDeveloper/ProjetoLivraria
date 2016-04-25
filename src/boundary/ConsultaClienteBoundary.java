package boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.PatternSyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
	
	private JTextField pesquisa;
	JPanel panelPrincipal = new JPanel(new BorderLayout());
	private int id;
	private JButton btnVisualizar;
	TableRowSorter<TableModel> sorter;
	
	public ConsultaClienteBoundary() {

		panelPrincipal.add(Centro(), BorderLayout.CENTER);
		panelPrincipal.add(Botoes(), BorderLayout.SOUTH);
		
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
		 sorter = new TableRowSorter<TableModel>(modelo);
		
		JLabel lblConsultaDeClientes = new JLabel("Consulta de Clientes");
		lblConsultaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblConsultaDeClientes.setBounds(242, 11, 257, 30);
		panelCentro.add(lblConsultaDeClientes);
		ClienteController control = new ClienteController();
		control = new ClienteController(tblCliente);
		control.listaCliente();
		
		
		
		pesquisa = new JTextField();
		pesquisa.setBounds(242, 64, 433, 20);
		panelCentro.add(pesquisa);
		pesquisa.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(673, 63, 101, 23);
		btnPesquisar.addActionListener(pesquisaClt);
		panelCentro.add(btnPesquisar);
		
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
	
	ActionListener pesquisaClt = new ActionListener() {
		
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			  String text = pesquisa.getText();  
              if (text.length() == 0) {  
                sorter.setRowFilter(null);  
              } else {  
                try {  
                  sorter.setRowFilter(  
                      RowFilter.regexFilter(text));  
                } catch (PatternSyntaxException pse) {  
                    JOptionPane.showMessageDialog(null, "Não existe.", "Erro", JOptionPane.ERROR_MESSAGE);  
                }  
              }  
              
          
			
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
		int linha = tblCliente.getSelectedRow();
		id = (int)tblCliente.getValueAt(linha, 0);
		btnVisualizar.setEnabled(true);

		
		
		
		
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
