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
        	int pos = nElem - 1;
        	while ((pos >= 0) && llista[pos].getCodi()!=(i.getCodi())) {
				llista[pos + 1] = llista[pos];
				pos--;
			}
			llista[pos + 1] = i.copia();
            llista[pos + 1].setTrato(i.getTrato());
            llista[pos + 1].setResposta(i.getResposta());
            llista[pos + 1].setIvaloracio(i.getIvaloracio());
            llista[pos + 1].setOvaloracio(i.getOvaloracio());


            nElem++;
        }
    }

  
}
