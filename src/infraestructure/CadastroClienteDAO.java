package infraestructure;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import entity.ClienteEntity;


public class CadastroClienteDAO {
	Connection con;
	
	public CadastroClienteDAO()throws SQLException{
				con = JDBCUtil.getConnection(); 
		
	}
	public void insereCliente (ClienteEntity clt )throws SQLException{
		String sql = "INSERT INTO `Cliente` (`Nome`, `CPF`, `RG`, `Sexo`, `Logradouro`"
				+ ", `Numero`, `Complemento`, `Bairro`, `Cidade`, `UF`, `CEP`, `Email`, `Telefone`, `Celular`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, clt.getNome());
		ps.setString(2,clt.getCpf() );
		ps.setString(3, clt.getRg());
		ps.setString(4,clt.getSexo());
		ps.setString(5, clt.getLogradouro());
		ps.setInt(6, clt.getNumero());
		ps.setString(7, clt.getComplemento());
		ps.setString(8, clt.getBairro());
		ps.setString(9,clt.getCidade());
		ps.setString(10, clt.getUf());
		ps.setString(11, clt.getCep());
		ps.setString(12,clt.getEmail());
		ps.setString(13,clt.getTelefone());
		ps.setString(14, clt.getCelular());
		ps.execute();
		ps.close();
		
		
		
	}
	
public void AtualizaCliente (ClienteEntity clt)throws SQLException{
	String sql = "UPDATE  `Cliente` set Nome = ?, CPF = ?, RG = ?, Sexo = ?, Logradouro = ?, Numero = ?, Numero = ?, "
			+ "Complemento = ?, Bairro = ?, Cidade = ?, UF = ?, CEP = ?, Email = ?, Telefone = ?, Celular = ?)";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, clt.getNome());
	ps.setString(2,clt.getCpf() );
	ps.setString(3, clt.getRg());
	ps.setString(4,clt.getSexo());
	ps.setString(5, clt.getLogradouro());
	ps.setInt(6, clt.getNumero());
	ps.setString(7, clt.getComplemento());
	ps.setString(8, clt.getBairro());
	ps.setString(9,clt.getCidade());
	ps.setString(10, clt.getUf());
	ps.setString(11, clt.getCep());
	ps.setString(12,clt.getEmail());
	ps.setString(13,clt.getTelefone());
	ps.setString(14, clt.getCelular());
	ps.execute();
	ps.close();
	
	
	
}

public ClienteEntity ConsultaCliente (ClienteEntity clt)throws SQLException{
	
	String sql = "SELECT CodCliente, nome, CPF, RG, Sexo, Logradouro, Numero, Complemento, Bairro, "
			+ "Cidade, UF, CEP, Email, Telefone, Celular where CodCliente = ?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1,clt.getCodCliente());
	ResultSet rs = ps.executeQuery();
	if(rs.next()){
		clt.setCodCliente(rs.getInt("CodCliente"));
		clt.setNome(rs.getString("Nome"));
		clt.setCpf(rs.getString("CPF"));
		clt.setRg(rs.getString("RG"));
		clt.setSexo(rs.getString("Sexo"));
		clt.setLogradouro(rs.getString("Logradouro"));
		clt.setNumero(rs.getInt("Numero"));
		clt.setComplemento(rs.getString("Complemento"));
		clt.setBairro(rs.getString("Bairro"));
		clt.setCidade(rs.getString("Cidade"));
		clt.setUf(rs.getString("UF"));
		clt.setCep(rs.getString("CEP"));
		clt.setEmail(rs.getString("Email"));
		clt.setTelefone(rs.getString("Telefone"));
		clt.setCelular(rs.getString("Celular"));

		
		
	}
	rs.close();
	ps.close();
	
	
	
	return clt;
	
	
}


public List<ClienteEntity> ConsultaCliente()throws SQLException {
	List<ClienteEntity> listaCliente = new ArrayList<ClienteEntity>();
	String sql = "*SELECT Nome, CPF, RG, Sexo, Logradouro, Numero, Complemento, Bairro, "
			+ "Cidade, UF, CEP, Email, Telefone, Celular from Cliente";
	
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
	
	while (rs.next()){
		
		ClienteEntity clt = new ClienteEntity();
		clt.setNome(rs.getString("Nome"));
		clt.setCpf(rs.getString("CPF"));
		clt.setRg(rs.getString("RG"));
		clt.setSexo(rs.getString("Sexo"));
		clt.setLogradouro(rs.getString("Logradouro"));
		clt.setNumero(rs.getInt("Numero"));
		clt.setComplemento(rs.getString("Complemento"));
		clt.setBairro(rs.getString("Bairro"));
		clt.setCidade(rs.getString("Cidade"));
		clt.setUf(rs.getString("UF"));
		clt.setCep(rs.getString("CEP"));
		clt.setEmail(rs.getString("Email"));
		clt.setTelefone(rs.getString("Telefone"));
		clt.setCelular(rs.getString("Celular"));
		
		listaCliente.add(clt);
		
		
	}
	rs.close();
	ps.close();
	
	return listaCliente;
	
}
public int proximoId() throws SQLException{
	String sql = "SELECT MAX(CodCliente)+1 as proximo_id FROM Cliente";
	PreparedStatement ps  = con.prepareStatement(sql);
	
	ResultSet rs = ps.executeQuery();
	if(rs.next()){
		return rs.getInt("proximo_id");
	}else
	{
		return 1;	
	}
	
}





}
