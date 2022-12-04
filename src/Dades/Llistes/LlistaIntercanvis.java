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

        if (nElem == 0)
            return "null";

        int iMax = llista.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        
        for (int i = 0; i<nElem; i++) {
            b.append(String.valueOf(llista[i]+"\n"));
            if (i == iMax)
                return b.append(' ').toString();
            
        
        }
        return null;
    }

  
}
