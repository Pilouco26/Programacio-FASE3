package Dades.Classes;

public final class Bens extends Producte {
    
    private double ampladaCM;
    private double alçadaCM;
    private double fonsCM;
    private double pesKG;
    private boolean intercanvi;

    /**
     * Constructor d'un bé, conté el superconstructor de la classe producte
     * @param nom: Nom del Producte
     * @param descripcio: Descripció del producte
     * @param tipus: Tipus de producte
     * @param data: Data del producte
     * @param amplada: amplada del bé
     * @param alçada: alçada del bé 
     * @param fons: fons del bé
     * @param pes: pes del bé
     */
    public Bens(String nom, String descripcio, Data data, double amplada, double alçada, double fonsCM, double pesKG)
    {
        super(nom, descripcio, data);
        this.ampladaCM = amplada;
        this.alçadaCM = alçada;
        this.fonsCM = fonsCM;
        this.pesKG = pesKG;
        intercanvi= false;
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

    public void setIntercanvi(boolean intercanvi)
    {
        this.intercanvi = intercanvi;
    }
    /**
     * Copia un bé
     * @return bé copiat
     */
    public Bens copia(){
        return new Bens(getNom(), getDescripcio(), getData(), ampladaCM, alçadaCM, fonsCM, pesKG);
    }

    public String toStringMaco()
    {
        return "Nom: +"+nom+", Descripció: "+descripcio+" Data inicial: "+data;
    }


}
