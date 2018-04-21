package model;

public class Transacao {
	private String dataTransacao, tipoTransacao;
	private int idTransacao, idConta;
	private double valorTransacao;
	
	public Transacao(String dataTransacao, int idTransacao, int idConta, double valorTransacao, String tipoTransacao) {
		super();
		this.dataTransacao = dataTransacao;
		this.idTransacao = idTransacao;
		this.idConta = idConta;
		this.valorTransacao = valorTransacao;
		this.tipoTransacao = tipoTransacao;
	}

	public String getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(String dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public double getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public String getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	
	public String toString() {
		return getIdTransacao() + "/" + getIdConta() + getValorTransacao() + "/" + getTipoTransacao() + "/" + getDataTransacao();
	}//String dataTransacao, int idTransacao, int idConta, double valorTransacao, String tipoTransacao
	
}