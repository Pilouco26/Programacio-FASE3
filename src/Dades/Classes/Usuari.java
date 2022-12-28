package Dades.Classes;
import java.io.Serializable;

public final class  Usuari implements Serializable{            //final pq no volem crear subtipus
    private String alies; //No es pot repetir
    private String email;
    private int cp;                                                  // YA DESPRES ES VEU SI UTILIZEM LLISTA PRODUCTES
    private int numProductes;
    private int numIntercanvis;
    private int valoracionGeneral;


    public Usuari(String alies, String email, int cp) 
    {
        this.alies = alies;
        this.email = email;
        this.cp = cp;
        numProductes = 0;
        numIntercanvis = 0;
        valoracionGeneral=0;
        
    }
  
    public void afegirProductes() {

    
        numProductes++;
	}
    
    public void afegirIntercanvis() {

        
		numIntercanvis++;
	}
    
    public double MitjanaValoració()
    {
        if(numIntercanvis==0) return 0;
        else return valoracionGeneral/numIntercanvis;
    }
    public void AddValoració(int valoracio)
    {
        valoracionGeneral+=valoracio;
    }
   

    public void setnumIntercanvis(int numIntercanvis)
    {
        this.numIntercanvis=numIntercanvis;
    }

    public void setNumProductes(int numProductes) {
        this.numProductes = numProductes;
    }

    public String getAlies()
    {
        return alies;
    }

    public String getEmail()
    {
        return email;
    }

    public int getCp()
    {
        return cp;
    }

    public int getIntercanvis()
    {
        return numIntercanvis;
    }

	public int getNumProductes()
    {
        return numProductes;
    }
    

    public Usuari copia()
    {
        return new Usuari(alies, email, cp);  //ARREGLAR AIXO PER OBTENIR ELS NUMEROS DE PRODUCTES I INTERCANVIS
    }


    public String toString()
    {
        return "Alies: "+alies+" Email: "+email+" Codi Postal: "+cp+" Numero de productes: "+numProductes+" Numeros d'intercanvis: "+numIntercanvis+"\n Valoració:"+MitjanaValoració()+" \n";
    }


}
