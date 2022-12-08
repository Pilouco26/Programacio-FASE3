package Dades.Classes;
import java.io.Serializable;
import java.util.Arrays;
public final class  Usuari implements Serializable{            //final pq no volem crear subtipus
    private String alies; //No es pot repetir
    private String email;
    private int cp;
    private Producte[] productes; // YA DESPRES ES VEU SI UTILIZEM LLISTA PRODUCTES
    private int numProductes;
    private Intercanvi[] intercanvis;
    private int numIntercanvis;


    public Usuari(String alies, String email, int cp) 
    {
        this.alies = alies;
        this.email = email;
        this.cp = cp;
        this.productes= new Producte[0];
        this.intercanvis= new Intercanvi[0];
        numProductes = 0;
        numIntercanvis = 0;
        
    }
  
    public void afegirProductes(Producte producte) {
		if (numProductes>=this.productes.length) {
			Producte[] nouAmpliar=new Producte[numProductes+1];

			for (int i=0; i<numProductes; i++)
				nouAmpliar[i]=this.productes[i];
			this.productes=nouAmpliar;
		}
		this.productes[numProductes]=producte;
		numProductes++;
	}
    
    public void afegirIntercanvis(Intercanvi intercanvi) {
		if (numIntercanvis>=this.intercanvis.length) {
			Intercanvi[] aux =new Intercanvi[numIntercanvis+1];

			for (int i=0; i<numIntercanvis; i++)
				aux[i]=this.intercanvis[i];
			this.intercanvis=aux;
		}
		this.intercanvis[numIntercanvis]=intercanvi;
		numIntercanvis++;
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
    
    public Producte[] getProductes()
    {
        return productes;
    }

    public Usuari copia()
    {
        return new Usuari(alies, email, cp);  //ARREGLAR AIXO PER OBTENIR ELS NUMEROS DE PRODUCTES I INTERCANVIS
    }


    public String toString()
    {
        return "Alies: "+alies+" Email: "+email+" Codi Postal: "+cp+" Numero de productes: "+numProductes+" Numeros d'intercanvis: "+numIntercanvis+" Productes: "+Arrays.toString(productes)+" Intercanvis" +Arrays.toString(intercanvis)+" \n";
    }


}
