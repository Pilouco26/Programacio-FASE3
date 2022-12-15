package Dades.Llistes;

import Dades.Classes.Producte;
import Dades.Classes.Bens;
import Dades.Classes.Servei;

public class LlistaProductes {
    private Producte[] llista;
    private int nElem;



    public LlistaProductes(int mida){           
        llista = new Producte[mida];
        nElem=0;
    }

    public void afegirProductes(Producte p)                 //cal ordenar-ho per nom
    {
        if(nElem<llista.length)
        {
        	int pos = nElem - 1;
        	while ((pos >= 0) && llista[pos].getNom().compareToIgnoreCase(p.getNom()) > 0) {
				llista[pos + 1] = llista[pos];
				pos--;
			}
			llista[pos + 1] = p.copia();

			if(p instanceof Bens) {
				((Bens)llista[pos + 1]).setIntercanvis( ((Bens)p).getIntercanvi() );

			}
			
            nElem++;
        }
    }
    public void esborraP(String nom)
    {
        boolean erased= true;
        int i = 0;

        while(i<nElem && !erased)
        {
            if(llista[i].getNom().equals(nom))
            {
                for(int j = i; j<nElem-1; j++)
                {
                    llista[j]= llista[j+1];

                }
                nElem--;
            }
            else i++;
        }
    }
}
