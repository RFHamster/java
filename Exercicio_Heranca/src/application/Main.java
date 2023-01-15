package application;

import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o numero de trabalhadores");
		int workers = sc.nextInt();
		
		
		sc.close();
	}
}
