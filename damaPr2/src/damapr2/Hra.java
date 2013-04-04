/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

import java.awt.Color;

/**
 *
 * @author Misa
 */
public class Hra {
    
    private Hrac hrac1;
    private Hrac hrac2;
    
    public Hra (String jm1, String jm2, String br1, boolean typ) {
        
        if("Červená".equals(br1)){ 
            hrac1 = new Hrac(jm1,Color.red);
            hrac2 = new Hrac(jm2,Color.blue);
        }
        else {
            hrac1 = new Hrac(jm1,Color.blue);
            hrac2 = new Hrac(jm2,Color.red);
        }
        
    }
    
    
    
    
}

