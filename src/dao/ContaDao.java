package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.Conta;

public class ContaDao {
	private Connection conexao;
	
	public ContaDao(Connection c) {
		this.conexao = c;
	}
	
	public ArrayList<Conta> getContas(Cliente c){
		ArrayList<Conta> contas = new ArrayList<>();
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			ps = conexao.prepareStatement("SELECT * FROM conta WHERE idcliente= ?");
			ps.setInt(1, c.getIdCliente());
			
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				contas.add(new Conta(rs.getInt("idconta"),
							rs.getInt("idcliente"),
							rs.getString("numeroconta"),
							rs.getString("agenciaconta"),
							rs.getString("tipoconta")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return contas;
	}
	
	public Conta getConta(int contaID) {
		Conta c = new Conta();
		try {
			PreparedStatement ps;
			ResultSet rs;
			
			ps = conexao.prepareStatement("SELECT * FROM conta WHERE idconta= ?");
			ps.setInt(1, contaID);
			
			
			
			rs = ps.executeQuery();
			rs.first();
			c = new Conta(rs.getInt("idconta"),
							rs.getInt("idcliente"),
							rs.getString("numeroconta"),
							rs.getString("agenciaconta"),
							rs.getString("tipoconta"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public double getSaldo(int contaID) {
		double saldo = 0;
		try {
			double credito = 0;
			double debito = 0;
			PreparedStatement ps;
			ResultSet rs;
			
			ps = conexao.prepareStatement("SELECT SUM(valortransacao) as valor FROM transacao t WHERE t.idconta= ? AND t.tipotransacao = 'C'");
			ps.setInt(1, contaID);
			rs = ps.executeQuery();
			rs.first();
			credito = rs.getDouble("valor");
			
			ps = conexao.prepareStatement("SELECT SUM(valortransacao) as valor FROM transacao t WHERE t.idconta= ? AND t.tipotransacao = 'D'");
			ps.setInt(1, contaID);
			rs = ps.executeQuery();
			rs.first();
			debito = rs.getDouble("valor");
			
			saldo = debito - credito;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return saldo;
	}
}
