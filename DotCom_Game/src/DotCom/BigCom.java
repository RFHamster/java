package DotCom;

import java.util.ArrayList;

import helper.GameHelper;

public class BigCom extends DotCom{
	private ArrayList<String> filiais = new ArrayList<String> ();
	int count = 0;
	public int distancia = 0;
	GameHelper helper = new GameHelper();

  public BigCom(String name){
    filiais.add("Filial1");
		filiais.add("Filial2");
    this.name = name;
  }
  
	public String hitMessage() {
		count++;
		String message;
		if(count == 2){
			String s = filiais.get(0);
			filiais.remove(0);
			count = 0;
			message = "Voce Acertou a " + name + " e removeu a filial " + s;
		}else {
			message = "Voce Acertou a " + name;
		}
		return message;
	}

	public void setup() {
		distancia = helper.convertAlphatoNuber(locationCells.get(1)) - helper.convertAlphatoNuber(locationCells.get(0));
	}
	
}
