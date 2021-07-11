package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import Model.Cliente;

public class ClienteDao {
	
	public void salvar(Cliente cliente) throws ClassNotFoundException {
		
		String sql = "insert into CLIENTE (nome, ano_nasci, sexo, cpf) values (?,?,?,?)";
		Connection conexao;
		
		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getAnoNasci());
			ps.setString(3, cliente.getSexo());
			ps.setString(4, cliente.getCPF());
			
			ps.execute();
			//conexao.commit();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		public void atualizar (Cliente cliente) throws ClassNotFoundException {
			
			String sql = "UPDATE CLIENTE SET NOME=?, CPF=?, ANO_NASCI=?, SEXO=? WHERE ID_cliente=?";
			Connection conexao;
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getCPF());
				ps.setString(3, cliente.getAnoNasci());
				ps.setString(4, cliente.getSexo());
				ps.setLong(5, cliente.getId());
				
				ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		public void deletar(Long id) throws SQLException, ClassNotFoundException {
			
			String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE=?";
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
		
		public List<Cliente> listarTodos() throws ClassNotFoundException {
			String sql = "SELECT * FROM CLIENTE";
			Connection conexao;
			
			List<Cliente> listarClientes = new ArrayList<Cliente>();
			
			try {
				conexao = ConexaoJDBC.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);
				ResultSet resultado = ps.executeQuery();
				
				while(resultado.next()) {
					
					Cliente cliente = new Cliente();
					cliente.setId(resultado.getLong("ID_CLIENTE"));
					cliente.setNome(resultado.getString("NOME"));
					cliente.setCPF(resultado.getString("CPF"));
					cliente.setSexo(resultado.getString("SEXO"));
					cliente.setAnoNasci(resultado.getString("ANO_NASCI"));
					
					listarClientes.add(cliente);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listarClientes;
			
		}
		
		
			
		
					
}
