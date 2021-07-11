package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import Model.Endereco;

public class EnderecoDao {
	
	public void salvar(Endereco endereco) throws ClassNotFoundException {
		
		String sql = "insert into ENDERECO (rua, bairro, cidade, cep, estado) values (?,?,?,?,?)";
		Connection conexao;
		
		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, endereco.getRua());
			ps.setString(2, endereco.getBairro());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getCep());
			ps.setString(5, endereco.getEstado());
			
			ps.execute();
			//conexao.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		public void atualizar (Endereco endereco) throws ClassNotFoundException {
			
			String sql = "UPDATE ENDERECO SET DDD=?, NUMERO=?, EMAIL=? WHERE ID_endereco=?";
			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, endereco.getRua());
				ps.setString(2, endereco.getBairro());
				ps.setString(3, endereco.getCidade());
				ps.setString(4, endereco.getCep());
				ps.setString(5, endereco.getEstado());
				
				ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		public void deletar(Long id) throws SQLException, ClassNotFoundException {
			
			String sql = "DELETE FROM ENDERECO WHERE ID_ENDERECO=?";
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
		
		public List<Endereco> listarTodos() throws ClassNotFoundException {
			String sql = "SELECT * FROM ENDERECO";
			Connection conexao;
			
			List<Endereco> listarEnderecos = new ArrayList<Endereco>();
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet resultado = ps.executeQuery();
				
				while(resultado.next()) {
					
					Endereco endereco = new Endereco();
					endereco.setId(resultado.getLong("ID_ENDERECO"));
					endereco.setRua(resultado.getString("RUA"));
					endereco.setBairro(resultado.getString("BAIRRO"));
					endereco.setCidade(resultado.getString("CIDADE"));
					endereco.setCep(resultado.getString("CEP"));
					endereco.setEstado(resultado.getString("ESTADO"));
					
					listarEnderecos.add(endereco);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listarEnderecos;
			
		}
		
		
			
		
					
}

