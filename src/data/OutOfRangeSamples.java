package data;

/**
 * Viene lanciata se viene inserito un numero di cluster non valido
 */
public class OutOfRangeSamples extends Exception {
    /**
     * Costruisce un oggetto {@code OutOfRangeSamples} con un messaggio di dettaglio specificato
     * @param error messaggio specificato
     */
    public OutOfRangeSamples(String error){
        super(error);
    }
}
