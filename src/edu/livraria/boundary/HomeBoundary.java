package edu.livraria.boundary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import edu.livraria.control.HomeControl;
import edu.livraria.entity.Livro;

public class HomeBoundary {
	private JPanel painelPrincipal = new JPanel(new BorderLayout());
	private HomeControl control = new HomeControl();
	private TelaPrincipalBoundary formPrincipal;
	
	
	public JPanel getPainelPrincipal() {
		return painelPrincipal;
	}

	public void setPainelPrincipal(JPanel painelPrincipal) {
		this.painelPrincipal = painelPrincipal;
	}

	public HomeBoundary(TelaPrincipalBoundary formPrincipal){
		this.formPrincipal = formPrincipal;
		create();
	}
	
	private void create(){
		GridLayout gridLayout = new GridLayout(1,4, 5, 5);
		JPanel painelLivros = new JPanel(gridLayout);
		List<Livro> listaLivros = control.selectAll();
		
		int rows = gridLayout.getRows();
		int columns = gridLayout.getColumns();
		for(Livro livro: listaLivros){
			if(painelLivros.getComponentCount()%5==0){
				gridLayout.setRows(gridLayout.getRows()+1);
			}
			ItemHomeBoundary homeBoundary = new ItemHomeBoundary(livro);
			homeBoundary.addObserver(formPrincipal);
			painelLivros.add(homeBoundary.getPainelPrincipal());
		}
		
		painelPrincipal.add(painelLivros, BorderLayout.CENTER);
		painelLivros.setBackground(Color.DARK_GRAY);
		painelPrincipal.setBackground(Color.DARK_GRAY);
	}
}
