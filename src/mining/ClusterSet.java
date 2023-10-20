package mining;

import data.Data;
import data.OutOfRangeSamples;
import data.Tuple;
import java.io.Serializable;

/**
 * Classe che rappresenta un insieme di cluster. Gli oggetti di questa classe
 * memorizzano un array di oggetti di tipo mining.Cluster, inizializzati a partire da
 * un insieme di centroidi campionati casualmente da un oggetto di tipo data.Data.
 * La classe fornisce metodi per identificare il cluster più vicino
 * ad una data tupla, calcolare il nuovo centroide per ciascun cluster
 */
public class ClusterSet implements Serializable{
    private Cluster C[];
    private int i = 0; //posiizone valida per la memorizazzione di un nuovo cluster in C

    /**
     * Costruttore della classe. Inizializza un nuovo insieme di cluster con <code>k</code> elementi
     * @param k numero di cluster dell'insieme
     */
    ClusterSet(int k){
        C = new Cluster[k];
    }

    /**
     * Aggiunge un nuovo cluster alla lista di cluster
     * @param c cluster da aggiungere
     */
    private void add(Cluster c){
        C[i] = c;
        i++;
    }

    /**
     *  Restituisce l'oggetto mining.Cluster in posizione <code>i</code> dell'insieme
     * @param i indice del cluster da restituire
     * @return oggetto di tipo mining.Cluster in posizione <code>i</code> dell'insieme
     */
    private Cluster get(int i){
        return C[i];
    }

    /**
     * Inizializza i centroidi dei cluster. Viene utilzzato il metodo <code>sampling</code> per scegliere
     * casualmente i centroidi dei cluster e crea una nuova istanza di mining.Cluster per ciascun centroide.
     * I nuovi cluster vengono aggiunti nell'array <code>C</code> della classe <code>mining.ClusterSet</code>
     * @param data oggetto di tipo <code>data.Data</code> contenente gli esempi da usare per inizializzare i centroidi
     * @throws OutOfRangeSamples se k il numero di cluster da generare è maggiore del numero
     * di cluster generabili o troppo piccolo
     */
    void initializeCentroids(Data data) throws OutOfRangeSamples {
        int[] centroidIndexes=data.sampling(C.length);
        for(int i=0; i<centroidIndexes.length; i++) {
            Tuple centroidI=data.getItemSet(centroidIndexes[i]);
            add(new Cluster(centroidI));
        }

    }

    /**
     * Calcola il cluster più vicino alla tupla passata come argomento
     * @param tuple tupla di riferimento per calcolare la distanza dai centroidi del cluster
     * @return cluster più vicino alla tupla
     */
    Cluster nearestCluster(Tuple tuple){
        double currentDistance = tuple.getDistance(C[0].getCentroid());
        double tmp;
        Cluster neareast = C[0];
        for(int i=1; i < C.length; i++){
            tmp = tuple.getDistance(C[i].getCentroid());
            if(tmp < currentDistance){
                currentDistance = tmp;
                neareast = C[i];
            }
        }
        return neareast;
    }

    /**
     * Identifica e restituisce il cluster che contiene l'elemento con indice <code>id</code>.
     * @param id indice dell'elemento da cercare
     * @return il cluster che contiene l'elemento con indice <code>id</code>, <code>null</code> se non viene trovato
     */
    Cluster currentCluster(int id){
        for(int i=0; i < C.length; i++){
            if(get(i).contain(id))
                return get(i);
        }
        return null;
    }

    /**
     * Aggiorna il valore del centroide di un cluster. Il nuovo centroide viene impostato come il centroide del cluster
     * @param data oggetto data.Data contenente le tuple degli esempi
     */
    void updateCentroids(Data data){
        for(int i = 0; i < C.length; i++){
            get(i).computeCentroid(data);
        }
    }


    public String toString() {
        String str = "";
        for(int i = 0; i < C.length; i++){
            str+=get(i).toString()+"\n";
        }
        return str;
    }

    public String toString(Data data) {
        String str = "";
        for(int i = 0; i < C.length; i++){
            if (get(i) != null){
                str += i + ": " + get(i).toString(data) + "\n";

            }
        }
        return str;
    }
}

