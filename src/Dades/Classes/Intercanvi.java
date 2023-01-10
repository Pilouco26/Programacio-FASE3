package Dades.Classes;
/**
 * Classe intercanvi
 * 
 * @author Grup
 *
 */
public final class Intercanvi {
    private int codi;
   
    private Usuari interessat;
   
    private Usuari contesta;
   
    private Producte demanat;
    
    private Producte oferit;
   
    private boolean trato;
   
    private boolean resposta;
   
    private int ivaloracio;
 
    private int ovaloracio;
    /**
     * Constructor intercanvi
     * @param codi
     * @param interessat
     * @param contesta
     * @param demanat
     * @param oferit
     */
    public Intercanvi(int codi, Usuari interessat, Usuari contesta, Producte demanat, Producte oferit)
    {
        this.codi= codi;
        this.interessat = interessat;
        this.contesta = contesta;
        this.demanat = demanat;
        this.oferit = oferit;
        trato = false;
        resposta = false;
        ivaloracio = 0;
        ovaloracio = 0;
    }

     /**
     * To string fitxer
     */
    @Override
    public String toString() {
        
        return (codi+";"+getInteressat().getAlies()+";"+getContesta().getAlies()+";"+getDemanat().getCodi()+";"+getOferit().getCodi()+";"+getResposta()+";"+getTrato()+";"+getIvaloracio()+";"+getOvaloracio());
    }

    /**
     * to String consola
     * @return string
     */
    public String toStringMaco() {
        
        return ("CODI: "+getCodi()+", Interessat: "+getInteressat().getAlies()+", Contestant: "+getContesta().getAlies()+", Producte demanat: "+getDemanat().getNom()+", Producte oferit: "+getOferit().getNom()+", Resposta: "+getResposta()+", Trato: "+getTrato()+", Valoració del interessat: "+getIvaloracio()+", Valoració del demanat: "+getOvaloracio());
    }
    /**
     * Copia instancia
     * @return intercanvi
     */
    public Intercanvi copia()
    {
        return new Intercanvi(codi, interessat, contesta, demanat, oferit);
    }
    /**
     * getter codi
     * @return codi
     */
    public int getCodi()
    {
        return codi;
    }
    /**
     * getter usuari interessat
     * @return   usuari
     */
    public Usuari getInteressat(){

        return interessat;
    }
    /** getter usuari contesta
     * @return contesta
     */
    public Usuari getContesta(){
        return contesta;
    }
    /**
     * getter producte demanat
     * @return demanat
     */
    public Producte getDemanat(){
        return demanat;
    }
    
    /**
     * getter producte oferit
     * @return oferit
     */
    public Producte getOferit(){
        return oferit;
    }
    /**
     * getter estat intercanvi
     * @return trato
     */
    public boolean getTrato(){
        return trato;
    }
    /**
     * getter resposta
     * @return veritat o fals
     */
    public boolean getResposta(){
        return resposta;
    }
    /**
     * getter valoració
     * @return valoracio interessat
     */
    public int getIvaloracio(){
        return ivaloracio;
    }
    /**
     * getter valoració
     * @return ovaloracio
     */
    public int getOvaloracio(){
        return ovaloracio;
    }
    

    /**
     * setter valoracio
     * @param ovaloracio
     */
    public void setOvaloracio(int ovaloracio) {
        this.ovaloracio = ovaloracio;
    }
    /**
     * setter codi
     * @param codi
     */
    public void setCodi(int codi) {
        this.codi = codi;
    }
    /**
     * setter interessat
     * @param interessat
     */
    public void setInteressat(Usuari interessat) {
        this.interessat = interessat;
    }
    /**
     * setter contesta
     * @param contesta
     */
    public void setContesta(Usuari contesta) {
        this.contesta = contesta;
    }
    /**
     * setter producte demanat
     * @param demanat
     */
    public void setDemanat(Producte demanat) {
        this.demanat = demanat;
    }
    /**
     * setter producte oferit
     * @param oferit
     */
    public void setOferit(Producte oferit) {
        this.oferit = oferit;
    }
    /**
     * setter trato
     * @param trato
     */
    public void setTrato(boolean trato) {
        this.trato = trato;
    }
    /**
     * setter ivaloracio
     * @param ivaloracio
     */
    public void setIvaloracio(int ivaloracio) {
        this.ivaloracio = ivaloracio;
    }
    /**
     * setter resposta
     * @param resposta
     */
    public void setResposta(boolean resposta)
    {
        this.resposta = resposta;
    }



}
