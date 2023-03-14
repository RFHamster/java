package helper;

import java.util.ArrayList;

import DotCom.BigCom;
import DotCom.DotCom;
import DotCom.JustAnotherDotCom;
import DotCom.MicroCom;
import DotCom.StartupCom;

public class ComputerPlayer extends Player{
	private ArrayList<String> jogadas;
	private int index;	
	
	private void novaDot(String name, int size) {
	    DotCom dotcom = null;
	    ArrayList<String> colinha;
	    if(size == 3) {
	    	dotcom = new StartupCom(name);
	    	colinha = createDotCom(size);
	      dotcom.setLocationCells(colinha);
	    	System.out.print(colinha);
	    }else if(size == 4) {
	    	dotcom = new MicroCom(name);
	    	colinha = createDotCom(size);
	      dotcom.setLocationCells(colinha);
	    	System.out.print(colinha);
	    }else if (size == 5) {
	    	dotcom = new JustAnotherDotCom(name);
	    	colinha = createDotCom(size);
	    	dotcom.setLocationCells(colinha);
	    	System.out.print(colinha);
	    }else if (size == 6) {
	    	dotcom = new BigCom(name);
	    	colinha = createDotCom(size);
	    	dotcom.setLocationCells(colinha);
	    	((BigCom) dotcom).setup();
	    	System.out.print(colinha);
	    }
	    placeDotCom(dotcom);
	  }
  
	public String Guess() {
		String jogada = jogadas.get((int) (Math.random() * index));
		return jogada;
	}
	public ArrayList<String> createDotCom(int comSize) {
		  ArrayList<String> alphaCells = new ArrayList<String>();
		  int [] coords = new int[comSize];
		  int attempts = 0;   
		  boolean success = false;
		  int location = 0;                               
		    
		  grid.comCount++;                                       
		  int incr = 1;                                     
		  if ((grid.comCount % 2) == 1) {                   
		    incr = grid.getGridLength();                              
		  }
		    
		  while (!success & attempts++ < 100 ) {
		  location = (int) (Math.random() * grid.getGridSize());
			int x = 0;                                      
		        success = true;                  
		        while (success && x < comSize) {       
		          if (grid.getGrid(location) == "v") {                  
		             coords[x++] = location;               
		             location += incr;                   
		             if (location >= grid.getGridSize()){          
		               success = false;                
		             }
		             if (x>0 & (location % grid.getGridLength() == 0)) {
		               success = false;                       
		             }
		          } else {
		              success = false;                      
		          }
		        }
		    }                                            
    
		    int x = 0;
		    while (x < comSize) {
		      grid.setGrid(coords[x], "d");
		      alphaCells.add(helper.convertNumberToAlpha(coords[x]));
		      x++; 
		    }
		    
		    return alphaCells;
	  }
	
	public ComputerPlayer(String name) {
		grid = new Grid();
		dotcoms = new ArrayList<DotCom>();
		this.name = name;
		this.jogadas = new ArrayList<String>();
    novaDot("StartupCom1", 3);
    novaDot("StartupCom2", 3);
    novaDot("StartupCom3", 3);
  	novaDot("StartupCom4", 3);
  	novaDot("MicroCom1", 4);
  	novaDot("MicroCom2", 4);
   	novaDot("MicroCom3", 4);
   	novaDot("JustAnotherDotCom1", 5);
   	novaDot("JustAnotherDotCom2", 5); 
    novaDot("BigCom1", 6);
    for(int i = 0; i < grid.getGridSize(); i++) {
			jogadas.add(helper.convertNumberToAlpha(i));
		}
    index = grid.gridSize;
	}

	
	
}
