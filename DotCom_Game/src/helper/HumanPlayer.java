package helper;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DotCom.BigCom;
import DotCom.DotCom;
import DotCom.JustAnotherDotCom;
import DotCom.MicroCom;
import DotCom.StartupCom;

public class HumanPlayer extends Player implements ActionListener{
  private int contadorDotCom;
  JFrame j;
  JTextField tf;

  
	public String Guess() {
		String jogada = helper.getUserInput("Informe a jogada");
	  System.out.println();
		return jogada;
	}
	
	public DotCom posicionarDotCom(String name, int comSize, String position) {
		  DotCom dotcom = null;
		  int [] coords = new int[comSize];
		  boolean success = true;
		  ArrayList<String> alphaCells = new ArrayList<String>();
    
		  while(helper.convertAlphatoNuber(position) >= 100 || helper.convertAlphatoNuber(position) < 0) {
			  System.out.println("Fora da Grid");
			  position = helper.getUserInput("Tente Novamente");
		  }
		  int espaco = Integer.parseInt(helper.getUserInput("1: Horizontal, 2: Vertical"));
		  if(espaco != 1) {
			  espaco = 10;
		  }
      int direcao = Integer.parseInt(helper.getUserInput("1: Direita/Embaixo, 2: Esquerda/Acima"));
      if(direcao != 1) {
  			  espaco = espaco * (-1);
  		}
		  int positionNumber = helper.convertAlphatoNuber(position);
		  int x = 0;
		  while (success && x < comSize){ 
        if(positionNumber < 0){
          break;
        }
	      if (grid.getGrid(positionNumber) == "v") {                  
          coords[x] = positionNumber;
          if(x<comSize){
            positionNumber += espaco;                      
    	      if(positionNumber >= grid.getGridSize() || positionNumber < 0){         
    	        success = false;
    	      }
            if (espaco == -1 && positionNumber % grid.getGridLength() == 0 && x<comSize-1) {
		          success = false;
		        }
    	      if (espaco == 1 & x > 0 & (positionNumber-espaco) % grid.getGridLength() == 0) {
    	        success = false;
    	      }
            x += 1;
    	    } 
        }else {
    	    success = false;
    	  }
	    }
		  if(success == false) {
			  System.out.println("Impossivel fazer a DotCom, tente novamente");
			  return null;
		  }else{
			  x = 0;
			  while (x < comSize) {
			      grid.setGrid(coords[x], "d");
			      alphaCells.add(helper.convertNumberToAlpha(coords[x]));
			      x++; 
			  }
			  if(comSize == 3) {
			    	dotcom = new StartupCom(name);
			      dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if(comSize == 4) {
			    	dotcom = new MicroCom(name);
			      dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if (comSize == 5) {
			    	dotcom = new JustAnotherDotCom(name);
			      dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    }else if (comSize == 6) {
			    	dotcom = new BigCom(name);
			      dotcom.setLocationCells(alphaCells);
			    	System.out.print(alphaCells);
			    	((BigCom) dotcom).setup();
			    }
		  }
		  return dotcom;
	  }
	
	public HumanPlayer(String name) {
    contadorDotCom = 1;
		grid = new Grid();
		dotcoms = new ArrayList<DotCom>();
		this.name = name;
		
    j = new JFrame();
    j.setLayout(new FlowLayout());
    j.setSize(300, 500);
    j.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    JLabel label = new JLabel("DotCom");
    label.setText("Digite a Posicao da DotCom");
		j.add(label);
    tf = new JTextField(20);
    j.add(tf);
    JButton button = new JButton("Enviar");
    button.addActionListener(this);
    j.add(button);
    j.setVisible(true);
	}
  public void actionPerformed(ActionEvent e){
    DotCom dot = null;
    grid.printGrid();
		if(contadorDotCom == 1){
      while(dot == null) {
			 dot = posicionarDotCom("StartupCom1", 3, tf.getText());
		  }
      placeDotCom(dot);
    }else if(contadorDotCom == 2){
      while(dot == null) {
  			dot = posicionarDotCom("StartupCom2", 3, tf.getText());
  		}
  		placeDotCom(dot);
    }else if(contadorDotCom == 3){
      while(dot == null) {
  			dot = posicionarDotCom("StartupCom3", 3,tf.getText());
  		}
  		placeDotCom(dot);
    }else if(contadorDotCom == 4){
      while(dot == null) {
  			dot = posicionarDotCom("StartupCom4", 3,tf.getText());
  		}
      placeDotCom(dot);
    }else if(contadorDotCom == 5){
      while(dot == null) {
  			dot = posicionarDotCom("MicroCom1", 4,tf.getText());
  		}
      placeDotCom(dot);
    }else if(contadorDotCom == 6){
      while(dot == null) {
  			dot = posicionarDotCom("MicroCom2", 4,tf.getText());
  		}
  		placeDotCom(dot);
    }else if(contadorDotCom == 7){
      while(dot == null) {
  			dot = posicionarDotCom("MicroCom3", 4,tf.getText());
  		}
      placeDotCom(dot);
    }else if(contadorDotCom == 8){
      while(dot == null) {
  			dot = posicionarDotCom("JustAnotherDotCom1", 5,tf.getText());
  		}
  		placeDotCom(dot);
    }else if(contadorDotCom == 9){
      while(dot == null) {
  			dot = posicionarDotCom("JustAnotherDotCom2", 5,tf.getText());
  		}
  		placeDotCom(dot);
    }else if(contadorDotCom == 10){
      while(dot == null) {
  			dot = posicionarDotCom("BigCom1", 6,tf.getText());
  		}
  		placeDotCom(dot);
    }else{
      System.out.println("Configuracao concluida, favor fechar a janela");
      j.dispose();
    }
    contadorDotCom++;
  }

}
