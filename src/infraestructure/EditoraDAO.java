package infraestructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.AutorEntity;
import entity.EditoraEntity;

public class EditoraDAO {
	
	public long insert(EditoraEntity editora) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `Editora` (`Nome`, `Logradouro`, `Numero`, `Complemento`, `Bairro`, `Cidade`, `UF`, `Telefone`, `CNPJ`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, editora.getNome());
			stmt.setString(2, editora.getLograd());
			stmt.setString(3, editora.getNum());
			stmt.setString(4, editora.getCompl());
			stmt.setString(5, editora.getBairro());
			stmt.setString(6, editora.getCidade());
			stmt.setString(7, editora.getUf());
			stmt.setString(8, editora.getTel());
			stmt.setInt(9, editora.getCNPJ());

			stmt.executeUpdate();

			ResultSet r = stmt.getGeneratedKeys();
			r.next();
			idGerado = r.getLong(1);

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return idGerado;
	}
	
	
	
	public int update(EditoraEntity editora) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `Editora` SET `Nome`=?, `Logradouro`=?, `Numero`=?,  `Complemento`=?, `Bairro`=?, `Cidade`=?, `UF`=?, `Telefone`=?, `CNPJ`=?   WHERE  `CodEditora`=?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, editora.getNome());
			stmt.setString(2, editora.getLograd());
			stmt.setString(3, editora.getNum());
			stmt.setString(4, editora.getCompl());
			stmt.setString(5, editora.getBairro());
			stmt.setString(6, editora.getCidade());
			stmt.setString(7, editora.getUf());
			stmt.setString(8, editora.getTel());
			stmt.setInt(9, editora.getCNPJ());
			
			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	
	public int delete(long id) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "DELETE FROM Editora WHERE CodEditora = ?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	public List<EditoraEntity> selectAll(){
		List<EditoraEntity> lista = new ArrayList<EditoraEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Editora";
			PreparedStatement stmt = con.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				EditoraEntity editora = new EditoraEntity();
				
				editora.setId(rs.getLong("CodEditora"));
				editora.setNome(rs.getString("Nome"));
				
				lista.add(editora);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<EditoraEntity> selectByName(String name){
		List<EditoraEntity> lista = new ArrayList<EditoraEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			String query = "SELECT * FROM Editora WHERE Nome LIKE ?";
			PreparedStatement stmt = con.prepareStatement(query);

			stmt.setString(1, "%" + name + "%");
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				EditoraEntity editora = new EditoraEntity();
				
				editora.setId(rs.getLong("CodEditora"));
				editora.setNome(rs.getString("Nome"));
				
				lista.add(editora);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
