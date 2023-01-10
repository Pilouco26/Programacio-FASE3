package Dades.Classes;
import java.io.Serializable;
/**
 * Classe Usuari
 * 
 * @author Grup
 *
 */
public final class  Usuari implements Serializable{            //final pq no volem crear subtipus
    private String alies; //No es pot repetir
    private String email;
    private int cp;                                                  // YA DESPRES ES VEU SI UTILIZEM LLISTA PRODUCTES
    private int numProductes;
    private int numIntercanvis;
    private int valoracionGeneral;

    /**
     * Constructor usuari
     * @param alies
     * @param email
     * @param cp
     */
    public Usuari(String alies, String email, int cp) 
    {
        this.alies = alies;
        this.email = email;
        this.cp = cp;
        numProductes = 0;
        numIntercanvis = 0;
        valoracionGeneral=0;
        
    }
    /**
     * afegir producte
     */
    public void afegirProductes() {

    
        numProductes++;
	}
    /**
     * afegir intercanvi
     */
    public void afegirIntercanvis() {

        
		numIntercanvis++;
	}
    /**
     * obtenir valoracio
     * @return mitjana
     */
    public double MitjanaValoració()
    {
        if(numIntercanvis==0) return 0;
        else return valoracionGeneral/numIntercanvis;
    }
    /**
     * afegir valoracio
     * @param valoracio
     */
    public void AddValoració(int valoracio)
    {
        valoracionGeneral+=valoracio;
    }
   
    /**
     * setter intercanvis
     * @param numIntercanvis
     */
    public void setnumIntercanvis(int numIntercanvis)
    {
        this.numIntercanvis=numIntercanvis;
    }
    /**
     * setter numproductes
     * @param numProductes
     */
    public void setNumProductes(int numProductes) {
        this.numProductes = numProductes;
    }
    /**
     * getter alies
     * @return alies
     */
    public String getAlies()
    {
        return alies;
    }
    /**
     * getter email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * getter cp
     * @return cp
     */
    public int getCp()
    {
        return cp;
    }
    /**
     * getter intercanvis
     * @return intercanvis
     */
    public int getIntercanvis()
    {
        return numIntercanvis;
    }
    /**
     * getter num productes
     * @return
     */
	public int getNumProductes()
    {
        return numProductes;
    }
    
    /**
     * copia instancia
     * @return usuari
     */
    public Usuari copia()
    {
        return new Usuari(alies, email, cp);  //ARREGLAR AIXO PER OBTENIR ELS NUMEROS DE PRODUCTES I INTERCANVIS
    }

    /**´
     * to string
     * @return string
     */
    public String toString()
    {
        return "Alies: "+alies+" Email: "+email+" Codi Postal: "+cp+" Numero de productes: "+numProductes+" Numeros d'intercanvis: "+numIntercanvis+"\n Valoració:"+MitjanaValoració()+" \n";
    }
    


}
