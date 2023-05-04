package data;

/**
 * Classe che estende la classe data.Item e rappresenta una coppia
 * (Attributo discreto- valore discreto per esempio Outlook="Sunny")
 */
public class DiscreteItem extends Item {

    /**
     * Costruttore di classe invoca il costruttore della superclasse
     * @param attribute Attributo coinvolto nell'item
     * @param value Valore assegnato all'attributo
     */
    public DiscreteItem(DiscreteAttribute attribute, String value){
        super(attribute,value);
    }


    /**
     * Valuta la distanza tra due attributi discreti, restituisce 0 se sono uguali
     * 1 se sono diversi
     *
     * @param a valore da cui calcolare la distanza
     * @return
     */
    double distance(Object a) {
        if(getValue().equals(a)){
            return 0;
        }
        else return 1;

    }
    
}
