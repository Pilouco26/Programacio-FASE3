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
    private JButton b2 = new JButton("Intercanvis");
    private JButton b3 = new JButton("Veure Intercanvis");
    private JButton b5 = new JButton("Afegir petició intercanvi");
    private JButton b6 = new JButton("Canviar usuari");
   
    private JTextArea missatge;
   
    public Interficie(String titol, LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU, String alies) {
        super(titol);
        this.setLayout(new BorderLayout(15, 15));
        missatge=new JTextArea("Resultat de la consulta:\n");
        missatge.setSize(this.getWidth(), 300);
        missatge.setText("");
        this.add(missatge, BorderLayout.CENTER);
        AccioDelBoto accio = new AccioDelBoto(missatge,  llistaI,  llistaP,  llistaU, alies);
        IntercanvisBoto intercanvisBoto = new IntercanvisBoto(missatge, llistaI, llistaP, llistaU, alies);
        CanviarUsuari b = new CanviarUsuari(missatge, llistaI, llistaP, llistaU, alies);
        b2.addActionListener(accio);
        b3.addActionListener(intercanvisBoto);
        b5.addActionListener(intercanvisBoto);
        b6.addActionListener(b);
        
                                                    // Forcem la disposició dels objectes continguts en el panell
        panellBotons.setLayout(new FlowLayout());
                                                    // Afegim els botons al panell
        panellBotons.add(b2);
        this.add(panellBotons, BorderLayout.NORTH);
        panellBotons2.add(b3);
      
        panellBotons2.add(b6);
        panellBotons.add(b5);
        this.add(panellBotons2, BorderLayout.SOUTH);

        this.setLocation(200, 200);
        this.setSize(700,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
       
    }
    
}

