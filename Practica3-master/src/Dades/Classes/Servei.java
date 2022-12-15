package Dades.Classes;

public final class Servei extends Producte{

    private Data datafi;


    public Servei(String nom,String descripcio, int tipus, Data data, Data datafi)
    {
        super(nom, descripcio, tipus, data);
        this.datafi= datafi;
    }

    public Data getDatafi()
    {
        return datafi;
    }

    public Servei copia()
    {
        return new Servei(getNom(), getDescripcio(), getTipus(), data, datafi);
    }
    
    public boolean actiu(Data actual)
    {
        if(datafi.esDataInferiorOigual(actual)) return true;
        else return false;
    }
}
