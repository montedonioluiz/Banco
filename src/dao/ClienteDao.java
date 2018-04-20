package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class ClienteDao {
	private Connection conexao;
	
	public ClienteDao(Connection c) {
		conexao = c;	
	}
	
	public boolean isCliente(String cpf, String pass) {
		boolean result;
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			ps = conexao.prepareStatement("SELECT idcliente FROM clientes WHERE cpfcliente = \"" + cpf + "\" AND senhacliente = \"" + pass + "\"");
			
			rs = ps.executeQuery();
			result = rs.first();
			
			
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}
	
	public Cliente getCliente(String cpf) {
		Cliente c;
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			ps = conexao.prepareStatement("SELECT idcliente, cpfcliente, nomecliente, senhacliente FROM clientes WHERE cpfcliente = " + cpf);
			
			rs = ps.executeQuery();
			rs.first();
			c =  new Cliente(rs.getInt("idcliente"), rs.getString("cpfcliente"), rs.getString("senhacliente"), rs.getString("nomecliente"));
			
			rs.close();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return c;
	}
}
