package Interficie;
import javax.swing.*;
import Dades.Llistes.LlistaIntercanvis;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Exception.AliesNoExisteix;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CanviaUsuari
 * 
 * @author Grup
 *
 */
public class CanviarUsuari implements ActionListener {

private LlistaUsuaris LlistaU; 
private String nom;
/**
 * Constructor
 * @param missatge
 * @param llistaI
 * @param llistaP
 * @param llistaU
 * @param alies
 */
public  CanviarUsuari(JTextArea missatge, LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU, String alies)
    {
      LlistaU = llistaU;
    }
    /**
     * ActionPerformed
     */
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