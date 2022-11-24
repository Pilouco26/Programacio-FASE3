package Dades.Llistes;

import java.util.*;
import Dades.Classes.Bens;
import Dades.Classes.Producte;
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
            llista[nElem]= p.copia();
            
            if(p instanceof Servei)
            {
                ((Servei)llista[nElem]).setActiu(((Servei)p).getActiu());
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
    public LlistaProductes ServeisActius()
    {
        LlistaProductes SerActiu= new LlistaProductes(getActius());
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Servei && ((Servei)llista[i]).getActiu())
            {
                SerActiu.afegirProductes(llista[i]);

            }
        }

        return SerActiu;
    }

    public int getActius()
    {
        int mida=0;
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Servei)
            {
                mida++;
            }
        }
        return mida;
    }
    @Override
    public String toString() {

        return Arrays.toString(llista);
     }
}
