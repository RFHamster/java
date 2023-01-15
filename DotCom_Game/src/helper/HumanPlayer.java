package helper;

import java.util.ArrayList;

import DotCom.DotCom;

public class HumanPlayer extends Player {

	@Override
	public String takeTurn() {
		String jogada = helper.getUserInput("Informe a jogada");
	    System.out.println();
		return jogada;
	}
	
	public ArrayList<String> createDotCom(int comSize) {
		  ArrayList<String> alphaCells = new ArrayList<String>();
		    
		    return alphaCells;
	  }
	
	public HumanPlayer(String name) {
		grid = new Grid();
		dotcoms = new ArrayList<DotCom>();
		this.name = name;
    	//criar 1 de 6, 2 de 5, 3 de 4 e 4 de 3
	}
}
