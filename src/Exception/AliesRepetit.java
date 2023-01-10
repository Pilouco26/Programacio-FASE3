package Exception;
/**
 * Classe excepcio usuari repetit
 * 
 * @author Grup
 *
 */
public class AliesRepetit extends Exception {
    
     /**
     * Contructor
     * @param alies
     */
    public AliesRepetit(String alies)
    {
        super("El alies "+alies+" esta repetit \n");
    }
}
