package helper;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

import DotCom.DotComBust;

public class Menu extends JFrame implements ActionListener{
    public static boolean RIGHT_TO_LEFT = false;
    private JButton setup1 = null;
    private JButton setup2 = null;
    private JButton Novo = null;
    private JButton Sair = null;
    private JButton Mapas = null;
    private JButton NovaJogada = null;
    private JButton Tiros = null;
    private DotComBust game = null;
    
    public Menu() {
      initialize();
      Novo = new JButton("Novo Jogo");
      this.add(Novo, BorderLayout.PAGE_START);
      Novo.addActionListener(this);  

      NovaJogada = new JButton("Nova Jogada");
      NovaJogada.setPreferredSize(new Dimension(200, 100));
      this.add(NovaJogada, BorderLayout.CENTER);
      NovaJogada.addActionListener(this);
        
      Mapas = new JButton("Mostrar Mapas");
      this.add(Mapas, BorderLayout.LINE_START);
      Mapas.addActionListener(this);
        
      Sair = new JButton("Sair do Jogo");
      this.add(Sair, BorderLayout.PAGE_END);
      Sair.addActionListener(this);
        
      Tiros = new JButton("Mostrar Tiros");
      this.add(Tiros, BorderLayout.LINE_END);
      Tiros.addActionListener(this);
    }
    
    private void initialize(){
    	this.setTitle("DotComGame");
    	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	this.setSize(650,400);
      this.setLayout(new BorderLayout());
    	this.setVisible(true);
    }
  
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == setup1){
        game.setupUm();
      }
      if(e.getSource() == setup2){
        game.setupDois();
      }
      if(e.getSource() == Novo){
        System.out.println("Novo Jogo");
        game = new DotComBust();
        JFrame frameSetup = new JFrame();
        frameSetup.setLayout(new FlowLayout());
        frameSetup.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    	  frameSetup.setSize(300,300);
        JLabel texto = new JLabel("Explicacao");
        texto.setText("Configure os dois Setups");
        setup1 = new JButton("Setup Jogador 1");
        setup2 = new JButton("Setup Jogador 2");
        setup1.addActionListener(this);
        setup2.addActionListener(this);
        frameSetup.add(texto);
        frameSetup.add(setup1);
        frameSetup.add(setup2);
        frameSetup.setVisible(true);
      }
      if(e.getSource() == Sair){
        showMessageDialog(null, "Você saiu do jogo!");
        this.dispose();
        game.finishGame();
        System.exit(0);
      }
      if(e.getSource() == Mapas){
        System.out.println("Mapa Jogador 1");
        game.Jogadorum.getGrid().printGrid();
        System.out.println();
        System.out.println("Mapa Jogador 2");
        game.Jogadordois.getGrid().printGridEscondida();
      }
      if(e.getSource() == NovaJogada){
        System.out.println("Nova Jogada");
        game.novoTurno();
      }
      if(e.getSource() == Tiros){
        System.out.println("Tiros Efetuados: " + game.countUm + "jogadas do jogador um e " + game.countDois + " jogadas do jogador dois");
        JFrame f = new JFrame();
        f.setLayout(new FlowLayout());
        f.setSize(300, 400);
        JLabel label = new JLabel("Barra");
        JProgressBar pr = new JProgressBar();
        pr.setStringPainted(true);
        pr.setValue((game.Jogadordois.getDotcoms().size())*10);
        pr.setSize(new Dimension(100, 23));
        label.setText("Ainda falta essas DotComs (0% = Vitoria)");
        f.add(label);
        f.add(pr);
        f.setVisible(true);
      }
    }
}