/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;

/**
 *
 * @author Misa
 */
public class Sachovnice {
    
    private Policko [][] poleP;
    private int x = 8;//velikost pole
    private int y = 8;
            
    public Sachovnice(Policko [][] pol){
        this.poleP = new Policko[8][8];
        this.poleP = pol;
        Kamen km = new Kamen();
            km.setSize(40, 40);
            km.setBarva(Color.BLUE);
        //kvuli sachovnici, meni se podle radku zacatek barveni
         poleP[5][5].setVisible(false);
         
        
        
    }
   
}
