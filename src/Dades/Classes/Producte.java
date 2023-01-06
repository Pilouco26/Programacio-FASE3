package Dades.Classes;

/**
 * Padreada de las gordas pq es la classe pare
 * @authors Miguel Lopes, Ivan Garcia , Pere Escoda i Adrià Sanjuan
 */
public abstract class Producte {    

    protected  String nom;
    protected  String descripcio;               
    protected  Data data; 
    protected  String codi;


    /**
     * 
     * 
     */
    public Producte(String codi, String nom, String descripcio, Data data)
    {
        this.codi = codi; 
        this.nom=nom;
        this.descripcio = descripcio;
        this.data = data;
    }

    public String getNom()
    {
        return nom;
    }

    public String getDescripcio()
    {
        return descripcio;
    }

    public Data getData()
    {
        return data;
    }
    public abstract String getCodi();
 

    public abstract Producte copia();
    

    @Override
    public String toString(){

        return ("NOM: "+getNom()+", Descripció: "+getDescripcio()+", Data: "+getData().toString());
    }

    public abstract String toStringMaco();
}
