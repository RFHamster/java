package helper;

import java.util.ArrayList;

public class Grid{
	protected int gridLength = 10;
	protected int gridSize = 100;
	protected int []grid;
	public int comCount = 0;
	private GameHelper helper = new GameHelper();

	public Grid(){
		grid = new int[gridSize];
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
		  if(x<0 || grid[x] == 1) {
			  return true;
		  }else {
			  return false;
		  }
	 }
	
	
		
	public void setGrid(String place, int num) {
		int number = helper.convertAlphatoNuber(place);
		grid[number] = num;
	}
	
	public void setGrid(int place, int num) {
		grid[place] = num;
	}
	
	public int getGrid(int number) {
		return grid[number];
	}
	
	public void clearGrid() {
		for(int i = 0; i < gridSize; i++) {
			grid[i] = 0;
		}
	}
	
	public ArrayList<String> createDotCom(int comSize) {
		  ArrayList<String> alphaCells = new ArrayList<String>();                                 
		  int [] coords = new int[comSize];                  
		  int attempts = 0;                                 
		  boolean success = false;                          
		  int location = 0;                               
		    
		  //se a com for impar ela fica na vertical, se for par na horizontal
		  comCount++;                                       
		  int incr = 1;                                     
		  if ((comCount % 2) == 1) {                   
		    incr = gridLength;                              
		  }
		    
		  //tentar as posicoes ate arumar uma posicao sem problemas para a dotcom
		  while (!success & attempts++ < 100 ) {          
		  location = (int) (Math.random() * gridSize);
			int x = 0;                                      
		        success = true;                  
		        while (success && x < comSize) {       
		          if (grid[location] == 0) {                  
		             coords[x++] = location;               
		             location += incr;                   
		             if (location >= gridSize){ //passou da grid            
		               success = false;                
		             }
		             if (x>0 & (location % gridLength == 0)) { //passou da grid
		               success = false;                       
		             }
		          } else {//grid ocupada
		              success = false;                      
		          }
		        }
		    }                                            
		
		    //converter de vetor para alpha (de "12" para "a2")
		    int x = 0;
		    while (x < comSize) {
		      grid[coords[x]] = 1;
		      alphaCells.add(helper.convertNumberToAlpha(coords[x]));
		      x++; 
		    }
		    
		    return alphaCells;
	  }
	
}
