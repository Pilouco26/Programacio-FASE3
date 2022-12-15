package Dades.Llistes;


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
            if(p instanceof Bens)
            {
                ((Bens)llista[nElem]).setIntercanvi(((Bens)p).getIntercanvi());
                
                if(((Bens)llista[nElem]).getIntercanvi())
                {
                    ((Bens)llista[nElem]).setData(((Bens)llista[nElem]).getData());
                }
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

    public LlistaProductes BensActius()
    {
        LlistaProductes BeActiu= new LlistaProductes(getIntercanviables());
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Bens && !((Bens)llista[i]).getIntercanvi())
            {
                BeActiu.afegirProductes(llista[i]);
            }
        }

        return BeActiu;
    }

    public LlistaProductes GetServeis()
    {
        LlistaProductes Serveis= new LlistaProductes(getnumServeis());
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Servei)
            {
                Serveis.afegirProductes(llista[i]);
            }
        }
        return Serveis;
    }

    public LlistaProductes GetBens()
    {
        LlistaProductes Bens= new LlistaProductes(getnumBens());
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Bens)
            {
                Bens.afegirProductes(llista[i]);
            }
        }
        return Bens;
    }

    public int getActius()
    {
        int mida=0;
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Servei && ((Servei)llista[i]).getActiu())
            {
                mida++;
            }
        }
        return mida;
    }
    public int getnumServeis()
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

    public int getnumBens()
    {
        int mida=0;
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Bens)
            {
                mida++;
            }
        }
        return mida;
    }

    public Producte TrobaCodi(String codi)
    {
        boolean trobat = false;
        int i=0; 
        while (i<nElem && !trobat)
        {
            if(llista[i].getCodi().equals(codi)) trobat = true;
            else i++;
        }
        if(trobat) return llista[i];                                    //ENRECORDARSE DE PPOSAR LO QUE NO ES DEL CONSTRUCTOR
        else return null;
    }


    public int getnElem()
    {
        return nElem;
    }

    public int getIntercanviables()
    {
        int mida =0;

        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Bens && !((Bens)llista[i]).getIntercanvi()) mida++;
        }

        return mida;
    }
    @Override
    public String toString() {

        if(nElem==0)
        {
            return "No hi ha cap element en aquesta llista.";
        }
        StringBuilder b = new StringBuilder();
        
        for (int i = 0; ; i++) {
            if(llista[i] instanceof Bens)
            {
                if(((Bens)llista[i]).getIntercanvi()){            
                    b.append(String.valueOf(llista[i]+"\n"));
                }
                else {
                    b.append(((Bens)llista[i]).toStringFalse()+"\n");
                }
            }
            else b.append(String.valueOf(llista[i]+ "\n"));
           
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
            if(llista[i] instanceof Bens)
            {
                if(((Bens)llista[i]).getIntercanvi()){            
                    b.append(((Bens)llista[i]).toStringMaco()+"\n");
                }
                else {
                    b.append(((Bens)llista[i]).toStringMacoFalse()+"\n");
                }
            }
            else b.append(((Servei)llista[i]).toStringMaco()+"\n");
           
            if (i == nElem-1)
                return b.toString();
            
        }
        
    }
}
