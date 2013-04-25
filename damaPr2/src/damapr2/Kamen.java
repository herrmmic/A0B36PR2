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
    public Kamen(int x, int y, Hrac koho) {
        super(x,y);
        this.koho = koho;
        this.setBarva(koho.getBarva());
    }

    
    
    
}
