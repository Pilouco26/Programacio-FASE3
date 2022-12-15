package Dades.Classes;

/**
 * Padreada de las gordas pq es la classe pare
 * @authors Miguel Lopes, Ivan Garcia , Pere Escoda i Adrià Sanjuan
 */
public abstract class Producte {    //no volem obtenir fer res

    protected  String nom;
    protected  String descripcio;               //0   bens 1 serveis
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
    public String getCodi()
    {
        return codi;
    }

    public abstract Producte copia();

    @Override
    public String toString(){

        return ("NOM: "+getNom()+", Descripció: "+getDescripcio()+", Data: "+getData().toString());
    }

    public abstract String toStringMaco();
}
