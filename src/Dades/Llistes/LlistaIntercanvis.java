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
            llista[nElem].setTrato(i.getTrato());
            llista[nElem].setResposta(i.getResposta());
            llista[nElem].setOvaloracio(i.getOvaloracio());
            llista[nElem].setIvaloracio(i.getIvaloracio());
            nElem++;
        }
    }

    @Override
    public String toString() {

        if(nElem==0)
        {
            return "No hi ha cap element en aquesta llista.";
        }
        StringBuilder b = new StringBuilder();
        
        for (int i = 0; ; i++) {
            b.append(String.valueOf(llista[i]+"\n"));
            if (i == nElem-1)
                return b.toString();
            
        }
        
    }
    public String toStringMaco() {

        if(nElem==0)
        {
            return "No hi ha cap element en aquesta llista.";
        }
        StringBuilder b = new StringBuilder();
        
        for (int i = 0; ; i++) {
            b.append(llista[i].toStringMaco()+"\n");
            if (i == nElem-1)
                return b.toString();
            
        }
        
    }

  
}
