package data;

public class OutOfRangeSamples extends Exception {
    OutOfRangeSamples(){
        super("\nil numero k di cluster inserito da tastiera è maggiore " +
                "\nrispetto al numero di centroidi generabili dall'insieme di transazioni\n");
    }
}
