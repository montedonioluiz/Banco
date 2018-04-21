package model;

public class Conta {
	private int idConta, idCliente;
	private String numeroConta, agenciaConta, tipoConta;
	public Conta(int idConta, int idCliente, String numeroConta, String agenciaConta, String tipoConta) {
		super();
		this.idConta = idConta;
		this.idCliente = idCliente;
		this.numeroConta = numeroConta;
		this.agenciaConta = agenciaConta;
		this.tipoConta = tipoConta;
	}
	
	public Conta() {
		this.idConta = -1;
	}
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getAgenciaConta() {
		return agenciaConta;
	}
	public void setAgenciaConta(String agenciaConta) {
		this.agenciaConta = agenciaConta;
	}
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public String toString() {
		//int idConta, int idCliente, String numeroConta, String agenciaConta, String tipoConta
		return getIdConta() + "/" + getIdCliente() + "/" + getNumeroConta()
							+ "/" + getAgenciaConta() + "/" + getTipoConta();
	}
}
