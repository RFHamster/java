package helper;

import java.util.ArrayList;

import DotCom.BigCom;
import DotCom.DotCom;
import DotCom.JustAnotherDotCom;
import DotCom.MicroCom;
import DotCom.StartupCom;

public class HumanPlayer extends Player {

	@Override
	public String takeTurn() {
		String jogada = helper.getUserInput("Informe a jogada");
	    System.out.println();
		return jogada;
	}
	
	public DotCom createDotCom(String name, int comSize) {
		  DotCom dotcom = null;
		  ArrayList<String> alphaCells = new ArrayList<String>();
		  System.out.println("Criando uma dotcom de tamanho " + comSize);
		  String position = helper.getUserInput("Digite a posicao que a DotCom vai ficar");
		  while(helper.convertAlphatoNuber(position) >= 100 || helper.convertAlphatoNuber(position) < 0) {
			  System.out.println("Fora da Grid");
			  position = helper.getUserInput("Digite a posicao que a DotCom vai ficar");
		  }
		  int displayed = Integer.parseInt(helper.getUserInput("1 - Horizontal, 2 - Vertical"));
		  if(displayed != 1) {
			  displayed = 10;
		  }
		  int positionNumber = helper.convertAlphatoNuber(position);
		  for(int i = 0; i < comSize; i++) {
			  alphaCells.add(helper.convertNumberToAlpha(positionNumber));
			  positionNumber += displayed;
		  }
		  int retorno = 0;
		  for(String c : alphaCells) {
			  if(grid.gridOccupied(helper.convertAlphatoNuber(c))) {
				  System.out.println("Grid Ocupada");
				  retorno = 1;
			  }
		  }
		  if(retorno == 1) {
			  alphaCells = new ArrayList<String>();
			  displayed = displayed - (2*displayed);
			  positionNumber = helper.convertAlphatoNuber(position);
			  for(int i = 0; i < comSize; i++) {
				  alphaCells.add(helper.convertNumberToAlpha(positionNumber));
				  positionNumber += displayed;
			  }
			  for(String c : alphaCells) {
				  if(grid.gridOccupied(helper.convertAlphatoNuber(c))) {
					  System.out.println("Grid Ocupada");
					  retorno = 2;
				  }
			  }
		  }
		  if(retorno == 2) {
			  System.out.println("Impossivel fazer a DotCom, tente novamente");
			  return null;
		  }else {
			  for(String c : alphaCells) {
				  grid.setGrid(c, 1);
			  }
			  if(comSize == 3) {
			    	dotcom = new StartupCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if(comSize == 4) {
			    	dotcom = new MicroCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if (comSize == 5) {
			    	dotcom = new JustAnotherDotCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if (comSize == 6) {
			    	dotcom = new BigCom();
			    	dotcom.setName(name);
			        dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    	((BigCom) dotcom).setup();
			    }
		  }
		  
		  return dotcom;
	  }
	
	public HumanPlayer(String name) {
		grid = new Grid();
		dotcoms = new ArrayList<DotCom>();
		this.name = name;
		DotCom teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("BigCom1", 6);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom1", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom2", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom3", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("StartupCom4", 3);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("MicroCom1", 4);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("MicroCom2", 4);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("MicroCom3", 4);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("JustAnotherDotCom1", 5);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
		while(teste == null) {
			teste = createDotCom("JustAnotherDotCom2", 5);
		}
		placeDotCom(teste);
		teste = null;
		grid.printGrid();
	}
}
