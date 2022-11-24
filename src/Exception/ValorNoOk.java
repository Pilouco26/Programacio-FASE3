package Exception;

public class ValorNoOk extends Exception {
    
    public  ValorNoOk(int num)
    {
        super("El numero "+num+" no es es pot associar amb cap part del menu, idiota :)");
    }
}
