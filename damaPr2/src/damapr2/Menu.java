/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Misa
 */
public class Menu extends JFrame{
    
    private Container kontejner;
    private JLabel txVyber;
    private JPanel kont2;
    private JButton[] rbVyber = new JButton[5];
    private JTextField hrac1; 
    private JTextField hrac2; 
    private JComboBox vyberB;
    private JComboBox vyberB2;
    
    private String vyberHry = ""; // typ hry true s PC, false s druhym hracem
    private Hra hraN; 
    private int x = 8;//pocet tlacitek na ose X
    private int y = 8;//pocet tlacitek na ose Y
    private int sirka; //sirka jednoho tlacitka
    private int odsazeni; // odsazeni od kraje
    private int index; // index tlacitka
    private boolean pom = true; // pomocna pro vytvoreni sachovnice
    private Policko[][] polHry  = new Policko[8][8];
    
    public Menu() throws IOException{
        super();
        this.setBounds(200, 200, 600, 600);
        this.setTitle("Dáma");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100,100);
        this.setResizable(false);
        try {
            this.setIconImage(ImageIO.read(this.getClass().getResource("/Ikony/Ikona.png")));
            } catch (IOException ex) {}
        this.setLayout(null);
        
       
        this.kontejner = getContentPane();
        this.kontejner.setBackground(Color.getHSBColor(20, 30, 40));
        setContentPane(kontejner);
        
       
        this.txVyber = new JLabel("Dáma");
        this.txVyber.setBounds(190, 50, 600, 70);
        this.txVyber.setFont(new Font("Serif", Font.ITALIC, 88));
        this.kontejner.add(this.txVyber);
        
        volba();
        
    }
     public void volba() {
      //   Obsluha o = new Obsluha("R");
         
        this.rbVyber[2] = new JButton("Načti hru");
        this.rbVyber[2].setFont(new Font("Serif", Font.BOLD, 22));
        this.rbVyber[2].setBounds(100, 200, 400, 50);
        this.rbVyber[2].setBackground(Color.CYAN);
        this.rbVyber[2].addActionListener(new Obsluha("oh"));
        this.kontejner.add(rbVyber[2]);
        
        this.rbVyber[3] = new JButton("Nová hra");
        this.rbVyber[3].setFont(new Font("Serif", Font.BOLD, 22));
        this.rbVyber[3].setBounds(100, 300, 400, 50);
        this.rbVyber[3].setBackground(Color.CYAN);
        this.rbVyber[3].addActionListener(new Obsluha("nh"));
        this.kontejner.add(rbVyber[3]);
        
     }
    

   public void novaHra() {
       
      this.rbVyber[2].setVisible(false);
      this.rbVyber[3].setVisible(false);
      //kontejner.validate(); 
      kontejner.repaint(); 
        
        this.rbVyber[0] = new JButton();
        this.rbVyber[0].setBounds(100, 300, 400, 50);
        this.rbVyber[0].setFont(new Font("Serif", Font.BOLD, 22));
        this.rbVyber[0].setText("PC-Hráč");
        this.rbVyber[0].setBackground(Color.CYAN);
        this.rbVyber[0].addActionListener(new Obsluha("t0"));
        this.kontejner.add(this.rbVyber[0]);
        
        this.rbVyber[1] = new JButton();
        this.rbVyber[1].setBounds(100, 400, 400, 50);
        this.rbVyber[1].setFont(new Font("Serif", Font.BOLD, 22));
        this.rbVyber[1].setText("Hra pro dva");
        this.rbVyber[1].setBackground(Color.CYAN);
        this.rbVyber[1].addActionListener(new Obsluha("t1"));
        this.kontejner.add(this.rbVyber[1]);
       
        this.txVyber = new JLabel("Vyberte typ hry");
        this.txVyber.setBounds(150, 200, 600, 70);
        this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 42));
        this.kontejner.add(this.txVyber);
       
   
   }
   
    public void nastavVl() {
       
      this.rbVyber[0].setVisible(false);
      this.rbVyber[1].setVisible(false);
      this.txVyber.setVisible(false);
      kontejner.validate(); 
      kontejner.repaint(); 
        
        this.txVyber = new JLabel("Jméno prvního hráče:");
        this.txVyber.setBounds(200, 150, 600, 50);
        this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 22));
        this.kontejner.add(this.txVyber);
      
        
        this.hrac1 = new JTextField("Jméno");
        this.hrac1.setBounds(220, 200, 150, 30);
        this.kontejner.add(this.hrac1);
        
        
        this.txVyber = new JLabel("Barva kamenů:");
        this.txVyber.setBounds(100, 238, 150, 30);
        this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
        this.kontejner.add(this.txVyber);
        
        this.vyberB = new JComboBox();
        this.vyberB.setSize(2, 1);
        this.vyberB.addItem("Červená");
        this.vyberB.addItem("Modrá");
        this.vyberB.setBounds(245, 240, 100, 30);
        this.kontejner.add(this.vyberB);
        
        this.txVyber = new JLabel("Jméno druhého hráče:");
        this.txVyber.setBounds(200, 280, 600, 50);
        this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 22));
        
        this.kontejner.add(this.txVyber);
        
        this.hrac2 = new JTextField("Jméno");
        this.hrac2.setBounds(220, 330, 150, 30);
        if("0".equals(this.vyberHry)){this.hrac2.setOpaque(false);this.hrac2.setEditable(false);this.hrac2.setText("PC-player");
        }
        this.kontejner.add(this.hrac2);
        
        this.rbVyber[4] = new JButton();
        this.rbVyber[4].setBounds(100, 430, 400, 50);
        this.rbVyber[4].setFont(new Font("Serif", Font.BOLD, 22));
        this.rbVyber[4].setText("Spusť");
        this.rbVyber[4].setBackground(Color.CYAN);
        this.rbVyber[4].addActionListener(new Obsluha("sp"));
        this.kontejner.add(this.rbVyber[4]);
       
        
       
   
   }    

  
  
        
   
     class Obsluha  implements ActionListener {
         
            String co;
            public Obsluha(String c) {
                this.co = c;
            }
             
             public void actionPerformed(ActionEvent e) {
             switch (co) {
                case "t0": 
                   vyberHry="0";
                   nastavVl();
                   break;
                case "t1": 
                   vyberHry="1";
                   nastavVl();
                   break;
                    
                 case "ot": 
                   break;
                        
                 case "nh": 
                      
                   novaHra();
                   break;
                      
                  case "sp": 
                      
                     hraN = new Hra(hrac1.getText(),hrac2.getText(),vyberB.getSelectedItem().toString(),vyberHry);
                     vytvorS();
                     hraN.hrPol(polHry);
                     break;  
                    
                }
                
          }
            
        }
      class ObsluhaPol implements ActionListener {
            private Policko pol;
            
            public ObsluhaPol(Policko p) {
                this.pol = p;
            }
             
             public void actionPerformed(ActionEvent e) {
                 hraN.klikNaTl(this.pol);
             } 
          }
            
     public void vytvorS() {
         
           this.sirka = 50; 
           this.odsazeni = 100; 
           this.index = 0;
           popisP();
         
           for (int q = 0; q < (this.y); q++)
            {

                for (int i = 0; i < (this.x); i++)
                {
                   Policko pol = new Policko(i,q);
                 

           
            int l = this.odsazeni + (this.index % this.x) * this.sirka; 
            int e = (this.odsazeni-20) + (this.index / this.y) * this.sirka;
            this.index++;
            
             //Vytvoření tlačítka 
            pol.setLocation(l,e);
            pol.setSize(this.sirka, this.sirka);
            if(pom ==true) {
                pol.setBarva(Color.WHITE);
                pom=false;
            }
            else {
                pol.setBarva(Color.getHSBColor(10, 10, 100));
                pom=true;
            }
            //kvuli sachovnici, meni se podle radku zacatek barveni
            if((this.index%8) == 0) {
            this.pom = !this.pom;
            }
            this.polHry[i][q] = pol;
            //přidání do labelu
            this.kontejner.add(pol);
            setContentPane(this.kontejner);
            //pridani akce - co bude po kliknuti tlacitko delat
            this.polHry[i][q].addActionListener(new ObsluhaPol(pol));
           
        }
     }
    }
     
     public void popisP () {
          kontejner.removeAll();
           kontejner.validate(); 
           kontejner.repaint(); 
           kontejner.setBackground(Color.getHSBColor(30, 50, 20));
           
           this.txVyber = new JLabel("Hráč:"+hraN.getHrac1().getJmeno());
           this.txVyber.setBounds(10, 10, 150, 30);
           this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
           this.kontejner.add(this.txVyber);
           
           this.txVyber = new JLabel("Kamenů:");
           this.txVyber.setBounds(10, 40, 100, 30);
           this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
           this.kontejner.add(this.txVyber);
           
           this.hrac1 = new JTextField();
           this.hrac1.setBounds(85, 40, 30, 30);
           this.hrac1.setOpaque(false);
           this.hrac1.setEditable(false);
           this.kontejner.add(this.hrac1);
           
           this.txVyber = new JLabel("Hráč:"+hraN.getHrac2().getJmeno());
           this.txVyber.setBounds(10, 500, 150, 30);
           this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
           this.kontejner.add(this.txVyber);
           
           this.txVyber = new JLabel("Kamenů:");
           this.txVyber.setBounds(10, 530, 100, 30);
           this.txVyber.setFont(new Font("Serif", Font.CENTER_BASELINE, 18));
           this.kontejner.add(this.txVyber);
           
           this.hrac2 = new JTextField();
           this.hrac2.setBounds(85, 530, 30, 30);
           this.hrac2.setOpaque(false);
           this.hrac2.setEditable(false);
           this.kontejner.add(this.hrac2);
           
         
     }
     
}

  