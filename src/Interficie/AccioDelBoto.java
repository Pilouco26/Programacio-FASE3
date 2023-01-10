package Interficie;
import javax.swing.*;
import Dades.Llistes.LlistaIntercanvis;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Classe AccioDelBoto
 * 
 * @author Grup
 *
 */
public class AccioDelBoto implements ActionListener {

private JTextArea missatge; 
private LlistaIntercanvis LlistaI;  

    /**
     * Contructor
     * @param missatge
     * @param llistaI
     * @param llistaP
     * @param llistaU
     * @param alies
     */
    public AccioDelBoto(JTextArea missatge, LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU, String alies)
    {
      this.missatge = missatge;
      LlistaI = llistaI;
    }
    /**
     * action perdormed
     */
    public void actionPerformed(ActionEvent evt) {
    JButton b = (JButton) evt.getSource();
    String s = b.getText();
    if(s.equals("Intercanvis")){
        missatge.append(""+LlistaI.getPendents().toStringMaco()+"\n");                      //ME DONA NULL FALTA REVISAR
    }
    else{
        missatge.append("Has seleccionat: "+s+"\n");
    }
    
    }


    


    }