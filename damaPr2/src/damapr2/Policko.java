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
        private Color barva;
        private int xova;
        private int yova;
        
        
        public Policko(int x, int y) {
            super();
            this.xova = x;
            this.yova = y;
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
