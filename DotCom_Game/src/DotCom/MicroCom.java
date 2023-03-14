package DotCom;

public class MicroCom extends DotCom{
	private String contratante = "Contratante1";
	private int count = 4;

  public MicroCom(String name){
    this.name = name;
  }
  
	public String hitMessage() {
		count--;
		return "Por favor jogador se voce me acertar mais " + count + " vezes, eu perco meu contrato com a " + contratante;
	}
}