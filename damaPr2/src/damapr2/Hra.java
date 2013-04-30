/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
    private Kamen predK, aktPol;
    
    
   public Hra(String jm1, String jm2, String br, String typ) {
        if(jm1.equals(jm2)){jm2+="2";}
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
       int pom = 1;
        
        if(this.predK !=null){
            
             if((this.hrPole.vratKam(aktPol.getXova(), aktPol.getYova())==null)){
                 
            if((this.hraje.equals(this.hrac1.getJmeno())&& this.hraje.equals(this.predK.getKoho().getJmeno()))){
                //zmena v damu
                if((aktPol.getYova()==7)&&(this.predK.isDama() == false)) {
                    this.predK.setDama(true);
                    this.predK.setBarva(Color.getHSBColor(0, 150, 100));
                }
                
                 if(((aktPol.getYova()-1)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-1))||
                         (aktPol.getXova()==(predK.getXova()+1)))){
                                     this.hrPole.obarvi(aktPol, predK);
                                     this.hraje = this.hrac2.getJmeno();
                                  }
                 else if(((aktPol.getYova()-2)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-2))||(aktPol.getXova()==(predK.getXova()+2)))){
                            //zjisteni jestli na pozici je kamen protihrace
                            if(aktPol.getXova()>predK.getXova()){pom-=2;}
                            if(this.hrPole.vratKam(aktPol.getXova()+pom, aktPol.getYova()-1).getKoho() == this.hrac2){
                            this.hrPole.obarvi(aktPol, predK);
                            this.hrPole.odeber(aktPol.getXova()+pom, aktPol.getYova()-1);
                            this.hraje = this.hrac2.getJmeno();
                            }
                 
                                }
                 else if(this.predK.isDama()==true) {
                     if(((aktPol.getYova()+1)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-1))||
                         (aktPol.getXova()==(predK.getXova()+1)))){
                                      this.hrPole.obarvi(aktPol, predK);
                                      this.predK = null;
                                      this.hraje = this.hrac2.getJmeno();
                                  }
                     else if(((aktPol.getYova()+2)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-2))||(aktPol.getXova()==(predK.getXova()+2)))){
                            //zjisteni jestli na pozici je kamen protihrace
                            if(aktPol.getXova()>predK.getXova()){pom-=2;}
                            if(this.hrPole.vratKam(aktPol.getXova()+pom, aktPol.getYova()+1).getKoho() == this.hrac2){
                            this.hrPole.obarvi(aktPol, predK);
                            this.hrPole.odeber(aktPol.getXova()+pom, aktPol.getYova()+1);
                            this.hraje = this.hrac2.getJmeno();
                            }
                        }
                    }
            }
            
            else if((this.hraje.equals(this.hrac2.getJmeno())&& this.hraje.equals(this.predK.getKoho().getJmeno()))){
                
                if((aktPol.getYova()==0)&&(this.predK.isDama() == false)) {
                    this.predK.setDama(true);
                    this.predK.setBarva(Color.CYAN);
                }
                
                 if(((aktPol.getYova()+1)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-1))||
                         (aktPol.getXova()==(predK.getXova()+1)))){
                                      this.hrPole.obarvi(aktPol, predK);
                                      this.predK = null;
                                      this.hraje = this.hrac1.getJmeno();
                                  }
                 else if(((aktPol.getYova()+2)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-2))||(aktPol.getXova()==(predK.getXova()+2)))){
                            //zjisteni jestli na pozici je kamen protihrace
                            if(aktPol.getXova()>predK.getXova()){pom-=2;}
                            if(this.hrPole.vratKam(aktPol.getXova()+pom, aktPol.getYova()+1).getKoho() == this.hrac1){
                            this.hrPole.obarvi(aktPol, predK);
                            this.hrPole.odeber(aktPol.getXova()+pom, aktPol.getYova()+1);
                            if(((this.hrPole.vratKam(aktPol.getXova()+1, aktPol.getYova()-1).getKoho()!=this.hrac1)||(this.hrPole.vratKam(aktPol.getXova()-1, aktPol.getYova()-1).getKoho()!=this.hrac1))
                                    ||((this.predK.isDama()==true)&&(this.hrPole.vratKam(aktPol.getXova()-1, aktPol.getYova()+1).getKoho()==this.hrac1)||(this.hrPole.vratKam(aktPol.getXova()-1, aktPol.getYova()-1).getKoho()==this.hrac1)
                                    ||(this.hrPole.vratKam(aktPol.getXova()+1, aktPol.getYova()+1).getKoho()!=this.hrac1))){this.hraje = this.hrac1.getJmeno();}
                            }
                 
                          }
                 
                else if(this.predK.isDama()==true) {
                    if(((aktPol.getYova()-1)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-1))||
                         (aktPol.getXova()==(predK.getXova()+1)))){
                                     this.hrPole.obarvi(aktPol, predK);
                                     this.hraje = this.hrac1.getJmeno();
                                  }
                 else if(((aktPol.getYova()-2)==predK.getYova())&&((aktPol.getXova()==(predK.getXova()-2))||(aktPol.getXova()==(predK.getXova()+2)))){
                            //zjisteni jestli na pozici je kamen protihrace
                            if(aktPol.getXova()>predK.getXova()){pom-=2;}
                            if(this.hrPole.vratKam(aktPol.getXova()+pom, aktPol.getYova()-1).getKoho() == this.hrac1){
                            this.hrPole.obarvi(aktPol, predK);
                            this.hrPole.odeber(aktPol.getXova()+pom, aktPol.getYova()-1);
                            this.hraje = this.hrac1.getJmeno();
                            }
                    }
                }
                  }
                
            }
            
        }
             
            this.predK = this.hrPole.vratKam(aktPol.getXova(), aktPol.getYova());
        
    }

    public String getHraje() {
        return hraje;
    }

  /*
     * Metoda pro uložení dat, vrací true nebo false podle toho jestli se data dobře nacetla
     * 
     */
    public boolean nactiDat(String nazevS) {
         String []hod; // pro ulozeni jmen z nazvu
         String []cislo = new String[4]; // pro ulozeni hodnot z nazvu
         int index = 0;
         String o; // pro ulozeni celeho nazvu akt. nacitaneho buttonu
         Scanner cteni;
       /* try {
            cteni = new Scanner(new FileInputStream(nazevS), "UTF8");
            hod = cteni.next().split(";");
            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 8; x++) {
                    o = (String)(hod[index]);
                    cislo = o.split(",");
                    index++;
                this.hraciPole[x][i].setName(o);
                    switch (cislo[0]) {
                        case "1":
                            if("0".equals(cislo[3])){
                            obarvit(x,i,Color.red,o);
                            }
                            else {
                            obarvit(x,i,Color.PINK,o);  
                            }
                            break;
                        case "2":
                            if("0".equals(cislo[3])){
                            obarvit(x,i,Color.BLUE,o);
                            }
                            else {
                            obarvit(x,i,Color.CYAN,o);  
                            }
                            break;
                    }
                
                }
                }   
            
            cteni.close();
            return true;
            
        } catch (IOException e) {
        }*/
        return false;
    }
    
    public void ulozDat(String nazevS) {
        
        
    }
    
}

