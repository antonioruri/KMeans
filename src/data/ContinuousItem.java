package data;

import static java.lang.Math.abs;

public class ContinuousItem extends Item {


    /**
     * Costruttore della classe, inizializza i valori dei membri con quelli passati in input
     *
     * @param attribute Attributo coinvolto nell'item
     * @param value Valore assegnato all'attributo
     */
    public ContinuousItem(Attribute attribute, Double value) {
        super(attribute, value);
    }

    /**
     * Determina la distanza (in valore assoluto) tra il valore scalato
     * memorizzato nello item corrente (this.getValue())
     * e quello scalato associato al parametro a.
     * @param a valore da cui calcolare la distanza
     * @return distanza in valore assoluto tra item corrente e membro passato in input
     */
    @Override
    double distance(Object a) {
        ContinuousAttribute x = (ContinuousAttribute) this.getAttribute();
        return abs(x.getScaledValue((Double) this.getValue()) -  ( x.getScaledValue((Double) a))); //senza il valore assoluto andava in loop
    }
}
