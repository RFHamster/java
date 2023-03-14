package entities;

public abstract class Cliente {
	protected String nometitular;
	protected String endereco;
	
	public Cliente(String nometitular, String endereco) {
		this.nometitular = nometitular;
		this.endereco= endereco;
	}
	public String getNometitular() {
		return nometitular;
	}
	public String getEndereco() {
		return endereco;
	}
	
	
}

