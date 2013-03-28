/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package damapr2;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author Misa
 */
public class Okno1 extends JFrame{
    
    private JButton proVyber;
    private JLabel txVyber;
    private JRadioButton rbVyber;
    
    public Okno1(){
        super();
        this.setBounds(200, 200, 600, 600);
        this.setTitle("Citac");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(10,100);
        this.setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLayout(null);
        
        
    }
    public void tlPotvrd(){
        this.proVyber = new JButton("Potvrd");
        this.proVyber.setBounds(250, 300, 100, 50);
        this.proVyber.setBackground(Color.cyan);
        this.add(this.proVyber);
    }
    
    public void TextVyber() {
        this.txVyber = new JLabel("Vyberte typ hry");
        this.txVyber.setBounds(120, 50, 600, 70);
        txVyber.setFont(new Font("Serif", Font.BOLD, 48));
        this.add(this.txVyber);
    }
    
    public void radioButton() {
        this.rbVyber = new JRadioButton("Proti PC");
        this.rbVyber.setBounds(250, 150, 100, 50);
        this.add(this.rbVyber);
    }
}

