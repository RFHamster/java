package DotCom;

import helper.ComputerPlayer;
import helper.GameHelper;
import helper.HumanPlayer;
import helper.Player;

public class DotComBust {
  private GameHelper helper;
  public Player Jogadorum;
  public Player Jogadordois;
  public int countUm;
  public int countDois;
  
  public void setupUm(){
    countUm = 0;
    helper = new GameHelper();
    String escolha = helper.getUserInput("DIGITE O TIPO DO PLAYER 1: 1 -HUMANO, 2 - MAQUINA (lembre-se de escolher os dois players antes de configurar as dotcons)");
    if(Integer.parseInt(escolha) == 2) {
    	Jogadorum = new ComputerPlayer("Bot Osvaldo");
    }else{
    	escolha = helper.getUserInput("Digite seu nome");
    	Jogadorum = new HumanPlayer(escolha);
    }
    System.out.println();
  }
  public void setupDois(){
    countDois = 0;
    String escolha = helper.getUserInput("DIGITE O TIPO DO PLAYER 1: 1 -HUMANO, 2 - MAQUINA");
    if(Integer.parseInt(escolha) == 2) {
    	Jogadordois = new ComputerPlayer("Bot Kleber");
    }else {
    	escolha = helper.getUserInput("Digite seu nome");
    	Jogadordois = new HumanPlayer(escolha);
    }
    System.out.println();
  }
  
  public void novoTurno() {
      System.out.println("Digite Sua Jogada (Jogador Um)");
      Jogadordois.takeTurn(Jogadorum.Guess());
      countUm++;
      if(!Jogadordois.getDotcoms().isEmpty()) {
    	  System.out.println("Digite Sua Jogada (Jogador dois)");
        Jogadorum.takeTurn(Jogadordois.Guess());
        countDois++;
      }
    if(Jogadorum.getDotcoms().isEmpty() || Jogadordois.getDotcoms().isEmpty()){
      finishGame();
    }
    
  }

  public void finishGame() {
    if(Jogadorum == null|| Jogadordois == null){
      return;
    }
	  if(Jogadorum.getDotcoms().isEmpty()) {
		  System.out.println(Jogadordois.getName() + " ganhou o jogo!");
	  }else if(Jogadordois.getDotcoms().isEmpty()){
		  System.out.println(Jogadorum.getName() + " ganhou o jogo!");
	  }
    System.out.println("Jogo terminado após " + Jogadorum.getName() + "- " + countUm + " jogadas e " + Jogadordois.getName() + " - " + countDois + " jogadas");
  }
  
  
}
