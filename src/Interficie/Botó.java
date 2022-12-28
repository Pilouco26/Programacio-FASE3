package Interficie;


import java.awt.*;
import javax.swing.*;


public class Botó extends JButton {
    
    public Botó(String titol)
    {
        super(titol);
        this.setBackground(Color.green);
    }
    public void iniContingutFinestraV1() {
        this.setLayout(new BorderLayout(10,10 ));
        this.add(new JButton("Opció 1"));
        this.add(new JButton("Opció 2"));
        this.add(new JButton("Opció 3"));
        
       
    }
}
