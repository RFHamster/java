package entities;

public class ContaCorrente extends ContaBancaria implements Tributavel{

	public Double limiteespecial;
	
	public ContaCorrente(Integer numero, Integer senha, Cliente cliente, Double limiteespecial) {
		super(numero, senha, cliente);
		this.limiteespecial = limiteespecial;
	}
	
	public boolean sacar(Double valor, Integer senha) {
		if(getSenha().equals(senha)) {
			if(saldo >= valor) {
				saldo -= valor;
				return true;
			}else if(saldo + limiteespecial - valor >= 0) {
				valor -= saldo;
				saldo = 0.0;
				limiteespecial -= valor;
				System.out.println("Seu limite especial diminuiu! Voce tem mais " + limiteespecial + " de credito");
				return true;
			}
		}else {
			System.out.println("Senha errada");
		}
		System.out.println("Saldo Insuficiente");
		return false;
	}
	
	public String imprimirSaldo() {
		Double saldoFinal = saldo + (limiteespecial - 1000);
		return "Saldo: " + Double.toString(saldoFinal) + " Seu limite de credito: " + Double.toString(limiteespecial);
	}

	@Override
	public double getValorImposto() {
		return (1/100);
	}
}
