package Dades.Llistes;

import Dades.Classes.Intercanvi;

public class LlistaIntercanvis {
    private Intercanvi[] llista;
    private int nElem;


    public LlistaIntercanvis(int mida)
    {
        llista = new Intercanvi[mida];
        nElem = 0;
    }


    public void AfegirIntercanvi(Intercanvi i)              // cal ordenarles
    {

        if(nElem<llista.length)
        {
            llista[nElem] = i.copia();
            nElem++;
        }
    }

    @Override
    public String toString() {

        StringBuilder b = new StringBuilder();
        
        for (int i = 0; ; i++) {
            b.append(String.valueOf(llista[i]+"\n"));
            if (i == nElem-1)
                return b.append(' ').toString();
            
        }
        
    }

  
}
