package application;

import entities.ClientePF;
import entities.ClientePj;
import entities.ContaBancaria;
import entities.ContaCorrente;
import entities.ContaPopanca;

public class Main {

	public static void main(String[] args) {
		ContaBancaria b1;
		ContaBancaria b2;
		b1 = new ContaCorrente(01, 0000, new ClientePF("Rhuan", "Rua 1"), 1000.0);
		b2 = new ContaPopanca(02, 1111, new ClientePj("Vitor", "Rua 2"), 0.5);
		
		b1.depositar(500.0);
		b2.depositar(200.0);
		System.out.println(b1.imprimirSaldo());
		System.out.println(b2.imprimirSaldo());
		System.out.println();
		
		b1.sacar(700.0, 0000);
		b2.sacar(100.0, 1111);
		System.out.println(b1.imprimirSaldo());
		System.out.println(b2.imprimirSaldo());
		System.out.println();
		
		b1.sacar(500.0, 0000);
		b2.sacar(200.0, 1111);
		System.out.println(b1.imprimirSaldo());
		System.out.println(b2.imprimirSaldo());
		System.out.println();
	}

}
