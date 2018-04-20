package model;

public class Cliente {
	private int idCliente;
	String cpfCliente, senhaCliente, nomeCliente;
	
	public Cliente() {
		
	}
	public Cliente(int idCliente, String cpfCliente, String senhaCliente, String nomeCliente) {
		super();
		this.idCliente = idCliente;
		this.cpfCliente = cpfCliente;
		this.senhaCliente = senhaCliente;
		this.nomeCliente = nomeCliente;
	}
	
	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public String getSenhaCliente() {
		return senhaCliente;
	}


	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
}
