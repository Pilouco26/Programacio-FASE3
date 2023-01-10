package Dades.Llistes;
import java.io.Serializable;
import Dades.Classes.Usuari;
import Exception.AliesNoExisteix;
import Exception.AliesRepetit;

/**
 * Classe llista Usuaris
 * 
 * @author Grup
 *
 */


public class LlistaUsuaris implements Serializable{
    
    private Usuari[] llista;
    private int nElem;


    /**
     * Constructor llista usuaris
     * @param mida
     */
    public LlistaUsuaris(int mida){

        llista= new Usuari[mida];
        nElem =0;
    }
    /**
     * Afegeix usuari, comprova que no estigui repetit
     * @param a
     * @throws AliesRepetit
     */
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
    /**
     * Busca usuari
     * @param usuari
     * @return usuari
     * @throws AliesNoExisteix
     */
    public Usuari TrobaUsuari(String usuari) throws AliesNoExisteix
    {
        boolean trobat= false;
        int i=0;       
        while(i<nElem && !trobat)
        {
            if(llista[i].getAlies().equals(usuari))
            {   
                trobat = true;
                
            }
            else i++;
        }
        if(trobat) return llista[i];                                        //ENRECORDARSE DE PPOSAR LO QUE NO ES DEL CONSTRUCTOR
        else 
        {
            throw new AliesNoExisteix(usuari);

        }
    }
    /**
     * Comprova existencia usuari
     * @param usuari
     * @return cert o fals
     */
    public boolean TrobaUsuariR(String usuari) 
    {
        boolean trobat= false;
        int i=0;       
        while(i<nElem && !trobat)
        {
            if(llista[i].getAlies().equals(usuari))
            {   
                 return true;
                
            }
            else i++;
        }
        
        return false;//ENRECORDARSE DE PPOSAR LO QUE NO ES DEL CONSTRUCTOR
        
    }
    /**
     * Retorna llista que compleix amb usuari
     * @param valoració
     * @return llista
     * @throws AliesRepetit
     */
    public LlistaUsuaris LlindarUsuari(double valoració) throws AliesRepetit
    {
        LlistaUsuaris aux = new LlistaUsuaris(nElem);
        for(int i=0; i<nElem; i++)
        {
            if(valoració<= llista[i].MitjanaValoració()) aux.AfegirUsuari(llista[i]); 
        }
        return aux;
    }






    /**
     * Troba usuari per posicio
     * @param posicio
     * @return usuari
     */
    public Usuari StoreData(int posicio)
    {
        return llista[posicio];
    }

    /**
     * getter mida llista
     * @return nElem
     */
    public int getnElem()
    {
        return nElem;
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
