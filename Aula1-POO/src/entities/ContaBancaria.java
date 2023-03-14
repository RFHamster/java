package entities;

public abstract class ContaBancaria {
	public Integer numero;
	private Integer senha;
	protected Double saldo;
	protected Cliente cliente;
	
	public ContaBancaria(Integer numero, Integer senha, Cliente cliente) {
		this.numero = numero;
		this.senha = senha;
		this.cliente = cliente;
		saldo = 0.0;
	}
	
	public boolean sacar(Double valor, Integer senha) {
		if(this.senha.equals(senha)) {
			if(saldo >= valor) {
				saldo -= valor;
				return true;
			}
		}else {
			System.out.println("Senha errada");
			return false;
		}
		System.out.println("Saldo Insuficiente");
		return false;
	}
	
	public Integer getSenha() {
		return senha;
	}
	
	public void depositar(Double valor) {
		saldo += valor;
	}
	
	public String imprimirSaldo() {
		return Double.toString(saldo);
	}
	
	
}
