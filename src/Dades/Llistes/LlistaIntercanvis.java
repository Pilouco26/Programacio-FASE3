package Dades.Llistes;
import java.io.Serializable;
import Dades.Classes.Bens;
import Dades.Classes.Data;
import Dades.Classes.Intercanvi;
import Dades.Classes.Usuari;
/**
 * Classe llista productes
 * 
 * @author Grup
 *
 */
public  class LlistaIntercanvis implements Serializable{
    private Intercanvi[] llista;
    private int nElem;

    /**
     * Constructor llista intercanvis
     * @param mida
     */
    public LlistaIntercanvis(int mida)
    {
        llista = new Intercanvi[mida];
        nElem = 0;
    }

    /**
     * Afegeix intercanvi
     * @param intercanvi
     */
    public void AfegirIntercanvi(Intercanvi i)              // cal ordenarles
    {

        if(nElem<llista.length)
        {
        	int pos = nElem - 1;
        	while ((pos >= 0) && llista[pos].getCodi()>(i.getCodi())) {
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
    /**
     * Accepta o refusa proposta
     * @param resposta
     * @param codi
     * @param ivaloracio
     * @param ovaloracio
     * @param p1
     */
    public void AcepRefusarIntercanvi(boolean resposta, int codi, int ivaloracio, int ovaloracio, LlistaProductes p1)
    {
        boolean trobat= false;
        int i=0; 
        while(i<nElem && !trobat){

            if(llista[i].getCodi()==codi) trobat = true;
            else i++;
        }
        if(trobat)
        {
            llista[i].setResposta(resposta);
            llista[i].setTrato(true);
            llista[i].setIvaloracio(ivaloracio);
            llista[i].setOvaloracio(ovaloracio);                                //si es un bé posar el estat en intercanviat
            if(p1.EsUnBe(llista[i].getDemanat().getCodi())&& resposta) {

                Bens b1 =  p1.RetornaUnBe(llista[i].getDemanat().getCodi());
                b1.Intercanviat();
                Data d1 = new Data(0, 0, 0);
                d1.DataActual();
                b1.setData(d1);

            }
            if(p1.EsUnBe(llista[i].getOferit().getCodi())&& resposta) {

                Bens b1 =  p1.RetornaUnBe(llista[i].getOferit().getCodi());
                b1.Intercanviat();
                Data d1 = new Data(0, 0, 0);
                d1.DataActual();
                b1.setData(d1);
            if(resposta)
            {
                llista[i].getContesta().AddValoració(ovaloracio);
                llista[i].getInteressat().AddValoració(ivaloracio);
            }

            }
        }

    }
    /**
     * Verfica que l'usuari que contesta es el actual
     * @param codi
     * @param contesta
     * @return cert o fals
     */
    public boolean Verificador(int codi, Usuari contesta)
    {
        int i =0;
        boolean trobat = false;

        while(i<nElem && !trobat)
        {
            if(codi == llista[i].getCodi()) trobat = true;
            else i++;
        }

        if(trobat)
        {
            if(llista[i].getContesta().getAlies().equals(contesta.getAlies())) return true;
            else return false;
        }
        else return false;
    }
    /**
     * Troba l'usuari interessat
     * @param codi
     * @return usuari
     */
    public Usuari TrobaInteressat( int codi)
    {
        for(int i = 0; i<llista.length; i++)
        {
            
            if(llista[i].getCodi()==codi) return llista[i].getInteressat();

        }
        
        return null;


    }
    /**
     * getter propostes sense contesta
     * @return  llista
     */
    public LlistaIntercanvis getPendents()
    {
        LlistaIntercanvis aux = new LlistaIntercanvis(nElem);

        for(int i=0; i<nElem; i++)
        {
            if(llista[i].getTrato()==false)
            {
                aux.AfegirIntercanvi(llista[i]);
            }
        }

        return aux;
    }
    /**
     * getter propostes contesta
     * @return llista
     */
    public LlistaIntercanvis getIntercanviades()
    {
        LlistaIntercanvis aux = new LlistaIntercanvis(nElem);

        for(int i=0; i<nElem; i++)
        {
            if(llista[i].getTrato()==true)
            {
                aux.AfegirIntercanvi(llista[i]);
            }
        }

        return aux;
    }
    /**
     * getter propostes acceptades
     * @return llista
     */
    public LlistaIntercanvis getAcceptades()
    {
        LlistaIntercanvis aux = new LlistaIntercanvis(nElem);

        for(int i=0; i<nElem; i++)
        {
            if(llista[i].getTrato()==true && llista[i].getResposta() == true)
            {
                aux.AfegirIntercanvi(llista[i]);
            }
        }

        return aux;
    }
    /**
     * getter propostes rebutjades
     * @return llista
     */
    public LlistaIntercanvis getRebutjades()
    {
        LlistaIntercanvis aux = new LlistaIntercanvis(nElem);

        for(int i=0; i<nElem; i++)
        {
            if(llista[i].getTrato()==true && llista[i].getResposta() == false)
            {
                aux.AfegirIntercanvi(llista[i]);
            }
        }

        return aux;
    }
    /**
     * Troba intercanvis a traves d'usuari
     * @param alies
     * @return llista
     */
    public LlistaIntercanvis TrobaUsuariIntercanvis(String alies)
    {
        LlistaIntercanvis aux = new LlistaIntercanvis(nElem);
        for(int i = 0;  i<nElem; i++)
        {
            if(llista[i].getContesta().getAlies().equals(alies) || llista[i].getInteressat().getAlies().equals(alies)) aux.AfegirIntercanvi(llista[i]);
        }

        return aux;
    }


    /**
     * getter mida llista
     * @return nElem
     */
    public int getnElem()
    {
        return nElem;
    }
    /**
     * getter intercanvi a traves de posicio
     * @param pos
     * @return intercanvi
     */
    public Intercanvi getLlista (int pos) {
        if (pos>=0 && pos<nElem) return llista[pos];
        else return null;
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
    /**
     * to string consola
     * @return string
     */
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
