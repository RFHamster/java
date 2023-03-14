package entities;

public class ContaPopanca extends ContaBancaria {

	public Double taxarendimento;
	
	public ContaPopanca(Integer numero, Integer senha, Cliente cliente, Double taxarendimento) {
		super(numero, senha, cliente);
		this.taxarendimento = taxarendimento;
	}
	
	public String imprimirSaldo() {
		return "Sua taxa de redimento esse mes foi de " + taxarendimento + " Saldo: " + Double.toString(saldo);
	}
	
	

}
