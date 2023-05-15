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
     * I valori del dominio sono memorizzati in <code>values</code> seguendo un ordine lessicografico.
     */
    private TreeSet<String> values = new TreeSet<String>();

    /**
     * Costrutture: invoca il costruttore della superclasse e avvalora
     * l'array <code>values</code> con i parametri discreti in input
     *
     * @param name   nome simbolico dell'attributo
     * @param index  identificativo numerico dell'attributo
     * @param values valori discreti rappresentanti il dominio dell'attributo
     */
    DiscreteAttribute(String name, int index, String values[]) {
        super(name, index);
        for(int i=0; i< values.length; i++)
            this.values.add(values[i]);
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
        int[] idArray = new int[idList.size()];
        int i = 0;
        for (Integer id : idList) {
            idArray[i++] = id;
        }
        int frequenza = 0;
        for (int j = 0; j < idArray.length; j++) {
            if (data.getAttributeValue(idArray[j], getIndex()).equals(v)) {
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
