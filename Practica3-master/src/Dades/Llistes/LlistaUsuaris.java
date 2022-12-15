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
    			int pos = nElem - 1;
            	while ((pos >= 0) && llista[pos].getAlies().compareToIgnoreCase(a.getAlies()) > 0) {
    				llista[pos + 1] = llista[pos];
    				pos--;
    			}
    			llista[pos + 1] = a.copia();
                llista[pos + 1].setNumProductes(a.getNumProductes());
                llista[pos + 1].setnumIntercanvis(a.getIntercanvis());
                nElem++;
            }
            else
            {
                throw new AliesRepetit(a.getAlies());
            }
           
        }
    }

    public void ordenarLlista()
    {
        Usuari[] aux= new Usuari[nElem];
        int i=0;
        boolean diferent= false;
        while(i<nElem)
        {
            

            if(llista[nElem].getAlies().charAt(i) == (llista[nElem].getAlies().charAt(i))) 
            {
                int j=0;
                while(j<llista[nElem].getAlies().length() &&  !diferent)
                {
                    if(llista[nElem].getAlies().charAt(j)>llista[nElem+1].getAlies().charAt(j)) 
                    {
                        aux[nElem] = llista[nElem];
                        llista[nElem]= llista[nElem+1];
                        llista[nElem+1] = aux[nElem];
                        diferent = true; 

                    }    
                    else if(llista[nElem].getAlies().charAt(j)<llista[nElem+1].getAlies().charAt(j))  diferent = true;

                    else j++;
                }
            }
            
            else  if(llista[nElem].getAlies().charAt(0)>llista[nElem+1].getAlies().charAt(0)) 
            {
                aux[nElem]= llista[nElem].copia();
                llista[nElem]= llista[nElem+1].copia();
                llista[nElem+1] = aux[nElem].copia();
            }    

            else i++;

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
