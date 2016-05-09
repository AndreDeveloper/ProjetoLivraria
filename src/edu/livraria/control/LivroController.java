package edu.livraria.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import edu.livraria.entity.Livro;
import edu.livraria.infraestructure.LivroDAO;

public class LivroController{
	
	public LivroController() {
		super();
	}

	public long salvar(Livro livro){
	LivroDAO dao = new LivroDAO();
	try {
		long affectedrows = dao.insert(livro);
		if(affectedrows > 0){
			JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso! id gerado: " + affectedrows,null,JOptionPane.INFORMATION_MESSAGE);
			return affectedrows;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return 0;
	}
	
	public Livro pesquisar(int isbn){
		LivroDAO dao = new LivroDAO();
		return dao.selectByIsbn(isbn);
	}
	
	public void atualizar(Livro livro){
		LivroDAO dao = new LivroDAO();
		long affectedrows = dao.update(livro);
		if(affectedrows > 0){
			JOptionPane.showMessageDialog(null, "Livro alterado com sucesso! Linhas afetadas: " + affectedrows,null,JOptionPane.INFORMATION_MESSAGE);
		}	
	}
	
	public long deletar(int isbn){
		LivroDAO dao = new LivroDAO();
		long affectedrows = dao.delete(isbn);
		if(affectedrows > 0){
			JOptionPane.showMessageDialog(null, "Livro excluido com sucesso! Linhas afetadas: " + affectedrows,null,JOptionPane.INFORMATION_MESSAGE);
			return affectedrows;
		}else{
			JOptionPane.showMessageDialog(null, "nao foi possivel deletar cadastro!",null,JOptionPane.ERROR_MESSAGE);	
		return 0;
		}
		
		 
	}
	
}
