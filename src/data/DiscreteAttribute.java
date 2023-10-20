package data;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Estende la classe data.Attribute e rappresenta un attributo discreto
 */
class DiscreteAttribute extends Attribute implements Iterable<String>{
    /**
     * Set ordinato di stringhe, uno per ciascun valore del dominio discreto.
     * I valori del dominio vengono memorizzati seguendo un ordine lessicografico con la struttura TreeSet.
     */
    private TreeSet<String> values;

    /**
     * Costruisce un nuovo attributo invoca il costruttore della superclasse
     * per inizializzare i campi {@code Index} e {@code Name} di un attributo,
     * quindi inizializza il Set {@code values} con quello passato in input.
     *
     * @param name   nome simbolico dell'attributo discreto
     * @param index  indice dell'attributo discreto
     * @param values Set di valori discreti, rappresentano il dominio dell'attributo discreto
     */
    DiscreteAttribute(String name, int index, TreeSet<String> values) {
        super(name, index);
        this.values = values;
    }

    /**
     * Restituisce la dimensione di values
     * @return numero di valori discreti nel dominio dell'attributo
     */
    int getNumberOfDistinctValues() {
        return values.size();
    }


    /**
     * Determina il numero di volte che il terrmine <code>v</code> passato in input compare in corrispondenza
     * dell'attributo corrente (indice di colonna) negli esempi memorizzati
     * in <code>data</code> e indicizzate (per riga) da <code>idList</code>
     * @param data riferimento ad un oggetto di tipo Data
     * @param idList riferimento ad un oggetto di tipo utility.ArraySet
     * @param v valore discreto da contare nella tupla
     * @return numero di occorrenze del valore discreto
     */
    int frequency(Data data, Set<Integer> idList, String v){
        int frequenza = 0;
        for (int j : idList) {
            if (data.getAttributeValue(j, getIndex()).equals(v)) {
                frequenza++;
            }
        }
        return frequenza;

    }

    @Override
    public Iterator<String> iterator() {
        return values.iterator();
    }
}
