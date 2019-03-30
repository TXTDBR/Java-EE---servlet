package br.com.caleum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caleum.jdbc.FabricaDeConexoes;
import br.com.caleum.modelo.Funcionario;

public class FuncionarioDAO {

	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public FuncionarioDAO() throws ClassNotFoundException {
		this.connection = new FabricaDeConexoes().getConnetion();
	}
	
	public void adicionar(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios (nome, usuario, senha) VALUES (?,?,?)";
		try {
		stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, funcionario.getNome());
		stmt.setString(2, funcionario.getUsuario());
		stmt.setString(3, funcionario.getSenha());
		
		
		stmt.execute();
		stmt.close();
		
		
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getList(){
		try {
			stmt = connection.prepareStatement("SELECT * FROM funcionarios");
			rs = stmt.executeQuery();
			
			List<Funcionario> funcionario = new ArrayList<>();
			
			while(rs.next()) {
				Funcionario f = new Funcionario();
				
				f.setNome(rs.getString("nome"));
				f.setUsuario(rs.getString("usuario"));
				f.setSenha(rs.getString("senha"));

				funcionario.add(f);
			}
			rs.close();
			stmt.close();
			return funcionario;
			
			
		} catch(SQLException e ){
			throw new RuntimeException(e);
		}
	}
		
	public void altera(Funcionario funcionario) {
		String sql = "update contatos set nome=?, email=?, endereco=?,"	+
				"dataNascimento=? where	id=?";
			try	{
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, funcionario.getNome());
				stmt.setString(2, funcionario.getUsuario());
				stmt.setString(3, funcionario.getSenha());
				
				stmt.setLong(5,	funcionario.getId());
				stmt.execute();
				stmt.close();
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	public void remove(Funcionario	funcionario) {
		try	{
			PreparedStatement	stmt	=	connection.prepareStatement("delete	"	+
			"from	contatos	where	id=?");
			stmt.setLong(1,	funcionario.getId());
			stmt.execute();
			stmt.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
}
}
