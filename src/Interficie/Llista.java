package Interficie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import Dades.Llistes.LlistaIntercanvis;

/**
 * Classe llista
 */
public class Llista implements ActionListener {
    
    private LlistaIntercanvis Llista;
    private int pos;
    private JTextArea missatge;
    /**
     * contructor
     * @param info
     * @param llista
     * @param pos
     */
    public Llista(JTextArea info, LlistaIntercanvis llista, int pos)
    {
        this.pos = pos;
        this.Llista = llista;
        missatge = info;
    }
    /**
     * action performed
     */
    public void actionPerformed(ActionEvent e )
    {   
        missatge.append(Llista.getLlista(pos).toStringMaco()+"\n");
    }
}
