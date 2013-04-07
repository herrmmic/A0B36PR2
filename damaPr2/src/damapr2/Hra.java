/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Misa
 */
public final class Hra {
    
     
     
    private Hrac hrac1;
    private Hrac hrac2;
    private Sachovnice hrPole; 
    private String typHr = "";
   
    
   public Hra(String jm1, String jm2, String br, String typ) {
        
        if("Červená".equals(br)){ 
            this.hrac1 = new Hrac(jm1,Color.red);
            this.hrac2 = new Hrac(jm2,Color.blue);
        }
        else {
            this.hrac1 = new Hrac(jm1,Color.blue);
            this.hrac2 = new Hrac(jm2,Color.red);
        }
        this.typHr = typ;
    }
   
   public void hrPol (Policko[][] pol) {
       hrPole = new Sachovnice(pol);
       
   }
   
    
    
    
    
}

