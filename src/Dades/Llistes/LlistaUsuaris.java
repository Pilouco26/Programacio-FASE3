package Dades.Llistes;


import Dades.Classes.Usuari;
import Exception.AliesRepetit;
public class LlistaUsuaris {
    
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
    public Usuari TrobaUsuari(String usuari)
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
        else return null;
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
