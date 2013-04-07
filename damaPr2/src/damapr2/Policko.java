/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Misa
 */
public class Policko extends JButton{
        Color barva;
        int xova;
        int yova;
        
        
        public Policko() {
            super();
        }

        public Color getBarva() {
            return barva;
        }

        public void setBarva(Color barva) {
            this.barva = barva;
            this.setBackground(barva);
        }

        public int getXova() {
            return xova;
           }

        public void setXova(int xova) {
            this.xova = xova;
        }

        public int getYova() {
            return yova;
        }

        public void setYova(int yova) {
            this.yova = yova;
        }
    
    
    
    
}
