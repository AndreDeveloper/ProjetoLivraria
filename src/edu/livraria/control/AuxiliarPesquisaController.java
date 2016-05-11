package edu.livraria.control;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.livraria.entity.Autor;
import edu.livraria.entity.Editora;
import edu.livraria.entity.Livro;
import edu.livraria.infraestructure.AutorDAO;
import edu.livraria.infraestructure.EditoraDAO;
import edu.livraria.infraestructure.LivroDAO;

public class AuxiliarPesquisaController {
	public void preencheTabela(JTable tabela, String param){
		if(param.equals("Autor")){
			AutorDAO dao = new AutorDAO();
			List<Autor> listaResultado = dao.selectAll(); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (Autor autor: listaResultado){
				modeloTabela.addRow(new Object[]{autor.getId(), autor.getNomeAutor()});
				
			}
			
			tabela.setModel(modeloTabela);
		} 
		else if (param.equals("Editora") ){
			EditoraDAO dao = new EditoraDAO();
			List<Editora> listaResultado = dao.selectAll(); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (Editora editora: listaResultado){
				modeloTabela.addRow(new Object[]{editora.getId(), editora.getNome()});
				
			}
			
			tabela.setModel(modeloTabela);
		}
		else if (param.equals("PesquisaLivro") ){
			LivroDAO dao = new LivroDAO();
			List<Livro> listaResultado = dao.selectAll(); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
				modeloTabela.removeRow(0);
			}															
			
			// adicionando as linha do array list para o defaulttablemodel
			for (Livro livro: listaResultado){
				modeloTabela.addRow(new Object[]{livro.getIsbn(),
						livro.getTituloLivro()});
				
			}
			
			tabela.setModel(modeloTabela);
		}
	}
	public void preencheTabela(JTable tabela, String param, String value){
		if(param.equals("Autor")){
			AutorDAO dao = new AutorDAO();
			List<Autor> listaResultado = dao.selectByName(value); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (Autor autor: listaResultado){
				modeloTabela.addRow(new Object[]{autor.getId(), autor.getNomeAutor()});
				
			}
			
			tabela.setModel(modeloTabela);
		} 
		else if (param.equals("Editora") ){
			EditoraDAO dao = new EditoraDAO();
			List<Editora> listaResultado = dao.selectByName(value); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
	            modeloTabela.removeRow(0);
	        }															

			// adicionando as linha do array list para o defaulttablemodel
			for (Editora editora: listaResultado){
				modeloTabela.addRow(new Object[]{editora.getId(), editora.getNome()});
				
			}
			
			tabela.setModel(modeloTabela);
		}else if (param.equals("PesquisaLivro") ){
			LivroDAO dao = new LivroDAO();
			List<Livro> listaResultado = dao.selectByNome(value); 
			DefaultTableModel modeloTabela = (DefaultTableModel) tabela.getModel();
			
			
			//limpando todos os registros da tabela 
			while (modeloTabela.getRowCount() > 0) {
				modeloTabela.removeRow(0);
			}															
			
			// adicionando as linha do array list para o defaulttablemodel
			for (Livro livro: listaResultado){
				modeloTabela.addRow(new Object[]{livro.getIsbn(),
						livro.getTituloLivro()});
				
			}
			
			tabela.setModel(modeloTabela);
		}
	}
}
