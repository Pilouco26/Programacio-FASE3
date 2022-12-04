package Dades.Classes;



public final class Servei extends Producte{

    private Data datafi;
    private boolean actiu;


    public Servei(String nom,String descripcio, Data data, Data datafi)
    {
        super(nom, descripcio, data);
        this.datafi= datafi;
    }

    public Data getDatafi()
    {
        return datafi;
    }

    public Servei copia()
    {
        return new Servei(getNom(), getDescripcio(), datafi, datafi);
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
    @Override
    public String toString()
    {
        return nom+";"+descripcio+";"+data+";"+datafi;
    }
   
    public String toStringMaco()
    {
        return "Nom: "+nom+", Descripció: "+descripcio+", Data inicial: "+data+", Data final: "+datafi;
    }
}
