package data;

import java.io.Serializable;
import java.util.Set;

/**
 * La classe data.Tuple rappresenta una tupla come sequenza di coppie attributo-valore.
 */

public class Tuple implements Serializable {
    /**
     *  Array di oggetti di tipo data.Item, rappresenta una sequenza di coppie
     *  attributo-valore che costituiscono una tupla
     */
    private Item[] tuple;

    /**
     * Costruisce l'oggetto riferito da tuple
     * @param size numero di item che costituirà la tupla
     */
    Tuple (int size){
        tuple = new Item[size];
    }

    /**
     * Restituisce la lunghezza del membro <code>tuple</code>
     * @return lunghezza di <code>tuple</code>
     */
    public int getLength(){
        return tuple.length;
    }

    /**
     * Restituisce l'item in posizione <code>i</code>
     * @param i indice dell'item da restituire
     * @return l'item in posizione i della tupla
     */
    public Item get(int i){
        return tuple[i];
    }

    /**
     * Memorizza l'item <code>c</code> nella posizione <code>i</code> della tupla
     * @param c item da memorizzare in tuple[]
     * @param i indice della posizione in cui memorizzare l'item
     */
    public void add(Item c, int i){
        tuple[i] = c;
    }

    /**
     * Restituisce la distanza tra la tupla corrente e quella passata in input.
     * La distanza è calcolata come somma delle distanze tra i singoli attributi delle tuple.
     * @param obj la tupla di cui calcolare la distanza rispetto alla tupla corrente
     * @return la distanza tra le due tuple
     */
    public double getDistance(Tuple obj){
        double distance = 0.0;
        for(int i = 0; i < this.getLength(); i++){
            distance += this.tuple[i].distance(obj.get(i).getValue());
        }
        return distance;
    }

    /**
     * Calcola la distanza media tra il centroide e gli esempi di dati clusterizzati in questo cluster
     * @param data Dataset degli esempi di dati clusterizzati in questo cluster
     * @param clusteredData array di interi che rappresenta gli esempi di dati clusterizzati in questo clauster
     * @return la distanza media tra il centroide e gli esempi di dati clusterizzati
     */
    public double avgDistance(Data data, Set<Integer> clusteredData){
        double p, sumD = 0.0;
        for(int i : clusteredData){
            double d = getDistance(data.getItemSet(i));
            sumD += d;
        }
        p = sumD/(double) clusteredData.size();
        return p;
    }


}
