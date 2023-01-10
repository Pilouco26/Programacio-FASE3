package Exception;
/**
 * Classe excepcio valor invalid
 * 
 * @author Grup
 *
 */
public class ValorNoOk extends Exception {
    
    /**
     * Contructor
     * @param num
     */
    public  ValorNoOk(int num)
    {
        super("El numero "+num+" no es es pot associar amb cap part del menu, idiota :)");
    }
}
