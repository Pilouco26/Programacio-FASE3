package Dades.Classes;



public final class Servei extends Producte{

    private Data datafi;
    private boolean actiu;


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
        return new Servei(getNom(), getDescripcio(), getTipus(), datafi, datafi);
    }
    
    public void actiu(Data actual)
    {
        if(actual.esDataInferiorOigual(datafi)&& data.esDataInferiorOigual(actual)) actiu = true;
        else actiu= false;
    }
    public boolean getActiu()
    {
        return actiu;
    }
    public void setActiu(boolean actiu)
    {
        this.actiu= actiu;
    }
}
