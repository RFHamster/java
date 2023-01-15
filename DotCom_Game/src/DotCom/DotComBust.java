package DotCom;

import helper.ComputerPlayer;
import helper.GameHelper;
import helper.HumanPlayer;
import helper.Player;

public class DotComBust {
  private GameHelper helper;
  private Player PlayerOne;
  private Player PlayerTwo;
  private int countPlayerOne;
  private int countPlayerTwo;
  
  public DotComBust() {
    helper = new GameHelper();
    String escolha = helper.getUserInput("Player um sera maquina ou humano? 1 - Humano 2 - Computador");
    if(Integer.parseInt(escolha) == 2) {
    	PlayerOne = new ComputerPlayer("Computador 1");
    }else if(Integer.parseInt(escolha) == 1) {
    	escolha = helper.getUserInput("Digite seu nome");
    	PlayerOne = new HumanPlayer(escolha);
    }
    System.out.println();
    escolha = helper.getUserInput("Player dois sera maquina ou humano? 1 - Humano 2 - Computador");
    if(Integer.parseInt(escolha) == 2) {
    	PlayerTwo = new ComputerPlayer("Computador 2");
    }else if(Integer.parseInt(escolha) == 1) {
    	escolha = helper.getUserInput("Digite seu nome");
    	PlayerTwo = new HumanPlayer(escolha);
    }
    System.out.println();
    countPlayerOne = 0;
    countPlayerTwo = 0;
  }
  
  // Inserir o m�todo para iniciar o jogo, apresentar as regras, receber as jogadas do usu�rio, processar e informar o resultado de cada jogada, apresentar os resultados finais
  public void start() {
    System.out.println("Objetivos do jogo...");
    do {
      System.out.println("Player One - Informe a jogada");
      countPlayerOne++;
      PlayerTwo.sufferTurn(PlayerOne.takeTurn());
      if(!PlayerTwo.getDotcoms().isEmpty()) {
    	  System.out.println("Player Two - Informe a jogada");
          countPlayerTwo++;
          PlayerOne.sufferTurn(PlayerTwo.takeTurn());
      }
    } while (!PlayerOne.getDotcoms().isEmpty() && !PlayerTwo.getDotcoms().isEmpty());
    finishGame();
  }

// Inserir o m�todo para apresentar os resultados do jogo  
  public void finishGame() {
	  if(PlayerOne.getDotcoms().isEmpty()) {
		  System.out.println("Player Two ganhou o jogo!!!");
	  }else {
		  System.out.println("Player One ganhou o jogo!!!");
	  }
    System.out.printf("Jogo terminado ap�s Player One - " + countPlayerOne + " jogadas e Player Two - " + countPlayerTwo + " jogadas");
  }
  
  
}
