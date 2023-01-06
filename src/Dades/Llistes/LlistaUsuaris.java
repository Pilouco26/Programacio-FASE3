package Dades.Llistes;


import java.io.Serializable;


import Dades.Classes.Usuari;
import Exception.AliesNoExisteix;
import Exception.AliesRepetit;
public class LlistaUsuaris implements Serializable{
    
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
                llista[nElem]= a.copia();
                llista[nElem].setNumProductes(a.getNumProductes());
                llista[nElem].setnumIntercanvis(a.getIntercanvis());
                nElem++;
            }
            else
            {
                throw new AliesRepetit(a.getAlies());
            }
           
        }
    }
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

    public LlistaUsuaris LlindarUsuari(double valoració) throws AliesRepetit
    {
        LlistaUsuaris aux = new LlistaUsuaris(nElem);
        for(int i=0; i<nElem; i++)
        {
            if(valoració<= llista[i].MitjanaValoració()) aux.AfegirUsuari(llista[i]); 
        }
        return aux;
    }







    public Usuari StoreData(int posicio)
    {
        return llista[posicio];
    }


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
