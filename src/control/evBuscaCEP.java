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
		//	for(EnderecoEntity endereco: list){
		//		
		//		
		//		
        //
		//		
		//		System.out.println(endereco.getUf());
		//		System.out.println(endereco.getBairro());
		//		System.out.println(endereco.getCidade());
		//		System.out.println(endereco.getLogradouro());
		//		
		//	}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return list;
		
	}

















}
