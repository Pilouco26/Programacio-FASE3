package Interficie;

import javax.swing.*;

import Dades.Classes.Usuari;
import Dades.Llistes.LlistaIntercanvis;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Exception.AliesNoExisteix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanviarUsuari implements ActionListener {

private JTextArea missatge; 
private LlistaUsuaris LlistaU; 
private Usuari demanat; 
private String nom;
    public  CanviarUsuari(JTextArea missatge, LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU, String alies)
    {
      this.missatge = missatge;
      LlistaU = llistaU;

      
    }

    public void actionPerformed(ActionEvent evt) {
    JButton b = (JButton) evt.getSource();
    String nom = JOptionPane.showInputDialog(null, "Qui ets?", "Intercanvis", JOptionPane.QUESTION_MESSAGE);
    try {
         demanat = LlistaU.TrobaUsuari(nom);
    } catch (AliesNoExisteix e) {
        
        System.out.println("AYO, l'alies no existeix");
    }
    
    }


    public String CanviarAlies()
    {
        String nom = JOptionPane.showInputDialog(null, "Qui ets?", "Intercanvis", JOptionPane.QUESTION_MESSAGE);
        return nom;
    }


    }