package Exception;

/**
 * Classe excepcio usuari inexistent
 * 
 * @author Grup
 *
 */
public class AliesNoExisteix extends Exception {
    
     /**
     * Contructor
     * @param alies
     */
    public AliesNoExisteix(String alies)
    {
        super("El alies "+alies+"  no existeix \n");
    }
}
