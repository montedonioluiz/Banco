package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Transacao;

public class TransacaoDao {
	private Connection conexao;
	
	public TransacaoDao(Connection c) {
		this.conexao = c;
	}
	
	public ArrayList<Transacao> getTransacoes(int contaID){
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Transacao> transacoes = new ArrayList<Transacao>();
		try{
			ps = conexao.prepareStatement("SELECT * FROM transacao WHERE idconta= ? ORDER BY datatransacao asc");
			ps.setInt(1, contaID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				transacoes.add(new Transacao(rs.getString("datatransacao"), rs.getInt("idtransacao"), rs.getInt("idconta"),
								rs.getDouble("valortransacao"), rs.getString("tipotransacao")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return transacoes;
	}
}
