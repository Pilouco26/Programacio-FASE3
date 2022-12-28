package Dades.Classes;

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

    
    @Override
    public String toString() {
        
        return (codi+";"+getInteressat().getAlies()+";"+getContesta().getAlies()+";"+getDemanat().getCodi()+";"+getOferit().getCodi()+";"+getResposta()+";"+getTrato()+";"+getIvaloracio()+";"+getOvaloracio());
    }


    public String toStringMaco() {
        
        return ("CODI: "+getCodi()+", Interessat: "+getInteressat().getAlies()+", Contestant: "+getContesta().getAlies()+", Producte demanat: "+getDemanat().getNom()+", Producte oferit: "+getOferit().getNom()+", Resposta: "+getResposta()+", Trato: "+getTrato()+", Valoració del interessat: "+getIvaloracio()+", Valoració del demanat: "+getOvaloracio());
    }

    public Intercanvi copia()
    {
        return new Intercanvi(codi, interessat, contesta, demanat, oferit);
    }

    public int getCodi()
    {
        return codi;
    }
    public Usuari getInteressat(){

        return interessat;
    }
    public Usuari getContesta(){
        return contesta;
    }
    public Producte getDemanat(){
        return demanat;
    }
    public Producte getOferit(){
        return oferit;
    }
    public boolean getTrato(){
        return trato;
    }
    public boolean getResposta(){
        return resposta;
    }
    public int getIvaloracio(){
        return ivaloracio;
    }
    public int getOvaloracio(){
        return ovaloracio;
    }
    


    public void setOvaloracio(int ovaloracio) {
        this.ovaloracio = ovaloracio;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public void setInteressat(Usuari interessat) {
        this.interessat = interessat;
    }

    public void setContesta(Usuari contesta) {
        this.contesta = contesta;
    }

    public void setDemanat(Producte demanat) {
        this.demanat = demanat;
    }

    public void setOferit(Producte oferit) {
        this.oferit = oferit;
    }

    public void setTrato(boolean trato) {
        this.trato = trato;
    }

    public void setIvaloracio(int ivaloracio) {
        this.ivaloracio = ivaloracio;
    }
    public void setResposta(boolean resposta)
    {
        this.resposta = resposta;
    }



}
