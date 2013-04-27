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
    private Kamen [] [] poleK;
    private int x = 8;//velikost pole
    private int y = 8;
            
    public Sachovnice(Policko [][] pol){
        this.poleP = new Policko[8][8];
        this.poleK = new Kamen[8][8];
        this.poleP = pol;
        
     }
    
    
    public void vytvorKam(Hrac hr1, Hrac hr2) {
         int x = 0;
        for (int i = 0; i < 8; i++) {
           
                for (; x < 8; x+=2) {
                    if(i<2){
                        poleK[x][i] = new Kamen(x,i,hr1);
                        poleP[x][i].setBarva(hr1.getBarva());
                    }
                    else {
                        poleK[x][i] = new Kamen(x,i,hr2);
                        poleP[x][i].setBarva(hr2.getBarva());
                    }
                }
                // nastaveni barveni od zacatku souradnice X nebo az od druheho buttonu
                if((i==0)||(i==6)){x=1;}
                else {x=0;}
                if(i == 1){
                    i +=4;
                    x=0;
            }
       } 
    }
    
    
    
    public Policko vratPol (int x, int y) {
        return poleP[x][y]; 
    }
    
    public Kamen vratKam (int x, int y) {
        return poleK[x][y]; 
    }
    
    public void  obarvi(Policko aktPol, Kamen predK) {
        this.poleP[predK.getXova()][predK.getYova()].setBarva(Color.WHITE);
        this.poleP[aktPol.getXova()][aktPol.getYova()].setBarva(predK.getBarva());
        this.poleK[predK.getXova()][predK.getYova()].posunSe(this.poleK , aktPol);  
    }

   public void odeber (int x, int y) {
       this.poleK[x][y]=null;
       this.poleP[x][y].setBarva(Color.WHITE);
   }
    
    
}
