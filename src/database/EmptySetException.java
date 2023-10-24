package database;

public class EmptySetException extends Exception{
    private static final long serialVersionUID = 1L;

    EmptySetException(){
        super("Resultset vuoto: la tabella inserita potrebbe non esistere all'interno del database.");
    }
}
