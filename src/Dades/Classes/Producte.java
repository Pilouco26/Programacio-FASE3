package Dades.Classes;

/**
 * Classe producte
 * 
 * @author Grup
 *
 */
public abstract class Producte {    

    protected  String nom;
    protected  String descripcio;               
    protected  Data data; 
    protected  String codi;

    /**
     * Constructor producte
     * @param codi
     * @param nom
     * @param descripcio
     * @param data
     */
    public Producte(String codi, String nom, String descripcio, Data data)
    {
        this.codi = codi; 
        this.nom=nom;
        this.descripcio = descripcio;
        this.data = data;
    }
    /**
     * getter nom
     * @return nom
     */
    public String getNom()
    {
        return nom;
    }
    /**
     * getter descripcio
     * @return descripcio
     */
    public String getDescripcio()
    {
        return descripcio;
    }

    /**
     * getter data
     * @return data
     */
    public Data getData()
    {
        return data;
    }
    /**
     * getter codi
     * @return codi
     */
    public abstract String getCodi();
 
    /**
     * copia intancias
     * @return producte
     */
    public abstract Producte copia();
    

    @Override
    public String toString(){

        return ("NOM: "+getNom()+", Descripció: "+getDescripcio()+", Data: "+getData().toString());
    }

    /**
     * String maco
     * @return string
     */
    public abstract String toStringMaco();
}
