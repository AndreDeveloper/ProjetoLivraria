package control;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.AutorEntity;
import entity.EditoraEntity;
import infraestructure.AutorDAO;
import infraestructure.EditoraDAO;

public class AuxiliarPesquisaController {
	public void preencheTabela(JTable tabela, String param){
		if(param.equals("Autor")){
			AutorDAO dao = new AutorDAO();
			List<AutorEntity> listaResultado = dao.selectAll(); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (AutorEntity autor: listaResultado){
				modeloTabela.addRow(new Object[]{autor.getId(), autor.getNomeAutor()});
				
			}
			
			tabela.setModel(modeloTabela);
		} 
		else if (param.equals("Editora") ){
			EditoraDAO dao = new EditoraDAO();
			List<EditoraEntity> listaResultado = dao.selectAll(); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (EditoraEntity editora: listaResultado){
				modeloTabela.addRow(new Object[]{editora.getId(), editora.getNome()});
				
			}
			
			tabela.setModel(modeloTabela);
		}
	}
	public void preencheTabela(JTable tabela, String param, String value){
		if(param.equals("Autor")){
			AutorDAO dao = new AutorDAO();
			List<AutorEntity> listaResultado = dao.selectByName(value); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (AutorEntity autor: listaResultado){
				modeloTabela.addRow(new Object[]{autor.getId(), autor.getNomeAutor()});
				
			}
			
			tabela.setModel(modeloTabela);
		} 
		else if (param.equals("Editora") ){
			EditoraDAO dao = new EditoraDAO();
			List<EditoraEntity> listaResultado = dao.selectByName(value); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (EditoraEntity editora: listaResultado){
				modeloTabela.addRow(new Object[]{editora.getId(), editora.getNome()});
				
			}
			
			tabela.setModel(modeloTabela);
		}
	}
}
