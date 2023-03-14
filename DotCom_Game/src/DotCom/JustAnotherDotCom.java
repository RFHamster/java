package DotCom;

import java.util.ArrayList;

public class JustAnotherDotCom extends DotCom{
	private ArrayList<String> contratantes = new ArrayList<String> ();

	public JustAnotherDotCom(String name) {
		contratantes.add("Loja1");
		contratantes.add("Loja2");
		contratantes.add("Loja3");
		contratantes.add("Loja4");
		contratantes.add("Loja5");
    this.name = name;
	}
	
	public String hitMessage() {
		String c = contratantes.get(0);
		contratantes.remove(0);
		return "A " + name + "foi acertada e perdeu a " + c;
	}
	
	
}
