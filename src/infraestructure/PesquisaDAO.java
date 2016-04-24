package infraestructure;
import entity.LivroEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.AutorEntity;
import entity.EditoraEntity;


public class PesquisaDAO {
	
	public List<LivroEntity> perquisarLivro(String tituloLivro, String autorLivro, Double precoLivro) {
		String query = "SELECT (`Titulo`,`PrecoVenda`,`CodAutor`) FROM `Livro` WHERE  like ?";
		List<LivroEntity> lista = new ArrayList<LivroEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,  "%" + tituloLivro + "%" );
			stmt.setString(2,  "%" + autorLivro + "%" );
			//stmt.setDouble(3,  "%" + precoLivro + "%" );
			ResultSet rs  = stmt.executeQuery();
			while( rs.next() ) { 
				LivroEntity l = new LivroEntity();
				l.setTituloLivro(rs.getString("tituloLivro"));
				l.setNomeAutor(rs.getString("nomeAutor"));
				l.setPrecoVenda(rs.getDouble("precoLivro"));
				lista.add( l );
			}
		} catch (SQLException e) {
//			throw new Exception( e );
		}
		return lista;
	}

	
	public List<LivroEntity> perquisarLivro(String tituloLivro) {
		String query = "SELECT * FROM `Livro` WHERE Titulo like ?";
		List<LivroEntity> lista = new ArrayList<LivroEntity>();
		try {
			Connection con = JDBCUtil.getConnection();

			PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1,  "%" + tituloLivro + "%" );
			//stmt.setDouble(3,  "%" + precoLivro + "%" );
			ResultSet rs  = stmt.executeQuery();
			while( rs.next() ) { 
				LivroEntity l = new LivroEntity();
				l.setTituloLivro(rs.getString("tituloLivro"));
				l.setNomeAutor(rs.getString("nomeAutor"));
				l.setPrecoVenda(rs.getDouble("precoLivro"));
				lista.add( l );
			}
		} catch (SQLException e) {
//			throw new Exception( e );
		}
		return lista;
	}
}

