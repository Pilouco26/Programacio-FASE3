package Dades.Classes;

/**
 * Classe Servei
 * 
 * @author Grup
 *
 */


public final class Servei extends Producte{

    private Data datafi;
    private boolean actiu;
    /**
     * Constructor Servei
     * @param codi
     * @param nom
     * @param descripcio
     * @param data
     * @param datafi
     */

    public Servei(String codi, String nom,String descripcio, Data data, Data datafi)
    {
        super(codi, nom, descripcio, data);
        this.datafi= datafi;
    }

    /**
     * Getter data
     * @return data
     */
    public Data getDatafi()
    {
        return datafi;
    }
    /**
     * Getter codi
     * @return codi
     */
    public  String getCodi()
    {
        return codi;
    }
    /**
     * Desactivar producte
     */
    public void setDataBaixa()
    {
        Data data= new Data(1, 1, 1);
       this.data= data;
       datafi= data; 

    }
    /**
     * Copia de la instacia
     * @return Servei copiat
     */
    public Servei copia()
    {
        return new Servei(getCodi(), getNom(), getDescripcio(), data, datafi);
    }
    /**
     * Comprova si el producte esta actiu
     * @param data actual
     */
    public void actiu(Data actual)
    {
        if(actual.esDataInferiorOigual(datafi)&& data.esDataInferiorOigual(actual)) actiu = true;
        else actiu= false;
    }
    /**
     * Comprova si el servei esta actiu
     * @return veritat o fals
     */
    public boolean getActiu()
    {
        return actiu;
    }
    /**
     * Canvia el estat d'actiu
     * @param actiu
     */
    public void setActiu(boolean actiu)
    {
        this.actiu= actiu;
    }
    /**
     * To string fitxer
     */
    @Override
    public String toString()
    {
        return codi+";"+nom+";"+descripcio+";"+data+";"+datafi;
    }
    /**
     * to String consola
     * @return string
     */
    public String toStringMaco()
    {
        return "Nom: "+nom+", Descripció: "+descripcio+",  El servei comença el : "+data+" i acaba el dia: "+datafi+".";
    }
}
