package Interficie;

import javax.swing.*;

import Dades.Classes.Intercanvi;
import Dades.Classes.Producte;
import Dades.Classes.Usuari;
import Dades.Llistes.LlistaIntercanvis;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Exception.AliesNoExisteix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntercanvisBoto implements ActionListener {

private JTextArea missatge; 
private LlistaIntercanvis LlistaI; 
private LlistaUsuaris LlistaU;   
private LlistaProductes LlistaP;
private String alies;
private Usuari demanat;
private Usuari actual;

    public IntercanvisBoto(JTextArea missatge, LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU, String alies)
    {
      this.missatge = missatge;
      LlistaI = llistaI;
      LlistaU = llistaU;
      LlistaP = llistaP;
      this.alies = alies; 
     
    }
    

    public void actionPerformed(ActionEvent evt) {
    JButton b = (JButton) evt.getSource();
    

    if(b.getText().equals("Afegir petició intercanvi"))
    {
        try {
            actual = LlistaU.TrobaUsuari(alies);
       } catch (AliesNoExisteix e) {
   
           System.out.println("AYO, l'alies no existeix");
       }
       
       String nom = JOptionPane.showInputDialog(null, "Amb qui vols fer negocis?", "Intercanvis", JOptionPane.QUESTION_MESSAGE);
       try {
            demanat = LlistaU.TrobaUsuari(nom);
       } catch (AliesNoExisteix e) {
           
           System.out.println("AYO, l'alies no existeix");
       }
       String producte1 = JOptionPane.showInputDialog(null, "que vols donar?", "Intercanvis", JOptionPane.QUESTION_MESSAGE);
   
       Producte ProducteA = LlistaP.TrobaCodi(producte1);
   
       String producte2 = JOptionPane.showInputDialog(null, "que vols rebre?", "Intercanvis", JOptionPane.QUESTION_MESSAGE);
   
       Producte ProducteB = LlistaP.TrobaCodi(producte2);
   
       Intercanvi a = new Intercanvi(GenCodiIntercanvi(), actual, demanat, ProducteA, ProducteB);
   
       LlistaI.AfegirIntercanvi(a);
    }
    else 
    {
        try {
            new IntercanvisJFrame( LlistaI, LlistaP, LlistaU, alies);
        } catch (AliesNoExisteix e) {
            
            
        }
    }

    }
   
    public  int GenCodiIntercanvi()
    {
        int min =0;
        int max =9999;
       

        return (int)(Math.random()*(max-min+1)+min);
    }
}