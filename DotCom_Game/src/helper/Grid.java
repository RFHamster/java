package helper;

import java.util.ArrayList;

public class Grid{
	protected int gridLength = 10;
	protected int gridSize = 100;
	protected String []grid;
	public int comCount = 0;
	private GameHelper helper = new GameHelper();

	public Grid(){
		grid = new String[gridSize];
    clearGrid();
  }
  
	public void printGrid() {
    System.out.println("v - Vazio, e - Errou, a - Acertou, d - DotCom");
    System.out.println("- A B C D E F G H I J");
		for(int i = 0; i < gridLength; i++) {
      System.out.print(i + " ");
			for(int j = i*gridLength; j < (i+1)*gridLength; j++) {
				System.out.print(grid[j] + " ");
			}
			System.out.println();
		}
	}

  public void printGridEscondida() {
    System.out.println("v - Vazio, e - Errou, a - Acertou");
		for(int i = 0; i < gridLength; i++) {
			for(int j = i*gridLength; j < (i+1)*gridLength; j++) {
        if(grid[j] == "d"){
          System.out.print("v ");
        }else{
          System.out.print(grid[j] + " ");
        }
			}
			System.out.println();
		}
	}

  public ArrayList<String> movePositions(ArrayList<String> locationCells, int space, int move) {
  		String s;
  		int temp;
  		if(move == 3 & !gridOccupied(helper.convertAlphatoNuber(locationCells.get(0)) - space)) {
  			for(int i = 0; i < locationCells.size(); i++){
  				s = locationCells.get(0);
  				temp = helper.convertAlphatoNuber(s) - space;
  				setGrid(temp, "d");
  				locationCells.add(helper.convertNumberToAlpha(temp));
  				setGrid(s,"v");
  				locationCells.remove(s);
  			}
  			System.out.println("A DotCom moveu para frente");
  		}else if (move == 2 & !gridOccupied(helper.convertAlphatoNuber(locationCells.get(locationCells.size()-1)) + space)) {
  			for(int i = 0; i < locationCells.size(); i++){
  				s = locationCells.get(0);
  				temp = helper.convertAlphatoNuber(s) + space;
  				setGrid(temp, "d");
  				locationCells.add(helper.convertNumberToAlpha(temp));
  				setGrid(s,"v");
  				locationCells.remove(s);
  			}
  			System.out.println("A DotCom moveu para tras");
  		}else {
  			System.out.println("A DotCom nao se moveu");
  		}
  		return locationCells;
  	}
  
	public int getGridSize() {
		return gridSize;
	}
	
	public int getGridLength() {
		return gridLength;
	}
  
	public void setGridLength(int gridLength) {
		this.gridLength = gridLength;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	public boolean gridOccupied(int x) {
		  if(x<0 || x >= 100) {
			  return true;
		  }
		  if(grid[x] == "d"){
			  return true;
		  }else {
			  return false;
		  }
	 }
	
		
	public void setGrid(String local, String escrita) {
		int number = helper.convertAlphatoNuber(local);
		grid[number] = escrita;
	}
	
	public void setGrid(int local, String escrita) {
		grid[local] = escrita;
	}
	
	public String getGrid(int number) {
		return grid[number];
	}
	
	public void clearGrid() {
		for(int i = 0; i < gridSize; i++) {
			grid[i] = "v";
		}
	}
	
}
