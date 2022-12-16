package Dades.Classes;



public final class Servei extends Producte{

    private Data datafi;
    private boolean actiu;


    public Servei(String codi, String nom,String descripcio, Data data, Data datafi)
    {
        super(codi, nom, descripcio, data);
        this.datafi= datafi;
    }

    public Data getDatafi()
    {
        return datafi;
    }
    public  String getCodi()
    {
        return codi;
    }
    public void setDataBaixa()
    {
        Data data= new Data(1, 1, 1);
       this.data= data;
       datafi= data; 

    }

    public Servei copia()
    {
        return new Servei(getCodi(), getNom(), getDescripcio(), data, datafi);
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
        return codi+";"+nom+";"+descripcio+";"+data+";"+datafi;
    }
   
    public String toStringMaco()
    {
        return "Nom: "+nom+", Descripció: "+descripcio+",  El servei comença el : "+data+" i acaba el dia: "+datafi+".";
    }
}
