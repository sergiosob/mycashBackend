package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import JDBCUtil.ConexaoJDBC;
import Model.Contato;

public class ContatoDao {
	
	public void salvar(Contato contato) throws ClassNotFoundException {
		
		String sql = "insert into CONTATO (ddd, numero, email) values (?,?,?)";
		Connection conexao;
		
		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, contato.getDdd());
			ps.setString(2, contato.getNumero());
			ps.setString(3, contato.getEmail());
			
			
			ps.execute();
			//conexao.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		public void atualizar (Contato contato) throws ClassNotFoundException {
			
			String sql = "UPDATE CONTATO SET DDD=?, NUMERO=?, EMAIL=? WHERE ID_contato=?";
			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, contato.getDdd());
				ps.setString(2, contato.getNumero());
				ps.setString(3, contato.getEmail());
				ps.setLong(5, contato.getId());
				
				ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		public void deletar(Long id) throws SQLException, ClassNotFoundException {
			
			String sql = "DELETE FROM CONTATO WHERE ID_CONTATO=?";
			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setLong(1, id);
				
				ps.execute();
				
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
		
		}
		
		public List<Contato> listarTodos() throws ClassNotFoundException {
			String sql = "SELECT * FROM CONTATO";
			Connection conexao;
			
			List<Contato> listarContatos = new ArrayList<Contato>();
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet resultado = ps.executeQuery();
				
				while(resultado.next()) {
					
					Contato contato = new Contato();
					contato.setId(resultado.getLong("ID_CONTATO"));
					contato.setNome(resultado.getString("DDD"));
					contato.setCPF(resultado.getString("NUMERO"));
					contato.setSexo(resultado.getString("EMAIL"));
					
					
					listarContatos.add(contato);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listarContatos;
			
		}
		
}
