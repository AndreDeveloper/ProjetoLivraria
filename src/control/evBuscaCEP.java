package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import entity.EnderecoEntity;
import infraestructure.LocalidadeDAO;

public class evBuscaCEP {
	
	
	

		

	
	public List<EnderecoEntity> buscaPorCep (String cep){
		
		List<EnderecoEntity> list = new ArrayList<EnderecoEntity>();
		
		
		try {
			LocalidadeDAO buscaEnd = new LocalidadeDAO();
			list = buscaEnd.ConsultaEndereco(cep);
			//Identifica se o cep foi encontrado. se não foi encontrado ele retorna null na list para o digitar os clientes
			//se nao ele autocompleta.
			for(EnderecoEntity endereco: list){
		
			if ((endereco.getUf() == null && endereco.getBairro() == null) && (endereco.getCidade() == null && endereco.getLogradouro() ==null) ){
				
				list =null;
			}
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return list;
		
	}

















}
