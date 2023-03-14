package DotCom;

import java.util.ArrayList;

abstract public class DotCom {
	
	protected ArrayList<String> locationCells;
	protected String name;

  public String checkYourself(String guess) {
		 String result = "miss";
		 for(String p : locationCells) {
		   if (p.equals(guess)) {
		     result = "hit";
		     break;
		   }
		 }
		 if (result == "hit") {
		   locationCells.remove(guess);
		 }
		 if (locationCells.isEmpty()) {
		   result = "kill";
		 }
		 return result;	
	}
  
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<String> getLocationCells() {
		return locationCells;
	}
	
	public void setLocationCells(ArrayList<String> cells) {
		this.locationCells = cells; 
	}
	
	public abstract String hitMessage();
	
	public String killMessage() {
		return "A " + name + " morreu";
	}
}