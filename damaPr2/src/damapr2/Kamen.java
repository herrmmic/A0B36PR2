/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

/**
 *
 * @author Misa
 */
public class Kamen extends Policko{

    private Hrac koho;

    private Kamen[][] kde;
    public Kamen(int x, int y, Hrac koho) {
        super(x,y);
        this.koho = koho;
        this.setBarva(koho.getBarva());
    }

    public void posunSe (Kamen [] [] kde,Policko kam) {
        this.kde = kde;
        this.kde[kam.getXova()][kam.getYova()]=this;
        this.kde[this.getXova()][this.getYova()]= null;
        this.kde[kam.getXova()][kam.getYova()].setXova(kam.getXova());
        this.kde[kam.getXova()][kam.getYova()].setYova(kam.getYova());
        
    }
    
    public Hrac getKoho() {
        return koho;
    }
    
    
    
}
