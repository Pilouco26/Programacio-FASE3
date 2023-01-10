package Dades.Classes;
/**
 * Classe bens
 * 
 * @author Grup
 *
 */
public final class Bens extends Producte {
    
    private double ampladaCM;
    private double alçadaCM;
    private double fonsCM;
    private double pesKG;
    private boolean intercanvi;
    private Data Data_intercanvi;

    /**
     * Constructor d'un bé, conté el superconstructor de la classe producte
     * @param nom: Nom del Producte
     * @param descripcio: Descripció del producte
     * @param data: Data del producte
     * @param amplada: amplada del bé
     * @param alçada: alçada del bé 
     * @param fons: fons del bé
     * @param pes: pes del bé
     */
    public Bens( String codi, String nom, String descripcio, Data data, double amplada, double alçada, double fonsCM, double pesKG)
    {
        super(codi, nom, descripcio, data);
        this.ampladaCM = amplada;
        this.alçadaCM = alçada;
        this.fonsCM = fonsCM;
        this.pesKG = pesKG;
        intercanvi= false;
        Data_intercanvi= null;

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
     * Getter amplada
     * @return amplada
     */
    public double getAmplada() 
    {
        return ampladaCM;
    }
    /**
     * Getter alçada
     * @return
     */
    public double getAlçada() 
    {
        return alçadaCM;
    }
    /**
     * Getter fons
     * @return fons
     */
    public double getFons() 
    {
        return fonsCM;
    }
    /**
     * Getter del pes
     * @return pes
     */
    public double getPes()
    {
        return pesKG;
    }
    /**
     * Calcula el volum
     * @return volum
     */
    public double  getVolum()
    {
        return ampladaCM*alçadaCM*fonsCM;
    }
    /**
     * Comprova si el item ha estat intercanviat
     * @return
     */
    public boolean getIntercanvi()
    {
        return intercanvi;
    }
    /**´
     * Cambia el estat del item, ara ja ha estat intercanviat
     */
    public void Intercanviat(){
        intercanvi = true;
    }
        /**´
     * Cambia el estat del item, ara ja ha estat intercanviat
     * @param estat intercanvi
     */
    public void setIntercanvi(boolean intercanvi)
    {
        this.intercanvi = intercanvi;
    }
    /**´
     * Cambia la data , 
     * @param data
     */
    public void setData(Data data)
    {
        this.Data_intercanvi = data;
    }
    /**
     * Copia un bé
     * @return bé copiat
     */
    public Bens copia(){
        return new Bens(getCodi(), getNom(), getDescripcio(), getData(), ampladaCM, alçadaCM, fonsCM, pesKG);
    }
    /**
     * ToString per la consola en cas de que el producte no ha estat intercanviat
     * @return  string 
     */
    public String toStringMacoFalse()
    {
        return "Nom: "+nom+", Descripció: "+descripcio+", Està disponible per intercanvi des-de: "+data;
    }
        /**
     * ToString per la consola en cas de que el producte  ha estat intercanviat
     * @return  string 
     */
    public String toStringMaco()
    {
        return "Nom: "+nom+", Descripció: "+descripcio+", Data inicial: "+data+ ", No està disponible per intercanvis, va ser intercanviat el : "+Data_intercanvi.toString();
    }
    /**
     *  To String per els fitxers
     */
    @Override
    public String toString()
    {
        return codi+";"+nom+";"+descripcio+";"+data+";"+ampladaCM+";"+alçadaCM+";"+fonsCM+";"+pesKG+";"+intercanvi+";"+Data_intercanvi.toString();
    }
     /**
     *  To String per els fitxers
     * @return string
     */
    public String toStringFalse()
    {
        return codi+";"+nom+";"+descripcio+";"+data+";"+ampladaCM+";"+alçadaCM+";"+fonsCM+";"+pesKG+";"+intercanvi;
    }

}
