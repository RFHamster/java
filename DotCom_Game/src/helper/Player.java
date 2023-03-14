package helper;

import java.util.ArrayList;

import DotCom.BigCom;
import DotCom.DotCom;

public abstract class Player {
	protected String name;
	protected Grid grid;
	protected ArrayList<DotCom> dotcoms;
	protected GameHelper helper = new GameHelper();
	
	public ArrayList<DotCom> getDotcoms() {
		return dotcoms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

  public abstract String Guess();

	public String takeTurn(String guess) {
		grid.setGrid(guess, "e");
		String result = "miss";
	      DotCom hitted = null;
	      for(DotCom dotcom : dotcoms) {
	        result = dotcom.checkYourself(guess);   
	        if (result != "miss") {
	          hitted = dotcom;
	          grid.setGrid(guess, "a");
	          if(result == "hit") {
	        	  if(hitted instanceof BigCom) {
	        		  int random = (int)(Math.random() * 4);
	        		  dotcom.setLocationCells(grid.movePositions(dotcom.getLocationCells(), ((BigCom) dotcom).distancia, random));
	        	  }else {
	        		  System.out.println(dotcom.hitMessage()); 
	        	  }	
	          }else {
	        	  System.out.println(dotcom.killMessage());
	          }
	          
	          break;
	        }
	        
	      }
	      if (result == "kill") {
	    	  dotcoms.remove(hitted);
	      }else if(result == "miss"){
	    	  System.out.println(result); 
	      }
	      return result;
	}
  
	public boolean placeDotCom(DotCom dotcom) {
		dotcoms.add(dotcom);
		return true;
	}
	
}

