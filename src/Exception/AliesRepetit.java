package Exception;

public class AliesRepetit extends Exception {
    
    public AliesRepetit(String alies)
    {
        super("El alies "+alies+" esta repetit fucking bozo\n");
    }
}
