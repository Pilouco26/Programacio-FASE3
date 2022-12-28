package Exception;

public class AliesNoExisteix extends Exception {
    
    public AliesNoExisteix(String alies)
    {
        super("El alies "+alies+"  no existeix \n");
    }
}
