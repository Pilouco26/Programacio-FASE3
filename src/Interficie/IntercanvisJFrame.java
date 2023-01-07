package Interficie;
import javax.swing.*;
import Dades.Llistes.LlistaIntercanvis;
import Dades.Llistes.LlistaProductes;
import Dades.Llistes.LlistaUsuaris;
import Exception.AliesNoExisteix;
import Dades.Classes.Usuari;
import java.awt.*;

/**
 * Classe FINESTRA INTERCANVIS
 * 
 * @author Grup
 *
 */
public class IntercanvisJFrame extends JFrame {

    private static final long serialVersionUID = 2L;
    private JButton b;
    private JPanel panelButtons = new JPanel();
    private JTextArea info = new JTextArea();
    private Usuari actual;
    /**
     * contructor
     * @param llistaI
     * @param llistaP
     * @param llistaU
     * @param alies
     * @throws AliesNoExisteix
     */
    public IntercanvisJFrame(LlistaIntercanvis llistaI, LlistaProductes llistaP, LlistaUsuaris llistaU, String alies) throws AliesNoExisteix {
    super();
    setSize(700,500);
    Container content = getContentPane();
    content.setLayout(new BorderLayout());
    panelButtons.setLayout(new GridLayout(2,7));
    content.add(panelButtons, BorderLayout.NORTH);
    content.add(info, BorderLayout.SOUTH);
    info=new JTextArea("Resultat de la consulta:\n");
    info.setSize(50, 50);
    info.setText("");
    this.add(info, BorderLayout.SOUTH);
    actual = llistaU.TrobaUsuari(alies);
    LlistaIntercanvis l = llistaI.getAcceptades().TrobaUsuariIntercanvis(alies);
    
    for(int i=0; i<l.getnElem(); i++){
        
        b = new JButton(""+l.getLlista(i).getCodi());

        if(l.getLlista(i).getContesta().equals(actual)){

            if(l.TrobaUsuariIntercanvis(alies).getLlista(i).getOvaloracio()>=4) b.setBackground(Color.GREEN);
            else if(l.TrobaUsuariIntercanvis(alies).getLlista(i).getOvaloracio()>=2 || l.TrobaUsuariIntercanvis(alies).getLlista(i).getOvaloracio() <4 ) b.setBackground(Color.YELLOW);
            else this.setBackground(Color.red);
    
        }
        else {
            if(l.TrobaUsuariIntercanvis(alies).getLlista(i).getIvaloracio()>=4) b.setBackground(Color.GREEN);
            else if(l.TrobaUsuariIntercanvis(alies).getLlista(i).getIvaloracio()>=2 && l.TrobaUsuariIntercanvis(alies).getLlista(i).getOvaloracio() <4 ) b.setBackground(Color.YELLOW);
            else b.setBackground(Color.red);
        }

        Llista Pop = new Llista(info, l, i);
            b.addActionListener(Pop);
            panelButtons.add(b);
    
    }
    this.setVisible(true);

}
}