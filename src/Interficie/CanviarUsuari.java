package Interficie;

import javax.swing.*;

import Dades.Llistes.LlistaIntercanvis;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Exception.AliesNoExisteix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanviarUsuari implements ActionListener {

private LlistaUsuaris LlistaU; 
private String nom;
public  CanviarUsuari(JTextArea missatge, LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU, String alies)
    {
      LlistaU = llistaU;

      
    }

    public void actionPerformed(ActionEvent evt) {
    nom = JOptionPane.showInputDialog(null, "Qui ets?", "Intercanvis", JOptionPane.QUESTION_MESSAGE);
    try {
         LlistaU.TrobaUsuari(nom);
    } catch (AliesNoExisteix e) {
        
        System.out.println("AYO, l'alies no existeix");
    }
    
    }


    public String CanviarAlies()
    {
        
        return nom;
    }


    }