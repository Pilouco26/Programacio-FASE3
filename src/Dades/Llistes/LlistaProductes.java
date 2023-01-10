package Dades.Llistes;
/**
 * Classe llista productes
 * 
 * @author Grup
 *
 */

import Dades.Classes.Bens;
import Dades.Classes.Producte;
import Dades.Classes.Servei;
import java.io.Serializable;

public class LlistaProductes implements Serializable {
    private Producte[] llista;
    private int nElem;


    /**
     * constructor LlistaProductes
     * @param mida
     */
    public LlistaProductes(int mida){           
        llista = new Producte[mida];
        nElem=0;
    }
    /**
     * Afegeix productes
     * @param producte
     */
    public void afegirProductes(Producte p)                 //cal ordenar-ho per nom
    {
        if(nElem<llista.length)
        {
            int pos = nElem - 1;
        	while ((pos >= 0) && llista[pos].getNom().compareToIgnoreCase(p.getNom()) > 0) {
				llista[pos + 1] = llista[pos];
				pos--;
			}
			llista[pos + 1] = p.copia();
    
            
            if(p instanceof Servei)
            {
                ((Servei)llista[pos + 1]).setActiu(((Servei)p).getActiu());
            }
            if(p instanceof Bens)
            {
                ((Bens)llista[pos + 1]).setIntercanvi(((Bens)p).getIntercanvi());
                
                if(((Bens)llista[pos + 1]).getIntercanvi())
                {
                    ((Bens)llista[pos + 1]).setData(((Bens)llista[pos + 1]).getData());
                }
            }
            nElem++;
        }
    } 
    /**
     * Comprova si el producte esta repetit
     * @param codi
     * @return veritat o fals
     */  
    public boolean ProducteRepetit(String codi)
    {
        boolean repetit=false;
        int i=0;
        while(i<nElem && !repetit)
        {
            if(llista[i].getCodi().equals(codi))
            {
                return true;
            }
            else i++;
        }
        return repetit;
    }

    /**
     * Esborrar un producte
     * @param nom del producte
     */
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




    /**
     * Retorna una llista de serveis actius
     * @return Serveis actius
     */
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
    /**
     * Bens actius
     * @return llista
     */
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
    /**
     * getter serveis
     * @return llista
     */
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
    /**
     * getter bens
     * @return llista
     */
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
    /**
     * getter productes actius
     * @return llista
     */
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
    /**
     * getter numero de serveis
     * @return numero
     */
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
      /**
     * getter numero de bens
     * @return numero
     */
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
    /**
     * Busca un producte 
     * @param codi
     * @return producte
     */
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
    /**
     * Comprova l'existencia d'un producte
     * @param codi
     * @return
     */
    public boolean CercaCodi(String codi)
    {
        boolean trobat = false;
        int i=0; 
        while (i<nElem && !trobat)
        {
            if(llista[i].getCodi().equals(codi)) trobat = true;
            else i++;
        }
        return trobat;
    }   
    /**
     * Busca un servei
     * @param codi
     * @return posicio
     */
    public int CercaCodiS(String codi)
    {
        boolean trobat = false;
        int i=0; 
        while (i<nElem && !trobat)
        {
            if(llista[i].getCodi().equals(codi) && llista[i] instanceof Servei) return i;
            else i++;
        }
        return -1;
    }  
    /**
     * Dona de baixa un servei
     * @param codi
     * @param pos
     */
    public void DonarBaixaServei(String codi, int pos)
    {
    
        ((Servei)llista[pos]).setActiu(false);
        ((Servei)llista[pos]).setDataBaixa();
    

    }
    /**
     * Dona de baixa un be
     * @param codi
     */
    public void DonarBaixaBe (String codi)
	{
		int i=0;
		while(i<nElem)
		{
			if(llista[i] instanceof Bens)
			{
                if(llista[i].getCodi().equals(codi)&& !((Bens)llista[i]).getIntercanvi())
                {
                    for(int j=i; j<nElem-1; j++)
                    {
                        llista[j]=llista[j+1];
                    }
                    
                    nElem--;
                }
                else i++;
			
			}
			else i++;
		}
	}
    /**
     * Comprova si el producte es un be
     * @param codi
     * @return cert o fals
     */
    public boolean EsUnBe(String codi)
    {
        
        int i=0;
		while(i<nElem)
		{
            if(llista[i].getCodi().equals(codi) && llista[i] instanceof Bens) return true;
            else i++;
        }
        return false;
    }
    /**
     * Retorna un be a partir d'un codi
     * @param codi
     * @return be
     */
    public Bens RetornaUnBe(String codi)
    {
        
        int i=0;
		while(i<nElem)
		{
            if(llista[i] instanceof Bens && llista[i].getCodi().equals(codi)) return ((Bens)llista[i]);
            else i++;
        }
        return null;
    }
   
   /**
    * get mida llista
    * @return mida
    */
    public int getnElem()
    {
        return nElem;
    }
    /**
     * getter productes intercanviables
     * @return numero
     */
    public int getIntercanviables()
    {
        int mida =0;

        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Bens && !((Bens)llista[i]).getIntercanvi()) mida++;
        }

        return mida;
    }
    /**
     * Comprova si el producte es intercanviable
     * @param codi
     * @return
     */
    public boolean intercanviable(String codi)
    {
        
        for(int i=0; i<nElem; i++)
        {
            if(llista[i] instanceof Bens && llista[i].getCodi().equals(codi) && !((Bens)llista[i]).getIntercanvi()) return true;
        }

        return false;
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
    /**
     * Tostring per la consola
     * @return to string
     */
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
