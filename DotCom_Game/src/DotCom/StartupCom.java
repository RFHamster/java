package DotCom;

public class StartupCom extends DotCom{

  public StartupCom(String name){
    this.name = name;
  }
  
	public String hitMessage() {
		return "A " + name + " foi acertada";
	}
}
