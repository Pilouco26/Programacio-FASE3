package Interficie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import Dades.Llistes.LlistaIntercanvis;

public class PopPop implements ActionListener {
    
    private LlistaIntercanvis Llista;
    private int pos;
    private JTextArea missatge;

    public PopPop(JTextArea info, LlistaIntercanvis llista, int pos)
    {
        this.pos = pos;
        this.Llista = llista;
        missatge = info;
    }

    public void actionPerformed(ActionEvent e )
    {   
        missatge.append(Llista.getLlista(pos).toStringMaco()+"\n");
    }
}
