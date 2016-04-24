package infraestructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.EnderecoEntity;


public class LocalidadeDAO {
	
	
	Connection con;
	
	public LocalidadeDAO()throws SQLException{
		
		con =JDBCCEP.getConnection();
		
		
		
	}

	public List<EnderecoEntity> ConsultaEndereco(String cep) throws SQLException{
		
		
		
		

		List<EnderecoEntity> Endereco = new ArrayList<EnderecoEntity>();
		
		
			int codBairroSequencialIni=0;
		
			String sql = "SELECT log_tipo_logradouro as tipo_logradouro,log_no as nome_rua,bai_nu_sequencial_ini, ufe_sg as siglauf FROM log_logradouro WHERE cep ="+cep;
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			EnderecoEntity end = new EnderecoEntity();
			String SiglaUF="" ;
			while(rs.next()){
			String nome_rua =rs.getString("tipo_logradouro")+ " " +rs.getString("nome_rua");
			SiglaUF = rs.getString("siglauf");
			end.setLogradouro(nome_rua);
			end.setUf(SiglaUF);
			codBairroSequencialIni =rs.getInt("bai_nu_sequencial_ini");
			}
			
			rs.close();
			ps.close();
			
            sql= "SELECT  bai_no as nome_do_bairro FROM  log_bairro WHERE bai_nu_sequencial="+codBairroSequencialIni;
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            	
            	
			end.setBairro(rs.getString("nome_do_bairro"));
            }
            
            
            
            rs.close();
			ps.close();
			
            sql= "SELECT ufe_no as cidade FROM log_faixa_uf WHERE ufe_sg = '"+SiglaUF+"'";
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
            	
            	
			end.setCidade(rs.getString("cidade"));
            }
				
				Endereco.add(end);
				
			
			rs.close();
			ps.close();
		
		return Endereco;
			
		
	}
	
	
	
	
	
}
