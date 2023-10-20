package data;

import java.io.Serializable;
import java.util.Set;

/**
 * Classe astratta che modella un generica coppia attributo-valore, es. Outlook="Sunny"
 */

public abstract class Item implements Serializable{
    /**
     * Attributo coinvolto nell'item
     */
    private final Attribute attribute; //attributo coinvolto nell'item
    /**
     * Valore assegnato all'attributo
     */
    private Object value; //valore assegnato all'attributo

    /**
     * Costruttore della classe, inizializza i valori di un {@code Item} con quelli passati in input
     * @param attribute Attributo coinvolto nell'item
     * @param value Valore assegnato all'attributo
     */
    public Item(Attribute attribute, Object value){
        this.attribute = attribute;
        this.value = value;
    }

    /**
     * Restituisce il valore di attribute
     * @return valore di attribute
     */
    Attribute getAttribute(){
        return attribute;
    }

    /**
     * Restituisce il valore di value
     * @return valore di value
     */
    Object getValue(){
        return value;
    }

    /**
     * Stampa il valore di value
     * @return valore di value
     */
    @Override
    public String toString(){
        return value.toString();
    }

    /**
     * Metodo astratto, l'implementazione sarò differente per un item continuo o discreto
     * @param a valore da cui calcolare la distanza
     * @return
     */
    abstract double distance(Object a);

    /**
     * Modifica il membro value, assegnandogli il valore
     * restituito da <code>data.computePrototype(clusteredData,attribute)</code>
     * @param data riferimento ad un oggetto della classe data.Data
     * @param clusteredData insieme di indici delle righe della matrice in data che formano il cluster
     */
    public void update(Data data, Set<Integer> clusteredData){
        value = data.computePrototype(clusteredData, attribute);
    }


}
