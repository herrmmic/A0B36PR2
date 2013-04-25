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
public class Hrac {
    
    private String jmeno = "";
    private Color barva;
    private Kamen[]kameny;
    
    public  Hrac (String jm, Color br){
        this.jmeno = jm;
        this.barva = br;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public Color getBarva() {
        return barva;
    }

    public void setBarva(Color barva) {
        this.barva = barva;
    }

    public Kamen[] getKameny() {
        return kameny;
    }

    public void setKameny(Kamen[] kameny) {
        this.kameny = kameny;
    }
    
}
