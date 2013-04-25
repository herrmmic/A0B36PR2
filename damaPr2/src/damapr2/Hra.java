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
   
    
    private String hraje ="";
    private Kamen predK;
    
    
   public Hra(String jm1, String jm2, String br, String typ) {
        if(jm1.equals(jm2))jm2+="2";
        if("Červená".equals(br)){ 
            this.hrac1 = new Hrac(jm1,Color.red);
            this.hrac2 = new Hrac(jm2,Color.blue);
        }
        else {
            this.hrac1 = new Hrac(jm1,Color.blue);
            this.hrac2 = new Hrac(jm2,Color.red);
        }
        this.typHr = typ;
        this.hraje = hrac1.getJmeno();
    }

    public Hrac getHrac1() {
        return hrac1;
    }

    public Hrac getHrac2() {
        return hrac2;
    }
   
   public void hrPol (Policko[][] pol) {
       this.hrPole = new Sachovnice(pol);
       this.hrPole.vytvorKam(this.hrac1,this.hrac2);
       
   }
   
    public void klikNaTl(Policko aktPol) {
       
        if(this.predK !=null){
            if(this.hraje.equals(this.hrac1.getJmeno())){
                
                 if(((aktPol.getYova()-1)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-1))||
                         (aktPol.getXova()==(predK.getXova()+1)))&&(this.hrPole.vratKam(aktPol.getXova(), aktPol.getYova())==null)){
                                     this.hrPole.obarvi(aktPol, predK);
                                     this.predK = null;
                                     this.hraje = this.hrac2.getJmeno();
                                  }
                 
                 
                 
                                }
            
            
            else if(this.hraje.equals(this.hrac2.getJmeno())){
                
                 if(((aktPol.getYova()+1)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-1))||
                         (aktPol.getXova()==(predK.getXova()+1)))&&(this.hrPole.vratKam(aktPol.getXova(), aktPol.getYova())==null)){
                                     this.hrPole.obarvi(aktPol, predK);
                                     this.predK = null;
                                     this.hraje = this.hrac1.getJmeno();
                                  }
                                }
                
                
                
            }
            
            
            
        // this.predK = null;   
        
        
            this.predK = this.hrPole.vratKam(aktPol.getXova(), aktPol.getYova());
            
        
        
        //this.hrPole.aktualizujPole();
        
    }

    
    
    
}

