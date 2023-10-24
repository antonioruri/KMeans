package database;

public class NoValueException extends Exception{
    private static final long serialVersionUID = 1L;

    NoValueException(){
        super("Nessun valore trovato all'interno del ResultSet");
    }
}
