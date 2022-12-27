package Interficie;

import javax.swing.*;

import Dades.Llistes.LlistaIntercanvis;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Dades.*;

import java.awt.*;

public class Interficie extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel panellBotons = new JPanel();
    private JPanel panellBotons2 = new JPanel();
    private JButton b1 = new JButton("LLISTES");
    private JButton b2 = new JButton("INTERCANVIS");
    private JButton b3 = new JButton("USUARI");
    private Botó b4 = new Botó("ANARMEN A PRENDRE PEL CUL");
    private JTextArea missatge;
   
    public Interficie(String titol, LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU) {
        super(titol);
        this.setLayout(new BorderLayout(15, 15));
        missatge=new JTextArea("Resultat de la consulta:\n");
        missatge.setSize(this.getWidth(), 300);
        missatge.setText("");
        this.add(missatge, BorderLayout.CENTER);
        AccioDelBoto accio = new AccioDelBoto(missatge,  llistaI,  llistaP,  llistaU);
        b1.addActionListener(accio);
        b2.addActionListener(accio);
        b3.addActionListener(accio);
        b4.addActionListener(accio);
                                                    // Forcem la disposició dels objectes continguts en el panell
        panellBotons.setLayout(new FlowLayout());
        panellBotons.add(b1); // Afegim els botons al panell
        panellBotons.add(b2);
        this.add(panellBotons, BorderLayout.NORTH);
        panellBotons2.add(b3);
        panellBotons2.add(b4);
        this.add(panellBotons2, BorderLayout.SOUTH);
        
        this.setLocation(200, 200);
        this.setSize(700,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

