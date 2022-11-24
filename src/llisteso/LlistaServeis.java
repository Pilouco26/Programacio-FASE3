package llisteso;
//NO TÉ PITNA QUE S'UTILIZI 




import Dades.Classes.Data;
import Dades.Classes.Servei;

public class LlistaServeis {
    private Servei[] llista;
    private int nElem;



    public LlistaServeis(int mida){             //decidir si es servei o producte
        llista = new Servei[mida];
        nElem=0;
    }

    public void afegirServei(Servei s)
    {
        if(nElem<llista.length)
        {
            llista[nElem]= s.copia();
            nElem++;
        }
    }
    public void esborraS(String nom)
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

    public LlistaServeis actius(Data actual)
    {
        LlistaServeis aux = new LlistaServeis(nElem);

        for(int i=0; i<nElem; i++)
        {
            if(llista[i].actiu(actual)) 
            {
                aux.afegirServei(llista[i]);
            }
        }

        return aux;
    }
}


