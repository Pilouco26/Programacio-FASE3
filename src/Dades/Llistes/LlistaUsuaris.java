package Dades.Llistes;

import java.util.Arrays;

import Dades.Classes.Usuari;
import Exception.AliesRepetit;
public class LlistaUsuaris {
    
    private Usuari[] llista;
    private int nElem;



    public LlistaUsuaris(int mida){

        llista= new Usuari[mida];
        nElem =0;
    }

    public void AfegirUsuari(Usuari a) throws AliesRepetit{                         //Cal ordenar-ho per nom
        boolean repetit= false;
        int i=0;
        if(nElem<llista.length)
        {
            while(i<nElem && !repetit)
            {
                if(llista[i].getAlies().equals(a.getAlies()))
                {
                    repetit = true;
                    
                }
                else i++;

            }
            if(!repetit)
            {
                llista[nElem]= a.copia();
                llista[nElem].setNumProductes(a.getNumProductes());
                llista[nElem].setnumIntercanvis(a.getIntercanvis());
                nElem++;
            }
            else
            {
                throw new AliesRepetit(a.getAlies());
            }
           
        }
    }



    public int getnElem()
    {
        return nElem;
    }

    public String toString() {

        return Arrays.toString(llista);
     }
}
