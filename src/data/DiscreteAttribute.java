package data;

import java.util.Arrays;
import utility.ArraySet;
/**
 * Estende la classe data.Attribute e rappresenta un attributo discreto
 */
class DiscreteAttribute extends Attribute {
    /**
     * Array di oggetti <code>String</code>, uno per ciascun valore del dominio discreto.
     * I valori del dominio sono memorizzati in <code>values</code> seguendo un ordine lessicografico.
     */
    private String values[];

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
        this.values = values;
        Arrays.sort(this.values);
    }

    /**
     * Restituisce la dimensione di values
     * @return numero di valori discreti nel dominio dell'attributo
     */
    int getNumberOfDistinctValues() {
        return values.length;
    }

    /**
     * Restituisce il valore values[i]
     *
     * @param i posizione di un valore in values
     * @return valore discreto nella posizione "i" di values
     */
    String getValue(int i) {
        return values[i];
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
    int frequency(Data data, ArraySet idList, String v){
        int frequenza = 0;
        int[] idArray = idList.toArray();
        for(int i=0; i < idArray.length; i++)
            if(data.getAttributeValue(idArray[i], getIndex()).equals(v))
                frequenza++;
        return frequenza;
    }

}
