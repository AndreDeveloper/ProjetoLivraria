package infraestructure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.CategoriaEntity;

public class CategoriaDAO {
	
	public long insert(CategoriaEntity categoria) {
		long idGerado = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "INSERT INTO `Categoria` (`Nome`) VALUES (?);";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, categoria.getNomeCategoria());

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
	
	
	
	public int update(CategoriaEntity categoria) {
		int affectedRows = 0;
		try {

			Connection con = JDBCUtil.getConnection();

			String query = "UPDATE `Autor` SET `Nome`=?, WHERE  `CodAutor`=?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, categoria.getNomeCategoria());
			
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

			String query = "DELETE FROM Categoria WHERE CodCategoria = ?;";

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, id);

			affectedRows = stmt.executeUpdate();

			JDBCUtil.close(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	

}
