package data;
import java.io.Serializable;
/**
 * Classe astratta che modella un generico attributo, discreto o continuo.
 */
abstract class Attribute implements Serializable{
    /**
     * Nome simbolico dell'attributo
     */
    private String name;
    /**
     * Identificativo numerico dell'attributo, indice della colonna che rappresenta l'attributo
     */
    private int index;

    /**
     * Inizializza i valori dei membri index, name
     * @param name nome simbolico dell'attributo
     * @param index identificativo numerico dell'attributo
     */
    Attribute(String name, int index){
        this.index = index;
        this.name = name;
    }

    /**
     * Restituisce il valore nel membro <code>name</code>
     * @return Nome dell'attributo
     */
    private String getName(){
        return this.name;
    }

    /**
     * Restituisce il valore nel membro <code>index</code>
     * @return Identificativo numerico dell'attributo
     */
    int getIndex() {
        return this.index;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
