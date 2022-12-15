
//NO TE PINTA QUE S'UTILZI 



import Dades.Classes.Bens;


public class LlistaBens {
    private Bens[] llista;                //decidir si es be o producte
    private int nElem;


    /**
     * Constructor de la LListaBens
     * @param mida: mida de la llista
     */
    public LlistaBens(int mida){
        llista = new Bens[mida];
        nElem=0;
    }
    /**
     * Afegir un be a la llista
     * @param b:be que afegim a la llista de bens
     */
    public void afegirBe(Bens b)
    {
        if(nElem<llista.length)
        {
            llista[nElem]= b.copia();
            nElem++;
        }
    }
    /**
     * Esborrem el bé que volem a partir del nom
     * @param nom: nom del bé que borrem de la llista
     */
    public void esborraB(String nom)
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
    /**
     * Comprova que un item esta disponible per intercanvia, es a dir, encara no ha estat intercanviat
     * @return LLista amb els items disponibles
     */
    public LlistaBens disponible()
    {
        LlistaBens aux = new LlistaBens(nElem);
        for(int i=0; i<nElem; i++)
        {
            if(!llista[i].getIntercanvi())          //Comprova que el bé no estigui intercanviat
            {
                aux.afegirBe(llista[i]);
            }
        }
        return aux; 
    }

    
}


